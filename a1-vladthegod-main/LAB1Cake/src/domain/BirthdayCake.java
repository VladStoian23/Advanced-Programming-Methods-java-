package LAB1Cake.src.domain;

import java.util.Objects;

public class BirthdayCake implements Identifiable{

    public int id;
    private String name,flavour;

    public BirthdayCake(int id,String name,String flavour)
    {
        this.id=id;
        this.name=name;
        this.flavour=flavour;

    }
    @Override
    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "BirthdayCake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flavour='" + flavour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthdayCake that = (BirthdayCake) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(flavour, that.flavour);
    }


}
