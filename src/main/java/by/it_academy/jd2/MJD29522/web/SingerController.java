package by.it_academy.jd2.MJD29522.web;

import by.it_academy.jd2.MJD29522.dto.SingerDTO;
import by.it_academy.jd2.MJD29522.dto.SingerWithId;
import by.it_academy.jd2.MJD29522.service.api.ISingerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/singer")
public class SingerController  {

    private final ISingerService service;

    public SingerController(ISingerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SingerWithId> getAllSingers()  { return service.get();  }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public SingerWithId getCard(@PathVariable("id") long singerId){
       return service.getCard(singerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(@RequestBody SingerDTO singerDTO) {
        service.add(singerDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void doDelete(@PathVariable("id") long singerId)  {
        service.delete(singerId);
    }

    @RequestMapping(path = "/{id}/version/{version}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") long singerId,
                      @PathVariable("version") long version,
                      @RequestBody SingerDTO singerDTO)  {
        service.update(singerId, singerDTO, version);
    }


}