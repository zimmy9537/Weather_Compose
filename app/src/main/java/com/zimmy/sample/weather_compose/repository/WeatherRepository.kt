package com.zimmy.sample.weather_compose.repository

import com.zimmy.sample.weather_compose.model.WeatherModel
import com.zimmy.sample.weather_compose.network.WeatherApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApiService: WeatherApiService) {
    suspend fun getWeatherData(city:String): WeatherModel? {
        return weatherApiService.getWeatherData(city)
    }
}