package dashboard.vishnu.com.dashboard.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vishnu on 18/4/17.
 */

public class City {
    private int cityId;
    private String name;

    public City(JSONObject json) {
        try {
            cityId = json.getInt("cityId");
            name = json.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public City(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }
}
