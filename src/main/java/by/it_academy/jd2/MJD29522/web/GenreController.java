package by.it_academy.jd2.MJD29522.web;

import by.it_academy.jd2.MJD29522.dto.GenreDTO;
import by.it_academy.jd2.MJD29522.dto.GenreWithId;
import by.it_academy.jd2.MJD29522.service.api.IGenreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final IGenreService service;

    public GenreController(IGenreService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<GenreWithId> getAllGenres() {
        return service.get();
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GenreWithId getCard(@PathVariable("id") long genreId) {
        return service.getCard(genreId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(@RequestBody GenreDTO genreDTO) {
        service.add(genreDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void doDelete(@PathVariable("id") long genreId) {
        service.delete(genreId);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") long genreId,
                      @RequestBody GenreDTO genreDTO ){
        service.update(genreId, genreDTO);
    }
}


