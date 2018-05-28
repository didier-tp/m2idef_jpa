//import.sql est un script SQL automatiquement déclenché par hibernate 
// au démarrage de appli (ou test) en mode hibernate.hbm2ddl.auto=create  
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

INSERT INTO Adresse(idAdresse,rue,codePostal,ville) VALUES (1,'rue 1','75001','Paris')
INSERT INTO Adresse(idAdresse,rue,codePostal,ville) VALUES (2,'rue 2','69000','Lyon')

INSERT INTO Compte(numero,label,solde,client) VALUES (1,'compte courant',250.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (2,'compte epargne',50.7,1)
INSERT INTO Compte(numero,label,solde,client) VALUES (3,'compte courant',0.7,2)