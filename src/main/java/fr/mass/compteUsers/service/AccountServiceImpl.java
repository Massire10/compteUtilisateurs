package fr.mass.compteUsers.service;

import fr.mass.compteUsers.entity.AppRole;
import fr.mass.compteUsers.entity.AppUser;
import fr.mass.compteUsers.repository.AppRoleRepository;
import fr.mass.compteUsers.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository,
                              AppRoleRepository appRoleRepository,
                              PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        // Ici, on va encoder le mot de passe
        String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        // On sauvergarde le mot de passe encodé dans la base
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {

        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        // On ajoute le role aux utilisateurs
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public AppUser loadByUsername(String username) {

        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {

        return appUserRepository.findAll();
    }
}
