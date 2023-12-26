package br.com.epet.repository;

import br.com.epet.entity.Product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM tb_product p" +
            "where p.name LIKE %:filtro% ")
    List<Product> findAllComFiltro(String filtro);
}
