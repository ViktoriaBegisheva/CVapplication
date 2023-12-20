package com.example.cvapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var foto: ImageView
    private lateinit var name: TextView
    private lateinit var telfonNumber: TextView
    private lateinit var emailAdress: TextView

    private lateinit var moreInfo: Button
    private lateinit var call: Button
    private lateinit var writeEmail: Button

    //val inf = File("D:/Repo/CVapplication/app/src/main/java/com/example/cvapplication/data.txt").readLines()
    //val profile = Profile(R.drawable.foto, inf[0], inf[1], inf[2])
    val profile = Profile(R.drawable.foto, "Vika Begisheva", "+3801111", "aaaapp@gmail.com")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foto = findViewById(R.id.foto)
        name = findViewById(R.id.name)
        telfonNumber = findViewById(R.id.telfonNumber)
        emailAdress = findViewById(R.id.emailAdress)

        foto.setImageResource(profile.foto)
        name.text = profile.name
        telfonNumber.text = profile.number
        emailAdress.text = profile.email


        moreInfo = findViewById(R.id.moreInfo)
//        moreInfo.setOnClickListener{
//            Log.d("XXXXX", "click")
//            val intent = Intent(Intent.ACTION_SENDTO)
//            intent.data = android.net.Uri.parse("mailto:")
//            Log.d("XXXXX", "internet done")
//
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            } else {
//
//                Log.d("XXXXX", "no gmail")
//            }
//            Log.d("XXXXX", "finish")
//        }
        call = findViewById(R.id.call)
        writeEmail = findViewById(R.id.writeEmail)

    }
}