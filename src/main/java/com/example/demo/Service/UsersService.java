package com.example.demo.Service;

import com.example.demo.Model.Users;

import java.util.List;

public interface UsersService {
    public Users getEntityById(long id);
    public Users getEntityByEmail(String email);
    public List<Users> getAllEntities();

}
