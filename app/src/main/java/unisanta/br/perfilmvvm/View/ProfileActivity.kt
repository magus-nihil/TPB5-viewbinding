package unisanta.br.perfilmvvm.View

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import unisanta.br.perfilmvvm.ViewModel.UserViewModel
import unisanta.br.perfilmvvm.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.userProfile.observe(this) { profile ->
            profile?.let { userProfile ->
                binding.editTextEmail.setText(userProfile.email)
                binding.imageViewProfile.load(userProfile.imageUrl)

                binding.buttonEdit.setOnClickListener {
                    val email = binding.editTextEmail.text.toString()
                    userViewModel.editUserProfile(email, userProfile.imageUrl)
                    Toast.makeText(this, "Perfil atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}






