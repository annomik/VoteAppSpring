package by.it_academy.jd2.MJD29522.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app.artists")
public class SingerEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private  Long id;
    @Column(name = "name")
    private String name;

    public SingerEntity() {
    }
    public SingerEntity(String name) {
        this.name = name;
    }

    public SingerEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerEntity that = (SingerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
