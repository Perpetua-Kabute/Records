package com.androidplayground.paycalc;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidplayground.paycalc.dummy.DummyContent;

/**
 * A fragment representing a single Worker detail screen.
 * This fragment is either contained in a {@link WorkerListActivity}
 * in two-pane mode (on tablets) or a {@link WorkerDetailActivity}
 * on handsets.
 */
public class WorkerDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;
    private ConstraintLayout layoutManager;
    private RecyclerView.Adapter mAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WorkerDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.workerName);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.worker_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
           // ((TextView) rootView.findViewById(R.id.worker_name_item)).setText(mItem.workerName);
            ((TextView) rootView.findViewById(R.id.worker_category)).setText(mItem.category);

            View recyclerView = ((RecyclerView) rootView.findViewById(R.id.worker_details));
            ((RecyclerView) recyclerView).setHasFixedSize(true);
            layoutManager = new ConstraintLayout(getActivity());

            mAdapter = new MyAdapter();


        }

        return rootView;
    }
}
