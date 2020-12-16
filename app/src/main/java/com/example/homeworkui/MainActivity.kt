package com.example.homeworkui

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TEXT_VIEW_KEY = "TEXT_VIEW_KEY"
    }

    private lateinit var firstImg: ImageView
    private lateinit var secondImg: ImageView
    private lateinit var score: TextView
    private lateinit var resultText: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        button.setOnClickListener {

            resultText.text = "Your result, ${editText.text}:"
            val n1 = (1..6).random()
            val n2 = (1..6).random()
            val result = n1+n2
            setImage(n1, firstImg)
            setImage(n2, secondImg)
            score.text = result.toString()

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(TEXT_VIEW_KEY, resultText.text.toString())}
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        resultText.text = savedInstanceState.getString(TEXT_VIEW_KEY)
        super.onRestoreInstanceState(savedInstanceState)
    }


    private fun init() {
        firstImg = findViewById(R.id.img_1)
        secondImg = findViewById(R.id.img_2)
        score = findViewById(R.id.score)
        resultText = findViewById(R.id.resultText)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
    }

    private fun setImage(n: Int, img: ImageView) {
        when(n){
            1 -> img.setImageResource(R.drawable.one)
            2 -> img.setImageResource(R.drawable.two)
            3 -> img.setImageResource(R.drawable.three)
            4 -> img.setImageResource(R.drawable.four)
            5 -> img.setImageResource(R.drawable.five)
            else -> img.setImageResource(R.drawable.six)
        }

    }
}