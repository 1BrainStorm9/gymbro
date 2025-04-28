package com.kirill_nikolaenko.gymbro.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onUsernameChange(username: String) {
        _uiState.update { it.copy(username = username) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _uiState.update { it.copy(confirmPassword = confirmPassword) }
    }

    fun togglePasswordVisibility() {
        _uiState.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    fun toggleConfirmPasswordVisibility() {
        _uiState.update { it.copy(confirmPasswordVisible = !it.confirmPasswordVisible) }
    }

    fun registerWithEmail() {
        viewModelScope.launch {
            // Validate input
            if (!validateInput()) {
                return@launch
            }

            _uiState.update { it.copy(isLoading = true) }

            try {
                // Call repository to register user
                // This is where you would call your authentication service
                // Example: authRepository.register(uiState.value.email, uiState.value.password)
                
                // Simulate network delay
                kotlinx.coroutines.delay(1500)
                
                // Set registration success
                _uiState.update { it.copy(isRegistered = true, isLoading = false) }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        errorMessage = e.message ?: "Registration failed",
                        isLoading = false
                    ) 
                }
            }
        }
    }

    fun registerWithGoogle() {
        // Implement Google registration logic
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            // Simulate network delay
            kotlinx.coroutines.delay(1000)
            _uiState.update { it.copy(isLoading = false, isRegistered = true) }
        }
    }

    fun registerWithFacebook() {
        // Implement Facebook registration logic
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            // Simulate network delay
            kotlinx.coroutines.delay(1000)
            _uiState.update { it.copy(isLoading = false, isRegistered = true) }
        }
    }

    fun registerWithApple() {
        // Implement Apple registration logic
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            // Simulate network delay
            kotlinx.coroutines.delay(1000)
            _uiState.update { it.copy(isLoading = false, isRegistered = true) }
        }
    }

    fun resetRegisterState() {
        _uiState.update { it.copy(isRegistered = false) }
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }

    private fun validateInput(): Boolean {
        val state = uiState.value
        
        when {
            state.username.isBlank() -> {
                _uiState.update { it.copy(errorMessage = "Username cannot be empty") }
                return false
            }
            state.email.isBlank() -> {
                _uiState.update { it.copy(errorMessage = "Email cannot be empty") }
                return false
            }
            !isValidEmail(state.email) -> {
                _uiState.update { it.copy(errorMessage = "Invalid email format") }
                return false
            }
            state.password.isBlank() -> {
                _uiState.update { it.copy(errorMessage = "Password cannot be empty") }
                return false
            }
            state.password.length < 6 -> {
                _uiState.update { it.copy(errorMessage = "Password must be at least 6 characters") }
                return false
            }
            state.password != state.confirmPassword -> {
                _uiState.update { it.copy(errorMessage = "Passwords do not match") }
                return false
            }
        }
        
        return true
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
        return email.matches(emailRegex)
    }
}

data class RegisterUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val passwordVisible: Boolean = false,
    val confirmPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val isRegistered: Boolean = false,
    val errorMessage: String? = null
) 