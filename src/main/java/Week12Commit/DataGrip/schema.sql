-- we don't know how to generate root <with-no-name> (class Root) :(

comment on database postgres is 'default administrative connection database';

create table accommodation
(
    id          serial
        primary key,
    type        varchar(32),
    bed_type    varchar(32),
    max_guests  integer,
    description varchar(512)
);

alter table accommodation
    owner to postgres;

create table room_fair
(
    id     serial
        primary key,
    value  double precision,
    season varchar(32)
);

alter table room_fair
    owner to postgres;

create table accommodation_room_fair_relation
(
    id               serial
        primary key,
    accommodation_id integer
        references accommodation,
    room_fair_id     integer
        references room_fair
);

alter table accommodation_room_fair_relation
    owner to postgres;