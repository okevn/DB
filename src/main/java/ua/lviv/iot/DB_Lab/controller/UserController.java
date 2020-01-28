package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.UserDto;
import ua.lviv.iot.DB_Lab.mapper.impl.UserMapper;
import ua.lviv.iot.DB_Lab.model.User;
import ua.lviv.iot.DB_Lab.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    final
    UserRepo userRepo;

    final
    UserMapper userMapper;

    public UserController(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id) {
        return userMapper.convertToDto(userRepo.findOne(id));
    }

    @GetMapping("/")
    public List<UserDto> getAll() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(userMapper.convertToDto(user));
        }
        return userDtos;
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
        userRepo.save(userMapper.convertToModel(userDto));
    }

    @PutMapping
    public void update(@RequestBody UserDto userDto) {
        userRepo.save(userMapper.convertToModel(userDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userRepo.delete(User.builder().id(id).build());
    }
}
