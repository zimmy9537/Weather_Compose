package com.zimmy.sample.weather_compose.viewmodel

import androidx.lifecycle.ViewModel
import com.zimmy.sample.weather_compose.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val useCase: WeatherUseCase) : ViewModel() {

}