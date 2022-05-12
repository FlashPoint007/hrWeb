package com.dhu.mapper;

import com.dhu.dto.UserAndEmp;
import com.dhu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//登录验证查询Mapper

@Mapper
@Repository
public interface UserMapper {
    User selectPasswordByName(@Param("userName") String userName);

    int saveUsernameAndPassword(User user);

    List<UserAndEmp> selectAllUser();

    UserAndEmp selectAllUserById(int id);

    void updatePerms(User user);

    User selectUserById(Integer id);

    void updatePassword(User user);

    String selectPermsByName(@Param("userName") String username);

    void delById(Integer id);
}
