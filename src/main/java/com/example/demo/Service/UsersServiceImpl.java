package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import com.example.demo.Model.Users;
import com.example.demo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    private UsersRepository repository;

    public UsersServiceImpl(){}

    @Autowired
    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Users getEntityById(long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Users getEntityByEmail(String title) {
        return this.repository.findByEmail(title);
    }

    @Override
    public List < Users > getAllEntities() {
        List < Users > list = new ArrayList < > ();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }


}
