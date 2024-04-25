import java.sql.Time;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        FlightDatabase flightDatabase = new FlightDatabase();

        // Dodanie lotów
        flightDatabase.addFlight(1, new ArrayList<>(List.of("Warszawa", "Nowy Jork")), new Date(), new Time(10, 0, 0), 200);
        flightDatabase.addFlight(2, new ArrayList<>(List.of("Londyn", "Paryż")), new Date(), new Time(12, 0, 0), 150);
        flightDatabase.addFlight(3, new ArrayList<>(List.of("Paryż", "Tokio")), new Date(), new Time(15, 0, 0), 300);

        // Dodanie pasażerów
        flightDatabase.addPassenger("John", "Doe", 123456789);
        flightDatabase.addPassenger("Alice", "Smith", 987654321);

        // Rezerwacja miejsc na lotach
        flightDatabase.bookSeat(1, new Passenger("John", "Doe", 123456789));
        flightDatabase.bookSeat(1, new Passenger("Alice", "Smith", 987654321));

        // Testowanie wszystkich funkcji

        // Test dodawania lotu
        System.out.println("Lista lotów po dodaniu:");
        flightDatabase.displayInfo(1);
        flightDatabase.displayInfo(2);
        flightDatabase.displayInfo(3);

        // Test usuwania lotu
        System.out.println("Usuwanie lotu o numerze 1:");
        flightDatabase.removeFlight(1);
        flightDatabase.displayInfo(1); // Powinien zwrócić null

        // Test dodawania pasażera
        System.out.println("Lista pasażerów po dodaniu:");
        flightDatabase.displayPassengers();

        // Test usuwania pasażera
        System.out.println("Usuwanie pasażera Johna Doe:");
        flightDatabase.removePassenger("John", "Doe");
        flightDatabase.displayPassengers(); // Pasażer John Doe powinien zniknąć

        // Test aktualizacji trasy lotu
        System.out.println("Aktualizacja trasy lotu o numerze 2:");
        flightDatabase.updateFlightRoute(2, new ArrayList<>(List.of("Londyn", "Berlin")));
        flightDatabase.displayInfo(2);

        // Test aktualizacji daty
        System.out.println("Aktualizacja daty lotu o numerze 2:");
        flightDatabase.updateDate(2, new Date(2024, 5, 10)); // Uwaga: Konstruktor Date(int, int, int) jest przestarzały
        flightDatabase.displayInfo(2);

        // Test aktualizacji godziny
        System.out.println("Aktualizacja godziny lotu o numerze 2:");
        flightDatabase.updateTime(2, new Time(14, 0, 0));
        flightDatabase.displayInfo(2);

        // Test aktualizacji limitu miejsc
        System.out.println("Aktualizacja limitu miejsc lotu o numerze 2:");
        flightDatabase.updatePlacesLimit(2, 200);
        flightDatabase.displayInfo(2);


        // Test rezerwacji i anulowania rezerwacji
        System.out.println("Anulowanie rezerwacji na locie o numerze 2 dla pasażera Alice Smith:");
        flightDatabase.cancelBooking(2, "Alice", "Smith");
        flightDatabase.displayInfo(2);

        // Test wyszukiwania lotów
        System.out.println("Wyszukiwanie lotów z Londynu:");
        ArrayList<Flight> flightsFromLondon = flightDatabase.searchFlightDeparture("Londyn");
        for (Flight flight : flightsFromLondon) {
            System.out.println(flight);
        }

        System.out.println("Wyszukiwanie lotów do Tokio:");
        ArrayList<Flight> flightsToTokyo = flightDatabase.searchFlightArrival("Tokio");
        for (Flight flight : flightsToTokyo) {
            System.out.println(flight);
        }

        // Test wyszukiwania lotów po dacie
        System.out.println("Wyszukiwanie lotów na 10 maja 2024 roku:");
        ArrayList<Flight> flightsOnDate = flightDatabase.searchFlightDate(new Date(2024, 5, 10)); // Uwaga: Konstruktor Date(int, int, int) jest przestarzały
        for (Flight flight : flightsOnDate) {
            System.out.println(flight);
        }

        // Test wyszukiwania lotów po godzinie
        System.out.println("Wyszukiwanie lotów o godzinie 14:00:");
        ArrayList<Flight> flightsAtTime = flightDatabase.searchFlightTime(new Time(14, 0, 0));
        for (Flight flight : flightsAtTime) {
            System.out.println(flight);
        }

        // Test wyszukiwania lotów po limitie miejsc
        System.out.println("Wyszukiwanie lotów z limitem miejsc 200:");
        ArrayList<Flight> flightsWithLimit = flightDatabase.searchFlightLimit(200);
        for (Flight flight : flightsWithLimit) {
            System.out.println(flight);
        }
    }
}
