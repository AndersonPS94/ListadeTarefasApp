package com.andersonpsdev.applistatarefas.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonpsdev.applistatarefas.presentation.adapter.TarefaAdapter
import com.andersonpsdev.applistatarefas.data.local.database.TarefaDAO
import com.andersonpsdev.applistatarefas.domain.model.Tarefa
import com.jamiltondamasceno.applistatarefas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var listaTarefas = emptyList<Tarefa>()
    private var tarefaAdapter : TarefaAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fabAdicionar.setOnClickListener {
            val intent = Intent(this, AdicionarTarefaActivity::class.java)
            startActivity( intent )
        }
        tarefaAdapter = TarefaAdapter(
            {id -> confirmarExclusao(id) },
            {tarefa -> editar(tarefa) }
        )
        binding.rvTarefas.adapter = tarefaAdapter

        binding.rvTarefas.layoutManager = LinearLayoutManager(this)
    }

    private fun editar(tarefa: Tarefa) {
        val intent = Intent(this, AdicionarTarefaActivity::class.java)
        intent.putExtra("tarefa", tarefa)
                startActivity(intent)
    }

    private fun confirmarExclusao(id: Int) {

        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Confirmar exclusão")
        alertBuilder.setMessage("Deseja realmente excluir a tarefa?")
        alertBuilder.setPositiveButton("Sim") { _, _ ->
                val tarefaDAO = TarefaDAO(this)
            if (tarefaDAO.Remover(id)) {
                atualizarlistaTarefas()
                    Toast.makeText(this,
                        "Tarefa removida com sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                }else{
                    Toast.makeText(
                        this,
                        "Erro ao remover tarefa",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        alertBuilder.setNegativeButton("Não") { _, _ ->
        }
        alertBuilder.create().show()
    }

    private fun  atualizarlistaTarefas(){

        val tarefaDAO = TarefaDAO(this)
        listaTarefas = tarefaDAO.Listar()
        tarefaAdapter?.adicionarLista(listaTarefas)
    }

    override fun onStart() {
        super.onStart()
        atualizarlistaTarefas()
    }
}