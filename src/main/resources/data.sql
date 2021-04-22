DELETE
FROM roles;

DELETE
FROM users;

DELETE
FROM userroles;

INSERT INTO roles(roleid, role)
    VALUES (1, 'ADMIN'),
           (2, 'USER');

INSERT INTO users(userid, username, password)
    VALUES (1, 'lindell', 'password'),
           (2, 'jason', 'password');

INSERT INTO userroles(userid, roleid)
    VALUES (1, 1),
           (1, 2),
           (2, 2);
