package unisanta.br.perfilmvvm.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import unisanta.br.perfilmvvm.Model.UserProfile

class UserViewModel : ViewModel() {
    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile> get() = _userProfile

    private val userStorage = mutableListOf<UserProfile>()

    fun registerUser(email: String, password: String, imageUrl: String) {
        if (userStorage.none { it.email == email }) {
            val newUser = UserProfile(email, password, imageUrl)
            userStorage.add(newUser)
            _userProfile.value = newUser
        } else {
            Log.w("UserViewModel", "Email já cadastrado: $email")
        }
    }

    fun loginUser(email: String, password: String): Boolean {
        val user = userStorage.find { it.email == email && it.password == password }
        return if (user != null) {
            _userProfile.value = user
            true
        } else {
            Log.w("UserViewModel", "Login falhou para o email: $email")
            false
        }
    }

    fun editUserProfile(email: String, imageUrl: String) {
        _userProfile.value?.let { userProfile ->
            userProfile.email = email
            userProfile.imageUrl = imageUrl
        }
    }

}




