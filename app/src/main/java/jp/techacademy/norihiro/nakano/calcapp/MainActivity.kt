package jp.techacademy.norihiro.nakano.calcapp

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

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (VALUE1.text.toString() == "" || VALUE2.text.toString() == ""){
            Snackbar.make(v ,"2箇所に値を入れてください", Snackbar.LENGTH_LONG)
                .setAction("閉じる"){
                    Log.d("エラー", "値の入力不足")
                }.show()
        }else{
            when(v.id){
                R.id.button1 -> plus()
                R.id.button2 -> muins()
                R.id.button3 -> multiplication()
                R.id.button4 -> division()
            }
        }
    }

    private fun plus(){
        val intent = Intent(this, ResultActivity::class.java)
        val totalPlus:Double = VALUE1.text.toString().toDouble() + VALUE2.text.toString().toDouble()
        intent.putExtra("Total", totalPlus)
        startActivity(intent)

    }

    private fun muins(){
        val intent = Intent(this, ResultActivity::class.java)
        val totalMuins:Double = VALUE1.text.toString().toDouble() - VALUE2.text.toString().toDouble()
        intent.putExtra("Total", totalMuins)
        startActivity(intent)
    }

    private  fun multiplication(){
        val intent = Intent(this, ResultActivity::class.java)
        val totalMultiplication:Double = VALUE1.text.toString().toDouble() * VALUE2.text.toString().toDouble()
        intent.putExtra("Total", totalMultiplication)
        startActivity(intent)
    }

    private fun division(){
        val intent = Intent(this, ResultActivity::class.java)
        val totalDivision:Double = VALUE1.text.toString().toDouble() / VALUE2.text.toString().toDouble()
        intent.putExtra("Total", totalDivision)
        startActivity(intent)
    }
}