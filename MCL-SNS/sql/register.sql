CREATE TABLE MCL_SNS_ACCOUNT (
	mailadress VARCHAR(256) PRIMARY KEY,
	nick_name VARCHAR(256)  NOT NULL UNIQUE,
	last_name VARCHAR(64)  NOT NULL UNIQUE,
	first_name VARCHAR(64)  NOT NULL UNIQUE,
	birthday VARCHAR(64) NOT NULL,
	school_name VARCHAR(256)  NOT NULL,
	solt VARCHAR(256)  NOT NULL UNIQUE,
	hashed_pass VARCHAR(256) NOT NULL
);