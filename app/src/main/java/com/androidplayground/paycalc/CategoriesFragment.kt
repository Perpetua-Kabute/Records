package com.androidplayground.paycalc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidplayground.paycalc.dummy.CategoryInfo
import com.google.android.play.core.internal.i
import java.lang.Math.random
import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: CategoryAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.category_list_view)
        adapter= CategoryAdapter(prepareDummyCategoryInfo() as List<CategoryInfo>)
        recyclerView?.setAdapter(adapter)
    }

    private fun prepareDummyCategoryInfo(): MutableList<CategoryInfo?> {
        val categoryInfos: MutableList<CategoryInfo?> = ArrayList()
        val categories = listOf("construction", "farming", "slashing", "cleaning", "weeding", "weeding", "BabySitting", "washing")

       for( category in categories){
           val cat = category
           categoryInfos.add(CategoryInfo(cat, (1000..10000).random()))
       }
        return categoryInfos
    }
}