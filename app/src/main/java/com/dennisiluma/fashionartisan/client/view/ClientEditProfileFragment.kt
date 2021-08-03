package com.dennisiluma.fashionartisan.client.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dennisiluma.fashionartisan.databinding.FragmentClientEditProfileBinding

class ClientEditProfileFragment : Fragment() {
    private var _binding:FragmentClientEditProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
}