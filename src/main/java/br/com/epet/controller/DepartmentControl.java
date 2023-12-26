package br.com.epet.controller;

import br.com.epet.entity.Department;
import br.com.epet.entity.Product;
import br.com.epet.service.DepartmentSrv;
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
@RequestMapping("/department")
public class DepartmentControl {

    @Autowired
    DepartmentSrv srv;

    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(srv.save(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> edit(@PathVariable Long id, @RequestBody Department department) throws Exception {
        return ResponseEntity.ok(srv.edit(id, department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> find(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(srv.find(id));
    }

    @GetMapping
    public ResponseEntity<Page<Department>> list(@RequestParam(defaultValue = "0") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Department> departmentListList = srv.list();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), departmentListList.size());

        return ResponseEntity.ok(new PageImpl<>(departmentListList.subList(start, end), pageable, departmentListList.size()));
    }

}
