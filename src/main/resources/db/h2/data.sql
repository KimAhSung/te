INSERT INTO USER (id,name,created_date,changed_date) VALUES
('user1','aaaa','20220101','20220101'),
('user2','bbbb','20230101','20230101'),
('user3','cccc','20240101','20240101'),
('user4','dddd','20250101','20250101');

INSERT INTO ROLE (id,name,created_date,changed_date) VALUES
('role1','admin','20220101','20220101'),
('role2','user','20230101','20230101');

INSERT INTO MENU (id,name,created_date,changed_date) VALUES
('menu1','신용','20220101','20220101'),
('menu2','제품','20230101','20230101');

insert into test (id,role_id,menu_id) values
('043c97b3-6200-48cf-bdd6-65b7667ea640','role1','menu1')