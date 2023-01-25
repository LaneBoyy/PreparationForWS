package ru.laneboy.preparationforws.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding: FragmentSignInBinding
        get() = _binding ?: throw RuntimeException("FragmentSignInBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickBtnNewResident()
        onClickBtnEnter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchSignUpFragment() {
        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SignUpFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun launchMainScreenFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainScreenFragment.newInstance())
            .commit()
    }

    private fun onClickBtnEnter() {
        binding.btnEnterSIn.setOnClickListener {
            val eMail = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if (eMail == "q" && password == "1") {
                launchMainScreenFragment()
            } else {
                Toast.makeText(
                    requireActivity(), getString(R.string.error_invalid_login_or_password),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun onClickBtnNewResident() {
        binding.btnNewResidentSIn.setOnClickListener {
            launchSignUpFragment()
        }
    }

    companion object {

        fun newInstance(): SignInFragment {
            return SignInFragment()
        }

    }
}