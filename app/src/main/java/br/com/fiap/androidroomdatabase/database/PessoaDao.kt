package br.com.fiap.androidroomdatabase.database

import androidx.room.*

@Dao
interface PessoaDao {
    @Query("SELECT * FROM pessoa ORDER BY nome ASC")
    fun getAll(): List<Pessoa>;

    @Insert
    fun insert(vararg pessoa: Pessoa)

    @Update
    fun update(pessoa: Pessoa)

    @Delete
    fun delete(pessoa: Pessoa)
}