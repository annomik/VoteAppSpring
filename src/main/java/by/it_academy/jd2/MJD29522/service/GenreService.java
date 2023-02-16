package by.it_academy.jd2.MJD29522.service;

import by.it_academy.jd2.MJD29522.dao.api.IGenreDao;
import by.it_academy.jd2.MJD29522.dto.GenreDTO;
import by.it_academy.jd2.MJD29522.dto.GenreWithId;
import by.it_academy.jd2.MJD29522.entity.GenreEntity;
import by.it_academy.jd2.MJD29522.service.api.IGenreService;
import java.util.ArrayList;
import java.util.List;


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
            genreWithIdList.add(new GenreWithId(genre));
        }
        return genreWithIdList;
    }

    @Override
    public GenreWithId getCard(long id) {
        if (dao.exist(id)) {
              GenreEntity genreEntity = dao.getCard(id);
              GenreWithId genreWithId = new GenreWithId(genreEntity);
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
    public void update(long id, GenreDTO genreDTO, long version) {
        validate(genreDTO);
            if (dao.exist(id)) {
                GenreEntity genreFromDB = dao.getCard(id);
                   if(genreFromDB.getVersion().equals(version)) {
                       GenreEntity genreWithNewName = new GenreEntity(id, genreDTO.getName(), version);
                       dao.update(genreWithNewName);
                }  else {
                throw new IllegalArgumentException("Версии для жанра " + genreDTO.getName() + " не совпадают!");
            }

            } else {
                throw new IllegalArgumentException("Жанра с id " + id + " для обновления не нейдено!");
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
        return true;
    }
}
