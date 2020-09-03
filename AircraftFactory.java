

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        String str = type.toLowerCase();
        if(str.equals("helicopter"))
        {
            return new Helicopter(name, coordinates);
        }
        else if(str.equals("jetPlane"))
        {
            return new JetPlane(name, coordinates);
        }
        else if(str.equals("baloon"))
        {
            return new Baloon(name, coordinates);
        }
        else
        {
            System.out.println("Unknown Type: " + type);
            return null;
        }

    }
}

