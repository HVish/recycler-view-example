package dashboard.vishnu.com.dashboard.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vishnu on 18/4/17.
 */

public class Shipment {
    private String generatedId, shipper, transporter, transporterId, balance, dala, remarks, status, truck;
    private int shipmentId, userId, truckType, truckCount;
    private double advance, extraHeight, reverseBid, commission;

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
            reverseBid = json.getDouble("reverseBid");
            commission = json.getDouble("commission");
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    public double getReverseBid() {
        return reverseBid;
    }

    public double getCommission() {
        return commission;
    }
}
