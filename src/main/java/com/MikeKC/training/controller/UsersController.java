package com.MikeKC.training.controller;

import com.MikeKC.training.NoFoundException;
import com.MikeKC.training.model.Users;
import com.MikeKC.training.repositiry.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJPARepository userJPARepository;

    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return userJPARepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name) {
        return userJPARepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users) {
        userJPARepository.save(users);
        return userJPARepository.findByName(users.getName());
    }

    @GetMapping (value = "/find{id}")
    public Optional<Users> findById (@PathVariable ("id") Long id) {
        return userJPARepository.findById(id);
    }

    @DeleteMapping(value = "/del/{id}")
    public void delete(@PathVariable("id") Long id) {
        if (!userJPARepository.findById(id).isPresent()) {
            throw new NoFoundException();
        }
        userJPARepository.deleteById(id); // Как дополнительно вернуть нужный HTTPStatus?
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String noPage() {
        return "Отработан метод noPage и HttpStatus.NO_CONTENT";
    }


}
