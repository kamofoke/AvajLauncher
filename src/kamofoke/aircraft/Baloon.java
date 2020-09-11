package kamofoke.aircraft;

import kamofoke.tower.WeatherTower;
import kamofoke.tower.WriteToFile;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setLongitude(100);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): This is a nice weather, lets enjoy and take pics");
                break;
            case "RAIN":
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): Damn this rain messed up my baloon");
                break;
            case "FOG":
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): OMG I can't see where we are going!");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): This snow will kill my Baloon, Ohh Lord:)");
                WriteToFile.getWriteToFile().writeFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " Unregistered from the weather tower.");
                break;
            default:
                WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + "): can't connect to the weather");
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
            WriteToFile.getWriteToFile().writeFile("Baloon#" + this.name + "(" + this.id + ") landing.");
        }
    }
    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToFile.getWriteToFile().writeFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " Registered to the weather tower.");
        weatherTower.register(this);
    }
}

