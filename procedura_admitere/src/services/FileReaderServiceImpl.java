package services;

import domain.entity.*;
import tools.Tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import java.util.Scanner;

public class FileReaderServiceImpl implements FileReaderService {

    public int[] citireCandidati(Candidat[] listaCandidati, Candidat[] listaCandidatiMate, Candidat[] listaCandidatiInfo, Candidat[] listaCandidatiCti, int nrCandidati, int nrCandidatiMate, int nrCandidatiInfo, int nrCandidatiCti) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("D:/csv/cand.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            Liceu l = new Liceu(fields[6], fields[7], fields[8]);
            Bacalaureat b = new Bacalaureat(Double.parseDouble(fields[9]), Double.parseDouble(fields[10]), Double.parseDouble(fields[11]), fields[12]);
            int nrExamene = Integer.parseInt(fields[13]);
            Examene[] examene = new Examene[nrExamene];
            for (int i = 0; i < nrExamene; i++) {
                examene[i] = new Examene(fields[14 + 5 * i], Double.parseDouble(fields[15 + 5 * i]), Double.parseDouble(fields[16 + 5 * i]), fields[17 + 5 * i], fields[18 + 5 * i]);
            }
            listaCandidati[nrCandidati] = new Candidat(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], l, b, nrExamene, examene);
            int[] specializari = listaCandidati[nrCandidati].getSpecializari();
            if (specializari[0] == 1) {
                listaCandidatiMate[nrCandidatiMate] = new Candidat(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], l, b, nrExamene, examene);
                nrCandidatiMate++;
            }

            if (specializari[1] == 1) {
                listaCandidatiInfo[nrCandidatiInfo] = new Candidat(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], l, b, nrExamene, examene);
                nrCandidatiInfo++;
            }

            if (specializari[2] == 1) {
                listaCandidatiCti[nrCandidatiCti] = new Candidat(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], l, b, nrExamene, examene);
                nrCandidatiCti++;
            }

            nrCandidati++;
        }

        int[] numere = new int[4];
        numere[0] = nrCandidati;
        numere[1] = nrCandidatiMate;
        numere[2] = nrCandidatiInfo;
        numere[3] = nrCandidatiCti;
        return numere;
    }

    public int citireLicee(Liceu[] listaLicee, int nrLicee) {
        UserService userService = new UserServiceImpl();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("D:/csv/licee.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            Liceu l = new Liceu(fields[0], fields[1], fields[2]);
            int identic = 0;
            for (int i = 0; i < nrLicee; i++) {
                if (userService.comparaLicee(listaLicee[i], l) != 0)
                    identic = 1;
            }

            if (identic == 0) {
                listaLicee[nrLicee] = l;
                nrLicee++;
            }
        }
        return nrLicee;
    }

    public int citireProfesori(Profesor[] listaProfesori, int nrProfesori){
        UserService userService = new UserServiceImpl();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("D:/csv/profesori.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            listaProfesori[nrProfesori] = new Profesor(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
            nrProfesori++;
        }
        return nrProfesori;
    }

    public void citireContestatii(Candidat[] listaCandidati) {
       Scanner scanner = null;
       int index = -1;
        try {
            scanner = new Scanner(new FileInputStream("D:/csv/contestatii.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            for (int i = 0; i < listaCandidati.length; i++){
                if (fields[0].equals(listaCandidati[i].getCnp())){
                    index = i;
                    break;
                }
            }
            if(index != -1){
                listaCandidati[index].setCerereContestatii(1);
                List<Contestatie> contest = new ArrayList<Contestatie>();
                for (int i = 0; i < listaCandidati[index].getNrOptiuni() * 2; i++){
                    Profesor p = new Profesor(fields[3 + i * 9], fields[4 + i * 9], fields[5 + i * 9], fields[6 + i * 9], fields[7 + i * 9], fields[8 + i * 9], fields[9 + i * 9]);
                    contest.add(new Contestatie(Double.parseDouble(fields[1 + i * 9]), Integer.parseInt(fields[2 + i * 9]), p));
                }
                listaCandidati[index].setContestatii(contest);
            }
        }
    }

}
