package com.example.tinder20.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tinder20.MainActivity
import com.example.tinder20.R
import com.example.tinder20.classes.GENDERS
import com.example.tinder20.databinding.FragmentRegistrationFragmnetBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.security.MessageDigest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistrationFragmnet : Fragment() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var binding: FragmentRegistrationFragmnetBinding
    fun hashString(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
    public override fun onStart() {
        super.onStart()
        if(mAuth.currentUser != null){
            //логика перехода на основной экран 
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationFragmnetBinding.inflate(inflater, container, false)
        mAuth = FirebaseAuth.getInstance()
        binding.toggleButtonPassword.setOnClickListener{
            if(binding.password.transformationMethod == PasswordTransformationMethod.getInstance()){
                binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
            } else {
                binding.password.setTransformationMethod(PasswordTransformationMethod.getInstance())
            }
        }

        binding.confirm.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            val dBemail = binding.email.text.toString().trim()
            val dBpassword = binding.password.text.toString().trim()
            if (TextUtils.isEmpty(dBpassword)) {
                binding.progressBar.visibility = View.GONE
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(dBemail)) {
                binding.progressBar.visibility = View.GONE
                return@setOnClickListener
            }
            if (binding.password.text.length < 8) {
                binding.textOnPassword.setTextColor(Color.RED)
                binding.textOnPassword.text = "8+ symbols!"
                binding.progressBar.visibility = View.GONE
                return@setOnClickListener
            }
            val hashedPassword = hashString(dBpassword)
            mAuth.createUserWithEmailAndPassword(dBemail, hashedPassword)
            binding.progressBar.visibility = View.GONE
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragmnet()
    }
}
