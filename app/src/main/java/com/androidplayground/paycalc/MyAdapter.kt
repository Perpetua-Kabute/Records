package com.androidplayground.paycalc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class MyAdapter(private val mWorker: List<WorkerInfo>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val worker: List<WorkerInfo>? = null
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
//        val context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_worker_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val worker = mWorker[position]
        holder.mDate.text = worker.getDate()
        holder.mUnit.setText(worker.getUnit())
    }

    override fun getItemCount(): Int {
        return mWorker.size
    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        public lateinit var  mDate: TextView
        public lateinit var mUnit: TextView

        init {
            mDate = view.findViewById(R.id.date)
            mUnit = view.findViewById(R.id.unit)
        }
    }
}