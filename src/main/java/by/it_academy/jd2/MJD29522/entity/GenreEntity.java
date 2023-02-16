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

    @Column(name = "version")
    @Version
    private Long version;

    public GenreEntity() {
    }

    public GenreEntity(Long id, String name, Long version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public GenreEntity(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
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


}
