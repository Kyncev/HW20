package selection;

import config.State;
import objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeadpoollOb extends State {
    public static void printInfo() throws SQLException{
        ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.deadpool;");
        while(resultSet.next()){
            System.out.println(resultSet.getString("name") + " "+resultSet.getString("date"));
        }
    }
public static void getUser(String name) throws SQLException {
    ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.deadpool where name=\""+name+"\";");
    while(resultSet.next()){
        System.out.println(resultSet.getString("family") + " "+resultSet.getString("date"));

}
}
public static boolean addUser(String name, String family, String cityName) throws SQLException{
       return getStatement().execute("INSERT INTO `sys`.`deadpool` (`name`, `family`, `city`) VALUES ('"+name+"', '"+family+"', '"+cityName+"');");
    }
    public static List<User> getUserObjects(String name) {
        ResultSet resultSet=null;
        List<User> list=new ArrayList<>();
        try {
            resultSet = getStatement().executeQuery("SELECT * FROM sys.deadpool where name=\"" + name + "\";");
            while (resultSet.next()) {
                list.add(new User(resultSet));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    return list;
    }
    //Homework
    public static void getUserbyId(String id) throws SQLException {
        ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.deadpool where id=\""+id+"\";");
        while(resultSet.next()){
            System.out.println(resultSet.getString("name") + " "+resultSet.getString("date"));

        }
    }
    public static List<User> getUserbysameTown(String name) {
        ResultSet resultSet=null;
        List<User> list=new ArrayList<>();
        try {
            resultSet = getStatement().executeQuery("SELECT * FROM sys.deadpool where city='Nikopol';");
            while (resultSet.next()) {
                list.add(new User(resultSet));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}

