package by.it_academy.jd2.MJD29522.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "app.votes")
public class VoteEntity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinTable(
            name="app.vote_artist",
            joinColumns=
            @JoinColumn(name="vote_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="artist_id", referencedColumnName="id")
    )
    private SingerEntity singer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="app.vote_genres",
            joinColumns=
            @JoinColumn(name="vote_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="genre_id", referencedColumnName="id")
    )
    private List<GenreEntity> genres;

    @Column(name = "about")
    private String about;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private LocalDateTime localDateTime;

    public VoteEntity() {
    }

    public VoteEntity(Long id, SingerEntity singer, List<GenreEntity> genres, String about, String email, LocalDateTime localDateTime) {
        this.id = id;
        this.singer = singer;
        this.genres = genres;
        this.about = about;
        this.email = email;
        this.localDateTime = localDateTime;
    }

    public VoteEntity(SingerEntity singer, List<GenreEntity> genres, String about, String email, LocalDateTime localDateTime) {
        this.singer = singer;
        this.genres = genres;
        this.about = about;
        this.email = email;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public SingerEntity getSinger() {
        return singer;
    }

    public List<GenreEntity> getGenre() {
        return genres;
    }

}
