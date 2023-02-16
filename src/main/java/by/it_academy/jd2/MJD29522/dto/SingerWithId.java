package by.it_academy.jd2.MJD29522.dto;

import by.it_academy.jd2.MJD29522.entity.SingerEntity;

import java.util.Objects;

public class SingerWithId {

    private long id;
    private String name;
    private long version;

    public SingerWithId() { }

    public SingerWithId(SingerEntity singerEntity) {
        this.id = singerEntity.getId();
        this.name = singerEntity.getName();
        this.version = singerEntity.getVersion();
    }

    public long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SingerWithId{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerWithId that = (SingerWithId) o;
        return id == that.id && version == that.version && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version);
    }
}
