//import.sql est un script SQL automatiquement déclenché par hibernate 
// au démarrage de appli (ou test) en mode hibernate.hbm2ddl.auto=create  
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('USD','dollar',1.0)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('GBP','livre',0.9)

INSERT INTO Client(numero,nom,prenom,salaire) VALUES (1,'dupond','eric',2000)
INSERT INTO Client(numero,nom,prenom,salaire) VALUES (2,'durant','alex',2500)