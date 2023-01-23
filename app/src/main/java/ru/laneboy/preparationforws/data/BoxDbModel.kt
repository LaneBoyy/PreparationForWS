package ru.laneboy.preparationforws.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boxes_table")
data class BoxDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val typeOfBox: TypesOfBoxes,
    val devisesCount: Int,
)