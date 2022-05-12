package com.dhu.mapper;

import com.dhu.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface AuthMapper {
    List<Auth> selectAllAuth();
}
