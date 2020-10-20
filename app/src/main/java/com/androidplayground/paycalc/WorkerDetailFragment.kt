package com.androidplayground.paycalc

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.androidplayground.paycalc.dummy.DummyContent
import com.androidplayground.paycalc.dummy.DummyContent.DummyItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.junit.runner.RunWith
import java.util.*

/**
 * A fragment representing a single Worker detail screen.
 * This fragment is either contained in a [WorkerListActivity]
 * in two-pane mode (on tablets) or a [WorkerDetailActivity]
 * on handsets.
 */
class WorkerDetailFragment
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
    : Fragment() {
    /**
     * The dummy content this fragment is presenting.
     */
    private var mItem: DummyItem? = null
    private val layoutManager: ConstraintLayout? = null
    private val mAdapter: RecyclerView.Adapter<*>? = null
    private val worker: MutableList<WorkerInfo?>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments?.containsKey(ARG_ITEM_ID)!!) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP?.get(arguments?.getString(ARG_ITEM_ID))
            val activity: Activity? = this.activity
            val appBarLayout = activity?.findViewById<View?>(R.id.toolbar_layout) as CollapsingToolbarLayout
            if (appBarLayout != null) {
                appBarLayout.title = mItem?.workerName
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.worker_detail, container, false)

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            // ((TextView) rootView.findViewById(R.id.worker_name_item)).setText(mItem.workerName);
            (rootView.findViewById<View?>(R.id.worker_category) as TextView).text = mItem!!.category
        }
        return rootView
    } //    @Override

    //    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    //        super.onViewCreated(view, savedInstanceState);
    //        View recyclerView = ((RecyclerView) view.findViewById(R.id.worker_details));
    //        ((RecyclerView) recyclerView).setHasFixedSize(true);
    //        layoutManager = new LinearLayoutManager(getActivity());
    //        initializeContent();
    //        mAdapter = new MyAdapter(this.getActivity(), worker);
    //        ((RecyclerView) recyclerView).setAdapter(mAdapter);
    //    }
    //
    //    public void initializeContent(){
    //        for(int count = 0; count < 25; count++){
    //            worker.add(new WorkerInfo(String.valueOf(21), 34));
    //        }
    //    }
    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        val ARG_ITEM_ID: String? = "item_id"
    }
}