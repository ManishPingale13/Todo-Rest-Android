package com.example.todorest.data.retrofit.repository

import com.example.todorest.data.retrofit.TodoApi
import com.example.todorest.data.retrofit.TodoResponse
import com.example.todorest.repository.TodoRepository

class TodoRepositoryImpl(
    private val todoApi: TodoApi
) : TodoRepository {

    override suspend fun getTodos() = todoApi.getTodos()

    override suspend fun getTodo(todoId: Int) = todoApi.getTodo(todoId)

    override suspend fun deleteTodo(todoId: Int) = todoApi.deleteTodo(todoId)

    override suspend fun addTodo(todo: TodoResponse) = todoApi.addTodo(todo)

    override suspend fun updateTodo(id: Int, todo: TodoResponse) = todoApi.updateTodo(id, todo)

}