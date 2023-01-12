Créer un set de Room

    -> Mobs
    -> Items
    -> Rooms voisines (auto générées par MAP)

Générer une Map aléatoire

    -> Créer une room de base
    -> Lui donner des voisins
    -> Répéter le process jusqu'à avoir X room
    -> Après avoir créé X room, ajouter une Exit
    

Actions 

    -> Attack, Look, Loot, Move, Use


Attack 

    -> permet d'attaquer les mobs de la room
    -> Utiliser la fonction Attack du joueur
    
    
    
Look 

    -> permet d'obtenir un descriptif de la room
    -> Ajoute d'un boolean "Explorer ?" à la class Room
    
    
    
Loot 

    -> permet de récupérer les golds des mobs notés deads
    -> Transferer au joueur les golds des monstres morts de la room
    -> Supprimer les cadavres de la room
    -> permet de recupérer les items au sol
    -> Supprimer les items de la salle
    -> Ajout d'un inventaire pour utilisation plus tard ? 
    -> Utilisation des items sur le champs ?
    
Move 
     
     -> permet de changer de room
     -> Afficher les différentes directions possibles
     -> Si l'action Look a été éffectuée : afficher tout les voisins et on laisse le choix au joueur d'où il va
     -> Si l'action Look n'a pas été éffectuée : le code choisit pour lui une salle aléatoire  
     
Use 
    
    -> permet d'intéragir avec une room (fonction interact)

GAME START

    -> Générer une map
    -> Déplacer le joueur dans une room aléatoire
    -> Le laisser choisir son action
    -> Le niveau ce fini quand la room exit est clear
