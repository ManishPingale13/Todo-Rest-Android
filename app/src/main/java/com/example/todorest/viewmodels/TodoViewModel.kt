package com.example.todorest.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todorest.data.retrofit.TodoResponse
import com.example.todorest.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@SuppressLint("SimpleDateFormat")
@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val todoLiveData = MutableLiveData<List<TodoResponse>>()
    val todos: LiveData<List<TodoResponse>> = todoLiveData

    init {
        viewModelScope.launch {
            try {
                val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                val date = formatter.format(Date()).toString()
                todoLiveData.value =
                    listOf(
                        todoRepository.updateTodo(
                            1,
                            TodoResponse(
                                "This task was updated from android app using Retrofit ! Pretty cool stuff",
                                null,
                                date,
                                null
                            )
                        )
                    )
            } catch (e: HttpException) {
                when (e.code()) {
                    404 -> println("The task you are trying to update does not exist $e")
                    500 -> println("Something went wrong $e")
                    400 -> println("Data not valid $e")
                }
            } catch (e: Exception) {
                println("Unexpected error occurred ! $e")
            }
        }
    }
}