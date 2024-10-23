package unisanta.br.perfilmvvm.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import unisanta.br.perfilmvvm.ViewModel.UserViewModel
import unisanta.br.perfilmvvm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (email.isNotBlank() && password.isNotBlank()) {
                if (userViewModel.loginUser(email, password)) {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Login falhou. Verifique suas credenciais.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}




