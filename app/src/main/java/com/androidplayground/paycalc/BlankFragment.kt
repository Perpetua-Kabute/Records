package com.androidplayground.paycalc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.junit.runner.RunWith
import java.util.*

class BlankFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize recyclerview
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = MyAdapter(activity, prepareDummyWorkerInfo())
        recyclerView.setAdapter(adapter)
    }

    private fun prepareDummyWorkerInfo(): MutableList<WorkerInfo?>? {
        val workerInfos: MutableList<WorkerInfo?> = ArrayList()
        workerInfos.add(WorkerInfo("", 0))
        workerInfos.add(WorkerInfo("", 1))
        workerInfos.add(WorkerInfo("", 2))
        return workerInfos
    }
}