package ru.laneboy.preparationforws.domain

import android.app.Application
import androidx.lifecycle.LiveData
import ru.laneboy.preparationforws.data.AppDatabase
import ru.laneboy.preparationforws.data.BoxDbModel

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