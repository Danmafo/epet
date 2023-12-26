package br.com.epet.service;

import br.com.epet.entity.Service;
import br.com.epet.repository.ServiceRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceSrv {

    @Autowired
    ServiceRepo repo;

    public Service save(Service service) {
        return repo.save(service);
    }

    public Service edit(Long id, Service service) throws Exception {
        Service edit = this.find(id);
        BeanUtils.copyProperties(edit, service, "id");
        return edit;
    }

    public Service find(Long id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("Service not found."));
    }

    public List<Service> list() {
        return repo.findAll();
    }

}