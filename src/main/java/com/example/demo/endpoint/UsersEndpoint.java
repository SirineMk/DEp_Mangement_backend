package com.example.demo.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.*;
import com.example.demo.Model.Users;
import com.example.demo.Service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



@Endpoint
public class UsersEndpoint {

    public static final String NAMESPACE_URI = "http://www.example.com/demo/users";

    private UsersService service;

    public UsersEndpoint() {

    }

    @Autowired
    public UsersEndpoint(UsersService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request) {
        GetUserByIdResponse response = new GetUserByIdResponse();
        Users userEntity = service.getEntityById(request.getId());
        UserType userType = new UserType();
        BeanUtils.copyProperties(userEntity, userType);
        response.setUserType(userType);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUserRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers (@RequestPayload GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
        List<UserType> userTypeList = new ArrayList<UserType>();
        List<Users> userEntityList = service.getAllEntities();
        for (Users entity : userEntityList) {
            UserType userType = new UserType();
            BeanUtils.copyProperties(entity, userType);
            userTypeList.add(userType);

        }
        response.getUserType().addAll(userTypeList);

        return response;

    }





}