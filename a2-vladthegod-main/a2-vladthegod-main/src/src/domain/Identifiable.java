package domain;

public interface Identifiable<T> {

    public T getId();

    public void setId(T id);

    void setName(String newName);
}
