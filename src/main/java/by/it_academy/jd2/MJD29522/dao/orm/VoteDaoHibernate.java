package by.it_academy.jd2.MJD29522.dao.orm;

import by.it_academy.jd2.MJD29522.dao.api.IVoteDao;
import by.it_academy.jd2.MJD29522.dao.orm.api.IManager;
import by.it_academy.jd2.MJD29522.entity.GenreEntity;
import by.it_academy.jd2.MJD29522.entity.SingerEntity;
import by.it_academy.jd2.MJD29522.entity.VoteEntity;
import by.it_academy.jd2.MJD29522.dto.VoteDTO;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class VoteDaoHibernate implements IVoteDao {

    private final IManager manager;

    public VoteDaoHibernate(IManager entityManager) {
        this.manager = entityManager;
    }

    @Override
    public List<VoteEntity> getVoteList() {
        EntityManager entityManager = null;
        List<VoteEntity> voteEntityList;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
           voteEntityList = entityManager.createQuery
                    ("FROM VoteEntity ORDER BY id", VoteEntity.class).getResultList();

            entityManager.getTransaction().commit();
            return voteEntityList;
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
    public void save(VoteEntity voteEntity) {
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(voteEntity);
            entityManager.getTransaction().commit();

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

//    @Override
//    public void save(VoteEntity voteEntity) {
//        List <GenreEntity> genres = voteToGenreEntityList(vote);
//        SingerEntity singer = voteToSingerEntity(vote);
//        EntityManager entityManager = null;
//        VoteEntity voteEntity = new VoteEntity(vote.getMessage(),
//               vote.getEmail(),
//                java.util.Date
//                     .from(vote.getLocalDate().atZone(ZoneId.systemDefault()).toInstant()),
//               singer,
//                genres);
//        try {
//            entityManager = manager.getEntityManager();
//            entityManager.getTransaction().begin();
//            entityManager.persist(voteEntity);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            if(entityManager != null){
//                entityManager.getTransaction().rollback();
//            }
//            throw new RuntimeException("Ошибка в базе данных", e);
//        }finally {
//            if(entityManager != null){
//                entityManager.close();
//            }
//        }
//    }

    @Override
    public List <GenreEntity> voteToGenreEntityList (VoteDTO voteDTO){
        List <GenreEntity> genresEntityList = new ArrayList<>();
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            for (long genre : voteDTO.getGenresID()) {
                genresEntityList.add(entityManager.find(GenreEntity.class,genre));
            }
            return genresEntityList;
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
    public SingerEntity voteToSingerEntity (VoteDTO voteDTO){
        EntityManager entityManager = null;
        try {
            entityManager = manager.getEntityManager();
            entityManager.getTransaction().begin();
            return entityManager.find(SingerEntity.class,voteDTO.getSingerID());
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
