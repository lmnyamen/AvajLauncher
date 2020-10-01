package Crafts;

import Weather.Coordinates;
import Weather.Flyable;
import Weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates){
        super(name,coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        if(weather.equals("SUN")){
            LogMessage.addString(LogMessage.formatStringBaloon(this, "This is some nice weather we are having. Nice clear blue skies and nice views all over"));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
        }
        else if (weather.equals("RAIN"))
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "who doesn't like a bit of rain!"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        }
        else if (weather.equals("FOG"))
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "Balloon to WeatherTower, its looking foggy."));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);

        }
        else if (weather.equals("SNOW"))
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "Balloon going down at a rapid pace"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        }

        if (coordinates.getHeight() <= 0)
        {
            LogMessage.addString(LogMessage.formatStringBaloon(this, "its a crash landing brace yourself! MAYDAY!MAYDAY!"));
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogMessage.addString(LogMessage.formatStringTowerBaloon(this, "registered to weather."));
    }
}
