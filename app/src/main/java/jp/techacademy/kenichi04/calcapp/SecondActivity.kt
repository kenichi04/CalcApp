package jp.techacademy.kenichi04.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var num1 = intent.getDoubleExtra("num1", 0.0)
        var num2 = intent.getDoubleExtra("num2", 0.0)
        val symbol = intent.getStringExtra("symbol")
        var result = intent.getDoubleExtra("result", 0.0)

        var strNum1 = num1.toString()
        var strNum2 = num2.toString()
        var strResult = result.toString()

        if (num1.toString().endsWith(".0")) {
            strNum1 = num1.toInt().toString()
        }
        if (num2.toString().endsWith(".0")) {
            strNum2 = num2.toInt().toString()
        }
        if (result.toString().endsWith(".0")) {
            strResult = result.toInt().toString()
        }

        textView.text = "${strNum1} ${symbol} ${strNum2} = ${strResult} です"
    }
}