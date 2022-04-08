package controller;



import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
@Profile("prod")
@RequestMapping("/users")
public class ProductionController {

    @Autowired
    private UserService userservice;

    @PostMapping("/user")
    public Users createNewUser(@RequestBody Users body){
        Users response = userservice.createUsers(body);
        return response;

    }
}
