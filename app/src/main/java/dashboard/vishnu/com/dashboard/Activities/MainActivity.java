package dashboard.vishnu.com.dashboard.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dashboard.vishnu.com.dashboard.Adapters.ShipmentAdapter;
import dashboard.vishnu.com.dashboard.Models.Shipment;
import dashboard.vishnu.com.dashboard.R;

public class MainActivity extends AppCompatActivity {

    //recyclerview objects
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //model object for our list data
    private List<Shipment> shipments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing views
        recyclerView = (RecyclerView) findViewById(R.id.shipments);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        shipments = new ArrayList<>();

        //loading list view item with this function
        loadShipments();
    }

    private void loadShipments() {
        //you can fetch the data from server or some apis
        try {
            JSONObject shipment = new JSONObject("{\n" +
                    "        \"shipmentId\": 7191,\n" +
                    "        \"generatedId\": \"SP17041271914\",\n" +
                    "        \"shipperId\": \"SR1704112913\",\n" +
                    "        \"userId\": 732,\n" +
                    "        \"transporterId\": \"TR1704114913\",\n" +
                    "        \"pickupDate\": \"2017-04-11T18:30:00.000Z\",\n" +
                    "        \"bidClosingDate\": \"2017-04-12T16:51:00.000Z\",\n" +
                    "        \"advance\": 60,\n" +
                    "        \"balance\": \"pahuch\",\n" +
                    "        \"truckType\": 17,\n" +
                    "        \"truckCount\": 1,\n" +
                    "        \"dala\": \"open\",\n" +
                    "        \"extraHeight\": 10,\n" +
                    "        \"expectedAmount\": 7800,\n" +
                    "        \"reverseBid\": null,\n" +
                    "        \"remarks\": \"Details on call\",\n" +
                    "        \"insurance\": \"yes\",\n" +
                    "        \"assistance\": \"yes\",\n" +
                    "        \"paymentProcessId\": 1,\n" +
                    "        \"createdAt\": \"2017-04-12T08:51:36.000Z\",\n" +
                    "        \"status\": \"accepted\",\n" +
                    "        \"truck\": \"11 Ton (2016 etc.)\",\n" +
                    "        \"shipper\": \"Bharat Sarkaar\",\n" +
                    "        \"transporter\": \"Vaahika\",\n" +
                    "        \"commission\": 0,\n" +
                    "        \"pickup\": \"VBN#Hingoli\",\n" +
                    "        \"delivery\": \"VKI#Jaipur\",\n" +
                    "        \"items\": [\n" +
                    "          {\n" +
                    "            \"shipmentId\": 7191,\n" +
                    "            \"capsuleId\": null,\n" +
                    "            \"itemId\": 7517,\n" +
                    "            \"name\": \"Cotton\",\n" +
                    "            \"weight\": 20,\n" +
                    "            \"quantity\": 50\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"bids\": [\n" +
                    "          {\n" +
                    "            \"transporterId\": 491,\n" +
                    "            \"shipmentId\": 7191,\n" +
                    "            \"bidId\": 8366,\n" +
                    "            \"quote\": 23423,\n" +
                    "            \"oldQuote\": 23423,\n" +
                    "            \"remarks\": \"good\",\n" +
                    "            \"offerAction\": null,\n" +
                    "            \"createdAt\": \"2017-04-12T12:50:14.000Z\",\n" +
                    "            \"status\": \"accepted\",\n" +
                    "            \"transporter\": \"TR1704114913\",\n" +
                    "            \"rating\": 0\n" +
                    "          }\n" +
                    "        ]}");

            for (int i = 1; i <= 5; i++) {
                Shipment shipmentData = new Shipment(shipment);
                shipments.add(shipmentData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new ShipmentAdapter(shipments, this);
        recyclerView.setAdapter(adapter);
    }
}
