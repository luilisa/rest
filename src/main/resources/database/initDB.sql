CREATE TABLE if not exists user_account
(
    id bigserial PRIMARY KEY NOT NULL,
    login character varying(20) NOT NULL,
    password character varying(30) NOT NULL
);

CREATE TABLE if not exists company
(
    id bigserial PRIMARY KEY NOT NULL,
    symbol character varying(5) NOT NULL,
    sector character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    market_cap bigint NOT NULL,
    ipo_year integer NOT NULL,
    country character varying(50) NOT NULL
);

CREATE TABLE if not exists stock
(
    id bigserial PRIMARY KEY NOT NULL,
    symbol character varying(5),
    date timestamp default current_date,
    open_price decimal NOT NULL,
    close_price decimal NOT NULL,
    high_price decimal NOT NULL,
    low_price decimal NOT NULL,
    volume integer NOT NULL,
    current_price decimal NOT NULL,
    company_id bigint REFERENCES company (id)
);

CREATE TABLE if not exists portfolio
(
    id bigserial PRIMARY KEY NOT NULL,
    profitability double precision,
    creation_date timestamp without time zone default current_date,
    name character varying(50) NOT NULL,
    stock_id bigint REFERENCES stock (id),
    user_id bigint REFERENCES user_account (id)
);

create table if not exists added_stocks
(
    stock_id bigint not null references stock (id),
    portfolio_id bigint not null references portfolio (id),
    primary key (stock_id, portfolio_id)
);