package com.andersonpsdev.applistatarefas.data.local.database

import com.andersonpsdev.applistatarefas.domain.model.Tarefa

interface ITarefaDAO {

    fun Salvar(tarefa: Tarefa): Boolean
    fun Atualizar(tarefa: Tarefa): Boolean
    fun Remover(idTarefa: Int): Boolean
    fun Listar(): List<Tarefa>
}