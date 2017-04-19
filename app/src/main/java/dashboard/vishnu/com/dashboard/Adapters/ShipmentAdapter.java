package dashboard.vishnu.com.dashboard.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

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
    public void onBindViewHolder(final ShipmentAdapter.ViewHolder holder, int position) {
        final Shipment shipment = shipments.get(position);

        holder.shipmentItemName.setText(shipment.getItems().get(0).getName());
        holder.shipmentItemWeight.setText("" + shipment.getItems().get(0).getWeight() + " Tones");
        holder.shipmentTruckType.setText(shipment.getTruck());
        holder.shipmentDalaHeight.setText("Dala " + shipment.getDala() + ", " + shipment.getExtraHeight() + "ft Height");
        holder.shipmentAdvance.setText("Advance: " + shipment.getAdvance() + "%");
        holder.shipmentBalance.setText("Balance: " + shipment.getBalance() + "");
        holder.pickup.setText(shipment.getPickup().get(0).getCity().getName());
        holder.delivery.setText(shipment.getDelivery().get(shipment.getDelivery().size() - 1).getCity().getName());

        LinearLayoutManager layout = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        holder.rvpBidContainer.setLayoutManager(layout);
        holder.rvpBidContainer.setAdapter(new BidAdapter(shipment.getBids(), context));

        final int totalBids = shipment.getBids().size();
        if (totalBids > 0) {
            holder.tvBidPager.setText("Bid: 1 of " + totalBids + "");
        } else {
            holder.tvBidPager.setText("No Bids");
        }
        if (totalBids < 2) {
            holder.nextBid.setVisibility(View.INVISIBLE);
            holder.prevBid.setVisibility(View.INVISIBLE);
        }

        // change visibility of prev-next buttons based on pages left
        holder.rvpBidContainer.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
            @Override
            public void OnPageChanged(int i, int i1) {
                holder.tvBidPager.setText("Bid: " + (i1 + 1) + " of " + totalBids);
                if ((totalBids - 1) == i1) {
                    holder.nextBid.setVisibility(View.INVISIBLE);
                    holder.prevBid.setVisibility(View.VISIBLE);
                } else if (i1 == 0) {
                    holder.nextBid.setVisibility(View.VISIBLE);
                    holder.prevBid.setVisibility(View.INVISIBLE);
                } else {
                    holder.nextBid.setVisibility(View.VISIBLE);
                    holder.prevBid.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.nextBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.rvpBidContainer.getCurrentPosition();
                if ((pos + 1) < totalBids) {
                    holder.rvpBidContainer.scrollToPosition(pos + 1);
                }
            }
        });

        holder.prevBid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.rvpBidContainer.getCurrentPosition();
                if (pos > 0) {
                    holder.rvpBidContainer.scrollToPosition(pos - 1);
                }
            }
        });

        //creating a popup menu
        final PopupMenu popup = new PopupMenu(context, holder.shipmentOptions);
        //inflating menu from xml resource
        popup.inflate(R.menu.shipment_menu);
        //adding click listener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.editShipmentMenu:
                        Toast.makeText(context, "Edit Shipment", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.reverseBidMenu:
                        Toast.makeText(context, "Reverse Bid", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.shipmentDeleteMenu:
                        Toast.makeText(context, "Delete Shipment", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });

        holder.shipmentOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.show();
            }
        });
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
                delivery,
                shipmentOptions,
                tvBidPager;
        public RecyclerViewPager rvpBidContainer;
        public ImageButton prevBid, nextBid;

        public ViewHolder(View itemView) {
            super(itemView);

            shipmentOptions = (TextView) itemView.findViewById(R.id.shipmentOptions);
            shipmentItemName = (TextView) itemView.findViewById(R.id.shipmentItemName);
            shipmentItemWeight = (TextView) itemView.findViewById(R.id.shipmentItemWeight);
            shipmentTruckType = (TextView) itemView.findViewById(R.id.shipmentTruckType);
            shipmentDalaHeight = (TextView) itemView.findViewById(R.id.shipmentDalaHeight);
            shipmentAdvance = (TextView) itemView.findViewById(R.id.shipmentAdvance);
            shipmentBalance = (TextView) itemView.findViewById(R.id.shipmentBalance);
            pickup = (TextView) itemView.findViewById(R.id.pickup);
            delivery = (TextView) itemView.findViewById(R.id.delivery);
            rvpBidContainer = (RecyclerViewPager) itemView.findViewById(R.id.rvpBidContainer);
            prevBid = (ImageButton) itemView.findViewById(R.id.prevBid);
            nextBid = (ImageButton) itemView.findViewById(R.id.nextBid);
            tvBidPager = (TextView) itemView.findViewById(R.id.tvBidPager);
        }
    }
}
