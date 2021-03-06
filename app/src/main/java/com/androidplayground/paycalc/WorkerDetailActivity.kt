package com.androidplayground.paycalc

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import org.junit.runner.RunWith

/**
 * An activity representing a single Worker detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [WorkerListActivity].
 */
class WorkerDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_detail)
        val toolbar = findViewById<View?>(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById<View?>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            setContentView(R.layout.activity_host)
            if(savedInstanceState == null){
                val fragment = WorkEntryFragment()
                supportFragmentManager.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit()
            }
        }

        // Show the Up button in the action bar.
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val arguments = Bundle()
//            arguments.putString(WorkerDetailFragment.Companion.ARG_ITEM_ID,
//                    intent.getStringExtra(WorkerDetailFragment.Companion.ARG_ITEM_ID))
            val fragment = BlankFragment()
            //fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                    .add(R.id.worker_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(Intent(this, WorkerListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}