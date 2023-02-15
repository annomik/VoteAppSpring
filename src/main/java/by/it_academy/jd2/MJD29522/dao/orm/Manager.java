package by.it_academy.jd2.MJD29522.dao.orm;

import by.it_academy.jd2.MJD29522.dao.orm.api.IManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Manager implements IManager {

    private EntityManagerFactory factory;

    public Manager() {
        this.factory = Persistence.createEntityManagerFactory("tutorial");;
    }

    @Override
    public EntityManager getEntityManager(){
        return this.factory.createEntityManager();
    }
}
