package br.com.epet.repository;

import br.com.epet.entity.Product;
import br.com.epet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    @Query("SELECT u FROM tb_product u" +
            "where u.name LIKE %:filtro% ")
    List<User> findAllComFiltro(String filtro);
}
