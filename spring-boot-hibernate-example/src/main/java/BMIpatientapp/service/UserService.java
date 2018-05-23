/**
 *
 */
package BMIpatientapp.service;

import java.util.List;

import BMIpatientapp.model.UserDetails;

public interface UserService {

	List<UserDetails> getUserDetails();
    List<UserDetails> setUserDetails(int id, String name, double height, double weight);

}
