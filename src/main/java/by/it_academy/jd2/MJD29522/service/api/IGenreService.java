package by.it_academy.jd2.MJD29522.service.api;

import by.it_academy.jd2.MJD29522.dto.GenreDTO;
import by.it_academy.jd2.MJD29522.dto.GenreWithId;
import java.util.List;

public interface IGenreService {

    List<GenreWithId> get();

    boolean add(GenreDTO genreDTO);

    GenreWithId getCard(long id);

    void update(long id, GenreDTO genreDTO, long version);

    boolean delete(long id);

    boolean exist (long id);

    boolean validate(GenreDTO genreDTO);

    String getName(long id);

}
