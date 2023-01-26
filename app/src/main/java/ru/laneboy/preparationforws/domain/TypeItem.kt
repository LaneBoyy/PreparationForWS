package ru.laneboy.preparationforws.domain

import ru.laneboy.preparationforws.data.TypesOfBoxes

data class TypeItem(
    val name: TypesOfBoxes,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        const val UNDEFINED_ID = -1
    }
}