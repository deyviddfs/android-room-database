package br.com.fiap.androidroomdatabase

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.androidroomdatabase.database.AppDatabase
import br.com.fiap.androidroomdatabase.database.Pessoa
import br.com.fiap.androidroomdatabase.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity(){

    lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val appDb = AppDatabase.getDatabase(this)
        val idPessoa = intent.getIntExtra("EXTRA_PESSOA_ID", 0)

        if(idPessoa>0){
            val nomePessoa = intent.getStringExtra("EXTRA_PESSOA_NOME")
            binding.editTextNome.setText(nomePessoa)
        }

        binding.botaoSalvar.setOnClickListener {
            if (idPessoa>0){
                //Alteracao
                Toast.makeText(super.getApplicationContext(), "Registro alterado com sucesso!", Toast.LENGTH_LONG).show()
                appDb.pessoaDao().update(Pessoa(idPessoa, binding.editTextNome.text.toString(), ""))
            }
            else {
                //Inclusao
                Toast.makeText(super.getApplicationContext(), "Registro cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                appDb.pessoaDao().insert(Pessoa(0, binding.editTextNome.text.toString(), ""))
            }

            super.finish()
        }

        binding.botaoExcluir.setOnClickListener {
            Toast.makeText(super.getApplicationContext(), "Registro excluído com sucesso!", Toast.LENGTH_LONG).show()
            appDb.pessoaDao().delete(Pessoa(idPessoa, "", ""))
            super.finish()
        }
    }
}