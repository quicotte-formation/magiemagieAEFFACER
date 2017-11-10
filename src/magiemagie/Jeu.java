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

    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private Joueur joueurEnCours;

    public void passerTour() {

    }

    public void lancerSort() {

        // 1. Affiche les sorts possible pour joueurEnCours
        Carte carteCorneLicorne = new Carte();
        Carte carteBaveCrapaud = new Carte();
        Carte carteMandragore = new Carte();
        Carte carteAileCS = new Carte();
        Carte carteLapisLazuli = new Carte();
        
        carteCorneLicorne.setType(Carte.TypeCarte.CORNE_DE_LICORNE);
        carteBaveCrapaud.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
        carteAileCS.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
        carteLapisLazuli.setType(Carte.TypeCarte.LAPIS_LAZULI);
        carteMandragore.setType(Carte.TypeCarte.MANDRAGORE);
        
        if( this.joueurEnCours.getCartes().contains(carteCorneLicorne) &&
            this.joueurEnCours.getCartes().contains(carteBaveCrapaud) ){
            System.out.println("[1] Invisibilite");
        }
        if( this.joueurEnCours.getCartes().contains(carteCorneLicorne) &&
            this.joueurEnCours.getCartes().contains(carteMandragore) ){
            System.out.println("[2] Filtre d'amour");
        }
        if( this.joueurEnCours.getCartes().contains(carteBaveCrapaud) &&
            this.joueurEnCours.getCartes().contains(carteLapisLazuli) ){
            System.out.println("[3] Hypnose");
        }
        if( this.joueurEnCours.getCartes().contains(carteLapisLazuli) &&
            this.joueurEnCours.getCartes().contains(carteAileCS) ){
            System.out.println("[4] Divination");
        }
        if( this.joueurEnCours.getCartes().contains(carteMandragore) &&
            this.joueurEnCours.getCartes().contains(carteBaveCrapaud) ){
            System.out.println("[5] Sommeil profond");
        }
        
        
        // 2. Saisie sort à lancer
        Scanner scan = new Scanner( System.in );
        String choix = scan.nextLine();
        
        switch(choix){
            case "1":
                sortInvisibilite();
                break;
                
            case "2":
                sortPhiltreAmour();
                break;
                
            case "3":
                sortHypnose();
                break;
                
            case "4":
                sortDivination();
                break;
                
            case "5":
                sortSommeilProfond();
                break;
                
            default:
                System.out.println("Ce sort n'existe pas");
                return;
        }
        
        // 3. Lancement du sort
        
        // 4. Supprime les 2 cartes ayant permis de lancer le sort
    }

    public void menuAction() {

        boolean termine = false;
        do {
            // 1. Afficher menu
            System.out.println("A vous de jouer:" + this.joueurEnCours.getNom());
            System.out.println("Vos cartes:" + this.joueurEnCours.getCartes());
            System.out.print("Actions possibles: [1] lancer un sort [2] passer son tour. Votre choix:");

            Scanner scan = new Scanner(System.in);
            String choix = scan.nextLine();

            // 2. Lance sort ou passe tour
            switch (choix) {

                case "1":
                    this.lancerSort();
                    termine = true;
                    break;

                case "2":
                    this.passerTour();
                    termine = true;
                    break;

                default:
                    System.out.println("Commande invalide");
                    break;
            }
        } while (termine == false);
        
    }

    public void demarrerPartie() {

        // 1. Distribue 7 cartes par joueur
        for (Joueur joueur : joueurs) {

            // Distribue 7 cartes pour le joueur actuel
            for (int i = 0; i < 7; i++) {

                Carte carte = new Carte();

                Random random = new Random();
                int nb = random.nextInt(5);
                switch (nb) {
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

    private void sortInvisibilite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortPhiltreAmour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortHypnose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortDivination() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sortSommeilProfond() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
