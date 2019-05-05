package domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Candidat extends Persoana {
    private final Liceu liceu;
    private final Bacalaureat bac;
    private int nrOptiuni;
    private Examene[] optiuni;
    private double medie;
    private int cerereContestatii;
    private List<Contestatie> contestatii;

    public int getCerereContestatii() {
        return cerereContestatii;
    }

    public void setCerereContestatii(int cerereContestatii) {
        this.cerereContestatii = cerereContestatii;
    }

    public List<Contestatie> getContestatii() {
        return contestatii;
    }

    public void setContestatii(List<Contestatie> contestatii) {
        this.contestatii = contestatii;
    }

    public Candidat(String nume, String prenume, String cnp, String adresa, String nrTelefon, String email, Liceu liceu, Bacalaureat bac, int nrOptiuni, Examene[] optiuni) {
        super(nume, prenume, cnp, adresa, nrTelefon, email);
        this.liceu = liceu;
        this.bac = bac;
        this.nrOptiuni = nrOptiuni;
        this.optiuni = optiuni;
        this.contestatii = new ArrayList<Contestatie>();
        this.cerereContestatii = 0;
        if(this.bac.getAdmis() == 0)
            for(int i = 0; i < nrOptiuni; i++)
                this.optiuni[i].setAdmis(0);
    }

    public Liceu getLiceu() {
        return liceu;
    }

    public Bacalaureat getBac() {
        return bac;
    }

    public int getNrOptiuni() {
        return nrOptiuni;
    }

    public Examene[] getOptiuni() {
        return optiuni;
    }

    public double getMedie() {
        return medie;
    }

    public void setNrOptiuni(int nrOptiuni) {
        this.nrOptiuni = nrOptiuni;
    }

    public void setOptiuni(Examene[] optiuni) {
        this.optiuni = optiuni;
    }

    public void afisare(){
        super.afisare();
        liceu.afisare();
        bac.afisare();
        for(int i = 0; i < nrOptiuni; i++)
        {
            System.out.print("Optiunea "+ (i+1) + ": ");
            optiuni[i].afisare();
            if(cerereContestatii == 1) {
                contestatii.get(i * 2).afisare();
                contestatii.get(i * 2 + 1).afisare();
            }
        }

    }

    public int[] getSpecializari(){

        int[] spec = new int[3];
        for(int i = 0; i < nrOptiuni; i++)
        {
            if (optiuni[i].getNumeSpecializare().contains("mate"))
                spec[0] = 1;
            if (optiuni[i].getNumeSpecializare().contains("info"))
                spec[1] = 1;
            if (optiuni[i].getNumeSpecializare().contains("info"))
                spec[2] = 1;

        }
        return spec;
    }
}
