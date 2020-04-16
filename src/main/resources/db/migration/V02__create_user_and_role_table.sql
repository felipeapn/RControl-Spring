CREATE TABLE user (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	password varchar(255) DEFAULT NULL,
	first_name varchar(45) DEFAULT NULL,
  	last_name varchar(45) DEFAULT NULL,
  	email varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE role (
        id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
        role VARCHAR(255) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
  
CREATE TABLE user_role (
       id_user bigint not null,
       id_role bigint not null,
       primary key (id_user, id_role),
       constraint fk_permissao foreign key(id_role) references role(id),
       constraint fk_usuario foreign key(id_user) references user(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
-- New users
INSERT INTO user VALUES (1, '$2a$10$RQplAzVNaPqKfts4F6rP2eKedAoto3O6lfTw.uRvwRbA42kYoBsiW', 'Felipe', 'Nunes', 'felipenumes@ranking.com');
INSERT INTO user VALUES (2, '$2a$10$RQplAzVNaPqKfts4F6rP2eKedAoto3O6lfTw.uRvwRbA42kYoBsiW', 'Lucas', 'Brum', 'brum@ranking.com');

-- Roles types
INSERT INTO role (id, role) values (1, 'ROLE_ADMIN');
INSERT INTO role (id, role) values (2, 'ROLE_CLIENT');
INSERT INTO role (id, role) values (3, 'ROLE_EMPLOYEE');

-- Users x roles
INSERT INTO user_role (id_user, id_role) VALUES (1, 1);
INSERT INTO user_role (id_user, id_role) VALUES (1, 2);
INSERT INTO user_role (id_user, id_role) VALUES (1, 3);

INSERT INTO user_role (id_user, id_role) VALUES (2, 2);



	
