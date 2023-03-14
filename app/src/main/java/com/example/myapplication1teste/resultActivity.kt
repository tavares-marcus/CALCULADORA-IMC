package com.example.myapplication1teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvresult = findViewById<TextView>(R.id.textview_result)
        val tvclassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result= intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvresult.text = result.toString()


        val classificacao = if (result < 18.5f){
            "abaixo do peso"
        }else if (result >= 18.5f && result < 24.9f){
            "normal"
        }else if (result in 25f..29.9f){
            "sobrepeso"
        }else if (result in 30f..39.9f){
            "obesidade"
        }else {
            "obesidade grave"
        }

        tvclassificacao.text = getString(R.string.message_classificacao,classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}