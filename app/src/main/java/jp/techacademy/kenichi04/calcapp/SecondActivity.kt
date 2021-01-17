package jp.techacademy.kenichi04.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val num1 = intent.getDoubleExtra("num1", 0.0)
        val num2 = intent.getDoubleExtra("num2", 0.0)
        val symbol = intent.getStringExtra("symbol")
        val result = intent.getDoubleExtra("result", 0.0)

        textView.text = "${num1} ${symbol} ${num2} = ${result} です"
    }
}