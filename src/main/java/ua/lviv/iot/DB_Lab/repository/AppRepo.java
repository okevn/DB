package ua.lviv.iot.DB_Lab.repository;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.model.App;

@Component
public class AppRepo extends GeneralRepo<App>{

    public AppRepo() {
        super(App.class);
    }
}
