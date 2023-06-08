package com.example.tinder20.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tinder20.R
import com.example.tinder20.databinding.FragmentRegistrationFragmnetBinding
import com.example.tinder20.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth
import java.security.MessageDigest
import com.example.tinder20.functions.hashString


class SignIn : Fragment() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        mAuth = FirebaseAuth.getInstance()
        binding.toggleButtonPassword.setOnClickListener {
            if (binding.password.transformationMethod == PasswordTransformationMethod.getInstance()) {
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

        binding.LogIn.setOnClickListener{
            it.findNavController().navigate(R.id.action_registrationFragmnet_to_signIn2)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignIn()
    }
}