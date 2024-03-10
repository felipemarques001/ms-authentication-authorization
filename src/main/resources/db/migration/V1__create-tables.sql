CREATE TABLE tb_application (
        id uuid NOT NULL,
        access_key VARCHAR(255) NOT NULL,
        name VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
);

CREATE TABLE tb_group (
    id uuid NOT NULL,
    name VARCHAR(255) NOT NULL,
    application_id uuid,
    PRIMARY KEY (id)
);

CREATE TABLE tb_group_permission (
    group_id uuid NOT NULL,
    permission_id uuid NOT NULL
);

CREATE TABLE tb_permission (
    id uuid NOT NULL,
    active boolean NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tb_user (
    id uuid NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    application_id uuid,
    PRIMARY KEY (id)
);

CREATE TABLE tb_user_group (
    user_id uuid NOT NULL,
    group_id uuid NOT NULL
)