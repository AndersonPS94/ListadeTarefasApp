package com.andersonpsdev.applistatarefas.data.local.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.andersonpsdev.applistatarefas.domain.model.Tarefa

class TarefaDAO(context: Context): ITarefaDAO {
    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase

    override fun Salvar(tarefa: Tarefa): Boolean {

        val conteudos = ContentValues()
        conteudos.put(DatabaseHelper.COLUNA_DESCRICAO, tarefa.descricao)
        try {
            escrita.insert(
                DatabaseHelper.NOME_TABELA_TAREFAS,
                null,
                conteudos
            )
            Log.i("INFO_DB", "Sucesso ao salvar tarefa")

        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("INFO_DB", "Erro ao salvar tarefa")
                return false
        }
                return true
    }

    override fun Atualizar(tarefa: Tarefa): Boolean {
        val args = arrayOf(tarefa.idTarefa.toString())
        val conteudo = ContentValues()
        conteudo.put(DatabaseHelper.COLUNA_DESCRICAO, tarefa.descricao)
        try {
            escrita.update(
                DatabaseHelper.NOME_TABELA_TAREFAS,
                conteudo,
                "${DatabaseHelper.COLUNA_ID_TAREFA} = ?",
                args
            )
            Log.i("INFO_DB", "Sucesso ao atualizar tarefa")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("INFO_DB", "Erro ao atualizar tarefa")
            return false
        }
        return true
    }


    override fun Remover(idTarefa: Int): Boolean {
        val args = arrayOf(idTarefa.toString())
        try {

escrita.delete(
    DatabaseHelper.NOME_TABELA_TAREFAS,
    "${DatabaseHelper.COLUNA_ID_TAREFA} = ?",
    args
)
            Log.i("INFO_DB", "Sucesso ao remover tarefa")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("INFO_DB", "Erro ao remover tarefa")
            return false
        }
        return true
    }

    override fun Listar(): List<Tarefa> {
        val listaTarefas = mutableListOf<Tarefa>()
        val sql = "SELECT " +
                "${DatabaseHelper.COLUNA_ID_TAREFA}, " +
                "${DatabaseHelper.COLUNA_DESCRICAO}, " +
                "strftime('%d/%m/%Y %H:%M', ${DatabaseHelper.COLUNA_DATA_CADASTRO})" +
                " ${DatabaseHelper.COLUNA_DATA_CADASTRO} " +
                "FROM ${DatabaseHelper.NOME_TABELA_TAREFAS};"

        val cursor = leitura.rawQuery(sql, null)

        val indiceId = cursor.getColumnIndex(DatabaseHelper.COLUNA_ID_TAREFA)
        val indiceDescricao = cursor.getColumnIndex(DatabaseHelper.COLUNA_DESCRICAO)
        val indiceData = cursor.getColumnIndex(DatabaseHelper.COLUNA_DATA_CADASTRO)

        while (cursor.moveToNext() ) {

            val idTarefa = cursor.getInt(indiceId)
            val descricao = cursor.getString(indiceDescricao)
            val data = cursor.getString(indiceData)

            listaTarefas.add(
                Tarefa(
                    idTarefa,
                    descricao,
                    data
                )
            )
        }

        return listaTarefas
    }
}