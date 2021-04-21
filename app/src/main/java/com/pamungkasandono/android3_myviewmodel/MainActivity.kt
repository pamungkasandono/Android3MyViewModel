package com.pamungkasandono.android3_myviewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pamungkasandono.android3_myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        activityMainBinding.btnCalculate.setOnClickListener {
            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "Tidak boleh kosong"
                    activityMainBinding.edtWidth.requestFocus()
                }
                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "Tidak boleh kosong"
                    activityMainBinding.edtHeight.requestFocus()
                }
                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "Tidak boleh kosong"
                    activityMainBinding.edtLength.requestFocus()
                }

                else -> {
                    viewModel.calc(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}