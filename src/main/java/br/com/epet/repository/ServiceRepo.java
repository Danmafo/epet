package br.com.epet.repository;

import br.com.epet.entity.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepo extends JpaRepository<Service, Long> {

    @Query("SELECT s FROM Service s " +
            "where s.name LIKE %:filtro%")
    List<Service> findAllComFiltro(String filtro);
}
