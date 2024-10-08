package com.jamiltondamasceno.applistatarefas.database

import com.jamiltondamasceno.applistatarefas.model.Tarefa

interface ITarefaDAO {

    fun Salvar(tarefa: Tarefa): Boolean
    fun Atualizar(tarefa: Tarefa): Boolean
    fun Remover(idTarefa: Int): Boolean
    fun Listar(): List<Tarefa>
}