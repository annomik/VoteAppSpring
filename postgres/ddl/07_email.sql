    CREATE TABLE IF NOT EXISTS app.email
    (
        id bigint NOT NULL,
        email character varying(255),
        lastsendtime bigint,
        message character varying(255),
        sendmessage boolean,
        validateemail boolean,
        CONSTRAINT email_pkey PRIMARY KEY (id)
  )