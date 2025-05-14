package com.andersonpsdev.applistatarefas.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andersonpsdev.applistatarefas.data.local.database.TarefaDAO
import com.andersonpsdev.applistatarefas.domain.model.Tarefa
import com.jamiltondamasceno.applistatarefas.databinding.ActivityAdicionarTarefaBinding

class AdicionarTarefaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAdicionarTarefaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var tarefa: Tarefa? = null
        val bundle = intent.extras
        if (bundle != null){
            tarefa = bundle.getSerializable("tarefa") as Tarefa
                binding.editTarefa.setText(tarefa.descricao)}

        with(binding){
            btnSalvar.setOnClickListener {
                if(editTarefa.text.isNotEmpty() ) {
                    if (tarefa != null) {
                        editar(tarefa)
                    } else {
                        Salvar()
                    }

                    Toast.makeText(
                        this@AdicionarTarefaActivity,
                        "Preencha uma tarefa",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun editar(tarefa: Tarefa) {
        val descricao = binding.editTarefa.text.toString()
        val tarefaAtualizar = Tarefa(
            tarefa.idTarefa,
            descricao,
            "default"
        )
        val tarefaDAO = TarefaDAO(this)
        if (tarefaDAO.Atualizar(tarefaAtualizar)){
            Toast.makeText(
                this@AdicionarTarefaActivity,
                "Tarefa atualizada com sucesso",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }

    }

    private fun ActivityAdicionarTarefaBinding.Salvar() {
        val descricao = editTarefa.text.toString()
        val tarefa = Tarefa(
            -1,
            descricao,
            "default"
        )
        val tarefaDAO = TarefaDAO(this@AdicionarTarefaActivity)
        if (tarefaDAO.Salvar(tarefa)) {
            Toast.makeText(
                this@AdicionarTarefaActivity,
                "Tarefa salva com sucesso",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
    }
}