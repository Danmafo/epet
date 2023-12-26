package br.com.epet.service;

import br.com.epet.entity.Department;
import br.com.epet.entity.Product;
import br.com.epet.exception.EpetException;
import br.com.epet.repository.DepartmentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentSrv {

    @Autowired
    DepartmentRepo repo;

    public Department save(Department department) {
        return repo.save(department);
    }

    public Department edit(Long id, Department department) throws EpetException {
        Department edit = this.find(id);
        BeanUtils.copyProperties(edit, department, "id");
        return edit;
    }

    public Department find(Long id) throws EpetException {
        return repo.findById(id).orElseThrow(() -> new EpetException("Department not found."));
    }

    public List<Department> list() {
        return repo.findAll();
    }

    public List<Department> listAll() {
        return repo.findAll();
    }
}
