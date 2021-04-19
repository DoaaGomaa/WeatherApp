package com.example.weatherapp.ui.alerts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.local.entities.AlertsEntity
import com.example.weatherapp.repo.WeatherRepository
import com.example.weatherforcast.data.roomdb.LocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlertsViewModel(application: Application): AndroidViewModel(application) {
    var repo : WeatherRepository
    init {
        repo = WeatherRepository(application)
    }
    fun deleteAlarmObjectById(id:Int){
        CoroutineScope(Dispatchers.IO).launch {
            repo.deleteAlarmObj(id)
        }
    }
    suspend fun insertAlarm(alertsEntity: AlertsEntity):Long{
        return repo.insertAlarm(alertsEntity)
    }
    fun getAlertsList():LiveData<List<AlertsEntity>>{
        return repo.getAllAlarmObj()
    }

}