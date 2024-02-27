package ui;

import domain.BirthdayCake;
import domain.CakeOrder;
import service.CakeService;

import java.util.Scanner;
public class UI {

    private CakeService cakeService;
    private Scanner scanner=new Scanner(System.in);

    public UI(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    public void add_BirthdayCake(){
        System.out.println("Enter cake details:");
        System.out.print("ID: ");

        int id=Integer.parseInt(scanner.nextLine());
        System.out.println(("Flavour: "));
        String flavour=scanner.nextLine();

        System.out.println("Theme: ");
        String theme=scanner.nextLine();

        try{
            cakeService.addBirthdayCake(id,flavour,theme);
            System.out.println("cake added successfully");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void delete_BirthdayCake(){
        System.out.println("ID to be deleted:");
        int id=Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
      try{
          cakeService.deleteBirthdayCakeByID(id);
          System.out.println("order deleted successfully");
      }catch (Exception e){
          System.out.println(e.getMessage());
      }


    }

    public void listAllBirthdayCakes()
    {
    Iterable<BirthdayCake> cakes = cakeService.getAllBirthdayCakes();
    for(BirthdayCake cake:cakes)
            System.out.println(cake);

    }
    private void updateBirthdayCake() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cake details to update:");
        int id=scanner.nextInt();
        scanner.nextLine();

        System.out.println("New Name");
        String new_Name=scanner.nextLine();

        System.out.println("New flavour");
        String new_Flavour=scanner.nextLine();

        try {
            cakeService.updateBirthdayCake(id,new_Name,new_Flavour);
            System.out.println("Order updated successfully");

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //Now same operations but using Orders

    public void addOrder() {
        System.out.println("Enter order details:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        try {
            cakeService.addCakeOrder(id, name, location, date);
            System.out.println("Order added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteOrder()
    {
        System.out.println("Enter order Id To delete: ");
        int id=Integer.parseInt(scanner.nextLine());
        try{
            cakeService.deleteCakeOrderByID(id);
            System.out.println("Order deleted successfully");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listAllOrders()
    {
        Iterable<CakeOrder> orders = cakeService.getAllCakeOrders();
        for (CakeOrder order:orders)
        {
            System.out.println(order);
        }
    }


    public void updateOrder(){
        System.out.println("Enter order ID to update: ");
        int id=Integer.parseInt(scanner.nextLine());

        System.out.println("New name: ");
        String newName= scanner.nextLine();

        System.out.println("New Location: ");
        String newLocation= scanner.nextLine();

        System.out.println("New Date: ");
        String newDate= scanner.nextLine();

        try{
            cakeService.updateCakeOrder(id,newName,newLocation,newDate);
            System.out.println("Order updated successfully");

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }



    public void printMenu()
    {
        System.out.println("8 - Update an existing order");
        System.out.println("7 - Delete an existing order");
        System.out.println("6 - List all orders");
        System.out.println("5 - Add a new order");
        System.out.println("4 - Update an existing birthday cake");
        System.out.println("3 - Delete an existing birthday cake");
        System.out.println("2 - Add a new birthday cake");
        System.out.println("1 - List all birthday cakes");
        System.out.println("0 - Exit");

    }


    public void run()
    {
        while (true)
        {
            printMenu();
            System.out.print("Please input your option: ");
            Scanner scan = new Scanner(System.in);
            int command = scan.nextInt();
            switch (command)
            {
                case 0:
                    return;
                case 1:
                    listAllBirthdayCakes();
                    break;
                case 2:
                    add_BirthdayCake();
                    break;
                case 3:
                    delete_BirthdayCake();
                    break;
                case 4:
                    updateBirthdayCake();
                    break;
                case 5:
                    addOrder();
                    break;
                case 6:
                    listAllOrders();
                    break;
                case 7:
                    deleteOrder();
                    break;
                case 8:
                    updateOrder();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


}

