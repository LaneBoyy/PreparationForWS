package ru.laneboy.preparationforws.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding
        get() = _binding ?: throw RuntimeException("FragmentSignUpBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
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

    private fun onClickBtnNewResident() {
        binding.btnNewResidentSUp.setOnClickListener {
            launchSignInFragment()
        }
    }

    private fun launchSignInFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SignInFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun onClickBtnEnter() {
        binding.btnEnterSUp.setOnClickListener {
            val eMail = binding.etEmail.text.toString()
            val name = binding.etName.text.toString()
            val password = binding.etPassword.text.toString()
            if (eMail.isNotEmpty() && name.isNotEmpty() && password.isNotEmpty()) {
                launchMainScreenFragment()
            } else {
                Toast.makeText(
                    requireActivity(), getString(R.string.error_empty_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun launchMainScreenFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainScreenFragment.newInstance())
            .commit()
    }

    companion object {
        fun newInstance() = SignUpFragment()
    }
}