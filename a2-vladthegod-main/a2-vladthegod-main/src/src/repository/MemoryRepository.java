package repository;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;
import domain.Identifiable;

import java.util.Map;
import java.util.HashMap;
public class MemoryRepository<T extends Identifiable,U> implements IRepository<T,U> {

    Map<U,T> MemElements =new HashMap<>();

    @Override
    public void addItem(T item) throws AlreadyExistentItem {
        if(MemElements.containsKey(item.getId()))
            throw new AlreadyExistentItem("Item with id"+item.getId()+"already exists");
            MemElements.put((U)item.getId(),item);
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
        if(MemElements.containsKey(id))
        {
            MemElements.replace(id,newItem);

        }
        throw new InexistentItem("Item with id"+id+"inexistent");

    }

    @Override
    public boolean removeItem(U itemId) throws InexistentItem {
        if (!MemElements.containsKey(itemId)) {
            MemElements.remove(itemId);
            return true;

        }
        throw new InexistentItem("item with id"+ itemId+"Not existent");
    }

    @Override
    public Iterable<T> getAllItems() {
        return MemElements.values();
    }
}
