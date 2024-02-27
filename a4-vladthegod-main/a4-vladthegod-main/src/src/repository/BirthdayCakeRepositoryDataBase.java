package repository;
import DataBase.DatabaseConnector;
import domain.BirthdayCake;
import exceptions.InexistentItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BirthdayCakeRepositoryDataBase extends MemoryRepository<BirthdayCake, Integer> {
public List<BirthdayCake> repo=new ArrayList<>();

@Override
    public String toString()
{
    return "BirthdayCakeRepositoryDataBase{"+
            "repo="+repo+
            '}';
}
public void getAllBirthdayCakes()
{
    try(Connection connection = DatabaseConnector.getConnection();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM BirthdayCake");
        ResultSet resultSet=statement.executeQuery()){
            while(resultSet.next()){
                BirthdayCake cake= new BirthdayCake(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("flavour")
                );
               repo.add(cake);

            }
    } catch (SQLException e) {
            e.printStackTrace();
    }}


public void saveBirthdayCake(BirthdayCake cake) throws SQLException {
    try(Connection connection =DatabaseConnector.getConnection())
    {
        PreparedStatement statement=connection.prepareStatement("INSERT INTO  BirthdayCake(id,name,flavour) values (?,?,?)");
        {
            statement.setInt(1,cake.getId());
            statement.setString(2,cake.getName());
            statement.setString(3,cake.getFlavour());
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public BirthdayCake getCakeById(int id)
{
    BirthdayCake cake =null;
    try(Connection connection = DatabaseConnector.getConnection()){
    PreparedStatement statement=connection.prepareStatement("SELECT * FROM  BirthdayCake WHERE id=?");
    {
        statement.setInt(1,id);
        try(ResultSet resultSet = statement.executeQuery()){
            if(resultSet.next()) {
                cake = new BirthdayCake(resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Flavour")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();

        }


    return cake;
    }



} catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
    public void deleteBirthdayCake(int id){
    if(getCakeById(id)==null)
        System.out.println("BrthdayCake!");
    else{
        try(Connection connection=DatabaseConnector.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("Delete from BirthdayCake where id=?")){
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}

public void updateBirthdayCake(BirthdayCake cake) throws InexistentItem {
    if(getCakeById(cake.getId())!=null)
    {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE BirthdayCake SET flavour = ?, name = ? WHERE id = ?"
             )) {
            statement.setString(1, cake.getFlavour());
            statement.setString(2,cake.getName());
            statement.setInt(3,cake.getId());
            statement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }


    }else{
        throw new InexistentItem("Birthday Cake with given id not existent");
    }
}
}