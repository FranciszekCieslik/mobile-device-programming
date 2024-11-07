package com.example.lista1_quiz_app

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lista1_quiz_app.model.DataProvider
import com.example.lista1_quiz_app.model.SummaryActivity
import java.security.KeyStore.TrustedCertificateEntry

class MainActivity : AppCompatActivity() {

    // UI elements
    private val radioButton1: RadioButton by lazy { findViewById(R.id.option1) }
    private val radioButton2: RadioButton by lazy { findViewById(R.id.option2) }
    private val radioButton3: RadioButton by lazy { findViewById(R.id.option3) }
    private val radioButton4: RadioButton by lazy { findViewById(R.id.option4) }
    private val nextButton: Button by lazy { findViewById(R.id.next_button) }
    private val questionNumber: TextView by lazy {findViewById(R.id.question_number)}
    private val questionText: TextView by lazy {findViewById(R.id.question_text)}
    private val progressBar: ProgressBar by lazy {findViewById(R.id.progress_bar) }
    private val radioGroup: RadioGroup by lazy {findViewById(R.id.options_radio_group)}

    // app var
    private lateinit var radioArray: Array<RadioButton>
    private var counter = 0
    private var corrects = 0
    private var correctAns = 0

    // data
    private val questions = DataProvider.questions

    // functions
    fun setData() {
        val question = questions[counter]
        val options = question.options
        questionText.text = question.question
        correctAns = question.correctAnswerIndex
        progressBar.progress = counter
        for (i in radioArray.indices) {
            radioArray[i].text = options[i]
        }
        radioButton1.setChecked(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set radioArray
        radioArray = arrayOf(radioButton1, radioButton2, radioButton3, radioButton4)

        // set data
        setData();

        // action
        nextButton.setOnClickListener{
            if((counter < 9) and (radioGroup.getCheckedRadioButtonId()!= -1)) {
                counter++
                questionNumber.text = "Question ${counter + 1}/10"
                var checkedIndex = radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
                if(checkedIndex == correctAns) {
                    corrects++
                }
                setData()
            }else{
                val intent  = Intent(this, SummaryActivity::class.java).apply{
                    putExtra("EXTRA_SCORE", corrects)
                }
                startActivity(intent)
            }
        }
    }

}