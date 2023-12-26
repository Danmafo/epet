package br.com.epet.service;

import br.com.epet.entity.Product;
import br.com.epet.exception.EpetException;
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

    public Product edit(Long id, Product product) throws EpetException {
        Product edit = this.find(id);
        BeanUtils.copyProperties(edit, product, "id");
        return edit;
    }

    public Product find(Long id) throws EpetException {
        return repo.findById(id).orElseThrow(() -> new EpetException("Product not found."));
    }

    public List<Product> list() {
        return repo.findAll();
    }

    public List<Product> listComFiltro(String filtro) {
        return repo.findAllComFiltro(filtro);
    }

}
