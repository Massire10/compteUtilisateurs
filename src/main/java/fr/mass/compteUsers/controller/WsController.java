package fr.mass.compteUsers.controller;

import fr.mass.compteUsers.entity.AppRole;
import fr.mass.compteUsers.entity.AppUser;
import fr.mass.compteUsers.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/mass")
public class WsController {
    private final AccountService accountService;

    public WsController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping(value = "/users")
    public ResponseEntity<List<AppUser>> findAll(){
       List<AppUser> userList = accountService.listUsers();
       return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping(value = "/addUser")
    public AppUser addUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping(value = "/addRole")
    public AppRole addRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }
}
