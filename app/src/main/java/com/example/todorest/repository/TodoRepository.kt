package com.example.todorest.repository

import com.example.todorest.data.retrofit.TodoResponse

interface TodoRepository {

    // Get list of all todos
    suspend fun getTodos():List<TodoResponse>
}