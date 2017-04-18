package dashboard.vishnu.com.dashboard.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by vishnu on 18/4/17.
 */

public class Shipment {
    private String generatedId, shipper, transporter, transporterId, balance, dala, remarks, status, truck, reverseBid;
    private int shipmentId, userId, truckType, truckCount;
    private double advance, extraHeight, commission;
    private Date pickupDate, bidClosingDate;
    private List<ShipmentAddress> pickup, delivery;
    private List<Bid> bids;
    private List<ShipmentItem> items;

    public Shipment(JSONObject json) {
        try {
            generatedId = json.getString("generatedId");
            shipper = json.getString("shipper");
            transporter = json.getString("transporter");
            transporterId = json.getString("transporterId");
            balance = json.getString("balance");
            dala = json.getString("dala");
            remarks = json.getString("remarks");
            status = json.getString("status");
            truck = json.getString("truck");
            shipmentId = json.getInt("shipmentId");
            userId = json.getInt("userId");
            truckType = json.getInt("truckType");
            truckCount = json.getInt("truckCount");
            advance = json.getDouble("advance");
            extraHeight = json.getDouble("extraHeight");
            reverseBid = json.getString("reverseBid");
            commission = json.getDouble("commission");
            bids = new ArrayList<>();
            items = new ArrayList<>();
            pickup = new ArrayList<>();
            delivery = new ArrayList<>();

            JSONArray bidsJSON = json.getJSONArray("bids"),
                    itemsJSON = json.getJSONArray("items"),
                    pickupJSON = json.getJSONArray("pickAddress"),
                    deliveryJSON = json.getJSONArray("deliveryAddress");
            for (int i = 0; i < bidsJSON.length(); i++) {
                 bids.add(new Bid(bidsJSON.getJSONObject(i)));
            }
            for (int i = 0; i < itemsJSON.length(); i++) {
                items.add(new ShipmentItem(itemsJSON.getJSONObject(i)));
            }
            for (int i = 0; i < pickupJSON.length(); i++) {
                pickup.add(new ShipmentAddress(pickupJSON.getJSONObject(i)));
            }
            for (int i = 0; i < deliveryJSON.length(); i++) {
                delivery.add(new ShipmentAddress(deliveryJSON.getJSONObject(i)));
            }

            DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
            pickupDate = isoFormat.parse(json.getString("pickupDate"));
            bidClosingDate = isoFormat.parse(json.getString("bidClosingDate"));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Bid> getBids() {
        return bids;
    }

    public List<ShipmentItem> getItems() {
        return items;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public Date getBidClosingDate() {
        return bidClosingDate;
    }

    public List<ShipmentAddress> getPickup() {
        return pickup;
    }

    public List<ShipmentAddress> getDelivery() {
        return delivery;
    }

    public String getGeneratedId() {
        return generatedId;
    }

    public String getShipper() {
        return shipper;
    }

    public String getTransporter() {
        return transporter;
    }

    public String getTransporterId() {
        return transporterId;
    }

    public String getBalance() {
        return balance;
    }

    public String getDala() {
        return dala;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getStatus() {
        return status;
    }

    public String getTruck() {
        return truck;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public int getUserId() {
        return userId;
    }

    public int getTruckType() {
        return truckType;
    }

    public int getTruckCount() {
        return truckCount;
    }

    public double getAdvance() {
        return advance;
    }

    public double getExtraHeight() {
        return extraHeight;
    }

    public String getReverseBid() {
        return reverseBid;
    }

    public double getCommission() {
        return commission;
    }
}
