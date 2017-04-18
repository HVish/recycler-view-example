package dashboard.vishnu.com.dashboard.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dashboard.vishnu.com.dashboard.Adapters.ShipmentAdapter;
import dashboard.vishnu.com.dashboard.Config;
import dashboard.vishnu.com.dashboard.Models.Shipment;
import dashboard.vishnu.com.dashboard.R;
import dashboard.vishnu.com.dashboard.Utils.AppController;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    //recyclerview objects
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //model object for our list data
    private List<Shipment> shipments;

    // progress dialog
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing views
        recyclerView = (RecyclerView) findViewById(R.id.shipments);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progress = new ProgressDialog(this);
        progress.setMessage("Please wait...");
        progress.setCancelable(false);

        shipments = new ArrayList<>();

        //loading list view item with this function
        loadShipments();
    }

    private void loadShipments() {

        showProgressDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                Config.DASHBOARD_URL + "?tab=older", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONObject result = response.getJSONObject("result");
                    JSONArray shipmentsJSON = result.getJSONArray("tab");
                    for (int i = 0; i < shipmentsJSON.length(); i++) {
                         shipments.add(new Shipment(shipmentsJSON.getJSONObject(i)));
                    }
                    adapter = new ShipmentAdapter(shipments, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hideProgressDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(MainActivity.this.getApplicationContext(),
                        networkResponse.statusCode, Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hideProgressDialog();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImZsYXNoIjp7fSwiYXV0aGVudGljYXRlZCI6dHJ1ZSwidXNlcklkIjo3MzIsInVzZXJOYW1lIjoiUmF0aXNoIiwidXNlclR5cGUiOiJzaGlwcGVyIiwidXNlclN0YXR1cyI6ImFjdGl2ZSIsInVzZXJMZXZlbCI6InByaW1hcnkiLCJlbWFpbCI6InJhdGlzaHVAdmFhaGlrYS5jb20iLCJub3RpZmljYXRpb25zIjoiMCIsImFwaUtleSI6IiIsImNvbXBhbnlJZCI6MjkxLCJjb21wYW55U3RhdHVzIjoiYWN0aXZlIn0sImlhdCI6MTQ5MjUwNjA5NywiZXhwIjoxNDkyNTA3NTM3LCJhdWQiOiJ2YWFoaWthLmNvbSIsImlzcyI6InZhYWhpa2EuY29tIn0.wFp8VedcRjLrOX47N-EYKYG8bOv-ptOKCRCi3sFNP_M");
                return params;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void showProgressDialog() {
        if (!progress.isShowing())
            progress.show();
    }

    private void hideProgressDialog() {
        if (progress.isShowing())
            progress.dismiss();
    }
}
