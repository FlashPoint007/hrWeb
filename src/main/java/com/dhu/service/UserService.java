package com.dhu.service;

import com.dhu.dto.UserAndEmp;
import com.dhu.pojo.User;
import java.util.List;

//User业务层

public interface UserService {
    User selectPasswordByName(String userName);
    void saveUsernameAndPassword(User user);

    List<UserAndEmp> selectAllUser();

    UserAndEmp selectAllUserById(int id);

    void updatePerms(User user);

    User selectUserById(Integer id);

    void updatePassword(User user);

    String selectPermsByName(String username);

    void delById(Integer id);
}
