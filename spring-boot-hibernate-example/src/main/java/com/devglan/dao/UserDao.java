package com.devglan.dao;

import java.util.List;

import com.devglan.model.UserDetails;

public interface UserDao {

    List<UserDetails> getUserDetails();
    List<UserDetails> setUserDetails(int id, String name, double height, double weight);

}
