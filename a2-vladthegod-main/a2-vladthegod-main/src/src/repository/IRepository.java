package repository;

import domain.Identifiable;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;

import java.util.Collection;
import java.util.List;
public interface IRepository <T extends Identifiable,U>{
    //here we just use the basic CRUD operations
    public void addItem(T item) throws AlreadyExistentItem;
    public boolean removeItem(U itemId) throws InexistentItem;


    public T findItem(U id) throws InexistentItem;
    public void updateItemById(U id, T newItem) throws InexistentItem;


    public Iterable<T> getAllItems();


}
