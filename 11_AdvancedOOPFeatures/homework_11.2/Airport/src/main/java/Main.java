import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        for (Flight f : findPlanesLeavingInTheNextTwoHours(airport)) {
            System.out.println(f);
        }

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime now = LocalDateTime.now();
        Stream<com.skillbox.airport.Terminal> terminalStream = airport.getTerminals().stream();

        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        return terminalStream.flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> Math.abs(now.until(getLocalDateTime(flight.getDate()), ChronoUnit.HOURS)) < 2 && flight.getType() == DEPARTURE)
                .collect(Collectors.toList());

    }

    public static LocalDateTime getLocalDateTime(Date date) {
        LocalDateTime localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDate;
    }

}