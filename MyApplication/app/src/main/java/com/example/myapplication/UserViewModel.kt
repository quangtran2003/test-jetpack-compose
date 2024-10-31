package com.example.myapplication
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                _users.value = RetrofitInstance.api.getUsers()
            } catch (e: Exception) {
                // Xử lý lỗi ở đây
            }
        }
    }
}
