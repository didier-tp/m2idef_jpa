//import.sql est un script SQL automatiquement déclenché au démarrage 
//de appli (ou test) en mode hibernate.hbm2ddl.auto = create  
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('USD','dollar',1.0)
INSERT INTO Devise(codeDevise,monnaie,dChange) VALUES ('GBP','livre',0.9)