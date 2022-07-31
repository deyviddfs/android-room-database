package br.com.fiap.androidroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.androidroomdatabase.database.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        load()
    }

    override fun onResume() {
        super.onResume()
        load()
    }

    private fun load(){
        val appDb = AppDatabase.getDatabase(this);
        var list = appDb.pessoaDao().getAll();
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PessoaAdapter(list)
    }

    fun openForm(view: View){
        val intent = Intent(this, FormActivity::class.java).apply {  }
        startActivity(intent)
    }
}