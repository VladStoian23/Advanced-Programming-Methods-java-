package LAB1Cake.src.service;


import LAB1Cake.src.domain.BirthdayCake;
import LAB1Cake.src.repository.Repository;

import java.util.ArrayList;

public class Service {
    private Repository BirthdayCakeRepository;

    public Service(Repository cakeRepository)
    {
        this.BirthdayCakeRepository=cakeRepository;
    }

    public void addBirthdayCake(int id,String name,String flavour)
    {
        BirthdayCake new_cake=new BirthdayCake(id,name,flavour);
        this.BirthdayCakeRepository.addBirthdayCake(new_cake);

    }

    public boolean deleteBirthdayCake(int id)
    {
        return this.BirthdayCakeRepository.deleteBirthdayCakeById(id);


    }
    public void updateBirthdayCake(int cakeIdToUpdate,String new_name,String new_flavour)
    {
        this.BirthdayCakeRepository.updateBirthdayCakeById(cakeIdToUpdate,new_name,new_flavour);
    }
    public ArrayList<BirthdayCake> getAllBirthdayCakes()
    {
        return this.BirthdayCakeRepository.getAllBirthdayCakes();
    }



}
