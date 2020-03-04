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
        val randint = Random(SystemClock.elapsedRealtime()).nextInt(0, 5);
        if (randint == 0) {
            return android.graphics.Color.RED
        } else if (randint == 1) {
            return android.graphics.Color.CYAN
        } else if (randint == 2) {
            return android.graphics.Color.MAGENTA
        } else if (randint == 3) {
            return android.graphics.Color.GREEN
        } else if (randint == 4) {
            return android.graphics.Color.BLUE
        } else {
            return android.graphics.Color.BLACK
        }
    }

    fun sayHi(view: android.view.View) {
        val namebox: EditText = findViewById(R.id.namebox)
        val name = namebox.text
        val msgbox: TextView = findViewById(R.id.msgview)
        if (name.length <= 0) {
            Toast.makeText(this, "That is an invalid name!", Toast.LENGTH_SHORT).show()
        } else {
            msgbox.setTextColor(rancolor());
            msgbox.text = "Hello, $name!";
        }
    }
}