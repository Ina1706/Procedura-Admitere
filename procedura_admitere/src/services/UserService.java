package services;
import java.util.Scanner;
import java.util.Random;
import domain.entity.Candidat;
import domain.entity.Liceu;
import domain.entity.Profesor;
import domain.entity.Bacalaureat;
import domain.entity.Examene;
import domain.entity.Contestatie;
import tools.Tools;
import java.util.HashMap;

public interface UserService {
    public int comparaLicee(Liceu a, Liceu b);
    public Liceu adaugareLiceu();
    public Bacalaureat adaugareBacalaureat();
    public Examene[] adaugareExamene(int nr);
    public void adaugareCandidat();
    public void afisareCandidati();
    public void afisareCandidatiSpecializare();
    public void adaugareProfesor();
    public void afisareProfesori();
    public void afisareLicee();
    public void afisareCandidatiLiceu();
    public void solicitareContestatie();
    public void vizualizareContestatii();
    public void cautareCandidatNumeFamilie();
    public void incarcareCandidati();
    public void incarcaLicee();
    public void incarcaProfesori();
    public void incarcaContestatii();
    public void statusPersoana(String cnp);
}
