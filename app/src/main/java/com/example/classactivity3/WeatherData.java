package com.example.classactivity3;

public class WeatherData {
    // instance variables
    private String time;
    private String weatherDescription;
    private String feelsLike;

    // constructor
    public WeatherData(String time, String weatherDescription, String feelsLike) {
        this.time = time;
        this.weatherDescription = weatherDescription;
        this.feelsLike = feelsLike;
    }

    // getters and setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }
}
