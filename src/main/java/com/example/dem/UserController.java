package com.example.dem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@RestController
public class UserController{
@Autowired
private UserService userservice;

@GetMapping("/{id}")
public Optional<User> getUserById(@PathVariable int id) {
	return userservice.getUserById(id);
}
@GetMapping
public Page<User> getAllUsers(@RequestParam int page,@RequestParam int size,@RequestParam String sortby){
	Pageable p=PageRequest.of(page,size,Sort.by(sortby));
	return userservice.getAllUsers(p);
}

@PostMapping("/createuser")
public User createuser(User user) {
	return userservice.createuser(user);
}

@PutMapping("/updateUser/{id}")
public User updateUser(@PathVariable int id,@RequestBody User userdata) {
	return userservice.updateUser(id,userdata);

}
@DeleteMapping("/deleteuser/{id}")
public void  deleteUser(@PathVariable int id) {
	userservice.deleteUser(id);
	
}
}