package com.sekai.conversordemoedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import com.sekai.conversordemoedas.data.model.Coin
import com.sekai.conversordemoedas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding
        .inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindingAdapters()
        clickListener()
    }

    private fun clickListener() {
        binding.edtValor.editText?.doAfterTextChanged {
            binding.fbConverter.isEnabled =  it!=null && it.toString().isNotEmpty()
        }
        binding.fbConverter.setOnClickListener {
           Log.d("testse", "clickou")
        }

        binding.imgarrow.setOnClickListener {
            val from = binding.txtFrom.text.toString()
            val to = binding.txtTo.text.toString()
            binding.txtFrom.setText(to, false)
            binding.txtTo.setText(from, false)
        }
    }

    private fun bindingAdapters(){
        val list = Coin.values()
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, list)
        binding.txtFrom.setAdapter(adapter)
        binding.txtTo.setAdapter(adapter)

        binding.txtFrom.setText(Coin.Real.name, false)
        binding.txtTo.setText(Coin.Dollar.name, false)
    }
}