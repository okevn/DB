package ua.lviv.iot.DB_Lab.repository;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.model.Country;

@Component
public class CountryRepo extends GeneralRepo<Country> {
    public CountryRepo() {
        super(Country.class);
    }
}
