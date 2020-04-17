CREATE TABLE address (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name varchar(45) DEFAULT NULL,
	number bigint DEFAULT NULL,
	street varchar(150) DEFAULT NULL,
  	city varchar(45) DEFAULT NULL,
  	state varchar(45) DEFAULT NULL,
  	zip_code varchar(5) DEFAULT NULL,
  	id_user BIGINT(20) NOT NULL,
  	constraint fk_user foreign key(id_user) references user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO address VALUES (1, 'Test Address', 1122, 'Firs av alabama', 'City one', 'State one', '12345', 1);
