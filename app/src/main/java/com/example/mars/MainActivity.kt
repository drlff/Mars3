package com.example.mars

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.record)
        button.setOnClickListener {
            intent = Intent(this, ActivityTwo::class.java)
            startActivity(intent)

            val spaceman: Button = findViewById(R.id.spaceman)
            spaceman.setOnClickListener {
                intent = Intent(this, ActivityThree::class.java)
                startActivity(intent)

                val space: ImageButton = findViewById(R.id.space)
                space.setOnClickListener {
                    intent = android.content.Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.roscosmos.ru/23310/")
                    )
                    startActivity(intent)


                }
            }


        }
    }
}
