package by.it_academy.jd2.MJD29522.dto;

import java.util.List;

public class StatisticDTO {


    private List<StatisticDTOArtistOrGenre> statisticArtist;
    private List<StatisticDTOArtistOrGenre> statisticGenre;
    private List<StatisticDTOMessage> statisticMessage;

    public StatisticDTO() {
    }

    public StatisticDTO(List<StatisticDTOArtistOrGenre> statisticArtist, List<StatisticDTOArtistOrGenre> statisticGenre, List<StatisticDTOMessage> statisticMessage) {
        this.statisticArtist = statisticArtist;
        this.statisticGenre = statisticGenre;
        this.statisticMessage = statisticMessage;
    }

    }
