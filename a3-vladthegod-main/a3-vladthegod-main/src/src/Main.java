import domain.BirthdayCake;
import domain.CakeOrder;
import exceptions.AlreadyExistentItem;
import exceptions.InexistentItem;
import repository.*;
import service.CakeService;
import ui.UI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main{
    public static void main(String[] args) throws AlreadyExistentItem, InexistentItem, FileNotFoundException {
      IRepository<CakeOrder,Integer> repoCakeOrder=null;
      IRepository<BirthdayCake,Integer> repoBirthdayCake=null;

      try(FileReader fr =new FileReader("settings.properties")) {
          Properties props=new Properties();
          props.load(fr);

          String repositoryType=props.getProperty("repositoryType");
          String sourceNameForBirhtdayCake=props.getProperty("repositoryBirthdayCakeLocation");
          String sourceNameForCakeOrder=props.getProperty("repositoryCakeOrderLocation");

          switch (repositoryType)
          {
              case "inmemory":
                  repoCakeOrder=new CakeOrderRepository();
                  repoBirthdayCake=new BirthdayCakeRepository();
                  break;
              case "textfile":
                  repoCakeOrder= new CakeOrderRepositoryTextFile(sourceNameForCakeOrder);
                  repoBirthdayCake=new BirthdayCakeRepositoryTextFile(sourceNameForBirhtdayCake);
                  break;
              case "binaryfile":
                  repoCakeOrder=new CakeOrderRepositoryBinaryFile(sourceNameForCakeOrder);
                  repoBirthdayCake=new BirthdayCakeRepositoryBinaryFile(sourceNameForBirhtdayCake);
          }
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      BirthdayCake cake1 = new BirthdayCake(1, "Chocolate Delight", "Chocolate");
      BirthdayCake cake2 = new BirthdayCake(2, "Vanilla Dream", "Vanilla");

      CakeOrder cakeOrder1=new CakeOrder(1,"CakeOrder1","Los Angeles","12.12.2023");
      CakeOrder cakeOrder2=new CakeOrder(2,"CakeOrder2","Cluj-Napoca","12.12.2023");

      try{
          repoCakeOrder.addItem(cakeOrder1);
      }catch (AlreadyExistentItem e)
      {
          throw new RuntimeException(e);
      }
        try{
            repoCakeOrder.addItem(cakeOrder2);
        }catch (AlreadyExistentItem e)
        {
            throw new RuntimeException(e);
        }
      for(CakeOrder cakes: repoCakeOrder.getAllItems())
          System.out.println(cakes);

    }

    //testing the binary files
    //CakeOrder cakeOrder1=new CakeOrder(1,"CakeOrder1","Los Angeles","12-12-2023");
    //CakeOrder cakeOrder2=new CakeOrder(2,"CakeOrder2","Cluj-Napoca","12-12-2023");
    //BirthdayCake BirthdayCake1=new BirthdayCake(1,"Pavlova","Sweet");
    //BirthdayCake BirthdayCake2=new BirthdayCake(2,"Cinnamon Toast","Cinnamon");
    //IRepository<BirthdayCake,String> BirthdayCakeRepo=new BirthdayCakeRepositoryBinaryFile("BirthdayCake.bin");

}