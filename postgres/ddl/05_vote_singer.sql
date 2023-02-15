CREATE TABLE IF NOT EXISTS app.vote_artist
(
    artist_id bigint,
    vote_id bigint,
    CONSTRAINT vote_artist_vote_id_key UNIQUE (vote_id),
    CONSTRAINT vote_artist_artist_id_fkey FOREIGN KEY (artist_id)
        REFERENCES app.artists (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT vote_artist_vote_id_fkey FOREIGN KEY (vote_id)
        REFERENCES app.votes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
