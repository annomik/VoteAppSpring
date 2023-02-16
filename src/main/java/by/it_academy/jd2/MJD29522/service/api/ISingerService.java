package by.it_academy.jd2.MJD29522.service.api;

import by.it_academy.jd2.MJD29522.dto.SingerDTO;
import by.it_academy.jd2.MJD29522.dto.SingerWithId;
import java.util.List;

public interface ISingerService {

   List<SingerWithId> get();

   boolean add(SingerDTO singerDTO);

   SingerWithId getCard(long id);

   void update(long id, SingerDTO singerDTO, long version);

   boolean delete(long id);

   boolean exist(long id);

   boolean validate(SingerDTO singerDTO) ;

   String getName(long id);
}
