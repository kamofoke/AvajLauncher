
//import WeatherProvider;
//import Coordinates;

public class WeatherTower {

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }   
}
