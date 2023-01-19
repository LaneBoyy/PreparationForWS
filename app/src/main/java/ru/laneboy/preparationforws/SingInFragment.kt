package ru.laneboy.preparationforws

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.laneboy.preparationforws.databinding.FragmentSingInBinding
import ru.laneboy.preparationforws.databinding.FragmentSplashScreenBinding

class SingInFragment : Fragment() {

    private var _binding: FragmentSingInBinding? = null
    private val binding: FragmentSingInBinding
        get() = _binding ?: throw RuntimeException("FragmentSingInBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): SingInFragment {
            return SingInFragment()
        }
    }
}