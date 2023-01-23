package ru.laneboy.preparationforws.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BoxesDao {

    @Query("SELECT * FROM boxes_table ORDER BY id")
    fun getBoxesList() : LiveData<List<BoxDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setBoxDbItem(item: BoxDbModel)

}