package ru.laneboy.preparationforws.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding: FragmentMainScreenBinding
        get() = _binding ?: throw RuntimeException("FragmentMainScreenBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBottomNavigation()
    }

    private fun setFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, fragment)
            .commit()
    }

    private fun setBottomNavigation() {
        setFragment(HomePageFragment.newInstance())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeButton -> {
                    setFragment(HomePageFragment.newInstance())
                }
                R.id.staticsButton -> {
                    setFragment(StaticsFragment.newInstance())
                }
                R.id.routinesButton -> {
                    setFragment(RoutinesFragment.newInstance())
                }
                R.id.settingButton -> {
                    setFragment(SettingFragment.newInstance())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = MainScreenFragment()
    }
}