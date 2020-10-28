package com.androidplayground.paycalc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.androidplayground.paycalc.databinding.FragmentBlankBinding
import org.junit.runner.RunWith
import java.util.*

class BlankFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentBlankBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize recyclerview
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = MyAdapter(prepareDummyWorkerInfo()!! as List<WorkerInfo>)
        recyclerView?.setAdapter(adapter)
    }

    private fun prepareDummyWorkerInfo(): List<WorkerInfo?>? {
        val workerInfos: MutableList<WorkerInfo?> = ArrayList()
        workerInfos?.add(WorkerInfo("", 0, "Construction"))
        workerInfos?.add(WorkerInfo("", 1, "farm"))
        workerInfos?.add(WorkerInfo("", 2, "Tea"))
        return workerInfos
    }
}