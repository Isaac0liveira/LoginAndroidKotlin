package com.example.loginandroidkotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    fun cadastrarUsuario(view: View){
        if(cadNome.text.toString().isEmpty() || cadCPF.text.toString().isEmpty() || cadData.text.toString().isEmpty() || cadSenha.text.toString().isEmpty() || cadConfirmaSenha.text.toString().isEmpty()){
           Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
           return;
        }else{
            if(cadSenha.text.toString() == cadConfirmaSenha.text.toString()){
                val sp = getSharedPreferences("Cadastro", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sp.edit()
                editor.putString("nome", cadNome.text.toString())
                editor.putString("cpf", cadCPF.text.toString())
                editor.putString("data", cadData.text.toString())
                editor.putString("senha", cadSenha.text.toString())
                editor.commit()
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show()
                return;
            }
        }
    }
}