package Crafts;

import Weather.Coordinates;
import Weather.Flyable;

//import Weather.Flyable;
public abstract class AircraftFactory {


    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
         if(longitude < 0 || latitude < 0 ){
             System.out.println("incorrect aircraft parameters");
         }
         if(type.equals("Baloon")){
             return new Baloon(name, coordinates);
         }
         else if(type.equals("Helicopter")){
             return new Helicopter(name, coordinates);
         }
         else if(type.equals("JetPlane")){
             return new JetPlane(name, coordinates);
         }
         else if((!type.equals("Baloon")) || (!type.equals("Helicopter")) || (!type.equals("JetPlane"))){
             System.out.println("incorrect aircraft type");
         }
        return null;
    }


}
