
//import WeatherProvider;
//import Coordinates;

public class WeatherTower extends Tower {

    WeatherTower weatherTower = new WeatherTower();

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }   
}
