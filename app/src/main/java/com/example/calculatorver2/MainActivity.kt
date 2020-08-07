package com.example.calculatorver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var plusButton: Button
private lateinit var minusButton: Button
private lateinit var oneButton: Button
private lateinit var twoButton: Button
private lateinit var threeButton: Button
private lateinit var answerText: TextView
private lateinit var equalButton: Button
private lateinit var cancelButton: Button
private lateinit var multiplyButton: Button


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plusButton = findViewById(R.id.plus_button)
        minusButton = findViewById(R.id.minus_button)
        oneButton = findViewById(R.id.one_button)
        twoButton = findViewById(R.id.two_button)
        threeButton = findViewById(R.id.three_button)
        answerText = findViewById(R.id.answer_text_view)
        equalButton = findViewById(R.id.equals_button)
        cancelButton = findViewById(R.id.cancel_button)
        multiplyButton = findViewById(R.id.multiply_button)

        var number = answerText.text
        var score = 0
        var plusIsClicked = false
        var isCounted = false
        var minusIsClicked = false
        var multiplyIsClicked = false
        var sNumber = 0
        var n = 0
        var isNumberUsed = false

        fun createNumber() {
            if(isCounted){
                answerText.text = ""
                isCounted = false
            }
            number = answerText.text
            answerText.setText("$number" + "$n")
            isNumberUsed = true
        }

        oneButton.setOnClickListener{
            n = 1
            createNumber()
        }

        twoButton.setOnClickListener{
            n = 2
            createNumber()
        }

        threeButton.setOnClickListener{
            n = 3
            createNumber()
        }


        plusButton.setOnClickListener{
            if(isNumberUsed) {
                if (minusIsClicked) {
                    number = answerText.text
                    score -= number.toString().toInt(10)
                    answerText.setText("")
                    minusIsClicked = false
                    plusIsClicked = true
                } else if (multiplyIsClicked) {
                    number = answerText.text
                    score = (number.toString().toInt()) * sNumber
                    answerText.setText("")
                    multiplyIsClicked = false
                    plusIsClicked = true
                } else {
                    number = answerText.text
                    score += number.toString().toInt(10)
                    answerText.setText("")
                    plusIsClicked = true
                }
            }
        }

        minusButton.setOnClickListener {
            if(isNumberUsed) {
                if (plusIsClicked) {
                    number = answerText.text
                    score += number.toString().toInt(10)
                    answerText.setText("")
                    plusIsClicked = false
                    minusIsClicked = true
                } else if (minusIsClicked) {
                    number = answerText.text
                    score -= number.toString().toInt(10)
                    answerText.setText("")
                    minusIsClicked = true
                } else if (multiplyIsClicked) {
                    number = answerText.text
                    score = (number.toString().toInt()) * sNumber
                    answerText.setText("")
                    multiplyIsClicked = false
                    minusIsClicked = true
                } else {
                    number = answerText.text
                    score = number.toString().toInt(10)
                    answerText.setText("")
                    minusIsClicked = true
                }
            }
        }

        multiplyButton.setOnClickListener {
           if(isNumberUsed) {
               if (multiplyIsClicked) {
                   number = answerText.text
                   score = (number.toString().toInt()) * sNumber
                   answerText.setText("")
                   multiplyIsClicked = true
               } else if (plusIsClicked) {
                   number = answerText.text
                   score += number.toString().toInt(10)
                   answerText.setText("")
                   plusIsClicked = false
                   multiplyIsClicked = true
               } else if (minusIsClicked) {
                   number = answerText.text
                   score -= number.toString().toInt(10)
                   answerText.setText("")
                   minusIsClicked = false
                   multiplyIsClicked = true
                   number = answerText.text
                   sNumber = number.toString().toInt()
               } else {
                   number = answerText.text
                   sNumber = number.toString().toInt()
                   score = number.toString().toInt()
                   answerText.setText("")
                   multiplyIsClicked = true
               }
           }
        }

        equalButton.setOnClickListener {
          if(isNumberUsed) {
              when {
                  plusIsClicked -> {
                      if (answerText.text != "") {
                          number = answerText.text
                          score += number.toString().toInt(10)
                          plusIsClicked = false
                      }
                  }
                  minusIsClicked -> {
                      number = answerText.text
                      score -= number.toString().toInt(10)
                      minusIsClicked = false
                  }
                  multiplyIsClicked -> {
                      number = answerText.text
                      score = (number.toString().toInt()) * sNumber
                      multiplyIsClicked = false
                  }
                  else -> {
                      number = answerText.text
                      score = number.toString().toInt(10)
                  }
              }

              answerText.text = "$score"
              number = ""
              score = 0
              isCounted = true
          }
        }

        cancelButton.setOnClickListener{
            score = 0
            number = ""
            answerText.text = ""
            isCounted = false
            isNumberUsed = false
        }
    }
}
