package com.tuf2000m.energymeter.views.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tuf2000m.energymeter.R
import com.tuf2000m.energymeter.data.model.auth.UserProfile
import com.tuf2000m.energymeter.data.model.auth.AuthResult
import com.tuf2000m.energymeter.databinding.FragmentAuthBinding
import com.tuf2000m.energymeter.utils.SharedPreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : Fragment() {


    // Inject ViewModel
    private val viewModel: AuthViewModel by viewModels()

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private var isLogin = true

    @Inject
    lateinit var sharedPreferences: SharedPreferenceManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                binding.buttonLogin.visibility = View.INVISIBLE
                binding.pb.visibility = View.VISIBLE

                val authLiveData = if (isLogin) {
                    viewModel.signIn(email, password)
                } else {
                    viewModel.createAccount(email, password)
                }

                authLiveData.observe(viewLifecycleOwner) { authResult ->
                    // Handle authentication result
                    when (authResult) {
                        is AuthResult.Success -> {
                            sharedPreferences.saveUSer(
                                UserProfile(
                                    authResult.user?.email,
                                    authResult.user?.displayName
                                )
                            )
                            navigateToHome()
                        }

                        is AuthResult.Failure -> {
                            showHideViews()
                            Toast.makeText(
                                requireContext(),
                                authResult.exception?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }

        binding.tvSignup.setOnClickListener {
            viewModel.toggleLoginSignupMode()
        }

        viewModel.isLoginMode.observe(viewLifecycleOwner) { isSigning ->
            isLogin = isSigning
            setLoginSignupView(isSigning)
        }
    }

    private fun showHideViews() {
        binding.buttonLogin.visibility = View.VISIBLE
        binding.pb.visibility = View.GONE
    }

    private fun navigateToHome() {
        findNavController().navigate(R.id.action_authFragment_to_homeFragment)
        binding.editTextEmail.text.clear()
        binding.editTextPassword.text.clear()
    }

    private fun setLoginSignupView(isSigning: Boolean) {
        if (isSigning) {
            binding.buttonLogin.text = getString(R.string.login)
            binding.tvSignup.text = getString(R.string.dha)
        } else {
            binding.buttonLogin.text = getString(R.string.signup)
            binding.tvSignup.text = getString(R.string.btl)
        }
    }

    override fun onResume() {
        super.onResume()
        validateUser()
    }

    private fun validateUser() {
        if (sharedPreferences.getUser() != null)
            navigateToHome()
    }
}