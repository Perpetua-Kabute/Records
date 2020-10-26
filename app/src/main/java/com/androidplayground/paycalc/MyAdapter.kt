package com.androidplayground.paycalc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidplayground.paycalc.databinding.WorkerDetailItemBinding

class MyAdapter(private val mWorker: List<WorkerInfo>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val worker: List<WorkerInfo>? = null
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
//        val context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: WorkerDetailItemBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.worker_detail_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val worker = mWorker[position]
        holder.mDate.text = worker.date
        holder.mUnit.setText(worker.unit)
    }

    override fun getItemCount(): Int {
        return mWorker.size
    }

    class ViewHolder(val binding: WorkerDetailItemBinding) : RecyclerView.ViewHolder(binding.root) {
        public lateinit var  mDate: TextView
        public lateinit var mUnit: TextView

        init {
            mDate = view.findViewById(R.id.date)
            mUnit = view.findViewById(R.id.unit)
        }
    }
}