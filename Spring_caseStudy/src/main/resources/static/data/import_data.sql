# use account_db;
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",1,"123456789","Nguyen Van A","0905678678",1);
insert into customer(customer_address,customer_birthday,customer_email,customer_gender,customer_id_card,customer_name,customer_phone,customer_type_id) values ("HCM","1990-01-01","abc@abc.com",0,"123456789","Tran B","0905678678",2);

insert into customer_type(customer_type_name) value ("VIP");
insert into customer_type(customer_type_name) value ("PREMIUM");
insert into customer_type(customer_type_name) value ("GOLD");
insert into customer_type(customer_type_name) value ("MEMBER");

insert into service_type(service_type_name) value ('Villa');
insert into service_type(service_type_name) value ('House');
insert into service_type(service_type_name) value ('Room');

insert into rent_type(rent_type_cost, rent_type_name) values(5000,'year');
insert into rent_type(rent_type_cost, rent_type_name) values(3000,'month');
insert into rent_type(rent_type_cost, rent_type_name) values(2000,'day');
insert into rent_type(rent_type_cost, rent_type_name) values(1000,'hour');

insert into service(description_other_convenience, number_of_floors, pool_area, service_area, service_cost, service_max_people, service_name, standard_room, rent_type_id, service_type_id) values ('description here',2,500,10,1000,2,'service1','ok',1,1);
insert into service(description_other_convenience, number_of_floors, pool_area, service_area, service_cost, service_max_people, service_name, standard_room, rent_type_id, service_type_id) values ('description here',3,500,10,1000,2,'service2','ok',2,2);
insert into service(description_other_convenience, number_of_floors, pool_area, service_area, service_cost, service_max_people, service_name, standard_room, rent_type_id, service_type_id) values ('description here',2,500,10,1000,2,'service3','ok',3,3);
insert into service(description_other_convenience, number_of_floors, pool_area, service_area, service_cost, service_max_people, service_name, standard_room, rent_type_id, service_type_id) values ('description here',4,500,10,1000,2,'service4','ok',4,1);
insert into service(description_other_convenience, number_of_floors, pool_area, service_area, service_cost, service_max_people, service_name, standard_room, rent_type_id, service_type_id) values ('description here',2,500,10,1000,2,'service1','ok',1,1);

insert into education_degree(education_degree_name) value ('Intermediate');
insert into education_degree(education_degree_name) value ('College');
insert into education_degree(education_degree_name) value ('University');
insert into education_degree(education_degree_name) value ('Postgraduate education');

insert into division(division_name) value ('Sales-Marketing');
insert into division(division_name) value ('Administration');
insert into division(division_name) value ('Management');

insert into user(username, password) VALUES ('username','123456');
insert into user(username, password) VALUES ('username1','123456');
insert into user(username, password) VALUES ('username2','123456');

insert into employee(employee_address, employee_birthday, employee_email, employee_id_card, employee_name, employee_phone, employee_salary, division_id, education_degree_id, position_id) values ('address','1990-01-01','email@gamil.com','123456789','Pham Van D','0905768678',1000,1,1,1);
insert into employee(employee_address, employee_birthday, employee_email, employee_id_card, employee_name, employee_phone, employee_salary, division_id, education_degree_id, position_id) values ('address','1990-01-01','email@gamil.com','123456789','Bui Thi E','0905768678',1000,2,2,2);
insert into employee(employee_address, employee_birthday, employee_email, employee_id_card, employee_name, employee_phone, employee_salary, division_id, education_degree_id, position_id) values ('address','1990-01-01','email@gamil.com','123456789','Tran Thi F','0905768678',1000,3,3,2);

insert into attach_service(attach_service_cost, attach_service_name, attach_service_status, attach_service_unit) VALUES (1000,'bike rental','rent',1)
insert into attach_service(attach_service_cost, attach_service_name, attach_service_status, attach_service_unit) VALUES (1000,'BBQ','rent',1)
insert into attach_service(attach_service_cost, attach_service_name, attach_service_status, attach_service_unit) VALUES (1000,'Karaoke','rent',1)
