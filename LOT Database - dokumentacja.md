# LOT Database - dokumentacja
Pogram LOT Database zawiera 3 klasy tworzące strukture naszej bazy danych oraz klasę testową zawierającą testy dla naszych metod. Klasy wchodzące w skład to: Flight, Passenger i FlightDatabase.
## class Flight
Klasa Flight reprezentuje obiekt lotu, z takimi atrybutami jak: numer lotu, trasa, data i godzina odlotu, limit pasażerów dostępne miejsca oraz listę pasażerów.
``` Java
public class Flight {
    private final int flightNr;
    private List<String> route; // [0] - place of departure, [1] - place of arrival
    private Date departureDate;
    private Time departureTime;
    private int limit;
    private int availablePlaces = limit;
    private final List<Passenger> passengers = new ArrayList<>();
}
```
### Konstruktor
```Java
public Flight(int flightNr, ArrayList<String> route, Date departureDate, Time departureTime, int placesLimit)
```
Wywołuje wyjątek IllegalArgumentException, jeżeli limit miejsc jest <= 0.

### Metody
#### addPassenger(Passenger p)
Dodaje pasażera do listy, jeżeli są jeszcze dostępne miejsca.
- Passenger p - pasażer do dodania.

#### removePassenger(Passenger p)
Usuwa danego pasażera z listy lotu.
- Passenger p - pasażer do usunięcia.

#### removePassenger(String name, String surname)
Usuwa pasażera na podstawie podanego umienia i nazwiska.
- String name - imię pasażera,
- String surname - nazwisko pasażera.

#### updateRoute(ArrayList<String> newRoute)
Uaktualnia trasę lotu.
- ArrayList<String> newRoute - lista z miejscami wylotu - [0] i przylotu - [1]

#### updateDate(Date newDate)
Uaktualnie datę wylotu.
- Date newDate - nowa data wylotu

#### updateTime(Time newTime)
Uaktualnie godzinę wylotu.
- Time newTime - nowa godzina wylotu.

#### updateLimit(int newLimit)
Uaktulnia limit pasażerów.
- int newLimit - nowy limit
Wywołuje IllegalArgumentException jeżeli limit <= 0.

#### toString()
Zapewnia reprezentację tekstową danych danego lotu.

## class Passenger
KLasa reprezentuje pasażera z wyszczególnionymi danymi takmi jak: ID pasażera, imię, nazwiskom, nr telefonu.
```Java
public class Passenger {
    private static int count = 0;
    private final int id;
    private String name;
    private String surname;
    private int phoneNumber;
}
```

### Konstruktor
```Java
Passenger(String name, String surname, int phoneNumber)
```
Wywołuje IllegalArgumentException jeżeli nr telefonu ma długość > 9.
### Metody
#### updatePhoneNumber(int newPhoneNumber)
Uaktualnie nr telefonu.
- int newPhoneNumber - nowy nr telefonu.
Wywołuje IllegalArgumentException jeżeli nr telefonu ma długość > 9.

#### updateName(String newName, String newSurname)
Uaktualnie imię i nazwisko pasażera.
- String newName - nowe imię,
- String newSurname - nowe nazwisko.

#### toString()
Zapewnia reprezentację tekstową danych danego pasażera.

#### hashCode() i equals()
Ustalają na podstawie jakich parametrów porównujemy pasażerów. W naszym przypadku po id, imieniu i nazwisku

## class FlightDatabase
Reprezentacja bazy danych lotów. Zawiera atrybuty: HashMapa lotów i ich nr ID oraz HashSet unikalnych pasażerów.

```Java
public class FlightDatabase {
    private final Map<Integer, Flight> flights = new HashMap<>();
    private final Set<Passenger> passengers = new HashSet<>();
}    
```
Klasa z konstruktorem bezargumentowym.
### Metody
#### addFlight(int flightNumber, ArrayList<String> route, Date depDate, Time depTime, int placesLimit)
Dodaje lot do bazy danych.
- int flightNumber - nr id lotu,
- ArrayList<String> route - trasa lotu,
- Date depDate - data wylotu,
- Time depTime - godzina wylotu, 
- int placesLimit - limit pasażerów.

#### addPassenger(String firstName, String lastName, int phoneNumber)
Dodaje pasażera do bazy danych.
- String firstName - imię pasażera, 
- String lastName - nazwisko pasażera,
- int phoneNumber - nr telefonu pasażera.

#### bookSeat(int flightNumber, Passenger p)
Rezerwuje miejsce dla danego pasażera w danym locie.
- int flightNumber - nr lotu,
- Passenger p - pasażer.

#### cancelBooking(int flightNumber, Passenger p)
Anuluje rezerwację dla danego pasażera w danym locie.
- int flightNumber - nr lotu,
- Passenger p - pasażer.

#### cancelBooking(int flightNumber, String name, String surname)
Anuluje rezerwację dla danego pasażera w danym locie.
- int flightNumber - nr lotu,
- String name - imię pasażera,
- String surname - nazwisko pasażera.

#### removeFlight(int flightNumber)
Usuwa dany lot.
- int flightNumber - nr lotu.

#### removePassenger(String firstName, String surname)
Usuwa danego pasażera.
- String name - imię pasażera,
- String surname - nazwisko pasażera.

#### updatePassengerPhoneNumber(Passenger p, int newPhoneNum)
Uaktualnie nr telefonu pasażera.
- int flightNumber - nr lotu,
- Passenger p - pasażer,
- int newPhoneNum - nr telefonu.

#### update
``` Java 
updateFlightRoute(int flightNumber, ArrayList<String> newRoute)

updateDate(int flightNumber, Date newDate)

updateTime(int flightNumber, Time newTime)

updatePlacesLimit(int flightNumber, int newLimit)
```
Uaktulnia dany atrybut danego lotu.

#### displayInfo(int flightNumber)
Wyświetla informacje na temat danego lotu.
- int flightNumber - nr lotu.

#### Wyszukiwania lotów na podstawie informacji

```Java
public ArrayList<Flight> searchFlightDeparture(String dep)

public ArrayList<Flight> searchFlightArrival(String arr)

public ArrayList<Flight> searchFlightDate(Date date)

public ArrayList<Flight> searchFlightTime(Time time)

public ArrayList<Flight> searchFlightLimit(int limit)
```
Wyszukuje loty z podanymi atrybutami.