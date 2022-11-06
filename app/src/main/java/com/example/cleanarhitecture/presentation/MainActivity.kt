package com.example.cleanarhitecture.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarhitecture.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //библиотека koin создает viewModel
    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Это подписка на изменения данных. Как только переменная resultLive поменяется
        // вызовется этот код binding.dataTextView.text = it
        vm.resultLive.observe(this, {
            binding.dataTextView.text = it
        })

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
           vm.save(text)
        }

        binding.receiveButton.setOnClickListener {
            vm.load()
        }
    }
}