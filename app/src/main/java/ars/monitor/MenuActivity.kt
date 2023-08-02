package ars.monitor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnAsrMonitor = findViewById(R.id.btnArsmonitor)
        btnAsrMonitor.setOnClickListener{navigateToAsrmonitor()}
    }

    private fun navigateToAsrmonitor() {
        val intent = Intent(this, Asrmonitor::class.java)
        startActivity(intent)
    }
}