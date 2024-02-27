package LAB1Cake.src;

import LAB1Cake.src.repository.Repository;
import LAB1Cake.src.service.Service;
import LAB1Cake.src.ui.Ui;

public class Main {
    public static void main(String[] args) {
        Repository repo=new Repository();
        Service service=new Service(repo);
        Ui ui=new Ui(service);
        service.addBirthdayCake(1,"Pavlova","Sweet");
        service.addBirthdayCake(2,"Tiramisu","Coffe");
        service.addBirthdayCake(3,"Papanas","Sour");
        service.addBirthdayCake(4,"Albinita","Honey");
        service.addBirthdayCake(5,"Mochi","Raspberry");
        ui.run();

    }
}