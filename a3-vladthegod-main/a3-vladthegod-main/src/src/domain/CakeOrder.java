package domain;

import java.util.Objects;

public class CakeOrder implements Identifiable<Integer> {
    private int id;
    private String name;
    private String date;
    private String location;

    public CakeOrder(int id, String name, String location, String date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setName(String new_name) {
        this.name = new_name;
    }

    public void setDate(String new_date) {
        this.date = new_date;
    }

    public void setLocation(String new_location) {
        this.location = new_location;
    }

    @Override
    public String toString() {
        return "Order{ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object objectToCompare) {
        if (this == objectToCompare)
            return true;
        if (objectToCompare == null || getClass() != objectToCompare.getClass())
            return false;
        CakeOrder cakeOrder = (CakeOrder) objectToCompare;
        return id == cakeOrder.id &&
                Objects.equals(name, cakeOrder.name) &&
                Objects.equals(date, cakeOrder.date) &&
                Objects.equals(location, cakeOrder.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, location);
    }
}
