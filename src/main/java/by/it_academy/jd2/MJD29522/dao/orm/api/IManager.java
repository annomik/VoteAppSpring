package by.it_academy.jd2.MJD29522.dao.orm.api;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public interface IManager {

    EntityManager getEntityManager() throws SQLException;
}
