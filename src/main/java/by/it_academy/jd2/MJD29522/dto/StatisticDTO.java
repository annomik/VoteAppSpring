package by.it_academy.jd2.MJD29522.dto;

import java.util.List;

public class StatisticDTO {


    private final List<StatisticDTOArtist> statisticArtist;
    private final List<StatisticDTOGenre> statisticGenre;
    private final List<StatisticDTOMessage> statisticMessage;


    public StatisticDTO(List<StatisticDTOArtist> statisticArtist,
                        List<StatisticDTOGenre> statisticGenre,
                        List<StatisticDTOMessage> statisticMessage) {
        this.statisticArtist = statisticArtist;
        this.statisticGenre = statisticGenre;
        this.statisticMessage = statisticMessage;
    }

    public List<StatisticDTOArtist> getStatisticArtist() {
        return statisticArtist;
    }

    public List<StatisticDTOGenre> getStatisticGenre() {
        return statisticGenre;
    }

    public List<StatisticDTOMessage> getStatisticMessage() {
        return statisticMessage;
    }

    @Override
    public String toString() {
        return "StatisticDTO{" +
                "statisticArtist=" + statisticArtist +
                ", statisticGenre=" + statisticGenre +
                ", statisticMessage=" + statisticMessage +
                '}';
    }
}
