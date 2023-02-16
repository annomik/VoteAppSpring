package by.it_academy.jd2.MJD29522.web;

import by.it_academy.jd2.MJD29522.dto.StatisticDTO;

import by.it_academy.jd2.MJD29522.service.api.IStatisticService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {

    private final IStatisticService statisticService;

    public ResultController(IStatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public StatisticDTO getStatistic() {
        return statisticService.getResults();
    }
}
