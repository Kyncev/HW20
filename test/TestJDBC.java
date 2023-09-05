package test;

import objects.User;
import org.junit.Assert;
import org.junit.Test;
import selection.DeadpoollOb;

import java.sql.SQLException;

public class TestJDBC {
    @Test
    public void test1() throws SQLException {
        DeadpoollOb.getUser("Vitaly");
    }
    @Test
    public void test2() throws SQLException {
        Assert.assertFalse(DeadpoollOb.addUser("Sergiy", "Luch", "Gdansk"));
    }
    @Test
    public void test3(){
        for (User l : DeadpoollOb.getUserObjects("Vitaly")) {
            System.out.println(l.date);
        }
    }
    //Homework
    @Test
    public void test4() throws SQLException {
        DeadpoollOb.getUserbyId("16");
    }
    @Test
    public void test5(){
        for (User l : DeadpoollOb.getUserbysameTown("Nikopol")) {
            System.out.println(l.name);
        }
    }
}

