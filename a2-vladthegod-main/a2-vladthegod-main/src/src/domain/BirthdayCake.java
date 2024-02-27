package domain;

import java.util.Objects;

public class BirthdayCake implements Identifiable<String> {
    public String flavour, name;
    private Integer id;
    public BirthdayCake(Integer id, String name, String flavour) {
        this.flavour = flavour;
        this.name = name;
        this.id = id;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String getId() {
        return String.valueOf(this.id);
    }

    @Override
    public void setId(String id) {
        this.id=Integer.parseInt(id);

    }

    @Override
    public String toString() {
        return "BirthdayCake{" +
                "flavour='" + flavour + '\'' +
                ", theme='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}