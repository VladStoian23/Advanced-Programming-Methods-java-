package service;

import domain.BirthdayCake;
import domain.CakeOrder;
import domain.Identifiable;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;
import repository.BirthdayCakeRepository;
import repository.CakeOrderRepository;

public class CakeService<T extends Identifiable> {
    BirthdayCakeRepository birthdayCakeRepository;
    CakeOrderRepository cakeOrderRepository;

    public CakeService(BirthdayCakeRepository birthdayCakeRepository, CakeOrderRepository cakeOrderRepository) {
        this.birthdayCakeRepository = birthdayCakeRepository;
        this.cakeOrderRepository = cakeOrderRepository;
    }

    // CRUD BirthdayCake
    public void addBirthdayCake(Integer id, String name, String flavour) throws AlreadyExistentItem {
        this.birthdayCakeRepository.addItem(new BirthdayCake(id, name, flavour));
    }

    public BirthdayCake getBirthdayCakeByID(Integer id) throws InexistentItem {
        BirthdayCake cake=birthdayCakeRepository.findItem(id);
        if(cake == null)
        {
            throw new InexistentItem("Birthday cake with id "+id+"is inexistent");
        }


        return cake;
    }

    public Iterable<BirthdayCake> getAllBirthdayCakes() {
        return this.birthdayCakeRepository.getAllItems();
    }

    public void updateBirthdayCake(Integer id, String newName, String newFlavour) throws InexistentItem {
        BirthdayCake cakeToUpdate = birthdayCakeRepository.findItem(id);

        if (!newName.equals(cakeToUpdate.getName())) {
            cakeToUpdate.setName(newName);
        }

        if (!newFlavour.equals(cakeToUpdate.getFlavour())) {
            cakeToUpdate.setFlavour(newFlavour);
        }

        this.birthdayCakeRepository.updateItemById(id, cakeToUpdate);
    }

    public void deleteBirthdayCakeByID(Integer id) throws InexistentItem {
        BirthdayCake cakeToDelete = birthdayCakeRepository.findItem(id);
        if (cakeToDelete != null) {
            this.birthdayCakeRepository.removeItem(id);
        } else {
            throw new InexistentItem("BirthdayCake with id " + id + " does not exist!");
        }
    }

    // CRUD Operations for CakeOrder

    public void addCakeOrder(int id, String name, String location, String date) throws AlreadyExistentItem {
        this.cakeOrderRepository.addItem(new CakeOrder(id, name, location, date));
    }

    public CakeOrder getCakeOrderByID(int id) throws InexistentItem {
        CakeOrder cakeOrder=cakeOrderRepository.findItem(id);
        if(cakeOrder==null)
        {
            throw new InexistentItem("The cake order with id"+id+" is not working");
        }

        return cakeOrder;
    }

    public Iterable<CakeOrder> getAllCakeOrders() {
        return cakeOrderRepository.getAllItems();
    }

    public void updateCakeOrder(int id, String newName, String newLocation, String newDate) throws InexistentItem {
        Integer itemId=id;
        CakeOrder orderToUpdate = cakeOrderRepository.findItem(itemId);
        if (orderToUpdate != null) {
            orderToUpdate.setName(newName);
            orderToUpdate.setLocation(newLocation);
            orderToUpdate.setDate(newDate);

            cakeOrderRepository.updateItemById(itemId, orderToUpdate);
        } else {
            throw new InexistentItem("Order with ID " + id + " not found");
        }
    }

    public void deleteCakeOrderByID(int id) throws InexistentItem {
        CakeOrder orderToDelete = cakeOrderRepository.findItem(id);
        if(orderToDelete != null){
             this.cakeOrderRepository.removeItem(id);
             System.out.println("Order removed successfully");
        }else{
            throw new InexistentItem("Order with id "+id+"does not exist!");
        }

    }
}