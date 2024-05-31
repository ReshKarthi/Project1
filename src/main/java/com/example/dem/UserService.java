package com.example.dem;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
public class UserService {
	@Autowired
	private UserRepository userrep;
	
public User createuser(User user) {
return userrep.save(user);
}
public Page<User> getAllUsers(Pageable p){
	return userrep.findAll(p);
}

public Optional<User> getUserById(int id) {
	return userrep.findById(id);
}

public User updateUser(int id,User userdata) {
	User user=userrep.findById(id).orElseThrow(()-> new IllegalArgumentException("Cannot Find by id" +id));
user.setId(userdata.getId());
user.setName(userdata.getName());
user.setEmail(userdata.getEmail());
return userrep.save(user);
}
public void deleteUser(int id) {
	userrep.deleteById(id);
}
}