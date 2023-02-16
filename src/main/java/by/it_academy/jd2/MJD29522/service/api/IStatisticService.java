package by.it_academy.jd2.MJD29522.service.api;

import by.it_academy.jd2.MJD29522.dto.*;
import java.util.List;

public interface IStatisticService {
     List<StatisticDTOArtist> getResultSinger();
     List<StatisticDTOGenre> getResultGenre();
     List<StatisticDTOMessage> getResultMessage();
     StatisticDTO getResults();
}
