package dashboard.vishnu.com.dashboard.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vishnu on 18/4/17.
 */

public class State {
    private int stateId;
    private String name;

    public State(JSONObject json) {
        try {
            stateId = json.getInt("stateId");
            name = json.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getStateId() {

        return stateId;
    }

    public String getName() {
        return name;
    }
}
