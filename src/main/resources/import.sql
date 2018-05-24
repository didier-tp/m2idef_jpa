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