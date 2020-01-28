package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.ReviewDto;
import ua.lviv.iot.DB_Lab.mapper.impl.ReviewMapper;
import ua.lviv.iot.DB_Lab.model.Review;
import ua.lviv.iot.DB_Lab.repository.ReviewRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    final
    ReviewMapper reviewMapper;

    final
    ReviewRepo reviewRepo;

    public ReviewController(ReviewMapper reviewMapper, ReviewRepo reviewRepo) {
        this.reviewMapper = reviewMapper;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/{id}")
    public ReviewDto getById(@PathVariable int id) {
        return reviewMapper.convertToDto(reviewRepo.findOne(id));
    }

    @GetMapping("/")
    public List<ReviewDto> getAll() {
        List<Review> users = reviewRepo.findAll();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review user : users) {
            reviewDtos.add(reviewMapper.convertToDto(user));
        }
        return reviewDtos;
    }

    @PostMapping
    public void create(@RequestBody ReviewDto reviewDto) {
        reviewRepo.save(reviewMapper.convertToModel(reviewDto));
    }

    @PutMapping
    public void update(@RequestBody ReviewDto reviewDto) {
        reviewRepo.save(reviewMapper.convertToModel(reviewDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewRepo.delete(Review.builder().id(id).build());
    }
}
