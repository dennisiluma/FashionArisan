package com.dennisiluma.fashionartisan.client.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dennisiluma.fashionartisan.R
import com.dennisiluma.fashionartisan.databinding.ActivityClientBinding
import com.dennisiluma.fashionartisan.databinding.ActivityMainBinding

class ClientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}