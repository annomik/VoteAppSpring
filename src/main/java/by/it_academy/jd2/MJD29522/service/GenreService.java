package by.it_academy.jd2.MJD29522.service;

import by.it_academy.jd2.MJD29522.dao.api.IGenreDao;
import by.it_academy.jd2.MJD29522.dto.GenreDTO;
import by.it_academy.jd2.MJD29522.dto.GenreWithId;
import by.it_academy.jd2.MJD29522.entity.GenreEntity;
import by.it_academy.jd2.MJD29522.entity.SingerEntity;
import by.it_academy.jd2.MJD29522.service.api.IGenreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenreService implements IGenreService {

    private final IGenreDao dao;

    public GenreService(IGenreDao dao) {
        this.dao = dao;
    }

    @Override
    public List<GenreWithId> get() {
        List<GenreEntity> genreEntityList = dao.get();
        List<GenreWithId> genreWithIdList = new ArrayList<>();
        for (GenreEntity genre : genreEntityList) {
            genreWithIdList.add(new GenreWithId(genre.getId(), new GenreDTO(genre.getName())));
        }
        return genreWithIdList;
    }

    @Override
    public GenreWithId getCard(long id) {
        if (dao.exist(id)) {
              GenreEntity genreEntity = dao.getCard(id);
              GenreWithId genreWithId = new GenreWithId(genreEntity.getId(), new GenreDTO(genreEntity.getName()));
              return genreWithId;
        } else {
            throw new IllegalArgumentException("Жанра с id " + id + " не нейдено!");
        }
    }

    @Override
    public boolean add(GenreDTO genreDTO) {
        List<GenreEntity> genreEntityList = dao.get();
        for (GenreEntity genreEntity : genreEntityList) {
            if (genreDTO.getName().equals(genreEntity.getName() )) {
                throw new IllegalArgumentException("Жанр с именем " + genreDTO.getName() + " уже есть в списке жанров");
            }
        }
        GenreEntity genreForAdd = new GenreEntity(genreDTO.getName());
        return dao.add(genreForAdd);
    }

    @Override
    public void update(long id, GenreDTO genreDTO) {
        if (validate(genreDTO)) {
            if (dao.exist(id)) {
                GenreEntity genreEntity = new GenreEntity(id, genreDTO.getName());
                dao.update(genreEntity);
            } else {
                throw new IllegalArgumentException("Жанра с id " + id + " для обновления не нейдено!");
            }
        }
   }

    @Override
    public boolean delete(long id) { return dao.delete(id); }

    @Override
    public boolean exist(long id) {
        return this.dao.exist(id);
    }

    @Override
    public String getName(long id) {
        return this.dao.getName(id);
    }

    @Override
    public boolean validate(GenreDTO genreDTO) {
        List<GenreEntity> genreEntityList = dao.get();
        for (GenreEntity genreEntity : genreEntityList){
            if (genreDTO.getName().equals(genreEntity.getName() )){
                throw new IllegalArgumentException("Исполнитель с именем " + genreDTO.getName() + " уже есть в списке");
            }
        }

//        List<GenreWithId> genres = get();
//        for (GenreWithId genre : genres) {
//            if (nameForAdd.equals(  genre.getGenreDTO().getName()  )) {
//                throw new IllegalArgumentException("Жанр с именем " + nameForAdd + " уже есть в списке жанров");
//            }
//        }
        return true;
        // }
    }
}
