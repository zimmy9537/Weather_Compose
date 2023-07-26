package com.zimmy.sample.weather_compose.model

data class WeatherModel(
    val alerts: Alerts,
    val current: Current,
    val forecast: Forecast,
    val location: Location
)