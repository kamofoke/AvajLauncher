package kamofoke.aircraft;

import kamofoke.tower.*;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

    // public Coordinates getCoordinates();
}
