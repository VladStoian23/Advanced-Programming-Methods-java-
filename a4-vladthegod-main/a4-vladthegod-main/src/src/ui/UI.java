package ui;

import Settings.Settings;
import domain.BirthdayCake;
import domain.CakeOrder;
import domain.Identifiable;
import repository.BirthdayCakeRepositoryBinaryFile;
import repository.BirthdayCakeRepositoryTextFile;
import repository.FileRepository;
import service.CakeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//adaug la UI

    /*private static CakeService<CakeOrder> cakeorderService1;
    private static CakeService<BirthdayCake> birthdaycakeService1;
    public static void main(String[] args) {
        //manageRepository();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Manage Birthday Cakes");
            System.out.println("2.Manage CakesOrder");
            System.out.println("3.reports");
            System.out.println("4.exit");
            System.out.println("Enter choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageEntitiescakeorderService1, "CakeOrder", scanner);
                    break;
                case 2:
                    manageEntities(birthdaycakeService1, "BirthdayCakes", scanner);
                    break;
                case 3:
                    reports(scanner);
                case 4:
                    System.out.println("exit the appplication");
                    return;
                default:
                    System.out.println("Invalid choice . Try again!");
            }

            private static void manageRepostitory ()
            {
                Scanner scaner = new Scanner(System.in);
                System.out.println("1-FileRepository");
                System.out.println("2-MemoryRepository");
                System.out.println("3-Choose repo type");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                BirthdayCake cake1 = new BirthdayCake(1, "Chocolate delight", "Chocolate");
                BirthdayCake cake2 = new BirthdayCake(2, "Caramel delight", "Caramel");
                BirthdayCake cake3 = new BirthdayCake(3, "Vanilla delight", "Vanilla");
                BirthdayCake cake4 = new BirthdayCake(4, "Dark delight", "Dark");
                BirthdayCake cake5 = new BirthdayCake(5, "Strawberry delight", "Strawberry");

                List<BirthdayCake> list1cakes = new ArrayList<BirthdayCake>();

                list1cakes.add(cake1);
                list1cakes.add(cake2);
                CakeOrder order1 = new CakeOrder(1, "order1", "here", "now");
                int choice1 = scanner.nextInt();
                scanner.nextLine();
                switch (choice1) {
                    case 1:
                        Settings settings = new Settings();
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("1-text repository");
                        System.out.println("2-binary repository");
                        int choise1 = scanner1.nextInt();
                        scanner1.nextLine();
                        switch (choise1) {
                            case 1:
                                settings.updateProperty("BirthdayCakeRepository", "text");
                                settings.updateProperty("BirthdayCakeFilePath", "cakes.txt");
                                settings.updateProperty("CakeOrderRepository", "text");
                                settings.updateProperty("CakeOrderFilePath", "orders.txt");
                                break;
                            case 2:
                                settings.updateProperty("BirthdayCakeRepository", "binary");
                                settings.updateProperty("BirthdayCakeFilePath", "cakes.bin");
                                settings.updateProperty("CakeOrderRepository", "binary");
                                settings.updateProperty("CakeOrderFilePath", "orders.bin");
                                break;
                            case 3:
                                System.out.println("Exiting the application.");
                                return;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        String BirthdayCakeRepositoryType = settings.getPropertyTest("BirthdayCakeRepository");
                        String BirthdayCakeFilePath = settings.getPropertyTest("BirthdayCakeFilePath");
                        System.out.println(BirthdayCakeFilePath);

                        String CakeOrderRepositoryType = settings.getPropertyTest("CakeOrderRepository");
                        String CakeOrderFilePath = settings.getPropertyTest("CakeOrderFilePath");
                        System.out.println(CakeOrderRepositoryType);

                        FileRepository<BirthdayCake, Integer> BirhtdayCakeRepository;
                        if (BirthdayCakeRepositoryType.equals("text")) {
                            BirhtdayCakeRepository = new BirthdayCakeRepositoryTextFile(BirthdayCakeFilePath);
                            System.out.println("Working!");
                        } else {
                            BirhtdayCakeRepository = new BirthdayCakeRepositoryBinaryFile(BirthdayCakeFilePath);
                            System.out.println("working for binary too :)");

                        }

                }
            }


        }
        private static <T extends Identifiable<T>,T> void manageCakes(CakeService cakeService, Scanner scanner) {
            while (true) {
                System.out.println("1. Add Birthday Cake");
                System.out.println("2. Update Birthday Cake");
                System.out.println("3. Delete Birthday Cake");
                System.out.println("4. List All Birthday Cakes");
                System.out.println("5. Cake Reports");
                System.out.println("6. Go Back");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        addBirthdayCake(cakeService, scanner);
                        break;
                    case 2:
                        updateBirthdayCake(cakeService, scanner);
                        break;
                    case 3:
                        deleteBirthdayCake(cakeService, scanner);
                        break;
                    case 4:
                        listAllBirthdayCakes(cakeService);
                        break;
                    case 5:
                        cakeReports(cakeService, scanner);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            public static List<String> getNamesForCake(BirthdayCake cake, Collection<CakeOrder> orders) {
                return orders.stream()
                        .filter(order -> order.getCakes().contains(cake))
                        .map(Order::getCustomerName)
                        .collect(Collectors.toList());
            }





            }





















    }*/
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
