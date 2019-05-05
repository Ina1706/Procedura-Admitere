package services;

import domain.entity.Candidat;
import domain.entity.Liceu;
import domain.entity.Profesor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterServiceImpl implements FileWriterService {
    public void adaugareCandidat(Candidat c) {
        File candidati = new File("D:/csv/cand.csv");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(candidati, true))) {
            //printWriter.println();
            printWriter.print(c.getNume() + ",");
            printWriter.print(c.getPrenume() + ",");
            printWriter.print(c.getCnp() + ",");
            printWriter.print(c.getAdresa() + ",");
            printWriter.print(c.getNrTelefon() + ",");
            printWriter.print(c.getEmail() + ",");
            printWriter.print(c.getLiceu().getNume() + ",");
            printWriter.print(c.getLiceu().getAdresa() + ",");
            printWriter.print(c.getLiceu().getLocalitate() + ",");
            printWriter.print(c.getBac().getNotaRomana() + ",");
            printWriter.print(c.getBac().getNotaProbaProfil() + ",");
            printWriter.print(c.getBac().getNotaProbAlegere() + ",");
            printWriter.print(c.getBac().getTipProbaProfil() + ",");
            printWriter.print(c.getNrOptiuni() + ",");
            for (int i = 0; i < c.getNrOptiuni(); i ++){
                printWriter.print(c.getOptiuni()[i].getNumeSpecializare() + ",");
                printWriter.print(c.getOptiuni()[i].getNota1() + ",");
                printWriter.print(c.getOptiuni()[i].getNota2() + ",");
                printWriter.print(c.getOptiuni()[i].getNumeDisciplina1() + ",");
                printWriter.print(c.getOptiuni()[i].getNumeDisciplina2() + ",");
            }
            printWriter.println();
            UserService userService = new UserServiceImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adaugareLiceu(Liceu l){

        File licee = new File("D:/csv/licee.csv");
        System.out.println("Intra");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(licee, true))) {
            printWriter.println();
            printWriter.print(l.getNume() + ",");
            printWriter.print(l.getAdresa() + ",");
            printWriter.print(l.getLocalitate() + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adaugareProfesor(Profesor p){
        File profesori = new File("D:/csv/profesori.csv");
        System.out.println("Intra");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(profesori, true))) {
            printWriter.println();
            printWriter.print(p.getNume() + ",");
            printWriter.print(p.getPrenume() + ",");
            printWriter.print(p.getCnp() + ",");
            printWriter.print(p.getAdresa() + ",");
            printWriter.print(p.getNrTelefon() + ",");
            printWriter.print(p.getEmail() + ",");
            printWriter.print(p.getSpecializare() + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adaugareContestatie(Candidat c){
        File contestatii = new File("D:/csv/contestatii.csv");
        System.out.println("INTRA IN MM");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(contestatii, true))) {
            printWriter.println();
            printWriter.print(c.getCnp() + ",");
            for (int i = 0; i < c.getNrOptiuni(); i ++){
                printWriter.print(c.getContestatii().get(i * 2).getNotaVeche() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getNotaNoua() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getProfesorCorector().getNume() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getProfesorCorector().getPrenume() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getProfesorCorector().getCnp() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getProfesorCorector().getAdresa() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getProfesorCorector().getNrTelefon() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getProfesorCorector().getEmail() + ",");
                printWriter.print(c.getContestatii().get(i * 2).getProfesorCorector().getSpecializare() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getNotaVeche() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getNotaNoua() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getProfesorCorector().getNume() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getProfesorCorector().getPrenume() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getProfesorCorector().getCnp() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getProfesorCorector().getAdresa() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getProfesorCorector().getNrTelefon() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getProfesorCorector().getEmail() + ",");
                printWriter.print(c.getContestatii().get(i * 2 + 1).getProfesorCorector().getSpecializare() + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
