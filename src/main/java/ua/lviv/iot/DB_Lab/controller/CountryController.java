package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.CountryDto;
import ua.lviv.iot.DB_Lab.mapper.impl.CountryMapper;
import ua.lviv.iot.DB_Lab.model.Country;
import ua.lviv.iot.DB_Lab.repository.CountryRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    final
    CountryRepo countryRepo;

    final
    CountryMapper countryMapper;

    public CountryController(CountryRepo countryRepo, CountryMapper countryMapper) {
        this.countryRepo = countryRepo;
        this.countryMapper = countryMapper;
    }

    @GetMapping("/{id}")
    public CountryDto getById(@PathVariable int id) {
        return countryMapper.convertToDto(countryRepo.findOne(id));
    }

    @GetMapping("/")
    public List<CountryDto> getAll() {
        List<Country> countrys = countryRepo.findAll();
        List<CountryDto> countryDtos = new ArrayList<>();
        for (Country country : countrys) {
            countryDtos.add(countryMapper.convertToDto(country));
        }
        return countryDtos;
    }

    @PostMapping
    public void create(@RequestBody CountryDto countryDto) {
        countryRepo.save(countryMapper.convertToModel(countryDto));
    }

    @PutMapping
    public void update(@RequestBody CountryDto countryDto) {
        countryRepo.update(countryMapper.convertToModel(countryDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        countryRepo.delete(Country.builder().id(id).build());
    }
}
