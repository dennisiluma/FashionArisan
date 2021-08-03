package com.dennisiluma.fashionartisan.client.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dennisiluma.fashionartisan.databinding.FragmentClientPostsBinding

class ClientPostsFragment : Fragment() {
    private var _binding:FragmentClientPostsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientPostsBinding.inflate(inflater,container,false)
        return binding.root
    }
}