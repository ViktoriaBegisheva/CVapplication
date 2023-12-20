package com.example.cvapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var foto: ImageView
    private lateinit var name: TextView
    private lateinit var telfonNumber: TextView
    private lateinit var emailAdress: TextView

    //val inf = File("data.txt").readLines()
    //val profile = Profile(R.drawable.foto, inf[0], inf[1], inf[2])
    val moreInfo = "More Information:\n" +
            "Date of Birth: 11.11.2000\n" +
            "education: ...\n" +
            "Professional Summary:\n" +
            "Dedicated and results-oriented professional with over 7 years of experience in marketing and brand management. Skilled in developing and executing comprehensive marketing strategies to drive brand awareness and increase market share. Proven ability to collaborate with cross-functional teams and deliver successful campaigns.\n" +
            "\n" +
            "Work Experience:\n" +
            "\n" +
            "ABC Marketing Agency, Anytown, USA\n" +
            "Position: Senior Marketing Specialist\n" +
            "Period of Employment: January 2018 – Present\n" +
            "\n" +
            "Led the development and execution of integrated marketing campaigns for key clients, resulting in a 20% increase in brand visibility.\n" +
            "Collaborated with the creative team to produce engaging content for digital and print platforms.\n" +
            "Conducted market research to identify new opportunities and trends, contributing to the development of innovative marketing strategies.\n" +
            "Education:\n" +
            "\n" +
            "University of Anytown, Anytown, USA\n" +
            "Major: Marketing\n" +
            "Degree: Bachelor of Business Administration\n" +
            "Year of Graduation: 2017\n" +
            "\n" +
            "Skills:\n" +
            "\n" +
            "Digital Marketing\n" +
            "Brand Development\n" +
            "Market Research\n" +
            "Social Media Management\n" +
            "Project Management\n" +
            "Adobe Creative Suite\n" +
            "Professional Goals:\n" +
            "Seeking a challenging position in a dynamic company where I can leverage my marketing expertise to contribute to the company's growth and success.\n" +
            "\n" +
            "Language Skills:\n" +
            "Fluent in English\n" +
            "\n" +
            "References:\n" +
            "Available upon request."
    val profile = Profile(
        R.drawable.foto,
        "Viktoria Lastname",
        "+380111111111",
        "aaaapp@gmail.com",
        moreInfo,
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foto = findViewById(R.id.foto)
        name = findViewById(R.id.name)
        telfonNumber = findViewById(R.id.telfonNumber)
        emailAdress = findViewById(R.id.emailAdress)

        foto.setImageResource(profile.foto)
        foto.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {}
        }

        name.text = profile.name
        name.setOnClickListener {

            val intent = Intent(this, InfoActivity::class.java)

            val infoText = profile.info
            intent.putExtra("INFO_TEXT", infoText)

            startActivity(intent)
        }

        telfonNumber.text = profile.number
        telfonNumber.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("tel:${profile.number}")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {Log.d("XXXXX", "no phone App on device")}
        }

        emailAdress.text = profile.email
        emailAdress.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            val subject = "Invitation to an interview"
            intent.data = android.net.Uri.parse(
                "mailto:${profile.email}?subject=${Uri.encode(subject)}")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {Log.d("XXXXX", "no gmail on device")}
        }

    }
}