package com.example.prak_2_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var viewModel = RandomNumberViewModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(RandomNumberViewModel::class.java)

        observeViewModel()

        GenerateButton()
    }

    fun observeViewModel() {
        viewModel.currentRandomNumber.observe(this, Observer { rndNum.setText(it.toString()) })
    }

    fun GenerateButton() {
        //getRnd.setOnClickListener { viewModel.generate() }
        getRnd.setOnClickListener { viewModel.generate() }
    }
}