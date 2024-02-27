package domain;

public interface Identifiable<T> {

    public Integer getId();

    public void setId(T id);

    void setName(String newName);
}
