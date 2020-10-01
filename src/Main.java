
import Weather.Flyable;
import Weather.WeatherTower;
import Crafts.AircraftFactory;
import Crafts.LogMessage;
import javax.imageio.IIOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;


public class Main {
    public static void main(String[] args) {
        //System.out.println("hello");
        WeatherTower tower = new WeatherTower();
        Flyable flyable;
        try {
            File file = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String Readline = reader.readLine();
            int cycle = Integer.parseInt(Readline);
            //System.out.println(cycle);
            while((Readline = reader.readLine()) != null)
            {
                String[] holder;
                holder = Readline.split(" ");
                int longt = Integer.parseInt(holder[2]);
                int lat = Integer.parseInt(holder[3]);
                int height = Integer.parseInt(holder[4]);
                //System.out.println(longt);
                flyable = AircraftFactory.newAircraft(holder[0],holder[1],longt, lat, height);
                flyable.registerTower(tower);
            }
            reader.close();

            for( int count = 0; count <= cycle; count++){
                tower.changeWeather();
            }
            LogMessage.printInTxt();

        }
        catch (IIOException | FileNotFoundException e){
            System.out.println(e);
        }
        catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e){
            System.out.print("Invalid input");

        }
       catch (Exception e)
       {
           System.out.println(e);
       }
    }
}
