-- include all

-- changeset angelomutti:1694561559314-1
CREATE TABLE "users"
(
    "id"        UUID         NOT NULL,
    "email"     VARCHAR(255) NOT NULL,
    "password"  VARCHAR(255) NOT NULL,
    "user_role" SMALLINT,
    "username"  VARCHAR(255) NOT NULL,
    CONSTRAINT "users_pkey" PRIMARY KEY ("id")
);

-- changeset angelomutti:1694561559314-2
ALTER TABLE "users"
    ADD CONSTRAINT "users_email_key" UNIQUE ("email");

-- changeset angelomutti:1694561559314-3
ALTER TABLE "users"
    ADD CONSTRAINT "users_username_key" UNIQUE ("username");
-- liquibase formatted sql


