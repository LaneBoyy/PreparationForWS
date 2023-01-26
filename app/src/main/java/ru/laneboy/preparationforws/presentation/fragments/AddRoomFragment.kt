package ru.laneboy.preparationforws.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import ru.laneboy.preparationforws.data.TypesOfBoxes
import ru.laneboy.preparationforws.databinding.FragmentAddRoomBinding
import ru.laneboy.preparationforws.domain.TypeItem
import ru.laneboy.preparationforws.presentation.TypeListAdapter

class AddRoomFragment : Fragment() {

    private var autoIncrementId = 0

    private val typeListLD = MutableLiveData<List<TypeItem>>()
    private val typeList = sortedSetOf<TypeItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private lateinit var typeListAdapter: TypeListAdapter

    private var _binding: FragmentAddRoomBinding? = null
    private val binding: FragmentAddRoomBinding
        get() = _binding ?: throw RuntimeException("FragmentAddRoomBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTypesList.layoutManager = GridLayoutManager(requireActivity(), 3)
        setupRecyclerView()
        typeListAdapter.submitList(typeList.toMutableList())
        onArrowBackClick()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        with(binding.rvTypesList) {
            typeListAdapter = TypeListAdapter()
            adapter = typeListAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        typeListAdapter.onTypeItemClickListener
    }

    private fun updateList() {
        typeListLD.value = typeList.toList()
    }

    private fun onArrowBackClick() {
        binding.btnArrowBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    init {
        val itemKitchen = TypeItem(TypesOfBoxes.KITCHEN)
        val itemBedroom = TypeItem(TypesOfBoxes.BEDROOM)
        val itemBathroom = TypeItem(TypesOfBoxes.BATHROOM)
        val itemOffice = TypeItem(TypesOfBoxes.OFFICE)
        val itemTVRoom = TypeItem(TypesOfBoxes.TV_ROOM)
        val itemLivingRoom = TypeItem(TypesOfBoxes.LIVING_ROOM)
        val itemGarage = TypeItem(TypesOfBoxes.GARAGE)
        val itemToilet = TypeItem(TypesOfBoxes.TOILET)
        val itemKidRoom = TypeItem(TypesOfBoxes.KID_ROOM)

        addTypeItem(itemKitchen)
        addTypeItem(itemBedroom)
        addTypeItem(itemBathroom)
        addTypeItem(itemOffice)
        addTypeItem(itemTVRoom)
        addTypeItem(itemLivingRoom)
        addTypeItem(itemGarage)
        addTypeItem(itemToilet)
        addTypeItem(itemKidRoom)

    }

    private fun addTypeItem(typeItem: TypeItem) {
        if (typeItem.id == TypeItem.UNDEFINED_ID) {
            typeItem.id = autoIncrementId++
        }
        typeList.add(typeItem)
        updateList()
    }

    companion object {

        fun newInstance() = AddRoomFragment()
    }
}