package com.androidplayground.paycalc

import android.icu.number.Notation.simple
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.androidplayground.paycalc.databinding.FragmentNewWorkerBinding


/**
 * A simple [Fragment] subclass.
 * Use the [NewWorkerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewWorkerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.i("NewWorkerFragment","Fragment created")
        val binding: FragmentNewWorkerBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_new_worker,
                container,
                false)
        val name = binding.newWorkerName.text.toString()
        val category = binding.newWorkerCategory


        val spinnerAdapter = ArrayAdapter(requireActivity().baseContext, android.R.layout.simple_spinner_item, CategoriesFragment().categories )
        category.adapter=spinnerAdapter
        return binding.root
    }


}