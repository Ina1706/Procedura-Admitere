import java.util.Scanner;

public class Main {

    public static void  main( String args[] )
    {
        UserService userService = new UserServiceImpl();
        int optiune = 0;
        Scanner inp = new Scanner(System.in);

        while (optiune != 11) {
            System.out.println("Alegeti: ");
            System.out.println("1 - Adaugare candidat;");
            System.out.println("2 - Vizualizare lista candidati;");
            System.out.println("3 - vizualizarea listei candidatilor care au optat pentru o specializare anume;");
            System.out.println("4 - Adaugare profesor; ");
            System.out.println("5 - Vizualizare lista profesori");
            System.out.println("6 - Vizualizarea listei cu liceele din care provin candidatii inscrisi");
            System.out.println("7 - Vizualizarea listei candidatilor care provin dintr-un anumit liceu;");
            System.out.println("8 - Solicitare contestatie pentru un candidat deja introdus;");
            System.out.println("9 - Vizualizarea listei cu rezolvarea contestatiilor");
            System.out.println("10 - Cautare candidat dupa numele de familie");
            System.out.println("11 - Parasire meniu.");
            optiune = inp.nextInt();
            switch(optiune) {
                case 1: userService.adaugareCandidat(); break;
                case 2: userService.afisareCandidati(); break;
                case 3: userService.afisareCandidatiSpecializare(); break;
                case 4: userService.adaugareProfesor(); break;
                case 5: userService.afisareProfesori(); break;
                case 6: userService.afisareLicee(); break;
                case 7: userService.afisareCandidatiLiceu(); break;
                case 8: userService.solicitareContestatie(); break;
                case 9: userService.vizualizareContestatii(); break;
                case 10: userService.cautareCandidatNumeFamilie(); break;
            }
        }
    }
}
