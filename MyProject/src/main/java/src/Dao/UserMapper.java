package src.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import src.Mode.User;

@Mapper
public interface  UserMapper {
    User selectUser(@Param("id") String id);
}
