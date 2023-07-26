package com.zimmy.sample.weather_compose.usecase

import com.zimmy.sample.weather_compose.network.ResultData
import com.zimmy.sample.weather_compose.model.WeatherModel
import com.zimmy.sample.weather_compose.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend fun getWeatherData(city: String): Flow<ResultData<WeatherModel>> {
        return flow {
            emit(ResultData.Loading)

            val weatherModel = weatherRepository.getWeatherData(city)

            val resultData = if (weatherModel == null) {
                ResultData.Failed()
            } else {
                ResultData.Success(weatherModel)
            }

            emit(resultData)
        }.catch {
            emit(ResultData.Failed())
        }
    }
}