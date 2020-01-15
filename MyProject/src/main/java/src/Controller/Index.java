package src.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.Mode.User;
import src.Service.UserService;


@RestController
public class Index {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/demo")
    public User index(@RequestParam(name = "id") String id ) {
        return userService.selectUser(id);
    }
}
