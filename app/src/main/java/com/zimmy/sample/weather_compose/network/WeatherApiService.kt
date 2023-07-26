package com.zimmy.sample.weather_compose.network

import com.zimmy.sample.weather_compose.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET(NetworkingConstants.GET_WEATHER)
    suspend fun getWeatherData(
        @Query("q") city: String
    ): WeatherModel?
}