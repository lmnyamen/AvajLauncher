package Weather;

import java.util.Random;

public class WeatherProvider {
    private static String[] weather;
    private static WeatherProvider weatherProvider;

    private WeatherProvider() {
        this.weather = new String[]{"FOG", "SUN", "RAIN", "SNOW"};
    }


    public static WeatherProvider getProvider() {
        if (WeatherProvider.weatherProvider == null) {
            WeatherProvider.weatherProvider = new WeatherProvider();
        }
        return WeatherProvider.weatherProvider;
    }

    public  String getCurrentWeather(Coordinates coordinates){
        Random ran = new Random();
        int n = ran.nextInt(4);
        return weather[n];
    }


}