package ru.laneboy.preparationforws.presentation

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
import ru.laneboy.preparationforws.data.BoxesRepository
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
            lifecycleScope.launch {
                repository.setBoxItem(boxItem)
            }
        }


        repository.getBoxesList().observe(viewLifecycleOwner) {
            Log.d("MainLogSuka", it.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    companion object {

        fun newInstance() = HomePageFragment()
    }
}

