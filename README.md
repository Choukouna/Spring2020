Compte rendu TP3
==

Parite 1 : Injection de dépendances
--

Lancement du projet
-

<p>
    Pour lancer le projet, il suffit d'exécuter la classe <em>SampleSimpleApplication</em> du projet <em>spring-boot-sample-simple-standalone</em> <br>
    Ceci représente le point d'entrée du projet, puis spring résout les dépendances via l'injection de dépendances et les méthodes des différentes classes sont appelées en chaine 
    (trace d'appel à la sortie standard) 
</p>

Partie 2 : Spring AOP
--

Lancement du projet
-

<p>
    Pour lancer le projet, il suffit d'exécuter la classe <em>SampleSimpleApplication</em> du projet <em>spring-boot-sample-aop</em> <br>
    La classe mettant en oeuvre l'AOP est <em>ServiceMonitor</em> du package <em>monitor</em><br>
</p>

Partie 3 : Spring-data
--

Lancement du projet
-

* Lancer un container mysql 8.0 ainsi : <em>docker run --name myContainer -e -p 3306:3306 MYSQL_ROOT_PASSWORD=mdp -d mysql:8.0</em>
* Se connecter au container via bash : <em>docker exec -it myContainer bash</em>
* Se connecter au serveur mysql : mysql -u root -p
* saisir le mot de passe qui est <em>mdp</em>
* Créer la base de données : <em> create database testspringdata; </em>
* Lancer l'application en exécutant la classe <em>SampleDataJpaApplication</em>

Tester l'application
-

<p>
    Le modèle métier a été complétement intégré avec spring-data. Pour le tester on peut utiliser les services rest mis en place pour accéder aux ressources du modèle ! Ainsi via postman, on peut :
</p>

* Créer un nouveau kanban : (http:://localhost:8080/create/tableau) en décrivant en json un tableau au sein du body de la request;
* Récupérer la liste des tableaux : (http:://localhost:8080/tableaux);
* Ces opérations de création et de récupération en entier sont disponibles pour toutes les ressources;
* On peut chercher une card par son libelle (usage de findByLibelle dont l'implémentation est générée par spring-data) : [FindCardByLibelle](http:://localhost:8080/card/{libelle});
* Un tel accès par attribut est défini pour toutes les ressources selon leurs attributs;
* L'AOP pour logger tous les appels rest effectués est implémenté dans la classe <em>RestLogger</em> du package <em>metrics</em>