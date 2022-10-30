package com.example.todorest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todorest.data.retrofit.TodoResponse
import com.example.todorest.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val todoLiveData = MutableLiveData<List<TodoResponse>>()
    val todos: LiveData<List<TodoResponse>> = todoLiveData

    init {
        viewModelScope.launch {
            todoLiveData.value = todoRepository.getTodos()
        }
    }
}