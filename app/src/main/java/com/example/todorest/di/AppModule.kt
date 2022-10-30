package com.example.todorest.di

import com.example.todorest.data.retrofit.TodoApi
import com.example.todorest.data.retrofit.repository.TodoRepositoryImpl
import com.example.todorest.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(TodoApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideTodoApi(retrofit: Retrofit): TodoApi = retrofit.create(TodoApi::class.java)

    @Provides
    @Singleton
    fun provideTodoRepo(todoApi: TodoApi): TodoRepository = TodoRepositoryImpl(todoApi)

}