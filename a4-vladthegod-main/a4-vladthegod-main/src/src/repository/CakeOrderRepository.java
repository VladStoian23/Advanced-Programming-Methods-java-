package repository;
import domain.CakeOrder;
import exceptions.InexistentItem;

public class CakeOrderRepository extends  MemoryRepository<CakeOrder,Integer> {

    @Override
    public boolean removeItem(Integer itemId) throws InexistentItem {
        if (MemElements.containsKey(itemId)) {
            MemElements.remove(itemId);
            return true;
        }
        throw new InexistentItem("Item with id " + itemId + " does not exist");
    }

}
