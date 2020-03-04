package com.example.helloworld

import android.os.Bundle
import android.os.SystemClock
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rancolor(): Int {
        // Generate a random number to return a random color
        val randint = Random(SystemClock.elapsedRealtime()).nextInt(0, 5)
        when (randint) {
            0 -> return android.graphics.Color.RED
            1 -> return android.graphics.Color.CYAN
            2 -> return android.graphics.Color.MAGENTA
            3 -> return android.graphics.Color.GREEN
            4 -> return android.graphics.Color.BLUE
            5 -> return android.graphics.Color.BLACK
            else -> {
                // This is just boilerplate, it would never be triggered, unless there's something
                // wrong with the framework
                return android.graphics.Color.GRAY
            }
        }
    }

    // This is the onclick function for our button
    fun sayHi(view: android.view.View) {
        // Get the EditText item using the ID
        // Note that we use val since the value of this doesn't change
        val namebox: EditText = findViewById(R.id.namebox)
        val name = namebox.text // Get the content
        // Now get msgbox which is the view we will be writing to
        val msgbox: TextView = findViewById(R.id.msgview)
        // Do a basic check to ensure that the name length is not empty
        if (name.length <= 0) {
            Toast.makeText(this, "That is an invalid name!", Toast.LENGTH_SHORT).show()
        } else {
            // Now set the text color to something random and write to the msgbox
            msgbox.setTextColor(rancolor())
            msgbox.text = "Hello, $name!"
        }
    }
}