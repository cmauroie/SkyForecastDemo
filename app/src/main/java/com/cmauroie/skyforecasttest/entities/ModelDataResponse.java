package com.cmauroie.skyforecasttest.entities;

/**
 * Created by Mauricio on 12/1/18.
 */

public class ModelDataResponse {
    public String latitude;
    public String longitude;
    public String timezone;
    public String offset;
    public Currently currently;
    public Daily daily;


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

    /*
        "currently": {
        "time": 1515798207,
        "summary": "Parcialmente Nublado",
        "icon": "partly-cloudy-day",
        "nearestStormDistance": 81,
        "nearestStormBearing": 266,
        "precipIntensity": 0,
        "precipProbability": 0,
        "temperature": 54.77,
        "apparentTemperature": 54.77,
        "dewPoint": 51.12,
        "humidity": 0.87,
        "pressure": 1026.13,
        "windSpeed": 2.97,
        "windGust": 6.87,
        "windBearing": 352,
        "cloudCover": 0.31,
        "uvIndex": 1,
        "visibility": 7.81,
        "ozone": 301.42
    }
    * */

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
