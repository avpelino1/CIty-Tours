CREATE TABLE landmark
(
landmark_id serial NOT NULL,
name varchar(100) NOT NULL,
description varchar,
address varchar,
venue_type varchar(64) NOT NULL,
pending_approval boolean,

CONSTRAINT pk_landmark_id PRIMARY KEY (landmark_id)

);



----------



CREATE TABLE itinerary
(
itinerary_id serial NOT NULL,
name varchar(64),
starting_point varchar NOT NULL,
date_of DATE NOT NULL,
user_id int NOT NULL,
share int,

CONSTRAINT pk_itinerary_id PRIMARY KEY (itinerary_id),
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users

);


----------


CREATE TABLE review
(
review_id serial NOT NULL,
title varchar,
description varchar,
thumbs_up boolean,
thumbs_down boolean,
landmark_id int,

CONSTRAINT pk_review_id PRIMARY KEY (review_id),
CONSTRAINT fk_landmark_id FOREIGN KEY (landmark_id) REFERENCES landmark

);

----------

CREATE TABLE business_hours
(
landmark_id int,
day_of int,
open_time time,
close_time time,

CONSTRAINT fk_landmark_id FOREIGN KEY (landmark_id) REFERENCES landmark,
CONSTRAINT day_of check(day_of > 0 AND day_of < 8)
);

----------

CREATE TABLE destinations
(
itinerary_id int,
landmark_id int,

CONSTRAINT fk_landmark_id FOREIGN KEY (landmark_id) REFERENCES landmark,
CONSTRAINT fk_itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itinerary
);

----------

CREATE TABLE images
(
landmark_id int,
review_id int,
image_url varchar,

CONSTRAINT fk_landmark_id FOREIGN KEY (landmark_id) REFERENCES landmark,
CONSTRAINT fk_review_id FOREIGN KEY (review_id) REFERENCES review

);

CREATE TABLE accessibility
(
itinerary_id int,
user_id int,

CONSTRAINT fk_itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itinerary,
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users

);

ALTER TABLE review DROP COLUMN share;
ALTER TABLE itinerary ADD COLUMN share int;