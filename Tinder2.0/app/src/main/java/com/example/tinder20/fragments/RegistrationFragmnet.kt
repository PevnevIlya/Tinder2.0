package com.example.tinder20.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tinder20.R
import com.example.tinder20.databinding.FragmentRegistrationFragmnetBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistrationFragmnet : Fragment() {

    private lateinit var binding: FragmentRegistrationFragmnetBinding
    private var db = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationFragmnetBinding.inflate(inflater, container, false)

        binding.confirm.setOnClickListener{
            val dBemail = binding.email.text.toString().trim()
            val dBpassword = binding.password.text.toString().trim()

            val userMap = hashMapOf(
                "email" to dBemail,
                "password" to dBpassword
            )

            db.collection("user").add(userMap)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "Succes", Toast.LENGTH_LONG).show()
                    binding.email.text.clear()
                    binding.password.text.clear()
                }
                .addOnFailureListener{
                    Toast.makeText(requireContext(), "Failed", Toast.LENGTH_LONG).show()
                }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragmnet()
    }
}