package test.service.impl;

import entity.Users;
import org.junit.Assert;
import org.junit.Test;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

public class TestUsersDAOImpl {
    @Test
    public void testUsersLogin() {
        Users u = new Users(1, "zhangsan", "123456");
        UsersDAO udao = new UsersDAOImpl();
        Assert.assertEquals(true, udao.usersLogin(u));
    }
}
