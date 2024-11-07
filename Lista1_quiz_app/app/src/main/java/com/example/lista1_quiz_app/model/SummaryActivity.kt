package com.example.lista1_quiz_app.model

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lista1_quiz_app.MainActivity
import com.example.lista1_quiz_app.R


class SummaryActivity : AppCompatActivity() {

    private val buttonRestart: Button by lazy { findViewById(R.id.btnRestart) }
    private  val view: TextView by lazy {findViewById(R.id.tvScore)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val score = intent.getIntExtra("EXTRA_SCORE", 0)

        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = "Your score: $score / 10"

        val btnRestart = findViewById<Button>(R.id.btnRestart)
        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
            finish()
        }
    }
}
