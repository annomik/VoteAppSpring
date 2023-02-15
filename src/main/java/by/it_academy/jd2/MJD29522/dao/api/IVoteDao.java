package by.it_academy.jd2.MJD29522.dao.api;

import by.it_academy.jd2.MJD29522.entity.GenreEntity;
import by.it_academy.jd2.MJD29522.entity.SingerEntity;
import by.it_academy.jd2.MJD29522.entity.VoteEntity;
import by.it_academy.jd2.MJD29522.dto.VoteDTO;
import java.util.List;

public interface IVoteDao {

    List<VoteEntity> getVoteList();

    void save(VoteEntity voteEntity);

    SingerEntity voteToSingerEntity (VoteDTO voteDTO);
    List <GenreEntity> voteToGenreEntityList (VoteDTO voteDTO);
}
