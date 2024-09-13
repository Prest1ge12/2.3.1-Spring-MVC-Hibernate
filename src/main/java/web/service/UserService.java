package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(Long id);

    public void saveUser(User user);

    public void update(Long id, User updateUser);

    public void delete(Long id);
}
