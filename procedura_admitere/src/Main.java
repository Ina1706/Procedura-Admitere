import services.UserService;
import services.UserServiceImpl;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;

public class Main {

    public static void main(String args[]) {
        UserService userService = new UserServiceImpl();
        int optiune = 0;
        Scanner inp = new Scanner(System.in);
        userService.incarcareCandidati();
        userService.afisareCandidati();
        userService.incarcaLicee();
        userService.afisareLicee();
        userService.incarcaProfesori();
        userService.afisareProfesori();
        userService.incarcaContestatii();
        userService.vizualizareContestatii();
        File audit = new File("D:/csv/audit.csv");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(audit, true))) {
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
                System.out.println("12 - Vizualizarea statutului unui candidat, dupa CNP");
                System.out.println("11 - Parasire meniu.");
                optiune = inp.nextInt();
                LocalDateTime time = LocalDateTime.now();
                switch (optiune) {
                    case 1:
                        userService.adaugareCandidat();
                        printWriter.print("adaugare_candidat,");
                        printWriter.println(time);
                        break;
                    case 2:
                        userService.afisareCandidati();
                        printWriter.print("afisare_candidati,");
                        printWriter.println(time);
                        break;
                    case 3:
                        userService.afisareCandidatiSpecializare();
                        printWriter.print("afisare_candidati_dupa_specializare,");
                        printWriter.println(time);
                        break;
                    case 4:
                        userService.adaugareProfesor();
                        printWriter.print("adaugare_profesor,");
                        printWriter.println(time);
                        break;
                    case 5:
                        userService.afisareProfesori();
                        printWriter.print("afisare_profesori,");
                        printWriter.println(time);
                        break;
                    case 6:
                        userService.afisareLicee();
                        printWriter.print("afisare_licee,");
                        printWriter.println(time);
                        break;
                    case 7:
                        userService.afisareCandidatiLiceu();
                        printWriter.print("afisare_candidati_dintr_un_liceu,");
                        printWriter.println(time);
                        break;
                    case 8:
                        userService.solicitareContestatie();
                        printWriter.print("solicitare_contestatie,");
                        printWriter.println(time);
                        break;
                    case 9:
                        userService.vizualizareContestatii();
                        printWriter.print("vizualizare_contestatii,");
                        printWriter.println(time);
                        break;
                    case 10:
                        userService.cautareCandidatNumeFamilie();
                        printWriter.print("cautare_candidat_nume_familie,");
                        printWriter.println(time);
                        break;
                    case 12:
                        int cnp = inp.nextInt();
                        userService.statusPersoana(Integer.toString(cnp));
                        printWriter.print("vizualizare_statut_persoana");
                        printWriter.println(time);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
