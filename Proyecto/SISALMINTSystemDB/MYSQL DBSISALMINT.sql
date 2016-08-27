DROP database IF EXISTS `DBSISALMINT`; 
create database DBSISALMINT;
use DBSISALMINT;
create table Products(	ProductID varchar(20) primary key,
						ProductName varchar(20) not null,
                        UnitPrice decimal(6,2) not null,
                        UnitsInStock int not null, 
                        Status varchar(2)not null,
                        RegDate Date,
                        CategoryID int not null
                      );
create table Categories(CategoryID int AUTO_INCREMENT primary key,
						CategoryName varchar(20) not null,
                        Status varchar(2)not null
                        );
create table Admin(AdminID int AUTO_INCREMENT primary key,
						User varchar(20)not null,
                        Password varchar(20)not null,
						FirstName varchar(20) not null,
                        LastName varchar(20) not null,
                        Email varchar(40) not null,
                        BirthDate Date not null,
                        Status varchar(5)not null
                        );
alter table Products add foreign key(CategoryID)references Categories(CategoryID);

insert into Admin(User,Password,Firstname,LastName,Email,BirthDate,Status) values('a','a','David','Silva','davidsilva3290@gmail.com','18900101','ACT');