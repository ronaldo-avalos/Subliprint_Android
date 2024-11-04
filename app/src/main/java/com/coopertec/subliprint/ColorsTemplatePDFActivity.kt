package com.coopertec.subliprint

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coopertec.subliprint.databinding.ActivityColorsPlatillaPdfactivityBinding

class ColorsTemplatePDFActivity : AppCompatActivity() {

    private lateinit var binding : ActivityColorsPlatillaPdfactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorsPlatillaPdfactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}