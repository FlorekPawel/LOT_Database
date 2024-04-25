import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
    private final int flightNr;
    private List<String> route;
    private Date departureDate;
    private Time departureTime;
    private int limit;
    private int availablePlaces = limit;
    private final List<Passenger> passengers = new ArrayList<>();

    public Flight(int flightNr, ArrayList<String> route, Date departureDate, Time departureTime, int placesLimit) {
        this.flightNr = flightNr;
        this.route = route;
        this.departureDate = departureDate;
        this.departureTime = departureTime;

        if (placesLimit <= 0) {
           throw (new IllegalArgumentException());
        } else{
            this.limit = placesLimit;
        }

    }

    public void addPassenger(Passenger p) {
        if (availablePlaces != 0) {
            availablePlaces--;
            passengers.add(p);
        } else {
            System.out.println("No places available");
        }
    }

    public void removePassenger(Passenger p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
            availablePlaces++;
        } else {
            System.out.println("No given passenger on the flight");
        }
    }

    public void removePassenger(String name, String surname) {
        passengers.removeIf(p -> p.getName().equals(name) && p.getSurname().equals(surname));

    }

    public void updateRoute(ArrayList<String> newRoute) {
        this.route = newRoute;
    }

    public void updateDate(Date newDate) {
        this.departureDate = newDate;
    }

    public void updateTime(Time newTime) {
        this.departureTime = newTime;
    }

    public void updateLimit(int newLimit) {
        if (newLimit <= 0) {
            throw (new IllegalArgumentException());
        } else{
            this.limit = newLimit;
        }
    }

    @Override
    public String toString() {
        return "Flight nr: " + flightNr +
                " from: " + route.get(0) + " to: " + route.get(1) +
                ", departure: " + departureDate.getDay() +"." + departureDate.getMonth() + "." + departureDate.getYear() + ", " + departureTime +
                ", passengers count: " + (limit - availablePlaces);
    }

    public int getFlightNr() {
        return flightNr;
    }

    public List<String> getRoute() {
        return route;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public int getLimit() {
        return limit;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public Passenger getPassenger(Passenger p) {
        for (Passenger passenger : passengers) {
            if (passenger.equals(p)) {
                return passenger;
            }
        }
        return null;
    }

    public Passenger getPassenger(String name, String surname) {
        for (Passenger p: passengers) {
            if (p.getName().equals(name) && p.getSurname().equals(surname)) {
                return p;
            }
        }
        return null;
    }
}
