package br.com.fiap.androidroomdatabase

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.androidroomdatabase.database.Pessoa

class PessoaAdapter(private val dataSet: List<Pessoa>): RecyclerView.Adapter<PessoaAdapter.ViewHolder>(),
            View.OnClickListener{

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textViewNome: TextView

        init {
            textViewNome = view.findViewById(R.id.textViewNome)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_pessoal_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = dataSet[position]
        var nome = item.nome
        holder.textViewNome.text = nome
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, FormActivity::class.java).apply {
                putExtra("EXTRA_PESSOA_ID", item.id)
                putExtra("EXTRA_PESSOA_NOME", item.nome)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}