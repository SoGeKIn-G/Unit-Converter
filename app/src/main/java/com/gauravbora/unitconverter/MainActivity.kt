package com.gauravbora.unitconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gauravbora.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var typeArray: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//       setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.length.setOnClickListener {
            typeArray = "length"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }

        binding.area.setOnClickListener {
            typeArray = "area"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }

        binding.volume.setOnClickListener {
            typeArray = "volume"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }

        binding.speed.setOnClickListener {
            typeArray = "speed"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }

        binding.weight.setOnClickListener {
            typeArray = "weight"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }

        binding.temp.setOnClickListener {
            typeArray = "temp"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }

        binding.power.setOnClickListener {
            typeArray = "power"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }

        binding.pressure.setOnClickListener {
            typeArray = "pressure"
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("typeArray", typeArray)
            startActivity(intent)
        }


    }
}