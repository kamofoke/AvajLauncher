
//import Coordinates;
//import WeatherTower;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather = {"FOG", "RAIN", "SUN", "SNOW"};

    //methods
    private WeatherProvider(){
        weatherProvider = this;
    }

    public static WeatherProvider getProvider(){
        new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather (Coordinates coordinates){
        int counter = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return (weather[counter % 4]);
    }
    
}
