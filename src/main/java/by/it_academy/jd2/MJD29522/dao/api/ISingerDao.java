package by.it_academy.jd2.MJD29522.dao.api;

import by.it_academy.jd2.MJD29522.entity.SingerEntity;

import java.util.List;

public interface ISingerDao {

    List<SingerEntity> get();

    SingerEntity getCard(long id);

    boolean add(SingerEntity singerEntity);

    void update(SingerEntity singerEntity);

    boolean delete(long id);

    boolean exist(long id);

    String getName(long id);
}
