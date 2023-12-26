package br.com.epet.service;

import br.com.epet.entity.Department;
import br.com.epet.entity.Product;
import br.com.epet.entity.Role;
import br.com.epet.exception.EpetException;
import br.com.epet.repository.RoleRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleSrv {

    @Autowired
    RoleRepo repo;

    public Role save(Role role) {
        return repo.save(role);
    }

    public Role edit(Long id, Role role) throws EpetException {
        Role edit = this.find(id);
        BeanUtils.copyProperties(edit, role, "id");
        return edit;
    }

    public Role find(Long id) throws EpetException {
        return repo.findById(id).orElseThrow(() -> new EpetException("Role not found."));
    }

    public List<Role> list() {
        return repo.findAll();
    }

    public List<Role> listAll() {
        return repo.findAll();
    }
}
