package br.com.epet.controller;

import br.com.epet.entity.User;
import br.com.epet.exception.EpetException;
import br.com.epet.service.UserSrv;
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
@RequestMapping("/user")
public class UserControl {

    @Autowired
    UserSrv srv;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(srv.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> edit(@PathVariable Long id, @RequestBody User user) throws EpetException {
        return ResponseEntity.ok(srv.edit(id, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable Long id) throws EpetException {
        return ResponseEntity.ok(srv.find(id));
    }

    @GetMapping
    public ResponseEntity<Page<User>> list(@RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size,
                                           @RequestParam(defaultValue = "") String filtro) {
        Pageable pageable = PageRequest.of(page, size);
        
        List<User> userList = srv.listComFiltro(filtro);

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), userList.size());

        return ResponseEntity.ok(new PageImpl<>(userList.subList(start, end), pageable, userList.size()));
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) throws EpetException {
        if (srv.login(username, password)) {
            return ResponseEntity.ok("Login success.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }

    }

}
