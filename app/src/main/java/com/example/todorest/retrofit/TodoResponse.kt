package com.example.todorest.retrofit

data class TodoResponse(
    val description: String,
    val id: Int,
    val timeStamp: String,
    val title: String
)