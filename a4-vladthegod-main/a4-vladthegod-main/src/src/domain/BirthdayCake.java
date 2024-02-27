package domain;

import java.io.Serializable;
import java.util.Objects;

public class BirthdayCake implements Identifiable<Integer>, Serializable {
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
    public Integer getId() {
        return (this.id);
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    @Override
    public String toString() {
        return "BirthdayCake{" +
                "flavour='" + flavour + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
    @Override
    public boolean equals(Object objectToCompare)
    {
        if (this == objectToCompare)
            return true;
        if (objectToCompare.getClass() != BirthdayCake.class)
            return false;
        BirthdayCake d = (BirthdayCake) objectToCompare;
        return Objects.equals(d.id, this.id);
    }
    private static final long serialVersionUID = 1L;
}