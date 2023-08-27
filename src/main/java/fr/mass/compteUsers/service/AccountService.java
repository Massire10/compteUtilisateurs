package fr.mass.compteUsers.service;

import fr.mass.compteUsers.entity.AppRole;
import fr.mass.compteUsers.entity.AppUser;

import java.util.List;

public interface AccountService {

    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole( AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadByUsername(String username);
    List<AppUser> listUsers();
}
