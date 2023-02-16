package by.it_academy.jd2.MJD29522.dto;

import by.it_academy.jd2.MJD29522.entity.GenreEntity;

import java.util.Objects;

public class GenreWithId {

    private long id;
    private String name;
    private long version;

    public GenreWithId() {    }

    public GenreWithId(GenreEntity genreEntity) {
        this.id = genreEntity.getId();
        this.name = genreEntity.getName();
        this.version = genreEntity.getVersion();
    }

    public String getName() {
        return name;
    }

    public long getVersion() {
        return version;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreWithId that = (GenreWithId) o;
        return id == that.id && version == that.version && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version);
    }

    @Override
    public String toString() {
        return "GenreWithId{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
