package com.example.loginandroidkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sp: SharedPreferences;
    private lateinit var nomeStr: String;
    private lateinit var senhaStr: String;


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun entrar(view: View){
        if(!txtNome.text.toString().isEmpty() && !txtSenha.text.toString().isEmpty()) {
            sp = getSharedPreferences("Cadastro", Context.MODE_PRIVATE);
            nomeStr = sp.getString("nome", "").toString();
            senhaStr = sp.getString("senha", "").toString();
            if (nomeStr == txtNome.text.toString() && senhaStr == txtSenha.text.toString()) {
                Toast.makeText(this, "Seja Bem Vindo $nomeStr!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, InfoActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Dados Incorretos!", Toast.LENGTH_SHORT).show()
                txtNome.setHint("");
                txtSenha.setHint("");
            }
        }else{
            txtNome.setHint("Digite um nome válido!");
            txtSenha.setHint("Digite uma senha válida");
        }
    }


    fun cadastrar(view: View){
        val intent = Intent(this, CadastroActivity::class.java);
        startActivity(intent);
    }
}