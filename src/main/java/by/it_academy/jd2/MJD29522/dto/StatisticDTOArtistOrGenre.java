package by.it_academy.jd2.MJD29522.dto;

import java.util.Objects;

public class StatisticDTOArtistOrGenre {
    private final long  id;
    private final String name;
    private long count;

    public StatisticDTOArtistOrGenre(long id, String name) {
        this.id = id;
        this.name = name;
        count = 0;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "StatisticDTOArtistOrGenre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticDTOArtistOrGenre that = (StatisticDTOArtistOrGenre) o;
        return id == that.id && count == that.count && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count);
    }
}
