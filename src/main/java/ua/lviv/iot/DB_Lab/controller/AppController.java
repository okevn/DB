package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.AppDto;
import ua.lviv.iot.DB_Lab.mapper.impl.AppMapper;
import ua.lviv.iot.DB_Lab.model.App;
import ua.lviv.iot.DB_Lab.repository.AppRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apps")
public class AppController {

    final
    AppRepo appRepo;

    final
    AppMapper appMapper;

    public AppController(AppRepo appRepo, AppMapper appMapper) {
        this.appRepo = appRepo;
        this.appMapper = appMapper;
    }
    
    @GetMapping("/{id}")
    public AppDto getById(@PathVariable int id) {
        return appMapper.convertToDto(appRepo.findOne(id));
    }

    @GetMapping("/")
    public List<AppDto> getAll() {
        List<App> apps = appRepo.findAll();
        List<AppDto> appDtos = new ArrayList<>();
        for (App app : apps) {
            appDtos.add(appMapper.convertToDto(app));
        }
        return appDtos;
    }

    @PostMapping
    public void create(@RequestBody AppDto appDto) {
        appRepo.save(appMapper.convertToModel(appDto));
    }

    @PutMapping
    public void update(@RequestBody AppDto appDto) {
        appRepo.update(appMapper.convertToModel(appDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        appRepo.delete(App.builder().id(id).build());
    }
}
