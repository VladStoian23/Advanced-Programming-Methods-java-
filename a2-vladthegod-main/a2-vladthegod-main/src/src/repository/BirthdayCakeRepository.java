package repository;

import domain.BirthdayCake;
import exceptions.InexistentItem;

import java.util.HashMap;
import java.util.Map;

public class BirthdayCakeRepository implements IRepository<BirthdayCake, String> {

    private static Map<String, BirthdayCake> cakeMap = new HashMap<>();


    public  void addItem(BirthdayCake cake) {
        if (!cakeMap.containsKey(cake.getId())) {
            cakeMap.put(cake.getId(), cake);
        }
    }

    @Override
    public boolean removeItem(String itemId) {
        if (cakeMap.containsKey(itemId)) {
            cakeMap.remove(itemId);
            return true;
        }
        return false;
    }

    @Override
    public BirthdayCake findItem(String id) {
        return cakeMap.get(id);
    }

    @Override
    public void updateItemById(String id, BirthdayCake newItem) throws InexistentItem {
        if(cakeMap.containsKey(id))
        {
            cakeMap.replace(id,newItem);
        }else{
            throw new InexistentItem("BirthdayCake with id "+id+"Does not exist!");
        }


    }

    public void updateCake(BirthdayCake updatedCake) {
        String cakeId = updatedCake.getId();
        if (cakeMap.containsKey(cakeId)) {
            cakeMap.replace(cakeId, updatedCake);
        }
    }

    @Override
    public Iterable<BirthdayCake> getAllItems() {
        return cakeMap.values();
    }
}
