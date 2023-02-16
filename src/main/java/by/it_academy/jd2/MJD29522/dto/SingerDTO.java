package by.it_academy.jd2.MJD29522.dto;

import java.util.Objects;

public class SingerDTO {
    private String name;

    private long version;

    public SingerDTO() {
    }

    public SingerDTO(String name) {
        this.name = name;
    }

    public SingerDTO(String name, long version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "SingerDTO{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerDTO singerDTO = (SingerDTO) o;
        return Objects.equals(name, singerDTO.name) && Objects.equals(version, singerDTO.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, version);
    }

}
