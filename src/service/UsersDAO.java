package service;

import entity.Users;

public interface UsersDAO {
    //用户登录方法
    boolean usersLogin(Users u);
}
