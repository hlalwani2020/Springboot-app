package BMIpatientapp.dao;

import java.util.List;

import BMIpatientapp.model.UserDetails;

public interface UserDao {

    List<UserDetails> getUserDetails();
    List<UserDetails> setUserDetails(int id, String name, double height, double weight);

}
