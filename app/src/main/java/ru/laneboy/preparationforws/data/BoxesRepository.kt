package ru.laneboy.preparationforws.data

import android.app.Application
import androidx.lifecycle.LiveData

class BoxesRepository(
    private val application: Application
) {
    private val boxesDao = AppDatabase.getInstance(application).boxesDao()

    fun getBoxesList() : LiveData<List<BoxDbModel>>{
        return boxesDao.getBoxesList()
    }

    suspend fun setBoxItem(item: BoxDbModel) {
        boxesDao.setBoxDbItem(item)
    }
}