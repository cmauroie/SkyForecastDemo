package com.cmauroie.skyforecasttest.entities;

import java.util.List;

/**
 * Created by Mauricio on 12/1/18.
 */

public class Daily {

    public String summary;
    public String icon;
    public List<DataDay> data;
}

/*
        "daily": {
        "summary": "Lluvia ligera el Lunes hasta Jueves, con temperaturas alcanzando un máximo de 62°F el Domingo.",
        "icon": "rain",
        "data": [
            {
                "time": 1515744000,
                "summary": "Mayormente nublado durante el día.",
                "icon": "partly-cloudy-day",
                "sunriseTime": 1515770760,
                "sunsetTime": 1515805938,
                "moonPhase": 0.87,
                "precipIntensity": 0.0001,
                "precipIntensityMax": 0.001,
                "precipIntensityMaxTime": 1515772800,
                "precipProbability": 0.24,
                "precipType": "rain",
                "temperatureHigh": 57,
                "temperatureHighTime": 1515805200,
                "temperatureLow": 49.1,
                "temperatureLowTime": 1515855600,
                "apparentTemperatureHigh": 57,
                "apparentTemperatureHighTime": 1515805200,
                "apparentTemperatureLow": 46.13,
                "apparentTemperatureLowTime": 1515855600,
                "dewPoint": 49.89,
                "humidity": 0.92,
                "pressure": 1027.1,
                "windSpeed": 2.63,
                "windGust": 8.06,
                "windGustTime": 1515780000,
                "windBearing": 353,
                "cloudCover": 0.65,
                "uvIndex": 2,
                "uvIndexTime": 1515787200,
                "visibility": 8.29,
                "ozone": 300.04,
                "temperatureMin": 49.15,
                "temperatureMinTime": 1515772800,
                "temperatureMax": 57,
                "temperatureMaxTime": 1515805200,
                "apparentTemperatureMin": 48.5,
                "apparentTemperatureMinTime": 1515780000,
                "apparentTemperatureMax": 57,
                "apparentTemperatureMaxTime": 1515805200
            },

    * */
