package fr.mass.compteUsers;

import fr.mass.compteUsers.entity.AppRole;
import fr.mass.compteUsers.entity.AppUser;
import fr.mass.compteUsers.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class CompteUsersApplication {

	public static void main(String[] args)  {
		SpringApplication.run(CompteUsersApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
			accountService.addNewRole(new AppRole(null,"USER"));
			accountService.addNewRole(new AppRole(null,"ADMIN"));
			accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
			accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
			accountService.addNewRole(new AppRole(null,"BILLS_MANAGER"));

			accountService.addNewUser(new AppUser(null, "user1", "1234", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "admin", "1234", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "user2", "1234", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "user3", "1234", new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "user4", "1234", new ArrayList<>()));

			accountService.addRoleToUser("user1", "USER");
			accountService.addRoleToUser("admin","ADMIN");
			accountService.addRoleToUser("admin", "ADMIN");
			accountService.addRoleToUser("user2", "USER");
			accountService.addRoleToUser("user2", "CUSTOMER_MANAGER");
			accountService.addRoleToUser("user3", "USER");
			accountService.addRoleToUser("user3", "PRODUCT_MANAGER");
			accountService.addRoleToUser("user4", "USER");
			accountService.addRoleToUser("user4", "BILLS_MANAGER");


		};
	}

}
