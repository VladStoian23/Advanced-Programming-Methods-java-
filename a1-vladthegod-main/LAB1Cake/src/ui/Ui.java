package LAB1Cake.src.ui;


import LAB1Cake.src.domain.BirthdayCake;
import LAB1Cake.src.service.Service;

import java.util.Scanner;
import java.util.ArrayList;

public class Ui {
    private Service BirthdayCakeService;
    public  Ui(Service service){this.BirthdayCakeService=service;}

    private Scanner scanner=new Scanner(System.in);

    public void add_BirthdayCake(){
        System.out.println("Enter Birthdaycake details");
        System.out.println("ID:");
        int id=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Name of the cake ");
        String name=scanner.nextLine();

        System.out.println("Flavour of the cake:");
        String flavour=scanner.nextLine();

        BirthdayCakeService.addBirthdayCake(id,name,flavour);
        System.out.println(("Birthday cake added successfully"));

    }

    public void delete_BirthdayCake()
    {
        System.out.println("Id to be deleted:");
        int orderToDelete=scanner.nextInt();
        scanner.nextLine();

        if(BirthdayCakeService.deleteBirthdayCake(orderToDelete))
            System.out.println(("Cake deleted successfully"));
        else
            System.out.println("Cake not found");

    }

    public void listAllCakes()
    {
        ArrayList<BirthdayCake> cakes=this.BirthdayCakeService.getAllBirthdayCakes();
        for(BirthdayCake cake:cakes)
            System.out.println(cake);
    }

    public void printMenu()
    {
        System.out.println("4 - Update an existing cake");
        System.out.println("3 - Delete an existing cake");
        System.out.println("2 - Add a new cake");
        System.out.println("1 - List all cakes");
        System.out.println("0 - Exit");

    }

    private void updateFromUI() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("New Name: ");
        String newName = scanner.nextLine();

        System.out.print("New Flavour: ");
        String newFlavour = scanner.nextLine();

        System.out.print("Id of the order to be updated: ");
        int orderIdToUpdate = scanner.nextInt();
        scanner.nextLine();


        BirthdayCakeService.updateBirthdayCake(orderIdToUpdate,newName,newFlavour);
        System.out.println("Cake updated successfully");
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
                    listAllCakes();
                    break;
                case 2:
                    add_BirthdayCake();
                    break;
                case 3:
                    delete_BirthdayCake();
                    break;
                case 4:
                    updateFromUI();

            }
        }
    }

}
