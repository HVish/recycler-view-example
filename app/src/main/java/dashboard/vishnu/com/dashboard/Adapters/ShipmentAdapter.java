package dashboard.vishnu.com.dashboard.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dashboard.vishnu.com.dashboard.Models.Shipment;
import dashboard.vishnu.com.dashboard.Models.ShipmentAddress;
import dashboard.vishnu.com.dashboard.R;

/**
 * Created by vishnu on 18/4/17.
 */

public class ShipmentAdapter extends RecyclerView.Adapter<ShipmentAdapter.ViewHolder> {
    private List<Shipment> shipments;
    private Context context;

    public ShipmentAdapter(List<Shipment> shipments, Context context) {
        this.shipments = shipments;
        this.context = context;
    }

    @Override
    public ShipmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shipment_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ShipmentAdapter.ViewHolder holder, int position) {
        Shipment shipment = shipments.get(position);

//        holder.shipmentItemName.setText(shipment.getItems().get(0).getName());
//        holder.shipmentItemWeight.setText("" + shipment.getItems().get(0).getWeight() + " Tones");
        holder.shipmentTruckType.setText(shipment.getTruck());
        holder.shipmentDalaHeight.setText("Dala " + shipment.getDala() + ", " + shipment.getExtraHeight() + "ft Height");
        holder.shipmentAdvance.setText("Advance: " + shipment.getAdvance() + "%");
        holder.shipmentBalance.setText("Balance: " + shipment.getBalance() + "");
//        holder.pickup.setText(shipment.getPickup().getCity().getName());
//        holder.delivery.setText(shipment.getDelivery().getCity().getName());
    }

    @Override
    public int getItemCount() {
        return shipments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView shipmentItemName,
                shipmentItemWeight,
                shipmentTruckType,
                shipmentDalaHeight,
                shipmentAdvance,
                shipmentBalance,
                pickup,
                delivery;
        public ViewHolder(View itemView) {
            super(itemView);

            shipmentItemName = (TextView) itemView.findViewById(R.id.shipmentItemName);
            shipmentItemWeight = (TextView) itemView.findViewById(R.id.shipmentItemWeight);
            shipmentTruckType = (TextView) itemView.findViewById(R.id.shipmentTruckType);
            shipmentDalaHeight = (TextView) itemView.findViewById(R.id.shipmentDalaHeight);
            shipmentAdvance = (TextView) itemView.findViewById(R.id.shipmentAdvance);
            shipmentBalance = (TextView) itemView.findViewById(R.id.shipmentBalance);
            pickup = (TextView) itemView.findViewById(R.id.pickup);
            delivery = (TextView) itemView.findViewById(R.id.delivery);
        }
    }
}
