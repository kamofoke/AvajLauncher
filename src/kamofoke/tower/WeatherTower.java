package kamofoke.tower;

import kamofoke.aircraft.*;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}

