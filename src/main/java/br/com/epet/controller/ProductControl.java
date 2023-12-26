package br.com.epet.controller;

import br.com.epet.entity.Product;
import br.com.epet.exception.EpetException;
import br.com.epet.service.ProductSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControl {

    @Autowired
    ProductSrv srv;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(srv.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Long id, @RequestBody Product product) throws EpetException {
        return ResponseEntity.ok(srv.edit(id, product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> find(@PathVariable Long id) throws EpetException {
        return ResponseEntity.ok(srv.find(id));
    }

    @GetMapping
    public ResponseEntity<Page<Product>> list(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size,
                                              @RequestParam String filtro) {
        Pageable pageable = PageRequest.of(page, size);
    
        List<Product> productList;
        if (filtro == null) {
            productList = srv.list();
        } else {
            productList = srv.listComFiltro(filtro);
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), productList.size());

        return ResponseEntity.ok(new PageImpl<>(productList.subList(start, end), pageable, productList.size()));
    }

}
