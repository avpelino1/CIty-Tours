CREATE TABLE landmark
(
landmark_id serial NOT NULL,
name varchar(100) NOT NULL,
description varchar,
address varchar,
venue_type varchar(64) NOT NULL,
images varchar[],
pending_approval boolean,

CONSTRAINT pk_landmark_id PRIMARY KEY (landmark_id)

);

----------

CREATE TABLE itinerary
(
itinerary_id serial NOT NULL,
name varchar(64),
starting_point varchar NOT NULL,
destinations int[],
date_of DATE NOT NULL,
user_id int NOT NULL,

CONSTRAINT pk_itinerary_id PRIMARY KEY (itinerary_id),
CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users

);


----------

CREATE TABLE review
(
review_id serial NOT NULL,
title varchar,
description varchar,
thumbs_up int,
thumbs_down int,
share boolean,
landmark_id int,
images varchar[],

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
