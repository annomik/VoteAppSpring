package by.it_academy.jd2.MJD29522.service.api;

import by.it_academy.jd2.MJD29522.dto.VoteDTO;
import by.it_academy.jd2.MJD29522.entity.VoteEntity;

import java.util.List;

public interface IVoteService {
    void save(VoteDTO vote);
    List<VoteEntity> getVote();
}
