package ru.eltex.spring;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.eltex.users.*;

@RestController
public class UserController {
	@GetMapping("get_users")
	public List<User> getUsers() {
		return DB.getUsers();
	}
}
