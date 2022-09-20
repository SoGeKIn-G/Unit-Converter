package com.gauravbora.unitconverter

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gauravbora.unitconverter.databinding.ActivityDataBinding
import kotlin.properties.Delegates


class DataActivity : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var binding: ActivityDataBinding
    private lateinit var values: Array<String>
    private var ans by Delegates.notNull<Double>()
    private lateinit var type1: String
    private lateinit var type2: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        back button
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val typeArray = intent.getStringExtra("typeArray").toString()



        when (typeArray) {
            "length" -> {
                supportActionBar?.setTitle("Length Conversation")
                values = arrayOf(
                    "Decimeter(dm)",
                    "Millimeter(mm)",
                    "Kilometer(km)",
                    "Centimeter(cm)",
                    "Meter(m)",
                    "Foot(ft)",
                    "Inch()"
                )
            }

            "area" -> {
                supportActionBar?.setTitle("Area Conversation")
                values = arrayOf(
                    "Square Meter(m2)",
                    "Square Decimeter(dm2)",
                    "Square Centimeter(cm2)",
                    "Square Kilometer(km2)",
                    "Square Millimeter(mm2)",
                    "Square Foot(ft2)"
                )
            }


            "volume" -> {
                supportActionBar?.setTitle("Volume Conversation")
                values = arrayOf(
                    "Cubic Meter(m3)",
                    "Cubic Cm(cm3)",
                    "Deciliter(dl)",
                    "Centiliter(lm)",
                    "Cubic Decimeter(dm3)",
                    "Liter(l)"
                )
            }


            "speed" -> {
                supportActionBar?.setTitle("Speed Conversation")
                values = arrayOf(
                    "Speed of Light(c)",
                    "Kilometer per Second(km/s)",
                    "Mile per hour(mile/h)",
                    "Inch per Second(in/s)",
                    "Meter per Second(m/s)",
                    "Kilometer per hour(km/h)"
                )
            }


            "weight" -> {
                supportActionBar?.setTitle("Weight Conversation")
                values = arrayOf(
                    "Gram(g)",
                    "Quintal(q)",
                    "Ton(t)",
                    "Milligram(mg)",
                    "Kilogram(kg)",
                    "Ounce(oz)",
                    "pound(lb)"
                )
            }


            "temp" -> {
                supportActionBar?.setTitle("Temperature Conversation")
                values = arrayOf(
                    "Degree Celsias",
                    "Degree Fahrenheit",
                    "Kelvin(k)"
                )
            }


            "power" -> {
                supportActionBar?.setTitle("Power Conversation")
                values = arrayOf(
                    "Joule/sec(j/s)",
                    "Metric Horse power(ps)",
                    "Kilogram-Meter/sec(kg.m/s)",
                    "Kilocalorie/sec(kcal/s)",
                    "Watt(w)",
                    "Newton-Meter/sec(N.m/s)",
                    "Kilowatt(kw)"
                )
            }


            "pressure" -> {
                supportActionBar?.setTitle("Pressure Conversation")
                values = arrayOf(
                    "mm of water(mmH2O)",
                    "Pounds/Square Foot(psf)",
                    "mm of Mercury(mmHg)",
                    "Bar",
                    "Milibar",
                    "Standard Atmosphere",
                    "Kilopaskal"
                )
            }


        }

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        binding.spinner1.adapter = adapter
        binding.spinner2.adapter = adapter
        binding.spinner1.dropDownWidth = 20




        binding.convertButton.setOnClickListener {
            type1 = binding.spinner1.selectedItem.toString()
            type2 = binding.spinner2.selectedItem.toString()
            ans = binding.editviewval1.text.toString().toDouble()



            if (type1 == type2) {
                binding.textviewval2.text = binding.editviewval1.text
            } else {
                when (typeArray) {
                    "length" -> {
                        requireLengthActions()
                    }
                    "area" -> {
                        requireAreaActions()
                    }
                    "volume" -> {
                        requireVolumeActions()
                    }
                    "speed" -> {
                        requireSpeedActions()
                    }
                    "weight" -> {
                        requireWeightActions()
                    }
                    "temp" -> {
                        requireTempActions()
                    }
                    "power" -> {
                        requirePowerActions()
                    }
                    else -> {
                        requirePressureActions()
                    }
                }

            }

        }


    }


    private fun requireSpeedActions() {
        when (type1) {
            "Speed of Light(c)" -> {
                when (type2) {
                    "Kilometer per Second(km/s)" -> {
                        binding.textviewval2.text = "${ans * 299796.14}".toString()
                    }
                    "Mile per hour(mile/h)" -> {
                        binding.textviewval2.text = "${ans * 670624775.153}".toString()
                    }
                    "Inch per Second(in/s)" -> {
                        binding.textviewval2.text = "${ans * 1.18e+10}".toString()
                    }
                    "Meter per Second(m/s)" -> {
                        binding.textviewval2.text = "${ans * 299792458}".toString()
                    }
//                    Kilometer per hour(km/h)
                    else -> {
                        binding.textviewval2.text = "${ans * 1.079e+9}".toString()
                    }
                }
            }
            "Kilometer per Second(km/s)" -> {
                when (type2) {
                    "Speed of Light(c)" -> {
                        binding.textviewval2.text = "${ans * 3.33564e-9}".toString()
                    }
                    "Mile per hour(mile/h)" -> {
                        binding.textviewval2.text = "${ans * 2.23694}".toString()
                    }
                    "Inch per Second(in/s)" -> {
                        binding.textviewval2.text = "${ans * 39.3701}".toString()
                    }
                    "Meter per Second(m/s)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
//                     Kilometer per hour(km/h)
                    else -> {
                        binding.textviewval2.text = "${ans * 3600}".toString()
                    }
                }
            }
            "Mile per hour(mile/h)" -> {
                when (type2) {
                    "Speed of Light(c)" -> {
                        binding.textviewval2.text = "${ans * 1.49115}".toString()
                    }
                    "Kilometer per Second(km/s)" -> {
                        binding.textviewval2.text = "${ans * 0.000447}".toString()
                    }
                    "Inch per Second(in/s)" -> {
                        binding.textviewval2.text = "${ans * 17.6}".toString()
                    }
                    "Meter per Second(m/s)" -> {
                        binding.textviewval2.text = "${ans * 0.44704}".toString()
                    }
//                    Kilometer per hour(km/h)
                    else -> {
                        binding.textviewval2.text = "${ans * 1.61}".toString()
                    }
                }
            }

            "Inch per Second(in/s)" -> {
                when (type2) {
                    "Speed of Light(c)" -> {
                        binding.textviewval2.text = "${ans * 8.472424}".toString()
                    }
                    "Kilometer per Second(km/s)" -> {
                        binding.textviewval2.text = "${ans * 0.0000254}".toString()
                    }
                    "Mile per hour(mile/h)" -> {
                        binding.textviewval2.text = "${ans * 0.05682}".toString()
                    }
                    "Meter per Second(m/s)" -> {
                        binding.textviewval2.text = "${ans * 0.254}".toString()
                    }
//                    Kilometer per hour(km/h)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.09144}".toString()
                    }
                }
            }
            "Meter per Second(m/s)" -> {
                when (type2) {
                    "Speed of Light(c)" -> {
                        binding.textviewval2.text = "${ans * 3.3356e-9}".toString()
                    }
                    "Kilometer per Second(km/s)" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                    "Mile per hour(mile/h)" -> {
                        binding.textviewval2.text = "${ans * 2.236936}".toString()
                    }
                    "Inch per Second(in/s)" -> {
                        binding.textviewval2.text = "${ans * 39.37}".toString()
                    }
//                    Kilometer per hour(km/h)
                    else -> {
                        binding.textviewval2.text = "${ans * 3.6}".toString()
                    }
                }
            }
//           Kilometer per hour(km/h)
            else -> {
                when (type2) {
                    "Speed of Light(c)" -> {
                        binding.textviewval2.text = "${ans * 9.27}".toString()
                    }
                    "Kilometer per Second(km/s)" -> {
                        binding.textviewval2.text = "${ans * 0.0002778}".toString()
                    }
                    "Mile per hour(mile/h)" -> {
                        binding.textviewval2.text = "${ans * 0.62137111}".toString()
                    }
                    "Inch per Second(in/s)" -> {
                        binding.textviewval2.text = "${ans * 10.936133}".toString()
                    }
//                    Meter per Second(m/s)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.2777778}".toString()
                    }
                }
            }

        }
    }

    private fun requireWeightActions() {

        when (type1) {
            "Gram(g)" -> {
                when (type2) {
                    "Quintal(q)" -> {
                        binding.textviewval2.text = "${ans * 0.00001}".toString()
                    }
                    "Ton(t)" -> {
                        binding.textviewval2.text = "${ans * 0.000001}".toString()
                    }
                    "Milligram(mg)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                    "Kilogram(kg)" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                    "Ounce(oz)" -> {
                        binding.textviewval2.text = "${ans * 0.03527396}".toString()
                    }
//                   pound(lb)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.002204622}".toString()
                    }
                }
            }
            "Quintal(q)" -> {
                when (type2) {
                    "Gram(g)" -> {
                        binding.textviewval2.text = "${ans * 100000}".toString()
                    }
                    "Ton(t)" -> {
                        binding.textviewval2.text = "${ans * 0.1}".toString()
                    }
                    "Milligram(mg)" -> {
                        binding.textviewval2.text = "${ans * 100000000}".toString()
                    }
                    "Kilogram(kg)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Ounce(oz)" -> {
                        binding.textviewval2.text = "${ans * 3527.39619}".toString()
                    }
//                   pound(lb)
                    else -> {
                        binding.textviewval2.text = "${ans * 220.46226}".toString()
                    }
                }
            }
            "Ton(t)" -> {
                when (type2) {
                    "Quintal(q)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Gram(g)" -> {
                        binding.textviewval2.text = "${ans * 1000000}".toString()
                    }
                    "Milligram(mg)" -> {
                        binding.textviewval2.text = "${ans * 1000000000}".toString()
                    }
                    "Kilogram(kg)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                    "Ounce(oz)" -> {
                        binding.textviewval2.text = "${ans * 35273.9619}".toString()
                    }
//                   pound(lb)
                    else -> {
                        binding.textviewval2.text = "${ans * 2204.6226}".toString()
                    }
                }
            }

            "Milligram(mg)" -> {
                when (type2) {
                    "Quintal(q)" -> {
                        binding.textviewval2.text = "${ans * 1e-8}".toString()
                    }
                    "Ton(t)" -> {
                        binding.textviewval2.text = "${ans * 1e-9}".toString()
                    }
                    "Gram(g)" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                    "Kilogram(kg)" -> {
                        binding.textviewval2.text = "${ans * 0.000001}".toString()
                    }
                    "Ounce(oz)" -> {
                        binding.textviewval2.text = "${ans * 0.000035274}".toString()
                    }
//                   pound(lb)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.000002204622}".toString()
                    }
                }
            }
            "Kilogram(kg)" -> {
                when (type2) {
                    "Quintal(q)" -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
                    "Ton(t)" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                    "Milligram(mg)" -> {
                        binding.textviewval2.text = "${ans * 1000000}".toString()
                    }
                    "Gram(g)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                    "Ounce(oz)" -> {
                        binding.textviewval2.text = "${ans * 35.27396}".toString()
                    }
//                   pound(lb)
                    else -> {
                        binding.textviewval2.text = "${ans * 2.204622}".toString()
                    }
                }
            }
            "Ounce(oz)" -> {
                when (type2) {
                    "Quintal(q)" -> {
                        binding.textviewval2.text = "${ans * 0.0002835}".toString()
                    }
                    "Ton(t)" -> {
                        binding.textviewval2.text = "${ans * 0.00002835}".toString()
                    }
                    "Milligram(mg)" -> {
                        binding.textviewval2.text = "${ans * 28349.52316}".toString()
                    }
                    "Kilogram(kg)" -> {
                        binding.textviewval2.text = "${ans * 0.02834952}".toString()
                    }
                    "Gram(g)" -> {
                        binding.textviewval2.text = "${ans * 28.349523}".toString()
                    }
//                   pound(lb)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.0625}".toString()
                    }
                }
            }
//             pound(lb)
            else -> {
                when (type2) {
                    "Quintal(q)" -> {
                        binding.textviewval2.text = "${ans * 0.0045359237}".toString()
                    }
                    "Ton(t)" -> {
                        binding.textviewval2.text = "${ans * 0.00045359237}".toString()
                    }
                    "Milligram(mg)" -> {
                        binding.textviewval2.text = "${ans * 453592.3745}".toString()
                    }
                    "Kilogram(kg)" -> {
                        binding.textviewval2.text = "${ans * 0.45359237}".toString()
                    }
                    "Ounce(oz)" -> {
                        binding.textviewval2.text = "${ans * 16.000000136}".toString()
                    }
//                  Gram(g)
                    else -> {
                        binding.textviewval2.text = "${ans * 453.5923745}".toString()
                    }
                }
            }

        }


    }

    private fun requireTempActions() {
        when (type1) {
            "Degree Celsias" -> {
                when (type2) {
                    "Degree Fahrenheit" -> {
                        binding.textviewval2.text = "${ans *(9/5)+ 32}".toString()
                    }
//                    Kelvin(k)
                    else -> {
                        binding.textviewval2.text = "${ans + 273.15}".toString()
                    }
                }
            }
            "Degree Fahrenheit" -> {
                when (type2) {
                    "Kelvin(k)" -> {
                        binding.textviewval2.text = "${(ans -32)*(5/9)+ 273.15}".toString()
                    }
//                    Degree Celsias
                    else -> {
                        binding.textviewval2.text = "${(ans -32)*(5/9)}".toString()
                    }
                }
            }
//            Kelvin(k)
            else -> {
                when (type2) {

                    "Degree Celsias" -> {
                        binding.textviewval2.text = "${ans -273.15}".toString()
                    }
//                    Degree Fahrenheit
                    else -> {
                        binding.textviewval2.text = "${(ans -273.15)* (9/5 )+ 32}".toString()
                    }

                }
            }
        }
    }

    private fun requirePowerActions() {
        when (type1) {
            "Joule/sec(j/s)" -> {
                when (type2) {
                    "Metric Horse power(ps)" -> {
                        binding.textviewval2.text = "${ans * 0.001359621}".toString()
                    }
                    "Kilogram-Meter/sec(kg.m/s)" -> {
                        binding.textviewval2.text = "${ans * 0.101971621}".toString()
                    }
                    "Kilocalorie/sec(kcal/s)" -> {
                        binding.textviewval2.text = "${ans * 0.000239}".toString()
                    }
                    "Watt(w)" -> {
                        binding.textviewval2.text = "${ans * 1}".toString()
                    }
                    "Newton-Meter/sec(N.m/s)" -> {
                        binding.textviewval2.text = "${ans * 1}".toString()
                    }
//                   Kilowatt(kw)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                }
            }
            "Metric Horse power(ps)" -> {
                when (type2) {
                    "Joule/sec(j/s)" -> {
                        binding.textviewval2.text = "${ans * 735.49876}".toString()
                    }
                    "Kilogram-Meter/sec(kg.m/s)" -> {
                        binding.textviewval2.text = "${ans * 75.0000000009}".toString()
                    }
                    "Kilocalorie/sec(kcal/s)" -> {
                        binding.textviewval2.text = "${ans * 0.17578420}".toString()
                    }
                    "Watt(w)" -> {
                        binding.textviewval2.text = "${ans * 735.49875936}".toString()
                    }
                    "Newton-Meter/sec(N.m/s)" -> {
                        binding.textviewval2.text = "${ans * 735.49875936}".toString()
                    }
//                   Kilowatt(kw)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.73549875936}".toString()
                    }
                }
            }
            "Kilogram-Meter/sec(kg.m/s)" -> {
                when (type2) {
                    "Metric Horse power(ps)" -> {
                        binding.textviewval2.text = "${ans * 0.0133333333}".toString()
                    }
                    "Joule/sec(j/s)" -> {
                        binding.textviewval2.text = "${ans * 9.80665}".toString()
                    }
                    "Kilocalorie/sec(kcal/s)" -> {
                        binding.textviewval2.text = "${ans * 0.0023437893}".toString()
                    }
                    "Watt(w)" -> {
                        binding.textviewval2.text = "${ans * 9.80665}".toString()
                    }
                    "Newton-Meter/sec(N.m/s)" -> {
                        binding.textviewval2.text = "${ans * 9.80665}".toString()
                    }
//                   Kilowatt(kw)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.00980665}".toString()
                    }
                }
            }

            "Kilocalorie/sec(kcal/s)" -> {
                when (type2) {
                    "Metric Horse power(ps)" -> {
                        binding.textviewval2.text = "${ans * 5.6887933}".toString()
                    }
                    "Kilogram-Meter/sec(kg.m/s)" -> {
                        binding.textviewval2.text = "${ans * 426.66}".toString()
                    }
                    "Joule/sec(j/s)" -> {
                        binding.textviewval2.text = "${ans * 4184.1004}".toString()
                    }
                    "Watt(w)" -> {
                        binding.textviewval2.text = "${ans * 4184.1004}".toString()
                    }
                    "Newton-Meter/sec(N.m/s)" -> {
                        binding.textviewval2.text = "${ans * 4184.1004}".toString()
                    }
//                   Kilowatt(kw)
                    else -> {
                        binding.textviewval2.text = "${ans * 4.1841004}".toString()
                    }
                }
            }
            "Watt(w)" -> {
                when (type2) {
                    "Metric Horse power(ps)" -> {
                        binding.textviewval2.text = "${ans * 0.001359621}".toString()
                    }
                    "Kilogram-Meter/sec(kg.m/s)" -> {
                        binding.textviewval2.text = "${ans * 0.101971621}".toString()
                    }
                    "Kilocalorie/sec(kcal/s)" -> {
                        binding.textviewval2.text = "${ans * 0.000239}".toString()
                    }
                    "Joule/sec(j/s)" -> {
                        binding.textviewval2.text = "${ans * 1}".toString()
                    }
                    "Newton-Meter/sec(N.m/s)" -> {
                        binding.textviewval2.text = "${ans * 1}".toString()
                    }
//                   Kilowatt(kw)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                }
            }
            "Newton-Meter/sec(N.m/s)" -> {
                when (type2) {
                    "Metric Horse power(ps)" -> {
                        binding.textviewval2.text = "${ans * 0.001359621}".toString()
                    }
                    "Kilogram-Meter/sec(kg.m/s)" -> {
                        binding.textviewval2.text = "${ans * 0.101971621}".toString()
                    }
                    "Kilocalorie/sec(kcal/s)" -> {
                        binding.textviewval2.text = "${ans * 0.000239}".toString()
                    }
                    "Watt(w)" -> {
                        binding.textviewval2.text = "${ans * 1}".toString()
                    }
                    "Joule/sec(j/s)" -> {
                        binding.textviewval2.text = "${ans * 1}".toString()
                    }
//                   Kilowatt(kw)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                }
            }
//           Kilowatt(kw)
            else -> {
                when (type2) {
                    "Metric Horse power(ps)" -> {
                        binding.textviewval2.text = "${ans * 1.3596216}".toString()
                    }
                    "Kilogram-Meter/sec(kg.m/s)" -> {
                        binding.textviewval2.text = "${ans * 101.971621}".toString()
                    }
                    "Kilocalorie/sec(kcal/s)" -> {
                        binding.textviewval2.text = "${ans * 0.239}".toString()
                    }
                    "Watt(w)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                    "Newton-Meter/sec(N.m/s)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
//                 Joule/sec(j/s)
                    else -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                }
            }

        }
    }

    private fun requirePressureActions() {
        when (type1) {
            "mm of water(mmH2O)" -> {
                when (type2) {
                    "Pounds/Square Foot(psf)" -> {
                        binding.textviewval2.text = "${ans * 0.20481619509}".toString()
                    }
                    "mm of Mercury(mmHg)" -> {
                        binding.textviewval2.text = "${ans * 0.07355594}".toString()
                    }
                    "Bar" -> {
                        binding.textviewval2.text = "${ans * 0.0000980665}".toString()
                    }
                    "Milibar" -> {
                        binding.textviewval2.text = "${ans * 0.0980665}".toString()
                    }
                    "Standard Atmosphere" -> {
                        binding.textviewval2.text = "${ans * 0.0000967841045}".toString()
                    }
//                  Kilopaskal
                    else -> {
                        binding.textviewval2.text = "${ans * 0.009806652}".toString()
                    }
                }
            }
            "Pounds/Square Foot(psf)" -> {
                when (type2) {
                    "mm of water(mmH2O)" -> {
                        binding.textviewval2.text = "${ans * 4.8824264}".toString()
                    }
                    "mm of Mercury(mmHg)" -> {
                        binding.textviewval2.text = "${ans * 0.35913147}".toString()
                    }
                    "Bar" -> {
                        binding.textviewval2.text = "${ans * 0.00047880257}".toString()
                    }
                    "Milibar" -> {
                        binding.textviewval2.text = "${ans * 0.47880257}".toString()
                    }
                    "Standard Atmosphere" -> {
                        binding.textviewval2.text = "${ans * 0.00047254127}".toString()
                    }
//                  Kilopaskal
                    else -> {
                        binding.textviewval2.text = "${ans * 0.047880257}".toString()
                    }
                }
            }
            "mm of Mercury(mmHg)" -> {
                when (type2) {
                    "Pounds/Square Foot(psf)" -> {
                        binding.textviewval2.text = "${ans * 2.7844957}".toString()
                    }
                    "mm of water(mmH2O)" -> {
                        binding.textviewval2.text = "${ans * 13.595}".toString()
                    }
                    "Bar" -> {
                        binding.textviewval2.text = "${ans * 0.00133322365}".toString()
                    }
                    "Milibar" -> {
                        binding.textviewval2.text = "${ans * 1.33322365}".toString()
                    }
                    "Standard Atmosphere" -> {
                        binding.textviewval2.text = "${ans * 0.0013157890}".toString()
                    }
//                  Kilopaskal
                    else -> {
                        binding.textviewval2.text = "${ans * 0.13332236}".toString()
                    }
                }
            }

            "Bar" -> {
                when (type2) {
                    "Pounds/Square Foot(psf)" -> {
                        binding.textviewval2.text = "${ans * 2088.5435}".toString()
                    }
                    "mm of Mercury(mmHg)" -> {
                        binding.textviewval2.text = "${ans * 750.0617}".toString()
                    }
                    "mm of water(mmH2O)" -> {
                        binding.textviewval2.text = "${ans * 10197.16}".toString()
                    }
                    "Milibar" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                    "Standard Atmosphere" -> {
                        binding.textviewval2.text = "${ans * 0.986923}".toString()
                    }
//                  Kilopaskal
                    else -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                }
            }
            "Milibar" -> {
                when (type2) {
                    "Pounds/Square Foot(psf)" -> {
                        binding.textviewval2.text = "${ans * 2.0885435}".toString()
                    }
                    "mm of Mercury(mmHg)" -> {
                        binding.textviewval2.text = "${ans * 0.7500617}".toString()
                    }
                    "Bar" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                    "mm of water(mmH2O)" -> {
                        binding.textviewval2.text = "${ans * 10.19716}".toString()
                    }
                    "Standard Atmosphere" -> {
                        binding.textviewval2.text = "${ans * 0.000986923}".toString()
                    }
//                  Kilopaskal
                    else -> {
                        binding.textviewval2.text = "${ans * 0.1}".toString()
                    }
                }
            }
            "Standard Atmosphere" -> {
                when (type2) {
                    "Pounds/Square Foot(psf)" -> {
                        binding.textviewval2.text = "${ans * 2116.21728544}".toString()
                    }
                    "mm of Mercury(mmHg)" -> {
                        binding.textviewval2.text = "${ans * 760}".toString()
                    }
                    "Bar" -> {
                        binding.textviewval2.text = "${ans * 1.013250}".toString()
                    }
                    "Milibar" -> {
                        binding.textviewval2.text = "${ans * 1013.25027}".toString()
                    }
                    "mm of water(mmH2O)" -> {
                        binding.textviewval2.text = "${ans * 10332.27516229}".toString()
                    }
//                  Kilopaskal
                    else -> {
                        binding.textviewval2.text = "${ans * 101.3250}".toString()
                    }
                }
            }
//          Kilopaskal
            else -> {
                when (type2) {
                    "Pounds/Square Foot(psf)" -> {
                        binding.textviewval2.text = "${ans * 20.885435}".toString()
                    }
                    "mm of Mercury(mmHg)" -> {
                        binding.textviewval2.text = "${ans * 7.5}".toString()
                    }
                    "Bar" -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
                    "Milibar" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Standard Atmosphere" -> {
                        binding.textviewval2.text = "${ans * 0.00986923}".toString()
                    }
//                  mm of water(mmH2O)
                    else -> {
                        binding.textviewval2.text = "${ans * 101.9716}".toString()
                    }
                }
            }

        }
    }

    private fun requireVolumeActions() {

        when (type1) {
            "Cubic Meter(m3)" -> {
                when (type2) {
                    "Cubic Cm(cm3)" -> {
                        binding.textviewval2.text = "${ans * 1000000}".toString()
                    }
                    "Deciliter(dl)" -> {
                        binding.textviewval2.text = "${ans * 10000}".toString()
                    }
                    "Centiliter(lm)" -> {
                        binding.textviewval2.text = "${ans * 100000}".toString()
                    }
                    "Cubic Decimeter(dm3)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
//                    Liter(l)
                    else -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                }
            }
            "Cubic Cm(cm3)" -> {
                when (type2) {
                    "Cubic Meter(m3)" -> {
                        binding.textviewval2.text = "${ans * 0.000001}".toString()
                    }
                    "Deciliter(dl)" -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
                    "Centiliter(lm)" -> {
                        binding.textviewval2.text = "${ans * 0.1}".toString()
                    }
                    "Cubic Decimeter(dm3)" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
//                     Liter(l)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                }
            }
            "Deciliter(dl)" -> {
                when (type2) {
                    "Cubic Meter(m3)" -> {
                        binding.textviewval2.text = "${ans * 0.0001}".toString()
                    }
                    "Cubic Cm(cm3)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Centiliter(lm)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Cubic Decimeter(dm3)" -> {
                        binding.textviewval2.text = "${ans * 0.1}".toString()
                    }
//                    Liter(l)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.1}".toString()
                    }
                }
            }
            "Centiliter(lm)" -> {
                when (type2) {
                    "Deciliter(dl)" -> {
                        binding.textviewval2.text = "${ans * 0.1}".toString()
                    }
                    "Cubic Meter(m3)" -> {
                        binding.textviewval2.text = "${ans * 0.00001}".toString()
                    }
                    "Cubic Cm(cm3)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Cubic Decimeter(dm3)" -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
//                    Liter(l)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
                }
            }
            "Cubic Decimeter(dm3)" -> {
                when (type2) {
                    "Centiliter(lm)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Deciliter(dl)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Cubic Meter(m3)" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                    "Cubic Cm(cm3)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
//                    Liter(l)
                    else -> {
                        binding.textviewval2.text = "$ans".toString()
                    }
                }
            }
//            Liter(l)
            else -> {
                when (type2) {
                    "Centiliter(lm)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Deciliter(dl)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Cubic Meter(m3)" -> {
                        binding.textviewval2.text = "${ans * 0.001}".toString()
                    }
                    "Cubic Cm(cm3)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
//                    Cubic Decimeter(dm3)
                    else -> {
                        binding.textviewval2.text = "$ans".toString()
                    }
                }
            }

        }


    }

    private fun requireAreaActions() {

        when (type1) {
            "Square Meter(m2)" -> {
                when (type2) {
                    "Square Decimeter(dm2)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Square Centimeter(cm2)" -> {
                        binding.textviewval2.text = "${ans * 10000}".toString()
                    }
                    "Square Kilometer(km2)" -> {
                        binding.textviewval2.text = "${ans * 0.000001}".toString()
                    }
                    "Square Millimeter(mm2)" -> {
                        binding.textviewval2.text = "${ans * 1000000}".toString()
                    }
//                    Square Foot(ft2)
                    else -> {
                        binding.textviewval2.text = "${ans * 10.764}".toString()
                    }
                }
            }
            "Square Foot(ft2)" -> {
                when (type2) {
                    "Square Decimeter(dm2)" -> {
                        binding.textviewval2.text = "${ans * 9.290304}".toString()
                    }
                    "Square Centimeter(cm2)" -> {
                        binding.textviewval2.text = "${ans * 929.0304014}".toString()
                    }
                    "Square Kilometer(km2)" -> {
                        binding.textviewval2.text = "${ans * 9.2903e-8}".toString()
                    }
                    "Square Millimeter(mm2)" -> {
                        binding.textviewval2.text = "${ans * 92903.04014}".toString()
                    }
//                    Square Meter(m2)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.9290304}".toString()
                    }
                }
            }
            "Square Decimeter(dm2)" -> {
                when (type2) {
                    "Square Foot(ft2)" -> {
                        binding.textviewval2.text = "${ans * 0.10764}".toString()
                    }
                    "Square Centimeter(cm2)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Square Kilometer(km2)" -> {
                        binding.textviewval2.text = "${ans * 1e-8}".toString()
                    }
                    "Square Millimeter(mm2)" -> {
                        binding.textviewval2.text = "${ans * 10000}".toString()
                    }
//                    Square Meter(m2)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
                }
            }
            "Square Centimeter(cm2)" -> {
                when (type2) {
                    "Square Decimeter(dm2)" -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
                    "Square Meter(m2)" -> {
                        binding.textviewval2.text = "${ans * 0.0001}".toString()
                    }
                    "Square Kilometer(km2)" -> {
                        binding.textviewval2.text = "${ans * 1e-10}".toString()
                    }
                    "Square Millimeter(mm2)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
//                    Square Foot(ft2)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.0010764}".toString()
                    }
                }
            }
            "Square Kilometer(km2)" -> {
                when (type2) {
                    "Square Decimeter(dm2)" -> {
                        binding.textviewval2.text = "${ans * 100000000}".toString()
                    }
                    "Square Meter(m2)" -> {
                        binding.textviewval2.text = "${ans * 1000000}".toString()
                    }
                    "Square Centimeter(cm2)" -> {
                        binding.textviewval2.text = "${ans * 10000000000}".toString()
                    }
                    "Square Millimeter(mm2)" -> {
                        binding.textviewval2.text = "${ans * 1000000000000}".toString()
                    }
//                    Square Foot(ft2)
                    else -> {
                        binding.textviewval2.text = "${ans * 10763910.4}".toString()
                    }
                }
            }
            else -> {
                when (type2) {
                    "Square Decimeter(dm2)" -> {
                        binding.textviewval2.text = "${ans * 0.0001}".toString()
                    }
                    "Square Meter(m2)" -> {
                        binding.textviewval2.text = "${ans / 0.000001}".toString()
                    }
                    "Square Centimeter(cm2)" -> {
                        binding.textviewval2.text = "${ans * 0.01}".toString()
                    }
                    "Square Kilometer(km2)" -> {
                        binding.textviewval2.text = "${ans * 1e-12}".toString()
                    }
//                    Square Foot(ft2)
                    else -> {
                        binding.textviewval2.text = "${ans * 0.000010764}".toString()
                    }
                }
            }

        }


    }

    private fun requireLengthActions() {

        when (type1) {
            "Decimeter(dm)" -> {
                when (type2) {
                    "Millimeter(mm)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Kilometer(km)" -> {
                        binding.textviewval2.text = "${ans / 10000}".toString()
                    }
                    "Centimeter(cm)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Meter(m)" -> {
                        binding.textviewval2.text = "${ans / 10}".toString()
                    }
                    "Foot(ft)" -> {
                        binding.textviewval2.text = "${ans * 0.32808399}".toString()
                    }
                    else -> {
                        binding.textviewval2.text = "${ans * 3.9370078}".toString()
                    }
                }
            }
            "Millimeter(mm)" -> {
                when (type2) {
                    "Decimeter(dm)" -> {
                        binding.textviewval2.text = "${ans / 10}".toString()
                    }
                    "Kilometer(km)" -> {
                        binding.textviewval2.text = "${ans / 1000000}".toString()
                    }
                    "Centimeter(cm)" -> {
                        binding.textviewval2.text = "${ans / 10}".toString()
                    }
                    "Meter(m)" -> {
                        binding.textviewval2.text = "${ans / 1000}".toString()
                    }
                    "Foot(ft)" -> {
                        binding.textviewval2.text = "${ans * 0.003280839}".toString()
                    }
                    else -> {
                        binding.textviewval2.text = "${ans * 0.03937008}".toString()
                    }
                }
            }
            "Kilometer(km)" -> {
                when (type2) {
                    "Decimeter(dm)" -> {
                        binding.textviewval2.text = "${ans * 10000}".toString()
                    }
                    "Millimeter(mm)" -> {
                        binding.textviewval2.text = "${ans * 1000000}".toString()
                    }
                    "Centimeter(cm)" -> {
                        binding.textviewval2.text = "${ans * 100000}".toString()
                    }
                    "Meter(m)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                    "Foot(ft)" -> {
                        binding.textviewval2.text = "${ans * 3280.84}".toString()
                    }
                    else -> {
                        binding.textviewval2.text = "${ans * 39370.078}".toString()
                    }
                }
            }
            "Centimeter(cm)" -> {
                when (type2) {
                    "Decimeter(dm)" -> {
                        binding.textviewval2.text = "${ans / 10}".toString()
                    }
                    "Millimeter(mm)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Kilometer(km)" -> {
                        binding.textviewval2.text = "${ans / 100000}".toString()
                    }
                    "Meter(m)" -> {
                        binding.textviewval2.text = "${ans / 100}".toString()
                    }
                    "Foot(ft)" -> {
                        binding.textviewval2.text = "${ans * 0.0328084}".toString()
                    }
                    else -> {
                        binding.textviewval2.text = "${ans * 0.3937}".toString()
                    }
                }
            }
            "Meter(m)" -> {
                when (type2) {
                    "Decimeter(dm)" -> {
                        binding.textviewval2.text = "${ans * 10}".toString()
                    }
                    "Millimeter(mm)" -> {
                        binding.textviewval2.text = "${ans * 1000}".toString()
                    }
                    "Kilometer(km)" -> {
                        binding.textviewval2.text = "${ans / 1000}".toString()
                    }
                    "Centimeter(cm)" -> {
                        binding.textviewval2.text = "${ans * 100}".toString()
                    }
                    "Foot(ft)" -> {
                        binding.textviewval2.text = "${ans * 3.28084}".toString()
                    }
                    else -> {
                        binding.textviewval2.text = "${ans * 39.37008}".toString()
                    }
                }
            }
            "Foot(ft)" -> {
                when (type2) {
                    "Decimeter(dm)" -> {
                        binding.textviewval2.text = "${ans * 3.04799999}".toString()
                    }
                    "Millimeter(mm)" -> {
                        binding.textviewval2.text = "${ans * 304.79999}".toString()
                    }
                    "Kilometer(km)" -> {
                        binding.textviewval2.text = "${ans * 0.0003047999}".toString()
                    }
                    "Centimeter(cm)" -> {
                        binding.textviewval2.text = "${ans * 30.479999}".toString()
                    }
                    "Meter(m)" -> {
                        binding.textviewval2.text = "${ans * 0.3047999}".toString()
                    }
                    else -> {
                        binding.textviewval2.text = "${ans * 11.9999999}".toString()
                    }
                }
            }
            else -> {
                when (type2) {
                    "Decimeter(dm)" -> {
                        binding.textviewval2.text = "${ans * 0.254}".toString()
                    }
                    "Millimeter(mm)" -> {
                        binding.textviewval2.text = "${ans * 25.4}".toString()
                    }
                    "Kilometer(km)" -> {
                        binding.textviewval2.text = "${ans * 0.0000254}".toString()
                    }
                    "Centimeter(cm)" -> {
                        binding.textviewval2.text = "${ans * 2.54}".toString()
                    }
                    "Meter(m)" -> {
                        binding.textviewval2.text = "${ans * 0.0254}".toString()
                    }
                    "Foot(ft)" -> {
                        binding.textviewval2.text = "${ans * 0.083334}".toString()
                    }
                    else -> {}
                }
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}