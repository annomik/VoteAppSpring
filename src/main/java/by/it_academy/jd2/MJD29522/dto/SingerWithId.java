package by.it_academy.jd2.MJD29522.dto;

import java.util.Objects;

public class SingerWithId {

    private long id;
    private SingerDTO singerDTO;

    public SingerWithId() { }

    public SingerWithId(long id, SingerDTO singerDTO) {
        this.id = id;
        this.singerDTO = singerDTO;
    }

    public SingerDTO getSingerDTO() {
        return singerDTO;
    }

    public void setSingerDTO(GenreDTO genreDTO) {
        this.singerDTO = singerDTO;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SingerWithId{" +
                "id=" + id +
                ", singerDTO=" + singerDTO +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerWithId that = (SingerWithId) o;
        return id == that.id && Objects.equals(singerDTO, that.singerDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, singerDTO);
    }
}
