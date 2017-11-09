/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class Jeu {

    protected ArrayList<Joueur> joueurs = new ArrayList<>();
    protected Joueur joueurEnCours;

    public void passerTour(){
        
    }
    
    public void lancerSort(){
        
    }
    
    public void menuAction(){
        
        // 1. Afficher menu
        System.out.println("A vous de jouer:" + this.joueurEnCours.getNom());
        System.out.println("Vos cartes:" + this.joueurEnCours.getCartes());
        System.out.print("Actions possibles: [1] lancer un sort [2] passer son tour. Votre choix:");
        Scanner scan = new Scanner( System.in );
        String choix = scan.nextLine();
        
        // 2. Lance sort ou passe tour
        switch(choix){
            
            case "1":
                this.lancerSort();
                break;
                
            case "2":
                this.passerTour();
                break;
                
            default:
                System.out.println("Commande invalide");
                break;
        }
    }
    
    public void demarrerPartie() {

        // 1. Distribue 7 cartes par joueur
        for (Joueur joueur : joueurs) {
        
            // Distribue 7 cartes pour le joueur actuel
            for (int i = 0; i < 7; i++) {
                
                Carte carte = new Carte();
                
                Random random = new Random();
                int nb = random.nextInt(5);
                switch(nb){
                    case 0:
                        carte.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
                        break;
                    
                    case 1:
                        carte.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
                        break;
                    
                    case 2:
                        carte.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
                        break;
                        
                    case 3:
                        carte.setType(Carte.TypeCarte.LAPIS_LAZULI);
                        break;
                        
                    case 4:
                        carte.setType(Carte.TypeCarte.MANDRAGORE);
                        break;
                        
                    default:
                        break;
                }
                
                joueur.getCartes().add(carte);
            }
        }

        // 2. Donne la main au 1er joueur
        this.joueurEnCours = this.joueurs.get(0);
        
        // 3. Affiche menu d'action
        this.menuAction();
        
    }

    public void afficherMenuNouveauJoueur() {

        // 1. saisie du nom
        System.out.print("Nom nouveau joueur:");
        Scanner s = new Scanner(System.in);
        String nomJoueur = s.nextLine();

        // 2. crée un joueur et lui set le nom
        Joueur joueur = new Joueur();// Crée joueur
        joueur.setNom(nomJoueur);

        // 3. Ajouts ds liste joueurs
        this.joueurs.add(joueur);
    }

    public void afficherMenuPrincipal() {

        boolean quitter = false;

        while (quitter == false) {

            // Affiche menu
            System.out.println("Menu :");
            System.out.println("------");
            System.out.println("1. Nouveau joueur");
            System.out.println("2. Démarrer partie");
            System.out.println("L. Liste des joueurs");
            System.out.println("3. Quitter");

            // Saisie clavier
            Scanner scanner = new Scanner(System.in);
            String choixUtil = scanner.nextLine();
            switch (choixUtil) {
                case "L":
                    System.out.println(this.joueurs);
                    break;
                case "1":
                    afficherMenuNouveauJoueur();
                    break;
                case "2":
                    demarrerPartie();
                    break;
                case "3":
                    quitter = true;
                    break;
                default:
                    System.out.println("Commande inconnue");
                    break;
            }
        }

    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
