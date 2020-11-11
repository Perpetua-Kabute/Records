package com.androidplayground.paycalc

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.androidplayground.paycalc.dummy.DummyContent
import com.androidplayground.paycalc.dummy.DummyContent.DummyItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * An activity representing a list of Workers. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [WorkerDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class WorkerListActivity : AppCompatActivity() {
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_list)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title
        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            setContentView(R.layout.activity_host)
            if(savedInstanceState == null){
                val fragment = NewWorkerFragment()
//                fragmentManager.support .popBackStack(NewWorkerFragment.class.name(), fragmentManager.POP_BACK_STACK_INCLUSIVE )
                supportFragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit()
            }
        }
        if (findViewById<View?>(R.id.worker_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true
        }
        val recyclerView = findViewById<View>(R.id.worker_list)!!
        setupRecyclerView(recyclerView as RecyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, DummyContent.ITEMS, mTwoPane)
    }

    class SimpleItemRecyclerViewAdapter(private val mParentActivity: WorkerListActivity,
                                        private val mValues: MutableList<DummyItem?>?,
                                        private val mTwoPane: Boolean) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {
        private val mOnClickListener = View.OnClickListener { view ->
            val item = view.tag as DummyItem
            if (mTwoPane) {
//                    Bundle arguments = new Bundle();
//                    arguments.putString(WorkerDetailFragment.ARG_ITEM_ID, item.id);
                val fragment = BlankFragment()
                //                    fragment.setArguments(arguments);
                mParentActivity.supportFragmentManager.beginTransaction()
                        .replace(R.id.worker_detail_container, fragment)
                        .commit()
            } else {
                val context = view.context
                val intent = Intent(context, WorkerDetailActivity::class.java)
                //intent.putExtra(WorkerDetailFragment.ARG_ITEM_ID, item.id)
                context.startActivity(intent)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.worker_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // holder.mIdView.setText(mValues.get(position).id);
            //holder.mContentView.setText(mValues.get(position).content);
            holder.mWorkerName.text = mValues!![position]!!.workerName
            holder.mWorkerAmount.text = mValues[position]!!.amount
            holder.itemView.tag = mValues[position]
            holder.itemView.setOnClickListener(mOnClickListener)
        }

        override fun getItemCount(): Int {

            return mValues!!.size
        }

         inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            //final TextView mIdView;
            //final TextView mContentView;
            val mWorkerName: TextView
            val mWorkerAmount: TextView

            init {
                mWorkerName = view.findViewById<View>(R.id.worker_name) as TextView
                mWorkerAmount = view.findViewById<View>(R.id.t_amount) as TextView
            }
        }
    }
}