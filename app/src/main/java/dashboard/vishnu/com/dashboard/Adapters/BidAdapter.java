package dashboard.vishnu.com.dashboard.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import dashboard.vishnu.com.dashboard.Models.Bid;
import dashboard.vishnu.com.dashboard.R;

/**
 * Created by vishnu on 19/4/17.
 */

public class BidAdapter extends RecyclerView.Adapter<BidAdapter.ViewHolder>{

    private List<Bid> bids;
    private Context context;

    public BidAdapter(List<Bid> bids, Context context) {
        this.bids = bids;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_bid_container, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bid bid = bids.get(position);

        holder.quote.setText("" + bid.getQuote() + "");
        holder.bidTransporter.setText(bid.getTransporter());
        holder.transporterRating.setRating((float) bid.getRating());
        holder.bidRemarks.setText(bid.getRemarks());
    }

    @Override
    public int getItemCount() {
        return bids.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView quote, bidTransporter, bidRemarks;
        public RatingBar transporterRating;

        public ViewHolder(View itemView) {
            super(itemView);

            quote = (TextView) itemView.findViewById(R.id.quote);
            bidTransporter = (TextView) itemView.findViewById(R.id.bidTransporter);
            bidRemarks = (TextView) itemView.findViewById(R.id.bidRemarks);
            transporterRating = (RatingBar) itemView.findViewById(R.id.transporterRating);
            Drawable progress = transporterRating.getProgressDrawable();
            DrawableCompat.setTint(progress, Color.parseColor("#f2b01e"));
        }
    }
}
