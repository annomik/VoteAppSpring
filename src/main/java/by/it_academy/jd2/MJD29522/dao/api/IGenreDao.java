package by.it_academy.jd2.MJD29522.dao.api;

import by.it_academy.jd2.MJD29522.entity.GenreEntity;
import java.util.List;

public interface IGenreDao{

    List<GenreEntity> get();

    GenreEntity getCard(long id);

    boolean add(GenreEntity genreEntity);

    void update(GenreEntity genreEntity);

    boolean delete(long id);

    boolean exist(long id);

    String getName(long id);
}
