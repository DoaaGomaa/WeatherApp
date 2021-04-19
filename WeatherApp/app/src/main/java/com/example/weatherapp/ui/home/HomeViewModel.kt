package com.example.weatherapp.ui.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.repo.WeatherRepository
import java.text.SimpleDateFormat
import java.util.*


class HomeViewModel (application: Application) : AndroidViewModel(application) {
        val apiObj= MutableLiveData<WeatherResponse>();
        var apiRepository:WeatherRepository

        init{
            apiRepository = WeatherRepository(application)
        }

        public fun getApiObjFromRoom(timeZone:String): WeatherResponse{
            return apiRepository.getApiObjFromRoom(timeZone)
        }


        public fun loadWeatherObj(context: Context, lat:Double, lon:Double, lang:String, unit:String) : LiveData<WeatherResponse> {
            apiRepository.fetchWeatherObj(context,lat,lon,lang,unit)
            return apiRepository.weatherObj
        }

        public fun updateAllData(context: Context, lang: String, unit: String){
            apiRepository.UpdateWeatherData(lang,unit,context)

        }

        fun dateFormat(milliSeconds: Int):String{
            // Create a calendar object that will convert the date and time value in milliseconds to date.
            val calendar: Calendar = Calendar.getInstance()
            calendar.setTimeInMillis(milliSeconds.toLong() * 1000)
            var month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            var day=calendar.get(Calendar.DAY_OF_MONTH).toString()
            var year=calendar.get(Calendar.YEAR).toString()
            return day+"/"+month// +"/"+year

        }

        fun timeFormat(millisSeconds:Int ): String {
            val calendar = Calendar.getInstance()
            calendar.setTimeInMillis((millisSeconds * 1000).toLong())
            val format = SimpleDateFormat("hh:00 aaa")
            return format.format(calendar.time)
        }


    }


