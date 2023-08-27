package fr.mass.compteUsers.repository;

import fr.mass.compteUsers.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUsername(String username);
}
