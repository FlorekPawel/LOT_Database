import java.sql.Time;
import java.util.*;

public class FlightDatabase {
    private final Map<Integer, Flight> flights = new HashMap<>();
    private final Set<Passenger> passengers = new HashSet<>();

    public void addFlight(int flightNumber, ArrayList<String> route, Date depDate, Time depTime, int placesLimit) {
        flights.put(flightNumber, new Flight(flightNumber, route, depDate, depTime, placesLimit));
    }

    public void addPassenger(String firstName, String lastName, int phoneNumber) {
        passengers.add(new Passenger(firstName, lastName, phoneNumber));
    }

    public void bookSeat(int flightNumber, Passenger p) {
        passengers.add(p);
        flights.get(flightNumber).addPassenger(p);
    }

    public void cancelBooking(int flightNumber, Passenger p) {
        flights.get(flightNumber).removePassenger(p);
    }

    public void cancelBooking(int flightNumber, String name, String surname) {
        flights.get(flightNumber).removePassenger(name, surname);
    }

    public void removeFlight(int flightNumber) {
        flights.remove(flightNumber);
    }

    public void removePassenger(String firstName, String surname) {
        passengers.removeIf(p -> p.getName().equals(firstName) && p.getSurname().equals(surname));
    }

    public void updatePassengerPhoneNumber(int flightNumber, Passenger p, int newPhoneNum) {
        flights.get(flightNumber).getPassenger(p).updatePhoneNumber(newPhoneNum);
    }

    public void updateFlightRoute(int flightNumber, ArrayList<String> newRoute){
        flights.get(flightNumber).updateRoute(newRoute);
    }

    public void updateDate(int flightNumber, Date newDate) {
        flights.get(flightNumber).updateDate(newDate);
    }

    public void updateTime(int flightNumber, Time newTime) {
        flights.get(flightNumber).updateTime(newTime);
    }

    public void updatePlacesLimit(int flightNumber, int newLimit) {
        flights.get(flightNumber).updateLimit(newLimit);
    }

    public void displayInfo(int flightNumber) {
        System.out.println(flights.get(flightNumber));
    }

    public void displayPassengers() {
        passengers.forEach(System.out::println);
    }

    public ArrayList<Flight> searchFlightDeparture(String dep) {
        ArrayList<Flight> flightsList = new ArrayList<>();
        for (Flight f: flights.values())
            if (f.getRoute().get(0).equals(dep)) {
                flightsList.add(f);
            }

        return flightsList;
    }

    public ArrayList<Flight> searchFlightArrival(String arr) {
        ArrayList<Flight> flightsList = new ArrayList<>();
        for (Flight f: flights.values())
            if (f.getRoute().get(1).equals(arr)) {
                flightsList.add(f);
            }

        return flightsList;
    }

    public ArrayList<Flight> searchFlightDate(Date date) {
        ArrayList<Flight> flightsList = new ArrayList<>();
        for (Flight f: flights.values())
            if (f.getDepartureDate().equals(date)) {
                flightsList.add(f);
            }

        return flightsList;
    }

    public ArrayList<Flight> searchFlightTime(Time time) {
        ArrayList<Flight> flightsList = new ArrayList<>();
        for (Flight f: flights.values())
            if (f.getDepartureTime().equals(time)) {
                flightsList.add(f);
            }

        return flightsList;
    }

    public ArrayList<Flight> searchFlightLimit(int limit) {
        ArrayList<Flight> flightsList = new ArrayList<>();
        for (Flight f: flights.values())
            if (f.getLimit() == limit) {
                flightsList.add(f);
            }

        return flightsList;
    }
}
