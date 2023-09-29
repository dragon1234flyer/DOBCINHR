package com.example.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    private var lastnumric: Boolean = false
    private var lastdot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvinput)
    }

    fun onclick(view: View) {
        tvInput?.append((view as Button).text)
        lastnumric = true
        lastdot = false
    }

    fun onclear(view: View) {
        tvInput?.text = " "
    }

    fun ondecimal(view: View) {
        if (lastnumric && !lastdot) {
            tvInput?.append(".")
            lastnumric = true
            lastdot = false
        }
    }

    fun onOperator(view: View) {
        tvInput?.text?.let {
            if (lastnumric && !isOperatoradded(it.toString()))
                tvInput?.append((view as Button).text)
            lastnumric = false
            lastdot = false
        }
    }
fun onEqual(view: View){
    if(lastnumric){
        var tvvalue = tvInput?.text.toString()
        var prefix = ""
        try {
            if(tvvalue.startsWith("-")){
                prefix = "-"
                tvvalue = tvvalue.substring(1)
            }
            if(tvvalue.contains("-")) {

                val splitvalue = tvvalue.split("-")
                var one = splitvalue[0] // 99

                var two = splitvalue[1]  //1
                if (prefix.isNotEmpty()) {

                    one = prefix + one

                }

            var result = one.toDouble() - two.toDouble()

                tvInput?.text = remove(result.toString())
        }
            else if (tvvalue.contains("+")) {

                    val splitvalue = tvvalue.split("+")
                    var one = splitvalue[0] // 99

                    var two = splitvalue[1]  //1
                    if (prefix.isNotEmpty()) {

                        one = prefix + one

                    }

                    var result = one.toDouble() + two.toDouble()

                tvInput?.text = remove(result.toString())
                }
            else if (tvvalue.contains("*")) {

                val splitvalue = tvvalue.split("*")
                var one = splitvalue[0] // 99

                var two = splitvalue[1]  //1
                if (prefix.isNotEmpty()) {

                    one = prefix + one

                }

                var result = one.toDouble() * two.toDouble()

                tvInput?.text = remove(result.toString())
            }
            else if (tvvalue.contains("/")) {

                val splitvalue = tvvalue.split("/")
                var one = splitvalue[0] // 99

                var two = splitvalue[1]  //1
                if (prefix.isNotEmpty()) {

                    one = prefix + one

                }

                var result = one.toDouble() / two.toDouble()

                tvInput?.text = remove(result.toString())
            }

            } catch (e : ArithmeticException){
            e.printStackTrace()
        }
    }
}
    private fun remove(result: String): String {
        var value = result
        if(result.contains(".0"))
            value = result.substring(0,result.length -2)
            return value
    }
    private fun isOperatoradded(value:String) :Boolean{
        return if(value.startsWith("-")){
            false
        }
            else{
                value.contains("/")
                        || value.contains("*")
                        ||value.contains("+")
                        ||value.contains("-")

        }
    }



}