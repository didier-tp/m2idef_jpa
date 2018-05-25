create table Client (numero bigint not null auto_increment, nom varchar(32), prenom varchar(32), salaire double precision, primary key (numero)) engine=InnoDB
create table Compte (numero bigint not null auto_increment, label varchar(255), solde double precision, client bigint, primary key (numero)) engine=InnoDB
create table Devise (codeDevise varchar(6) not null, dchange double precision, monnaie varchar(64), primary key (codeDevise)) engine=InnoDB
create table Pays (codePays varchar(255) not null, nom varchar(255), devise varchar(6), primary key (codePays)) engine=InnoDB
alter table Compte add constraint FKi80y90hf0pkbr33xpxpcl7pbl foreign key (client) references Client (numero)
alter table Pays add constraint FK62tq58js1n8wb5gftxq36xqga foreign key (devise) references Devise (codeDevise)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('USD','dollar',1.0)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('GBP','livre',0.9)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('EUR','euro',1.1)
INSERT INTO Pays(codePays,nom,devise) VALUES ('fr', 'France', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('es', 'Espagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('de', 'Allemagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('it', 'Italie', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('uk', 'Royaume Uni', 'GBP')
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (1,'dupond','eric',2000)
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (2,'durant','alex',2500)
INSERT INTO Compte(numero,label,solde,client) VALUES (1,'compte courant',250.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (2,'compte epargne',50.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (3,'compte courant',0.7,2)
create table Client (numero bigint not null auto_increment, nom varchar(32), prenom varchar(32), salaire double precision, primary key (numero)) engine=InnoDB
create table Compte (numero bigint not null auto_increment, label varchar(255), solde double precision, client bigint, primary key (numero)) engine=InnoDB
create table Devise (codeDevise varchar(6) not null, dchange double precision, monnaie varchar(64), primary key (codeDevise)) engine=InnoDB
create table Pays (codePays varchar(255) not null, nom varchar(255), devise varchar(6), primary key (codePays)) engine=InnoDB
alter table Compte add constraint FKi80y90hf0pkbr33xpxpcl7pbl foreign key (client) references Client (numero)
alter table Pays add constraint FK62tq58js1n8wb5gftxq36xqga foreign key (devise) references Devise (codeDevise)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('USD','dollar',1.0)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('GBP','livre',0.9)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('EUR','euro',1.1)
INSERT INTO Pays(codePays,nom,devise) VALUES ('fr', 'France', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('es', 'Espagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('de', 'Allemagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('it', 'Italie', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('uk', 'Royaume Uni', 'GBP')
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (1,'dupond','eric',2000)
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (2,'durant','alex',2500)
INSERT INTO Compte(numero,label,solde,client) VALUES (1,'compte courant',250.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (2,'compte epargne',50.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (3,'compte courant',0.7,2)
create table Client (numero bigint not null auto_increment, nom varchar(32), prenom varchar(32), salaire double precision, primary key (numero)) engine=InnoDB
create table Compte (numero bigint not null auto_increment, label varchar(255), solde double precision, client bigint, primary key (numero)) engine=InnoDB
create table Devise (codeDevise varchar(6) not null, dchange double precision, monnaie varchar(64), primary key (codeDevise)) engine=InnoDB
create table Pays (codePays varchar(255) not null, nom varchar(255), devise varchar(6), primary key (codePays)) engine=InnoDB
alter table Compte add constraint FKi80y90hf0pkbr33xpxpcl7pbl foreign key (client) references Client (numero)
alter table Pays add constraint FK62tq58js1n8wb5gftxq36xqga foreign key (devise) references Devise (codeDevise)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('USD','dollar',1.0)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('GBP','livre',0.9)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('EUR','euro',1.1)
INSERT INTO Pays(codePays,nom,devise) VALUES ('fr', 'France', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('es', 'Espagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('de', 'Allemagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('it', 'Italie', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('uk', 'Royaume Uni', 'GBP')
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (1,'dupond','eric',2000)
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (2,'durant','alex',2500)
INSERT INTO Compte(numero,label,solde,client) VALUES (1,'compte courant',250.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (2,'compte epargne',50.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (3,'compte courant',0.7,2)
create table Client (numero bigint not null auto_increment, nom varchar(32), prenom varchar(32), salaire double precision, primary key (numero)) engine=InnoDB
create table Compte (numero bigint not null auto_increment, label varchar(255), solde double precision, client bigint, primary key (numero)) engine=InnoDB
create table Devise (codeDevise varchar(6) not null, dchange double precision, monnaie varchar(64), primary key (codeDevise)) engine=InnoDB
create table Pays (codePays varchar(255) not null, nom varchar(255), devise varchar(6), primary key (codePays)) engine=InnoDB
alter table Compte add constraint FKi80y90hf0pkbr33xpxpcl7pbl foreign key (client) references Client (numero)
alter table Pays add constraint FK62tq58js1n8wb5gftxq36xqga foreign key (devise) references Devise (codeDevise)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('USD','dollar',1.0)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('GBP','livre',0.9)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('EUR','euro',1.1)
INSERT INTO Pays(codePays,nom,devise) VALUES ('fr', 'France', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('es', 'Espagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('de', 'Allemagne', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('it', 'Italie', 'EUR')
INSERT INTO Pays(codePays,nom,devise) VALUES ('uk', 'Royaume Uni', 'GBP')
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (1,'dupond','eric',2000)
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (2,'durant','alex',2500)
INSERT INTO Compte(numero,label,solde,client) VALUES (1,'compte courant',250.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (2,'compte epargne',50.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (3,'compte courant',0.7,2)
