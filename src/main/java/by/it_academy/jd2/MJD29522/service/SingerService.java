package by.it_academy.jd2.MJD29522.service;

import by.it_academy.jd2.MJD29522.dao.api.ISingerDao;
import by.it_academy.jd2.MJD29522.dto.SingerDTO;
import by.it_academy.jd2.MJD29522.dto.SingerWithId;
import by.it_academy.jd2.MJD29522.entity.SingerEntity;
import by.it_academy.jd2.MJD29522.service.api.ISingerService;
import java.util.ArrayList;
import java.util.List;

public class SingerService implements ISingerService {

    private final ISingerDao singerDao;

    public SingerService(ISingerDao singerDao) {
        this.singerDao = singerDao;
    }

    @Override
    public List<SingerWithId> get() {
        List<SingerEntity> singerEntityList = singerDao.get();
        List<SingerWithId> singerWithIdList = new ArrayList<>();
        for (SingerEntity singerEntity : singerEntityList){
            singerWithIdList.add(new SingerWithId(singerEntity));
        }
        return singerWithIdList;
    }

    @Override
    public boolean add(SingerDTO singerDTO) {
        List<SingerEntity> singerEntityList = singerDao.get();
        for (SingerEntity singerEntity : singerEntityList){
            if (singerDTO.getName().equals(singerEntity.getName() )){
                throw new IllegalArgumentException("Исполнитель с именем " + singerDTO.getName() + " уже есть в списке");
            }
        }
        SingerEntity singerForAdd = new SingerEntity(singerDTO.getName());
        return singerDao.add(singerForAdd);
    }

    @Override
    public SingerWithId getCard(long id) {
        if (singerDao.exist(id)) {
             SingerEntity singerEntity = singerDao.getCard(id);
             SingerWithId singerWithId = new SingerWithId(singerEntity);
             return singerWithId;
        } else {
            throw new IllegalArgumentException("Исполнителя с id " + id + " не нейдено!");
        }
    }

    @Override
    public void update(long id, SingerDTO singerDTO, long version) {
        validate(singerDTO);
            if (singerDao.exist(id)) {
                SingerEntity singerFromDB = singerDao.getCard(id);
                if(singerFromDB.getVersion().equals(version) ) {
                    SingerEntity singerWithNewName = new SingerEntity(id, singerDTO.getName(), version);
                    singerDao.update(singerWithNewName);
                } else{
                    throw new IllegalArgumentException("Версии для исполнителя id " + id + " не совпадают!");
                }
            } else {
                throw new IllegalArgumentException("Исполнителя с id " + id + " для обновления не нейдено!");
            }
    }

    @Override
    public boolean delete(long id) {
        return singerDao.delete(id);
    }

    @Override
    public boolean exist(long id) {
        return this.singerDao.exist(id);
    }

    @Override
    public String getName(long id) {
        return this.singerDao.getName(id);
    }

    @Override
    public boolean validate(SingerDTO singerDTO) {

        List<SingerEntity> singerEntityList = singerDao.get();
        for (SingerEntity singerEntity : singerEntityList) {
            if (singerDTO.getName().equals(singerEntity.getName() )){
                throw new IllegalArgumentException("Исполнитель с именем " + singerDTO.getName() + " уже есть в списке");
            }
        }
        return true;
    }

}
