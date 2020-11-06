package com.androidplayground.paycalc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.androidplayground.paycalc.databinding.CategoryListContentBinding
import com.androidplayground.paycalc.databinding.WorkerDetailItemBinding
import com.androidplayground.paycalc.dummy.CategoryInfo

class CategoryAdapter(private val categoryitem: List<CategoryInfo>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CategoryListContentBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.category_list_content,
                parent,
        false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) = holder.bind(categoryitem[position])

    override fun getItemCount(): Int {
        return categoryitem.size
    }
    class ViewHolder(val binding: CategoryListContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryInfo){
            binding.apply {
                categoryName.text = item.categoryName
                rate.text = item.rate.toString()
            }
        }
    }
}