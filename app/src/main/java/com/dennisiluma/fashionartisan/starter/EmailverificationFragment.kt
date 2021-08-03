package com.dennisiluma.fashionartisan.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dennisiluma.fashionartisan.databinding.FragmentEmailverificationBinding

class EmailverificationFragment : Fragment() {
    private var _binding: FragmentEmailverificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layer for this fragment
        _binding = FragmentEmailverificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}