package com.example.simplecalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var ans = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun submit(view: View) {


        val input = editText.text.toString()

        if ("+" in input) {
            val index = input.indexOf("+")
            val num1 = getNum1(input, index)
            val num2 = getNum2(input, index)
            ans = num1 + num2
            result.text = "= " + ans.toString()

        } else if ("-" in input) {
            val index = input.indexOf("-")
            val num1 = getNum1(input, index)
            val num2 = getNum2(input, index)
            ans = num1 - num2
            result.text = "= $ans"
        } else if ("*" in input) {
            val index = input.indexOf("*")
            val num1 = getNum1(input, index)
            val num2 = getNum2(input, index)
            ans = num1 * num2
            result.text = "= $ans"
        } else if ("/" in input) {
            val index = input.indexOf("/")
            val num1 = getNum1(input, index)
            val num2 = getNum2(input, index)
            ans = num1 / num2
            result.text = "= $ans"
        } else if ("^" in input) {
            val index = input.indexOf("^")
            val num1 = getNum1(input, index)
            val num2 = getNum2(input, index)
            ans = Math.pow(num1, num2)
            result.text = "= $ans"
        } else {
            result.text = "Invalid input"
        }


    }

    fun getNum1(input:String, index:Int):Double {
        val num = input.substring(0, index)
        val num1 = if (num == "Ans" || num == "ans") {
            ans
        } else {
            num.toDouble()
        }
        return num1
    }

    fun getNum2(input:String, index:Int):Double {
        val num = input.substring(index + 1, input.length)
        val num2 = if (num == "Ans" || num == "ans") {
            ans
        } else {
            num.toDouble()
        }
        return num2
    }



}