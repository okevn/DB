package ua.lviv.iot.DB_Lab.repository;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.model.Review;

@Component
public class ReviewRepo extends GeneralRepo<Review> {
    public ReviewRepo() {
        super(Review.class);
    }
}
