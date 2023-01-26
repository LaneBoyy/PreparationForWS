package ru.laneboy.preparationforws.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import ru.laneboy.preparationforws.R
import ru.laneboy.preparationforws.domain.TypeItem
import ru.laneboy.preparationforws.data.TypesOfBoxes

class TypeListAdapter : ListAdapter<TypeItem, TypeItemViewHolder>(TypeItemDiffCallback()) {

    var onTypeItemClickListener: ((TypeItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeItemViewHolder {
        val layout = R.layout.box_item_type_disable
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return TypeItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TypeItemViewHolder, position: Int) {
        val typeItem = getItem(position)
        with(holder) {
            tvTypesName.text = typeItem.name.toString()
            when (typeItem.name) {
                TypesOfBoxes.KITCHEN -> ivTypeImage.setImageResource(R.drawable.ic_kitchen)
                TypesOfBoxes.KID_ROOM -> ivTypeImage.setImageResource(R.drawable.ic_kid_room)
                TypesOfBoxes.BATHROOM -> ivTypeImage.setImageResource(R.drawable.ic_bathroom)
                TypesOfBoxes.BEDROOM -> ivTypeImage.setImageResource(R.drawable.ic_bedroom)
                TypesOfBoxes.GARAGE -> ivTypeImage.setImageResource(R.drawable.ic_garage)
                TypesOfBoxes.LIVING_ROOM -> ivTypeImage.setImageResource(R.drawable.ic_living_room)
                TypesOfBoxes.OFFICE -> ivTypeImage.setImageResource(R.drawable.ic_office)
                TypesOfBoxes.TOILET -> ivTypeImage.setImageResource(R.drawable.ic_toilet)
                TypesOfBoxes.TV_ROOM -> ivTypeImage.setImageResource(R.drawable.ic_tv_room)
            }
            view.setOnClickListener {
                onTypeItemClickListener?.invoke(typeItem)

            }
        }
    }
}