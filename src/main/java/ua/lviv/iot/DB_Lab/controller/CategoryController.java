package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.CategoryDto;
import ua.lviv.iot.DB_Lab.mapper.impl.CategoryMapper;
import ua.lviv.iot.DB_Lab.model.Category;
import ua.lviv.iot.DB_Lab.repository.CategoryRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    final
    CategoryRepo categoryRepo;

    final
    CategoryMapper categoryMapper;

    public CategoryController(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable int id) {
        return categoryMapper.convertToDto(categoryRepo.findOne(id));
    }

    @GetMapping("/")
    public List<CategoryDto> getAll() {
        List<Category> categorys = categoryRepo.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categorys) {
            categoryDtos.add(categoryMapper.convertToDto(category));
        }
        return categoryDtos;
    }

    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto) {
        categoryRepo.save(categoryMapper.convertToModel(categoryDto));
    }

    @PutMapping
    public void update(@RequestBody CategoryDto categoryDto) {
        categoryRepo.update(categoryMapper.convertToModel(categoryDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryRepo.delete(Category.builder().id(id).build());
    }
}
