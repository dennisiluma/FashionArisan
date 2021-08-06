package com.dennisiluma.fashionartisan.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dennisiluma.fashionartisan.R
import com.dennisiluma.fashionartisan.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    /* declare variables that will be initialized when needed */
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*inflate the layer for this fragment*/
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*What will happen when SignUp Button is pressed */
        binding.fragmentLoginSignupButton.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signup)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}