package Crafts;

import Weather.Coordinates;
import Weather.WeatherTower;
import Weather.Flyable;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

    /**
     * This method will update the weather conditions of the sim.
     */

    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, "its beautiful out here"));
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
        else if (weather.equals("RAIN"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, "It's getting a little wet in here!"));
            coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        }
        else if (weather.equals("FOG"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, "Tower!! I can't see the helipad"));
            coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        }
        else if (weather.equals("SNOW"))
        {
            LogMessage.addString(LogMessage.formatStringHelicopter(this, "I see smoke from my rotor, I think it froze"));
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        }
        if (coordinates.getHeight() == 0)
        {
            LogMessage.addString(LogMessage.formatStringTowerHelicopter(this, "unregistered from weather tower."));
            weatherTower.unregister(this);
        }

    }

    /**
     * This method will register a flyable to the weather to
     * @param weatherTower - flyable(Helicopter) to the weather tower
     */

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        LogMessage.addString(LogMessage.formatStringTowerHelicopter(this, "registered to weather."));
    }
}
