package dashboard.vishnu.com.dashboard.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vishnu on 18/4/17.
 */

public class Bid {
    private int transporterId, shipmentId, bidId;
    private double quote, oldQuote, rating;
    private String remarks, offerAction, status, transporter;

    public Bid(JSONObject json) {
        try {
            remarks = json.getString("remarks");
            offerAction = json.getString("offerAction");
            status = json.getString("status");
            transporter = json.getString("transporter");
            transporterId = json.getInt("transporterId");
            shipmentId = json.getInt("shipmentId");
            bidId = json.getInt("bidId");
            quote = json.getDouble("quote");
            oldQuote = json.getDouble("oldQuote");
            rating = json.getDouble("rating");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getTransporterId() {

        return transporterId;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public int getBidId() {
        return bidId;
    }

    public double getQuote() {
        return quote;
    }

    public double getOldQuote() {
        return oldQuote;
    }

    public double getRating() {
        return rating;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getOfferAction() {
        return offerAction;
    }

    public String getStatus() {
        return status;
    }

    public String getTransporter() {
        return transporter;
    }
}
