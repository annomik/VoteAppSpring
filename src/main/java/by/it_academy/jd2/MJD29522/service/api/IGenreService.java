package by.it_academy.jd2.MJD29522.service.api;

import by.it_academy.jd2.MJD29522.dto.GenreDTO;
import by.it_academy.jd2.MJD29522.dto.GenreWithId;

import java.util.List;
import java.util.Map;

public interface IGenreService {

    List<GenreWithId> get();

    boolean add(GenreDTO genreDTO);

    GenreWithId getCard(long id);

    void update(long id, GenreDTO genreDTO);

    boolean delete(long id);

    boolean exist (long id);

    boolean validate(GenreDTO genreDTO);

    String getName(long id);

}
