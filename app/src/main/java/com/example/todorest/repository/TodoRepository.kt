package com.example.todorest.repository

import com.example.todorest.data.retrofit.TodoResponse
import retrofit2.Response

interface TodoRepository {

    // Get list of all todos
    suspend fun getTodos():List<TodoResponse>

    suspend fun getTodo(todoId:Int):TodoResponse

    suspend fun deleteTodo(todoId: Int):Response<String>

    suspend fun addTodo(todo:TodoResponse):TodoResponse

    suspend fun updateTodo(id:Int,todo:TodoResponse):TodoResponse
}