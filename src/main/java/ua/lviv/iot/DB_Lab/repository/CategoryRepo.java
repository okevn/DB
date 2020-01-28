package ua.lviv.iot.DB_Lab.repository;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.model.Category;

@Component
public class CategoryRepo extends GeneralRepo<Category> {
    public CategoryRepo() {
        super(Category.class);
    }
}
