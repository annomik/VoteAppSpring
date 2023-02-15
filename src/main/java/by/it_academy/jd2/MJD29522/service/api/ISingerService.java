package by.it_academy.jd2.MJD29522.service.api;

import by.it_academy.jd2.MJD29522.dto.SingerDTO;
import by.it_academy.jd2.MJD29522.dto.SingerWithId;
import by.it_academy.jd2.MJD29522.entity.SingerEntity;

import java.util.List;
import java.util.Map;

public interface ISingerService {

   List<SingerWithId> get();

   boolean add(SingerDTO singerDTO);

   SingerWithId getCard(long id);

   void update(long id, SingerDTO singerDTO);

   boolean delete(long id);

   boolean exist(long id);

   boolean validate(SingerDTO singerDTO) ;

   String getName(long id);
}
