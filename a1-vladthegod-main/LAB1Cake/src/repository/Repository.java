package LAB1Cake.src.repository;

import LAB1Cake.src.domain.BirthdayCake;

import java.util.ArrayList;
public class Repository {
    private ArrayList<BirthdayCake> CakeArray = new ArrayList<>();

    public void addBirthdayCake(BirthdayCake new_BirthdayCake) {
        CakeArray.add(new_BirthdayCake);
    }

    public BirthdayCake getCakeById(int idToSearch) {
        for (BirthdayCake cake : CakeArray)
            if (cake.getId() == idToSearch)
                return cake;

        return null;

    }



    public void updateBirthdayCakeById(int CakeIdToUpdate,String new_name,String new_flavour)
    {
        for(BirthdayCake cake:CakeArray)
        {
            if(cake.getId()==CakeIdToUpdate)
            {

                cake.setName(new_name);
                cake.setFlavour(new_flavour);

            }
        }
    }

    public boolean deleteBirthdayCakeById(int id)
    {
        int indexCakeToDelete=0;
        boolean foundBirthdayCake=false;
        for(BirthdayCake cake:CakeArray)
        {
            if(cake.getId()==id)
            {
                CakeArray.remove(indexCakeToDelete);
                foundBirthdayCake=true;
                break;
            }
            indexCakeToDelete++;
        }
        return foundBirthdayCake;

    }

    public ArrayList<BirthdayCake> getAllBirthdayCakes()
    {
        return this.CakeArray;

    }


}
