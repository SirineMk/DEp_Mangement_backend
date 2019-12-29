package com.example.demo.Repository;

import com.example.demo.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    public Users findByEmail(String email);
}
