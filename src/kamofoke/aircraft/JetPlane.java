package kamofoke.aircraft;
import kamofoke.tower.*;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): Wow sunshine, nice weather!");
                break;
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): Did u just have to rain this bad!");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): One of my favourite weather yey!!");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): Damn it's cold hey");
                break;
            default:
                WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + "): Can't connect to the weather");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            WriteToFile.getWriteToFile().writeFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
            WriteToFile.getWriteToFile().writeFile("Tower  says: JetPlane#" + this.name + "(" + this.id + ")" + "Unreistered from the weather tower.");
        }
    }

    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToFile.getWriteToFile().writeFile("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + "Registered to the tower.");
        this.weatherTower.register(this);
    }
}


