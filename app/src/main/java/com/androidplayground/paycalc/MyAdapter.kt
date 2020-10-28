package com.androidplayground.paycalc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidplayground.paycalc.databinding.WorkerDetailItemBinding

class MyAdapter(private val worker: List<WorkerInfo>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
//        val context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: WorkerDetailItemBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.worker_detail_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(worker[position])

    override fun getItemCount(): Int {
        return worker.size
    }

    class ViewHolder(val binding: WorkerDetailItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WorkerInfo){
            binding.apply {
                date.text = item.date
                category.text = item.category
                unit.text = item.unit.toString()
            }
        }
    }
}