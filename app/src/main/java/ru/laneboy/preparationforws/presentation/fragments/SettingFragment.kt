package ru.laneboy.preparationforws.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding: FragmentSettingBinding
        get() = _binding ?: throw RuntimeException("FragmentSettingBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickBtnSignOut()
    }

    private fun onClickBtnSignOut() {
        binding.btnSignOut.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SignInFragment.newInstance())
                .commit()
        }
    }


    companion object {
        fun newInstance() = SettingFragment()
    }
}