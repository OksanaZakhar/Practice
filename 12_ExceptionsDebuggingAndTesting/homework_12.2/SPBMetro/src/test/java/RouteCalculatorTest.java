import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Line line3 = new Line(3, "Third");

        Station A1 = new Station("A1", line1);
        Station B1 = new Station("B1", line1);
        Station C1 = new Station("C1", line1);
        Station D1 = new Station("D1", line1);
        Station A2 = new Station("A2", line2);
        Station B2 = new Station("B2", line2);
        Station A3 = new Station("A3", line3);
        Station B3 = new Station("B3", line3);

        line1.addStation(A1);
        line1.addStation(B1);
        line1.addStation(C1);
        line1.addStation(D1);
        line2.addStation(A2);
        line2.addStation(B2);
        line3.addStation(A3);
        line3.addStation(B3);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(A1);
        stationIndex.addStation(B1);
        stationIndex.addStation(C1);
        stationIndex.addStation(D1);
        stationIndex.addStation(A2);
        stationIndex.addStation(B2);
        stationIndex.addStation(A3);
        stationIndex.addStation(B3);

        List<Station> conect1 = List.of(B1, A2);
        List<Station> conect2 = List.of(C1, A3);
        stationIndex.addConnection(conect1);
        stationIndex.addConnection(conect2);


        route.add(A1);
        route.add(B1);
        route.add(C1);
        route.add(D1);
        route.add(A2);
        route.add(B2);
        route.add(A3);
        route.add(B3);

    }

    public void testCalculateDuration() {
        double actual = routeCalculator.calculateDuration(route);
        double expected = 19.5;
        assertEquals(expected, actual);
    }


    public void testGetShortestRouteOneLine() {
        List<Station> routeExpected = new ArrayList<>();
        List<Station> routeActual = new ArrayList<>();
        routeActual = routeCalculator.getShortestRoute(route.get(1), route.get(3));
        for (int i = 1; i <= 3; i++) {
            routeExpected.add(route.get(i));
        }
        assertEquals(routeExpected, routeActual);

    }

    public void testGetShortestRouteTwoLine() {
        List<Station> routeExpected2 = new ArrayList<>();
        List<Station> routeActual2 = new ArrayList<>();
        routeActual2 = routeCalculator.getShortestRoute(route.get(0), route.get(5));
        routeExpected2.add(route.get(0));
        routeExpected2.add(route.get(1));
        routeExpected2.add(route.get(4));
        routeExpected2.add(route.get(5));

        assertEquals(routeExpected2, routeActual2);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
