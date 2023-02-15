package by.it_academy.jd2.MJD29522.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app.genres")
public class GenreEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private  Long id;
    @Column(name = "name")
    private String name;

    public GenreEntity() {
    }

    public GenreEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreEntity(String name) {
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
        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
