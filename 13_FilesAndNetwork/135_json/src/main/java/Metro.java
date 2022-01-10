import java.util.*;

public class Metro {

    private final Map<String, Line> number2line;
    private final HashSet<Station> stations;
    private final Map<Station, TreeSet<Station>> connections;

    public Metro() {
        number2line = new HashMap<>();
        stations = new HashSet<>();
        connections = new TreeMap<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addLine(Line line) {
        number2line.put(line.getNumber(), line);
    }

    public Line getLine(String number) {
        return number2line.get(number);
    }

    public Station getStation(String name) {
        for (Station station : stations) {
            if (station.getName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    }

    public Station getStation(String name, String lineNumber) {

        return new Station(name, getLine(lineNumber));
    }

}
