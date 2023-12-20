package br.com.epet.service;

import br.com.epet.entity.User;
import br.com.epet.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSrv {

    @Autowired
    UserRepo repo;

    public User save(User user) {
        return repo.save(user);
    }

    public User edit(Long id, User user) throws Exception {
        User edit = this.find(id);
        BeanUtils.copyProperties(edit, user, "id");
        return edit;
    }

    public User find(Long id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("User not found."));
    }

    public List<User> list() {
        return repo.findAll();
    }

}
