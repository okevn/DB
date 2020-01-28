package ua.lviv.iot.DB_Lab.repository;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.model.User;

@Component
public class UserRepo extends GeneralRepo<User> {

    public UserRepo() {
        super(User.class);
    }
}
