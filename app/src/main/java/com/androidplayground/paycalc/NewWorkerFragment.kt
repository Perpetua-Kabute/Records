package com.androidplayground.paycalc

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.androidplayground.paycalc.databinding.FragmentNewWorkerBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


/**
 * A simple [Fragment] subclass.
 * Use the [NewWorkerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewWorkerFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var selectedItem: String= ""


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
        val spinner = binding.newWorkerCategory

        val db = Firebase.firestore


        val spinnerAdapter = ArrayAdapter(requireActivity().baseContext, android.R.layout.simple_spinner_item, CategoriesFragment().categories )
        spinner.adapter=spinnerAdapter

        spinner.onItemSelectedListener= this

        binding.add.setOnClickListener {
            val user = hashMapOf(
                    "name" to name,
                    "category" to selectedItem
            )
            db.collection("workers")
                    .add(user)
                    .addOnSuccessListener {
                        Log.i( "DocumentSnapshot ", user.toString())
                    }
                    .addOnFailureListener {
                        Log.i("failure","failed")
                    }
            
        }
        return binding.root
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        selectedItem = parent?.getItemAtPosition(position).toString()
        Log.i("NewWorkerFragment", selectedItem)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.i("NewWorkerFragment", "no item selected")
    }


}