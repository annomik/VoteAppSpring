package by.it_academy.jd2.MJD29522.dao.orm;

import by.it_academy.jd2.MJD29522.dao.api.IGenreDao;
import by.it_academy.jd2.MJD29522.dao.orm.api.IManager;
import by.it_academy.jd2.MJD29522.entity.GenreEntity;
import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoHibernate implements IGenreDao {

    private final IManager manager;

    public GenreDaoHibernate(IManager entityManager) {
        this.manager = entityManager;
    }

    @Override
    public List<GenreEntity> get() {
        List<GenreEntity> genres = new ArrayList<>();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            List<GenreEntity> genreEntityList = entityManager.createQuery
                    ("from GenreEntity ORDER BY id", GenreEntity.class).getResultList();
            entityManager.getTransaction().commit();
            genres.addAll(genreEntityList);
            return genres;
        } catch (Exception e) {
            if(entityManager != null){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Ошибка в базе данных", e);
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public GenreEntity getCard(long id) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            GenreEntity genreEntity = entityManager.find(GenreEntity.class, id);

            entityManager.getTransaction().commit();
            return genreEntity;
        } catch (SQLException e) {
                if(entityManager != null){
                    entityManager.getTransaction().rollback();
                }
                throw new RuntimeException("Ошибка в базе данных", e);
        }finally {
            if(entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean add(GenreEntity genreEntity) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(genreEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if(entityManager != null){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Ошибка в базе данных", e);
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void update(GenreEntity genreEntity) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            GenreEntity genreFromDB = entityManager.find(GenreEntity.class, genreEntity.getId());
            if(genreFromDB != null && genreFromDB.getVersion().equals(genreEntity.getVersion())){
                entityManager.merge(genreEntity);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if(entityManager != null && entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Ошибка в базе данных", e);
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public boolean delete(long id) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            GenreEntity genreToRemoved = entityManager.find(GenreEntity.class, id);
            if(genreToRemoved != null){
                entityManager.remove(genreToRemoved);
            }
            entityManager.getTransaction().commit();
            return genreToRemoved != null;
        } catch (Exception e) {
            if(entityManager != null){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Ошибка в базе данных", e);
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public boolean exist(long id) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            GenreEntity genre = entityManager.find(GenreEntity.class, id);
            entityManager.getTransaction().commit();
            return genre != null;

        } catch (Exception e) {
            if(entityManager != null){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Ошибка в базе данных", e);
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public String getName(long id) {
        EntityManager entityManager = null;
        try{
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            GenreEntity genre = entityManager.find(GenreEntity.class, id);
            entityManager.getTransaction().commit();
            if(genre == null){
                throw new IllegalArgumentException("Жанра с id " + id + " не найдено");
            }
            return genre.getName();
//            if(genre != null){
//                return genre.getName();
//            }else throw new IllegalArgumentException("Жанра с id " + id + " не найдено");
        } catch (Exception e) {
            if(entityManager != null){
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Ошибка в базе данных", e);
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
