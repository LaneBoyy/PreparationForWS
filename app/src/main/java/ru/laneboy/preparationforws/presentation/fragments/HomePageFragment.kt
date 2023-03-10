package ru.laneboy.preparationforws.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.data.BoxDbModel
import ru.laneboy.preparationforws.domain.BoxesRepository
import ru.laneboy.preparationforws.data.TypesOfBoxes
import ru.laneboy.preparationforws.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private val repository by lazy {
        BoxesRepository(requireActivity().application)
    }

    private var _binding: FragmentHomePageBinding? = null
    private val binding: FragmentHomePageBinding
        get() = _binding ?: throw RuntimeException("FragmentHomePageBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val boxItem = BoxDbModel(0, TypesOfBoxes.KITCHEN, 3)

        binding.btnAddRoom.setOnClickListener{
            launchAddRoomFragment()
            lifecycleScope.launch {
                repository.setBoxItem(boxItem)
            }
        }


        repository.getBoxesList().observe(viewLifecycleOwner) {
            Log.d("MainLog", it.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchAddRoomFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, AddRoomFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    companion object {

        fun newInstance() = HomePageFragment()
    }
}

