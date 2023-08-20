package org.example.util;


import org.example.dao.ClientDAO;
import org.example.dao.CompteBancaireDAO;
import org.example.model.CompteBancaire;
import org.example.model.Operation;
import org.example.service.ClientService;
import org.example.service.CompteBancaireService;
import org.example.service.OperationService;


import java.util.List;
import java.util.Scanner;

public class ConsoleIhm {
    private static ClientService ClientService = new ClientService();

    private static CompteBancaireService compteBancaireService = new CompteBancaireService();

    private ClientDAO clientDAO;
    
    private  static OperationService operationService = new OperationService();

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Créer utilisateur");
            System.out.println("2. Ajouter de l'argent");
            System.out.println("3. Retirer de l'argent");
            System.out.println("4. Afficher tous les opérations");
            System.out.println("5. Créer un compte");
            System.out.println("6. Voir le solde du compte");
            System.out.println("7. Voir mes comptes");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    createOperationDepot();
                    break;
                case 3:
                    createOperationRetrait();
                    break;
                case 4:
                    getOperation();
                    break;
                case 5:
                    createCompte();
                    break;
                case 6:
                    viewCompteBancaire();
                    break;
                case 7:
                    viewAllCompteBancaire();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }

    private static int createUser() {
        System.out.print("Nom  : ");
        String firstName = scanner.nextLine();
        System.out.print("Prenom : ");
        String lastName = scanner.nextLine();
        System.out.println("Numéro de téléphone :");
        String nb_phone = scanner.nextLine();
        ClientService.createPerson(firstName, lastName, nb_phone);
        compteBancaireService.createCompte(ClientService.getPerson(nb_phone).getId());
        return ClientService.getPerson(nb_phone).getId();
    }

    private static void createCompte(){
        System.out.println("ID du client :");
        int id_client = scanner.nextInt();
        compteBancaireService.createCompte(id_client);
    }

    private static void createOperationDepot() {
        Boolean statut = true;

        System.out.print("ID du compte : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        CompteBancaire compteBancaire = compteBancaireService.compteBancaire(id);
        if (compteBancaire == null) {
            System.out.println("Compte bancaire non trouvé !");
            return;
        }

        System.out.print("Montant : ");
        double montant = scanner.nextInt();
        CompteBancaire compteBancaire1 = compteBancaireService.compteBancaire(id);
        double solde = compteBancaire1.getSolde();
        compteBancaire.setSolde(montant + solde);



        if(compteBancaireService.updateCompte(compteBancaire)){
            System.out.println("Dépôt effectué avec succès !");
        }else {
            System.out.println("Erreur !");
        }
        operationService.createOperation(id, montant, statut);
    }

    private static void createOperationRetrait() {
        Boolean statut = false;

        System.out.print("ID du compte : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        CompteBancaire compteBancaire = compteBancaireService.compteBancaire(id);
        if (compteBancaire == null) {
            System.out.println("Compte bancaire non trouvé !");
            return;
        }

        System.out.print("Montant : ");
        double montant = scanner.nextInt();
        CompteBancaire compteBancaire1 = compteBancaireService.compteBancaire(id);
        double solde = compteBancaire1.getSolde();
        compteBancaire.setSolde(solde - montant);



        if(compteBancaireService.updateCompte(compteBancaire)){
            System.out.println("Retrait effectué avec succès !");
        }else {
            System.out.println("Erreur !");
        }
        operationService.createOperation(id, montant, statut);
    }

    private static void getOperation(){
        System.out.println("ID du compte :");
        int id = scanner.nextInt();
        List<Operation> operations = operationService.getOperation(id);
        for (Operation operation : operations) {
            System.out.println();
            if(operation.isStatut() == false) {
                System.out.println("Compte ID: " + id + " - Montant: " + operation.getMontant() + " - Retrait");
            }
            else{
                System.out.println("Compte ID: " + id + " - Montant: " + operation.getMontant() + " - Dépôt");
            }
        }
    }

    private static  void  viewCompteBancaire(){
        System.out.println("ID du compte :");
        int id = scanner.nextInt();
        System.out.println("Le solde de votre compte est de : " + compteBancaireService.compteBancaire(id).getSolde() + "€");
    }

    private  static void viewAllCompteBancaire(){
        System.out.println("ID client : ");
        int id = scanner.nextInt();
        List<CompteBancaire> compteBancaires = compteBancaireService.getAllCompteBancaire(id);
        for (CompteBancaire compteBancaire : compteBancaires) {
            System.out.println();
            System.out.println("ID du compte : " + compteBancaire.getId() + "\nSolde du compte : " + compteBancaire.getSolde() + "€");
            System.out.println();
        }
    }
}