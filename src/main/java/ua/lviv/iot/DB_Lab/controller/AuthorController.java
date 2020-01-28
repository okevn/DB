package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.AuthorDto;
import ua.lviv.iot.DB_Lab.mapper.impl.AuthorMapper;
import ua.lviv.iot.DB_Lab.model.Author;
import ua.lviv.iot.DB_Lab.repository.AuthorRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    final
    AuthorRepo authorRepo;

    final
    AuthorMapper authorMapper;

    public AuthorController(AuthorRepo authorRepo, AuthorMapper authorMapper) {
        this.authorRepo = authorRepo;
        this.authorMapper = authorMapper;
    }

    @GetMapping("/{id}")
    public AuthorDto getById(@PathVariable int id) {
        return authorMapper.convertToDto(authorRepo.findOne(id));
    }

    @GetMapping("/")
    public List<AuthorDto> getAll() {
        List<Author> authors = authorRepo.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authors) {
            authorDtos.add(authorMapper.convertToDto(author));
        }
        return authorDtos;
    }

    @PostMapping
    public void create(@RequestBody AuthorDto authorDto) {
        authorRepo.save(authorMapper.convertToModel(authorDto));
    }

    @PutMapping
    public void update(@RequestBody AuthorDto authorDto) {
        authorRepo.update(authorMapper.convertToModel(authorDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        authorRepo.delete(Author.builder().id(id).build());
    }
}
