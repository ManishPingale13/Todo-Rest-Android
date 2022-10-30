package com.example.todorest.repository

import com.example.todorest.data.retrofit.TodoResponse
import retrofit2.Response

interface TodoRepository {

    // Get list of all tasks
    suspend fun getTodos(): List<TodoResponse>

    //Get a single task by id
    suspend fun getTodo(todoId: Int): TodoResponse

    //Delete a single task
    suspend fun deleteTodo(todoId: Int): Response<String>

    //Add a task
    suspend fun addTodo(todo: TodoResponse): TodoResponse

    //Update perticular task
    suspend fun updateTodo(id: Int, todo: TodoResponse): TodoResponse
}