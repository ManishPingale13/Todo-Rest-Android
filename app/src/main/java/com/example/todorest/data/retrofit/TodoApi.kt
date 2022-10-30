package com.example.todorest.data.retrofit

import retrofit2.Response
import retrofit2.http.*

interface TodoApi {
    companion object {
        const val BASE_URL = "http://165.227.91.217/"
    }

    @GET(".")
    suspend fun getTodos(): List<TodoResponse>

    @GET("getTodo/{id}")
    suspend fun getTodo(@Path("id") id:Int): TodoResponse

    @DELETE("deleteTodo/{id}")
    suspend fun deleteTodo(@Path("id") id:Int):Response<String>

    @POST("addTodo")
    suspend fun addTodo(@Body todoResponse: TodoResponse): TodoResponse

    @PUT("updateTodo/{id}")
    suspend fun updateTodo(@Path("id") id: Int,@Body todoResponse: TodoResponse):TodoResponse


}

