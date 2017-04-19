package dashboard.vishnu.com.dashboard.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import dashboard.vishnu.com.dashboard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BidContainer extends Fragment {

    private String transporter, remarks;
    private double quote;

    public BidContainer() {
        // Required empty public constructor
    }

    // newInstance constructor for creating fragment with arguments
    public static BidContainer newInstance(String transporter, String remarks, double quote) {
        BidContainer bidFragment = new BidContainer();
        Bundle args = new Bundle();
        args.putDouble("quote", quote);
        args.putString("transporter", transporter);
        args.putString("remarks", remarks);
        bidFragment.setArguments(args);
        return bidFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quote = getArguments().getDouble("quote", 0);
        transporter = getArguments().getString("transporter");
        remarks = getArguments().getString("remarks");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bid_container, container, false);

        TextView tvQuote = (TextView) view.findViewById(R.id.quote);
        TextView tvTransporter = (TextView) view.findViewById(R.id.bidTransporter);
        TextView tvRemarks = (TextView) view.findViewById(R.id.bidRemarks);

        tvQuote.setText("" + quote + "");
        tvTransporter.setText("Transporter: " + transporter + "");
        tvRemarks.setText("Remarks: " + remarks + "");

        return view;
    }

}
