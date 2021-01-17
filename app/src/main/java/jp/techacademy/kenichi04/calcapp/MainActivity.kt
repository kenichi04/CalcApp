package jp.techacademy.kenichi04.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDevide.setOnClickListener(this)
    }

    override fun onClick(v: View) {
//        val text = editText1.text
        if (editText1.text.toString() == "" || editText2.text.toString() == "") {
            Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Hide") {
                        // 処理なし（snackBar隠れる）
                    }
                    .show()
            return
        }
        if ((editText2.text.toString().equals("0") && v.id == R.id.buttonDevide) ||
            (editText2.text.toString().equals("-0") && v.id == R.id.buttonDevide)) {
            Snackbar.make(v, "0による割り算はできません", Snackbar.LENGTH_INDEFINITE)
                .setAction("Hide") {}
                .show()
            return
        }
        val num1 = editText1.text.toString().toDouble()
        val num2 = editText2.text.toString().toDouble()
        var symbol = ""
        var result = 0.0
        when(v.id) {
            R.id.buttonPlus -> {
                result = num1 + num2
                symbol = "+"
            }
            R.id.buttonMinus -> {
                result = num1 - num2
                symbol = "-"
            }
            R.id.buttonMultiply -> {
                result = num1 * num2
                symbol = "×"
            }
            R.id.buttonDevide -> {
                result = num1 / num2
                symbol = "÷"
            }
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("num1", num1)
        intent.putExtra("num2", num2)
        intent.putExtra("symbol", symbol)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}