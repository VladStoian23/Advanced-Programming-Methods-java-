package repository;
import DataBase.DatabaseConnector;
import domain.CakeOrder;
import domain.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CakeOrderRepositoryDataBase {
public List<CakeOrder> repo=new ArrayList<>();
    public void getAllOrders() {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM CakeOrders");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                String Date = resultSet.getString("date");
                String Location=resultSet.getString("location");
                OrderStatus status = OrderStatus.valueOf(resultSet.getString("status"));

                List<CakeOrder> cakes = getCakeOrderID(orderId);


                CakeOrder order = new CakeOrder(orderId, Name, Date, Location);
                            order.setStatus(status);

                repo.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCakeOrder(CakeOrder order)
    {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Cakeorders(id, Name, Date,Location, status) VALUES (?, ?, ?, ?,?)"
             )) {
                statement.setInt(1,order.getId());;
                statement.setString(2,"Name");
                statement.setString(3,"Date");
                statement.setString(4,"Location");
            // statement.setString(5,order.getStatus().toString());
                statement.executeUpdate();
                saveCakeOrder(order.getId(),order.getCakes());
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateCakeOrder(CakeOrder order) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Cakeorders SET name = ?, date = ?, status = ? WHERE id = ?"
             )) {
            statement.setString(1, order.getName());
            statement.setString(2, order.getDate());
            statement.setString(3, order.getLocation());
            statement.executeUpdate();

            updateCakeOrderSave(order.getId(), order.getCakes());
        }catch (SQLException e)
        {e.printStackTrace();
        }
        }


    public void deleteCakeOrder(int id)
    {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Cakeorders WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();

            deleteCakeOrderID(id);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }


    private List<CakeOrder> getCakeOrderID(int id) {
        List<CakeOrder> cakes = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT c.* FROM CakeOrders c " +
                             "JOIN Cakeorders oc ON c.id = oc.id " +
                             "WHERE oc.id = ?"
             )) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CakeOrder cake = new CakeOrder(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("location"),
                            resultSet.getString("date")
                           );
                    cakes.add(cake);
                     }
                 };
            } catch (SQLException e) {
                e.printStackTrace();


        }
        return cakes;
    }


    private void saveCakeOrder(Integer id, List<CakeOrder> cakes) {
        try (Connection connection = DatabaseConnector.getConnection()){
            for(CakeOrder cake:cakes)
            {
                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO CakeOrders(id, id) VALUES (?, ?)"
                )) {
                    statement.setInt(1,id);
                    statement.setInt(2,cake.getId());
                    statement.executeUpdate();
                }
            }




        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

private void updateCakeOrderSave(int id,List<CakeOrder> newCakes)
{
    try (Connection connection = DatabaseConnector.getConnection();
         PreparedStatement deleteStatement = connection.prepareStatement(
                 "DELETE FROM Cakeorders WHERE id = ?"
         )) {
        deleteStatement.setInt(1,id);
        deleteStatement.executeUpdate();
    }catch (SQLException e)
    {
        e.printStackTrace();
    }

    saveCakeOrder(id,newCakes);

}

private void deleteCakeOrderID(int id) {
    try (Connection connection = DatabaseConnector.getConnection();
         PreparedStatement statement = connection.prepareStatement(
                 "DELETE FROM Cakeorders WHERE id = ?"
         )) {
        statement.setInt(1, id);
        statement.executeUpdate();
    } catch (SQLException e)
    {
        e.printStackTrace();
    }

}

}
