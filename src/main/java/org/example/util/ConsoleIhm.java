package org.example.util;


import org.example.dao.ClientDAO;
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
            System.out.println("4. Afficher tous les utilisateurs");
            System.out.println("5. Créer un compte");
            System.out.println("5. Quitter");
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

                    break;
                case 4:

                    break;
                case 5:
                    createCompte();
                    break;
                case 6:
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
        Boolean statut = false;
        System.out.println("ID du client :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Montant ?");
        int montant = scanner.nextInt();
        operationService.createOperation(id, montant, statut);
    }

}