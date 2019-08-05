package pl.coderslab.charity.services;

import pl.coderslab.charity.entity.User;

public interface UserService {

    User findByUserName(String username);
    void saveUser(User user);


}
