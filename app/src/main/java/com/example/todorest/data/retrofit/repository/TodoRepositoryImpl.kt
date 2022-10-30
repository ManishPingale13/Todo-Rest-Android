package com.example.todorest.data.retrofit.repository

import com.example.todorest.data.retrofit.TodoApi
import com.example.todorest.repository.TodoRepository

class TodoRepositoryImpl(
    private val todoApi: TodoApi
) : TodoRepository {

    override suspend fun getTodos() = todoApi.getTodos()

}