package com.dennisiluma.fashionartisan.client.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dennisiluma.fashionartisan.R
import com.dennisiluma.fashionartisan.databinding.FragmentClientDashboardBinding
import com.dennisiluma.fashionartisan.databinding.FragmentSignupBinding

class ClientDashboardFragment : Fragment() {
    private var _binding: FragmentClientDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layer for this fragment
        _binding = FragmentClientDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}