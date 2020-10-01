package Crafts;

import Weather.Coordinates;
import Weather.WeatherTower;
import Weather.Flyable;

public class JetPlane  extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates)
    {
        super(name,coordinates);

    }

    /**
     * This will request the weather from the weatherTower and based on the
     * conditions, it will modify the coordinates
     * If the height of the flyable is 0 (meaning the flight has landed)
     * it will unregister it from the weatherTower
     */


    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "This is some nice weather we are having."));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
        else if (weatherTower.equals("RAIN"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "This weather is taking a turn for the worst!"));
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        }
        else if (weatherTower.equals("FOG"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "JetPlane to WeatherTower, we can't see a thing over here!"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());

        }
        else if (weatherTower.equals("SNOW"))
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "Command, the snow is a beau"));
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        }

        if (coordinates.getHeight() <= 0)
        {
            LogMessage.addString(LogMessage.formatStringJetPlane(this, "is crash landing brace yourself! MAYDAY!MAYDAY!"));
            weatherTower.unregister(this);
        }

    }


    /**
     * This with register this flyable(JetPlane) to the weather tower and log the message to a log file
     * @param weatherTower - registers this flyable(JetPlane) to the weather tower
     */

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        LogMessage.addString(LogMessage.formatStringTowerJetPlane(this, "registered to weather."));
    }
}