package dashboard.vishnu.com.dashboard.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vishnu on 18/4/17.
 */

public class ShipmentItem {
    private String name;
    private int shipmentId, capsuleId, itemId, quantity;
    private double weight;

    public ShipmentItem(JSONObject json) {
        try {
            name = json.getString("name");
            shipmentId = json.getInt("shipmentId");
            capsuleId = json.getInt("capsuleId");
            itemId = json.getInt("itemId");
            quantity = json.getInt("quantity");
            weight = json.getDouble("weight");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public int getCapsuleId() {
        return capsuleId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }
}
