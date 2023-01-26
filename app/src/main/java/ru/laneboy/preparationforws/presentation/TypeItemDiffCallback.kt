package ru.laneboy.preparationforws.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.laneboy.preparationforws.domain.TypeItem

class TypeItemDiffCallback: DiffUtil.ItemCallback<TypeItem>() {

    override fun areItemsTheSame(oldItem: TypeItem, newItem: TypeItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TypeItem, newItem: TypeItem): Boolean {
        return oldItem == newItem
    }
}