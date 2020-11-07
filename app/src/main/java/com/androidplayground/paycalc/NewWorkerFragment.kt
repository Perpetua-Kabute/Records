package com.androidplayground.paycalc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val binding: FragmentNewWorkerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_worker,container,false)
        return binding.root
    }


}