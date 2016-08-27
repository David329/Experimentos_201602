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
						FirstName varchar(20) not null,
                        LastName varchar(20) not null,
                        Email varchar(20) not null,
                        BirthDate Date not null,
                        Status varchar(2)not null
                        );
alter table Products add foreign key(CategoryID)references Categories(CategoryID);


