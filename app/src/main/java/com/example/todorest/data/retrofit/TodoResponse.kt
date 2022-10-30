package com.example.todorest.data.retrofit

data class TodoResponse(
    val description: String?,
    val id: Int? = null,
    val timeStamp:String,
    val title: String?
)