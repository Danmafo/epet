package br.com.epet.controller;

import br.com.epet.entity.Service;
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
@RequestMapping("/service")
public class ServiceControl {

    @Autowired
    ServiceSrv srv;

    @PostMapping
    public ResponseEntity<Service> save(@RequestBody Service service) {
        return ResponseEntity.status(HttpStatus.CREATED).body(srv.save(service));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> edit(@PathVariable Long id, @RequestBody Service service) throws Exception {
        return ResponseEntity.ok(srv.edit(id, service));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> find(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(srv.find(id));
    }

    @GetMapping
    public ResponseEntity<Page<Service>> list(@RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Service> serviceList = srv.list();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), serviceList.size());

        return ResponseEntity.ok(new PageImpl<>(serviceList.subList(start, end), pageable, serviceList.size()));
    }

}
