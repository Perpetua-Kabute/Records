package com.androidplayground.paycalc.Landing

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel(){
    private lateinit var mFirebaseAuth : FirebaseAuth
    private lateinit var mAuthStateListener: FirebaseAuth.AuthStateListener


}