CREATE TABLE IF NOT EXISTS app.votes
(
    id bigserial,
    about text NOT NULL,
    email text NOT NULL,
    date timestamp without time zone NOT NULL,
    CONSTRAINT votes_pkey PRIMARY KEY (id)
)
