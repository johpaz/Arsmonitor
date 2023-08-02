package ars.monitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import ars.monitor.Asrmonitor.Companion.IMC_KEY

class ResultActivity : AppCompatActivity() {
    private lateinit var tvGsa: TextView
    private lateinit var tvph: TextView
    private lateinit var tvhco3: TextView
    private lateinit var tvco2: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener{onBackPressed()}
    }

    private fun initUI(result: Double) {
        tvGsa.text = result.toString()

        when (result) {
            1.00 -> { //Bajo peso
                tvDescription.text = getString(R.string.title_bajo_peso)
                tvDescription.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
            }
        }
    }
    private fun initComponents() {
        tvGsa = findViewById(R.id.tvGsa)
        tvph = findViewById(R.id.tvph)
        tvco2 = findViewById(R.id.tvco2)
        tvhco3 = findViewById(R.id.tvhco3)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}
