import java.util.Objects;

public class Passenger {
    private static int count = 0;
    private final int id;
    private String name;
    private String surname;
    private int phoneNumber;

    public Passenger(String name, String surname, int phoneNumber) {
        count++;
        this.id = count;
        this.name = name;
        this.surname = surname;

        if ((phoneNumber - 10^10) <= 0) {
            throw (new IllegalArgumentException());
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void updatePhoneNumber(int newPhoneNumber) {
        if ((phoneNumber - 10^10) <= 0) {
            throw (new IllegalArgumentException());
        } else {
            this.phoneNumber = newPhoneNumber;
        }
    }

    public void updateName(String newName, String newSurname) {
        this.name = newName;
        this.surname = newSurname;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name+
                ", surname: " + surname +
                ", phoneNumber: " + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return id == passenger.id && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
