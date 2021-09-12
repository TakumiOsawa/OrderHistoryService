CREATE DATABASE IF NOT EXISTS views;

USE views;

DROP TABLE IF EXISTS views;
DROP TABLE IF EXISTS order_line_items;

CREATE TABLE views
(
    order_id bigint NOT NULL,
    order_state varchar(32) NOT NULL,
    order_version int NOT NULL,
    restaurant_name bigint,
    PRIMARY KEY (order_id)
);

CREATE TABLE order_line_items
(
    views_views_id bigint NOT NULL,
    quantity bigint NOT NULL,
    menu_item_id varchar(32) NOT NULL,
    menu_item_name varchar(32) NOT NULL,
    price bigint NOT NULL
);