package services;


import model.Users;

import java.util.List;

public interface UserService {

    public Users createUsers(Users user);

    public List<Users> getAll();

    public Users UpdateUsers(Users user);

    public void deleteUsersById(int id);
}
