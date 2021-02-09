package com.example.classactivity3;

public class WeatherData {
    // instance variables
    // private String date;
    private String time;
    private String weatherDescription;
    private String temp;

    // constructor
    public WeatherData(String time, String weatherDescription, String temp) {
        // this.date = date;
        this.time = time;
        this.weatherDescription = weatherDescription;
        this.temp = temp;
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

}
