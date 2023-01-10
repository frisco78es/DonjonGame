Créer un set de Room
    -> Mobs
    -> Items
    -> Rooms voisines (auto généré par MAP)

Générer une Map aléatoire
    -> Créer une room de base
    -> Lui donné des voisins
    -> Répété le process jusqu'a avoir X room
    -> apres avoir créer X room, ajouter une Exit

Actions -> Attack, Look, Loot, Move, Use
Attack -> permet d'attaquer les mobs de la room
    -> Utilisé la fonction Attack du joueur
Look -> permet d'obtenir un descriptif de la room
    -> Ajoute un boolean "Explorer ?" a la class Room
Loot -> permet de récupéré les golds des mobs noté deads
    -> Transfert au joueur les golds des monstres morts de la room
    -> Supprime les cadavres de la room
Move -> permet de changer de room
    -> Afficher les différentes directions possibles
        -> Si l'action Look a été éffectuer : affiche tout les voisins et on laisse le choix au joueur d'ou il va
        -> Si l'action Look n'a pas été éffectuer : le code choisis pour lui une salle aléatoire
Use -> permet de recupérer les items au sol
    -> Supprimer les items de la salle
    -> Ajoute a un inventaire pour utilisation plus tard ? 
    -> Utilisation des items sur le champs ?

GAME START

-> Générer une map
-> Déplacer le joueur dans une room aléatoire
-> Le laisser choisir son action
-> Le niveau ce fini quand la room exit est clear
