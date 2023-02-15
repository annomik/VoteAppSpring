package by.it_academy.jd2.MJD29522.dto;

import java.util.Objects;

public class GenreWithId {

    private long id;
    private GenreDTO genreDTO;

    public GenreWithId() {    }

    public GenreWithId(long id, GenreDTO genreDTO) {
        this.id = id;
        this.genreDTO = genreDTO;
    }

    public GenreDTO getGenreDTO() {
        return genreDTO;
    }

    public void setGenreDTO(GenreDTO genreDTO) {
        this.genreDTO = genreDTO;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GenreWithId{" +
                "id=" + id +
                ", genreDTO=" + genreDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreWithId that = (GenreWithId) o;
        return id == that.id && Objects.equals(genreDTO, that.genreDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genreDTO);
    }
}
