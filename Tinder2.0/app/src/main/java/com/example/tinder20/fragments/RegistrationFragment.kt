package com.example.tinder20.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tinder20.R
import com.example.tinder20.databinding.FragmentRegistrationBinding
import com.example.tinder20.functions.hashString
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.SignInMethodQueryResult
import com.google.firebase.ktx.Firebase

class RegistrationFragment : Fragment() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var binding: FragmentRegistrationBinding
    override fun onStart() {
        super.onStart()
        if(mAuth.currentUser != null){
            //логика перехода на основной экран
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        mAuth = FirebaseAuth.getInstance()

        binding.btnConfirmRegistaration.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            val dBemail = binding.etEmail.text.toString().trim()
            val dBpassword = binding.etPassword.text.toString().trim()
            if (TextUtils.isEmpty(dBpassword)) {
                binding.progressBar.visibility = View.GONE
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(dBemail)) {
                binding.progressBar.visibility = View.GONE
                return@setOnClickListener
            }
            if (binding.etPassword.text.toString().length < 8) {
                binding.etPassword.setHintTextColor(R.color.redError.toInt())
                binding.layoutPasswordInput.helperText = "8+ symbols!"
                binding.progressBar.visibility = View.GONE
                return@setOnClickListener
            }
            val hashedPassword = hashString(dBpassword)
            FirebaseAuth.getInstance().fetchSignInMethodsForEmail(dBemail)
                .addOnSuccessListener {
                mAuth.createUserWithEmailAndPassword(dBemail, hashedPassword)
                    .addOnSuccessListener {
                        //логика когда юзер зарегистировался
                    }
                    .addOnFailureListener{
                        //логика когда юзер не зарегестрировался,тк есть аккаунт с таким email
                    }
                }
                .addOnFailureListener{
                    //логика когда пользователь ввел неккоректный email
                }
            binding.progressBar.visibility = View.GONE
        }
        binding.btnSingIn.setOnClickListener{
            it.findNavController().navigate(R.id.action_registrationFragmnet_to_signIn2)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }
}
