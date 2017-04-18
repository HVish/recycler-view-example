package dashboard.vishnu.com.dashboard.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by vishnu on 18/4/17.
 */

public class ShipmentAddress {
    private String area, type;
    private int id;
    private City city;
    private State state;

    public ShipmentAddress(JSONObject json) {
        try {
            area = json.getString("area");
            type = json.getString("type");
            id = json.getInt("id");
            city = new City(json.getJSONObject("city"));
            state = new State(json.getJSONObject("state"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ShipmentAddress(String city, String area) {
        this.city = new City("city");
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public State getState() {
        return state;
    }
}
