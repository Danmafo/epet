package br.com.epet.repository;

import br.com.epet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    @Query("SELECT u FROM User u " +
            "where u.name LIKE %:filtro%")
    List<User> findAllComFiltro(String filtro);
}
