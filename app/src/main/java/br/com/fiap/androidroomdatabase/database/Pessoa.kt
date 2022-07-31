package br.com.fiap.androidroomdatabase.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoa")
data class Pessoa (@PrimaryKey(autoGenerate = true) var id: Int = 0,
                    @NonNull @ColumnInfo(name = "nome") var nome: String,
                   @NonNull @ColumnInfo(name = "cpf") var cpf: String){
}