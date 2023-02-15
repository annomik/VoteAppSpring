package by.it_academy.jd2.MJD29522.dto;

import java.util.Objects;

public class SingerDTO {
    private String name;

    public SingerDTO(String name) {
        this.name = name;
    }

    public SingerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingerDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerDTO singerDTO = (SingerDTO) o;
        return Objects.equals(name, singerDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
