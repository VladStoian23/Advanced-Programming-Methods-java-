package repository;

import domain.Identifiable;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;

import java.util.HashMap;
import java.util.Map;
public class MemoryRepository<T extends Identifiable<U>,U> implements IRepository<T,U> {

    public Map<U,T> MemElements =new HashMap<>();

    @Override
    public void addItem(T item) throws AlreadyExistentItem {
        if(MemElements.containsKey(item.getId()))
            throw new AlreadyExistentItem("Item with id"+item.getId()+"already exists");
            MemElements.put((U)item.getId(),item);
    }
    @Override
    public boolean removeItem(U itemId) throws InexistentItem {
        if (MemElements.containsKey(itemId)) {
            MemElements.remove(itemId);
            return true;

        } else {
            throw new InexistentItem("item with id" + itemId + "Not existent");
        }
    }
    @Override
    public T findItem(U id) throws InexistentItem {
        if(!MemElements.containsKey(id))
        {
            throw new InexistentItem("Item with id "+ id+"Is not found");
        }


        return MemElements.get(id);
    }


    @Override
    public void updateItemById(U id, T newItem) throws InexistentItem{
        if(!MemElements.containsKey(id))
        {
           throw new InexistentItem("Item with id "+id+" inexistent");


        }
        MemElements.replace(id,newItem);
    }




    @Override
    public Iterable<T> getAllItems() {
        return MemElements.values();
    }
}
