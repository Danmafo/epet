package br.com.epet.controller;

import br.com.epet.entity.Role;
import br.com.epet.entity.Service;
import br.com.epet.exception.EpetException;
import br.com.epet.service.RoleSrv;
import br.com.epet.service.ServiceSrv;
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
@RequestMapping("/role")
public class RoleControl {

    @Autowired
    RoleSrv srv;

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(srv.save(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> edit(@PathVariable Long id, @RequestBody Role role) throws EpetException {
        return ResponseEntity.ok(srv.edit(id, role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> find(@PathVariable Long id) throws EpetException {
        return ResponseEntity.ok(srv.find(id));
    }

    @GetMapping
    public ResponseEntity<Page<Role>> list(@RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Role> roleList = srv.list();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), roleList.size());

        return ResponseEntity.ok(new PageImpl<>(roleList.subList(start, end), pageable, roleList.size()));
    }

}
