package com.example.loginandroidkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_info.*
import org.w3c.dom.Text

class InfoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val sp = getSharedPreferences("Cadastro", Context.MODE_PRIVATE)
        infoNome.setText(sp.getString("nome", "").toString())
        infoCPF.setText(sp.getString("cpf", "").toString())
        infoData.setText(sp.getString("data", "").toString())
        /*val strNome = sp.getString("nome", "")
        val strCPF = sp.getString("cpf", "")
        val strData = sp.getString("data", "")*/
    }
}