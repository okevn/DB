package ua.lviv.iot.DB_Lab.repository;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.model.Info;

@Component
public class InfoRepo extends GeneralRepo<Info> {
    public InfoRepo() {
        super(Info.class);
    }
}
