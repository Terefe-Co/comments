BEGIN;

CREATE TABLE "comments" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "parent_id" BIGINT,
  "author_id" BIGINT NOT NULL,
  "message" VARCHAR NOT NULL,
  "created" TIMESTAMP NOT NULL,
  "modified" TIMESTAMP NOT NULL
);

CREATE TABLE "users" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "name" VARCHAR NOT NULL,
  "username" VARCHAR NOT NULL,
  "created" TIMESTAMP NOT NULL,
  "modified" TIMESTAMP NOT NULL
);

CREATE UNIQUE INDEX "users__username_idx" on "users" ("username");

ALTER TABLE "comments" ADD CONSTRAINT "comments__author_id_fk" foreign key ("author_id") references "users" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;


-- Insert Users
INSERT INTO
  "users" ("name", "username", "created", "modified")
VALUES
  ('John Doe', 'john_doe', NOW (), NOW ());

INSERT INTO
  "users" ("name", "username", "created", "modified")
VALUES
  ('Jane Doe', 'jane_doe', NOW (), NOW ());

COMMIT;
