package src.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.Dao.UserMapper;
import src.Mode.User;
import src.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(String id) {
        return userMapper.selectUser(id);
    }
}
