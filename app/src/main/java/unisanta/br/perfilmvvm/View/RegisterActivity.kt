package unisanta.br.perfilmvvm.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import unisanta.br.perfilmvvm.ViewModel.UserViewModel
import unisanta.br.perfilmvvm.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val imageUrl = binding.editTextImageUrl.text.toString()

            if (email.isNotBlank() && password.isNotBlank() && imageUrl.isNotBlank()) {
                userViewModel.registerUser(email, password, imageUrl)
                Toast.makeText(this, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonBackToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}






