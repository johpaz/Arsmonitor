package ars.monitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class Asrmonitor : AppCompatActivity() {

    private var currentph: Double = 7.10
    private var currentco2: Int = 30
    private var currenthco3: Int = 20


    private lateinit var tvph: TextView
    private lateinit var rsph: RangeSlider
    private lateinit var tvco2: TextView
    private lateinit var rsco2: RangeSlider
    private lateinit var tvhco3: TextView
    private lateinit var rshco3: RangeSlider
    private lateinit var btnCalculate: Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asrmonitor)
        initcomponents()
        initlisteners()

    }


    private fun initcomponents() {
        tvph = findViewById(R.id.tvph)
        rsph = findViewById(R.id.rsph)
        tvco2 = findViewById(R.id.tvco2)
        rsco2 = findViewById(R.id.rsco2)
        tvhco3 = findViewById(R.id.tvhco3)
        rshco3 = findViewById(R.id.rshco3)
        btnCalculate = findViewById(R.id.btnCalculate)
    }
    private fun initlisteners() {
        rsph.addOnChangeListener { _, value, _ ->
            currentph = value.toDouble()
            tvph.text = "$currentph"
        }
        rsco2.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentco2 = df.format(value).toInt()
            tvco2.text = "$currentco2"
        }
        rshco3.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currenthco3 = df.format(value).toInt()
            tvhco3.text = "$currenthco3"
        }
        btnCalculate.setOnClickListener {
            interpretationGsa()

        }

    }

    private fun interpretationGsa() {
        var gsa = 0
        if (currentph < 7.35 && currentco2 > 46 && currenthco3 in 22..26) {
            gsa += 1
        }
    }
}
