package br.com.epet.service;

import br.com.epet.entity.Product;
import br.com.epet.repository.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSrv {

    @Autowired
    ProductRepo repo;

    public Product save(Product product) {
        return repo.save(product);
    }

    public Product edit(Long id, Product product) throws Exception {
        Product edit = this.find(id);
        BeanUtils.copyProperties(edit, product, "id");
        return edit;
    }

    public Product find(Long id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("Product not found."));
    }

    public List<Product> list() {
        return repo.findAll();
    }

}
