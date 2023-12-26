package br.com.epet.service;

import br.com.epet.entity.User;
import br.com.epet.exception.EpetException;
import br.com.epet.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserSrv {

    @Autowired
    UserRepo repo;

    public User save(User user) {
        return repo.save(user);
    }

    public User edit(Long id, User user) throws EpetException {
        User edit = this.find(id);
        BeanUtils.copyProperties(user, edit, "id");
        return repo.save(edit);
    }

    public User find(Long id) throws EpetException {
        return repo.findById(id).orElseThrow(() -> new EpetException("User not found."));
    }

    public List<User> list() {
        return repo.findAll();
    }

    public List<User> listComFiltro(String filtro) {
        return repo.findAllComFiltro(filtro);
    }

    public Boolean login(String username, String password) throws EpetException {
        User user = repo.findByName(username).orElseThrow(() -> new EpetException("User not found."));
        if (!Objects.equals(user.getPassword(), password)) {
            throw new EpetException("Wrong password.");
        }
        return Boolean.TRUE;
    }
}
