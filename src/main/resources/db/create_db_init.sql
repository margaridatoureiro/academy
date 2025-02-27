CREATE TABLE T_TEAM(
                       id bigint PRIMARY KEY,
                       name varchar(255) NOT NULL,
                       product varchar(255) NOT NULL,
                       default_location varchar(255) NOT NULL,
                       created_at timestamp DEFAULT now(),
                       modified_at timestamp
);

CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_ID;

CREATE TABLE T_TEAM_MEMBER(
                              id bigint PRIMARY KEY,
                              name varchar(255) NOT NULL,
                              ctw_id varchar(255) NOT NULL,
                              team_id bigint REFERENCES T_TEAM(id),
                              created_at timestamp DEFAULT now(),
                              modified_at timestamp
);

CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_MEMBER_ID;

CREATE TABLE T_RACK(
                       id bigint PRIMARY KEY,
                       serial_number text NOT NULL UNIQUE,
                       status varchar(20) NOT NULL CHECK (status IN ('AVAILABLE', 'BOOKED', 'UNAVAILABLE')),
                       team_id bigint REFERENCES T_TEAM(id),
                       default_location varchar(255) NOT NULL,
                       created_at timestamp DEFAULT now(),
                       modified_at timestamp
);

CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ID;

CREATE TABLE T_RACK_ASSET(
                             id bigint PRIMARY KEY,
                             asset_tag varchar(255) NOT NULL,
                             rack_id bigint REFERENCES T_RACK(id)
);

CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ASSET_ID;

CREATE TABLE T_BOOKING(
                          id bigint PRIMARY KEY,
                          rack_id bigint REFERENCES T_RACK(id),
                          requester_id bigint REFERENCES T_TEAM_MEMBER(id),
                          book_from timestamp NOT NULL,
                          book_to timestamp NOT NULL,
                          created_at timestamp DEFAULT now(),
                          modified_at timestamp
);

CREATE SEQUENCE IF NOT EXISTS SEQ_BOOKING_ID;