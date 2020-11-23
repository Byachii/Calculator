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
private lateinit var dotButton: Button
private lateinit var fourButton: Button
private lateinit var fiveButton: Button
private lateinit var sixButton: Button
private lateinit var sevenButton: Button
private lateinit var eightButton: Button
private lateinit var nineButton: Button
private lateinit var zeroButton: Button
private lateinit var divideButton: Button

enum class Calculations {
    PLUS, MINUS, MULTIPLY, DIVIDE, NONE
}

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
        dotButton = findViewById(R.id.dot_button)
        fourButton = findViewById(R.id.four_button)
        fiveButton = findViewById(R.id.five_button)
        sixButton = findViewById(R.id.six_button)
        sevenButton = findViewById(R.id.seven_button)
        eightButton = findViewById(R.id.eight_button)
        nineButton = findViewById(R.id.nine_button)
        zeroButton = findViewById(R.id.zero_button)
        divideButton = findViewById(R.id.divide_button)

        var number = answerText.text
        var score = 0f
        var isCounted = false
        var n = 0
        var enumValue = Calculations.NONE

       fun createNumber() {
            if(isCounted){
                answerText.text = ""
                isCounted = false
            }
            number = answerText.text
            answerText.setText("$number" + "$n")
        }

        oneButton.setOnClickListener {
            n = 1
            createNumber()
        }

        twoButton.setOnClickListener {
            n = 2
            createNumber()
        }

        threeButton.setOnClickListener {
            n = 3
            createNumber()
        }

        fourButton.setOnClickListener {
            n = 4
            createNumber()
        }

        fiveButton.setOnClickListener {
            n = 5
            createNumber()
        }

        sixButton.setOnClickListener {
            n = 6
            createNumber()
        }

        sevenButton.setOnClickListener {
            n = 7
            createNumber()
        }

        eightButton.setOnClickListener {
            n = 8
            createNumber()
        }

        nineButton.setOnClickListener {
            n = 9
            createNumber()
        }

        zeroButton.setOnClickListener {
            n = 0
            createNumber()
        }

        dotButton.setOnClickListener {
            if(answerText.text != "" && answerText.text != "-"){
                if(!answerText.text.contains(".")) {
                 number = answerText.text
                 answerText.setText("$number" + ".")
                }
            }
        }

        fun Calculate(){
            when (enumValue) {
                Calculations.PLUS -> {
                    number = answerText.text
                    score += number.toString().toFloat()
                    answerText.setText("")
                }
                Calculations.MINUS -> {
                    number = answerText.text
                    score -= number.toString().toFloat()
                    answerText.setText("")
                }
                Calculations.MULTIPLY -> {
                    number = answerText.text
                    score *= number.toString().toFloat()
                    answerText.setText("")
                }
                Calculations.DIVIDE -> {
                    number = answerText.text
                    score /= number.toString().toFloat()
                    answerText.text = ""
                }
                Calculations.NONE -> {
                    number = answerText.text
                    score = number.toString().toFloat()
                    answerText.text = ""
                }
            }
        }
        plusButton.setOnClickListener {
            if (answerText.text != "" && answerText.text != "-") {
                Calculate()
                enumValue = Calculations.PLUS
            }
        }

        minusButton.setOnClickListener {
            if(answerText.text != "") {
                if(answerText.text !== "-") {
                    Calculate()
                    enumValue = Calculations.MINUS
                }
            } else if(answerText.text == ""){
                answerText.text = "-"
            }
        }

        multiplyButton.setOnClickListener {
            if(answerText.text != "" && answerText.text != "-") {
                Calculate()
                enumValue = Calculations.MULTIPLY
            }
        }

        divideButton.setOnClickListener {
            if(answerText.text != "" && answerText.text != "-") {
                Calculate()
                enumValue = Calculations.DIVIDE
            }
        }

        equalButton.setOnClickListener {
               if(answerText.text != "" && answerText.text != "-"){
               Calculate()
               }
                var s = String.format("%.2f", score)
                answerText.text = "$s"
                number = ""
                score = 0f
                isCounted = true
                enumValue = Calculations.NONE

        }

        cancelButton.setOnClickListener{
            score = 0f
            number = ""
            answerText.text = ""
            isCounted = false
            enumValue = Calculations.NONE
        }

    }
}
