package za.co.app.bitrisebuddy.ui.login

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import za.co.app.bitrisebuddy.databinding.LayoutLoginBinding
import za.co.app.bitrisebuddy.ui.landing.LandingActivity

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var personalAccessToken: String
    lateinit var binding: LayoutLoginBinding
    val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.viewState.observe(this, { viewState ->
            when (viewState) {
                is LoginViewState.Loading -> {
                    Log.d("Login", "Loading")
                }
                is LoginViewState.AuthenticationError -> {
                    Log.d("Login", "Auth error")
                }
                is LoginViewState.UserAuthenticated -> {
                    Log.d("Login", "success ${viewState.v0UserProfileDataModel}")
                    startActivity(LandingActivity.getStartIntent(this@LoginActivity, arrayListOf()))
                }
                is LoginViewState.Error -> {
                    Log.d("Login", "Error ${viewState.errorMessage}")
                }
            }
        })

        binding.buttonLogin.setOnClickListener {
            personalAccessToken = binding.textAccessToken.text.toString()
            viewModel.authenticateUser("7kLgOIbXssyw2T_PrfV41uaZDfnrhhVONjxRqTyfNmThZr8kdxPhe4-pc6RD9fBPwJGe_v_1pmW6y28QiAgT0w")
        }
    }
}
