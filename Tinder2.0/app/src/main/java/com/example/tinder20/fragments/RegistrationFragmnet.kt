package com.example.tinder20.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.tinder20.MainActivity
import com.example.tinder20.R
import com.example.tinder20.classes.GENDERS
import com.example.tinder20.databinding.FragmentRegistrationFragmnetBinding
import java.security.MessageDigest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistrationFragmnet : Fragment() {

    private lateinit var binding: FragmentRegistrationFragmnetBinding
    private var db = Firebase.firestore
    var gender = GENDERS.UNKNOWN
    fun hashString(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationFragmnetBinding.inflate(inflater, container, false)


        binding.maleRadioButton.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked) {
                gender = GENDERS.MALE
            }
        }
        binding.femaleRadioButton.setOnCheckedChangeListener{
                _, isChecked ->
            if (isChecked) {
                gender = GENDERS.FEMALE
            }
        }

        binding.toggleButtonPassword.setOnClickListener{
            if(binding.password.transformationMethod == PasswordTransformationMethod.getInstance()){
                binding.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
            } else {
                binding.password.setTransformationMethod(PasswordTransformationMethod.getInstance())
            }
        }

        binding.confirm.setOnClickListener{
            if(binding.password.text.length < 8){
                binding.textOnPassword.setTextColor(Color.RED)
                binding.textOnPassword.text = "8+ symbols!"
                return@setOnClickListener
            }
            val usersCollection = db.collection("users")
            val dBemail = binding.email.text.toString().trim()
            val dBpassword = binding.password.text.toString().trim()

            val hashedPassword = hashString(dBpassword)

            val userMap = hashMapOf(
                "email" to dBemail,
                "password" to hashedPassword,
                "gender" to gender.name
            )

            it.findNavController().navigate(R.id.action_registrationFragmnet_to_mainPage)
            usersCollection.add(userMap)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragmnet()
    }
}
