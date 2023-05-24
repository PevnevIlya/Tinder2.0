package com.example.tinder20.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tinder20.R
import com.example.tinder20.databinding.FragmentRegistrationFragmnetBinding

class RegistrationFragmnet : Fragment() {

    private lateinit var binding: FragmentRegistrationFragmnetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationFragmnetBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragmnet()
    }
}