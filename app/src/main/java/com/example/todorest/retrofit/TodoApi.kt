package com.example.todorest.retrofit

import retrofit2.http.*

interface TodoApi {
    companion object {
        const val BASE_URL = "http://165.227.91.217/"
    }

    @GET(".")
    suspend fun getTodos(): List<TodoResponse>
//
//    @GET("getTodo/{id}")
//    suspend fun getTodo(@Path("id") todoId: Int): TodoResponse
//
//    @POST("addTodo")
//    suspend fun addTodo(): TodoResponse
//
//    @DELETE("deleteTodo/{id}")
//    suspend fun deleteTodo():String
//
//
//    @PUT("updateTodo/{id}")
//    suspend fun updateTodo():TodoResponse


}

