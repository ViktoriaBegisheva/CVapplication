package com.example.cvapplication
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    private lateinit var textViewInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val infoText = intent.getStringExtra("INFO_TEXT")

        textViewInfo = findViewById(R.id.textViewInfo)
        textViewInfo.text = infoText
    }
}