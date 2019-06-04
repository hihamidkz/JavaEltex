package ru.eltex.spring;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.eltex.database.DB;
import ru.eltex.users.User;

@RestController
public class UserController {
	private final static Logger log = Logger.getLogger(UserController.class);

	@GetMapping("get_users")
	public List<User> getUsers() {
		log.debug("UserController: get_users");
		return DB.getUsers();
	}
}
