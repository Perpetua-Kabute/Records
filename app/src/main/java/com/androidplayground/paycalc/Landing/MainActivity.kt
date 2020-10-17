package com.androidplayground.paycalc.Landing

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.androidplayground.paycalc.R
import com.androidplayground.paycalc.WorkerListActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    private lateinit var mFirebaseAuth : FirebaseAuth
    private lateinit var mAuthStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAuth = FirebaseAuth.getInstance()
        val toolbar = findViewById<Toolbar?>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val btn1 = findViewById<Button?>(R.id.button1)
        btn1.setOnClickListener { startActivity(Intent(this@MainActivity, WorkerListActivity::class.java)) }
        mAuthStateListener = FirebaseAuth.AuthStateListener{firebaseAuth ->
            val user = firebaseAuth.currentUser
            if(user != null){

            }else{
                
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onResume() {
        super.onResume()
        mFirebaseAuth.addAuthStateListener(mAuthStateListener)
    }

    override fun onPause() {
        super.onPause()
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener)
    }

    //    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        val id = item.getItemId()
//        return if (id == R.id.action_settings) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }

}