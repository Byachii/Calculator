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
        var n = 0

       fun createNumber() {
            if(isCounted){
                answerText.text = ""
                isCounted = false
            }
            number = answerText.text
            answerText.setText("$number" + "$n")
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


        plusButton.setOnClickListener {
            if (answerText.text != "") {
                when {
                    minusIsClicked -> {
                        number = answerText.text
                        score -= number.toString().toInt(10)
                        answerText.setText("")
                        minusIsClicked = false
                        plusIsClicked = true
                    }
                    multiplyIsClicked -> {
                        number = answerText.text
                        score *= number.toString().toInt()
                        answerText.setText("")
                        multiplyIsClicked = false
                        plusIsClicked = true
                    }
                    else -> {
                        number = answerText.text
                        score += number.toString().toInt(10)
                        answerText.setText("")
                        plusIsClicked = true

                    }
                }
            }
        }

        minusButton.setOnClickListener {
            if(answerText.text != "") {
                when {
                    plusIsClicked -> {
                        number = answerText.text
                        score += number.toString().toInt(10)
                        answerText.setText("")
                        plusIsClicked = false
                        minusIsClicked = true
                    }
                    minusIsClicked -> {
                        number = answerText.text
                        score -= number.toString().toInt(10)
                        answerText.setText("")
                        minusIsClicked = true
                    }
                    multiplyIsClicked -> {
                        number = answerText.text
                        score *= number.toString().toInt()
                        answerText.setText("")
                        multiplyIsClicked = false
                        minusIsClicked = true
                    }
                    else -> {
                        number = answerText.text
                        score = number.toString().toInt(10)
                        answerText.text = ""
                        minusIsClicked = true

                    }
                }
            }
        }

        multiplyButton.setOnClickListener {
            if(answerText.text != "") {
                when {
                    multiplyIsClicked -> {
                        number = answerText.text
                        score *= number.toString().toInt()
                        answerText.text = ""
                        multiplyIsClicked = true
                    }
                    plusIsClicked -> {
                        number = answerText.text
                        score += number.toString().toInt(10)
                        answerText.text = ""
                        plusIsClicked = false
                        multiplyIsClicked = true
                    }
                    minusIsClicked -> {
                        number = answerText.text
                        score -= number.toString().toInt(10)
                        answerText.text = ""
                        minusIsClicked = false
                        multiplyIsClicked = true
                    }
                    else -> {
                        number = answerText.text
                        score = number.toString().toInt()
                        answerText.text = ""
                        multiplyIsClicked = true

                    }
                }
            }
        }

        equalButton.setOnClickListener {
               if(answerText.text != ""){
                when {
                    plusIsClicked -> {
                        number = answerText.text
                        score += number.toString().toInt(10)
                        plusIsClicked = false
                        answerText.text = ""
                    }
                    minusIsClicked -> {

                        number = answerText.text
                        score -= number.toString().toInt(10)
                        minusIsClicked = false
                        answerText.text = ""

                    }
                    multiplyIsClicked -> {

                        number = answerText.text
                        score *= number.toString().toInt()
                        multiplyIsClicked = false
                        answerText.text = ""
                    }
                    else -> {
                        number = answerText.text
                        score = number.toString().toInt(10)
                        answerText.text = ""
                    }
                }
               }
                answerText.text = "$score"
                number = ""
                score = 0
                isCounted = true
                plusIsClicked = false
                minusIsClicked = false
                multiplyIsClicked = false

        }

        cancelButton.setOnClickListener{
            score = 0
            number = ""
            answerText.text = ""
            isCounted = false
            plusIsClicked = false
            minusIsClicked = false
            multiplyIsClicked = false
        }
    }
}
