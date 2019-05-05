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
import java.io.FileNotFoundException;

public interface FileReaderService {
    public int[] citireCandidati(Candidat[] listaCandidati, Candidat[] listaCandidatiMate, Candidat[] listaCandidatiInfo, Candidat[] listaCandidatiCti, int nrCandidati, int nrCandidatiMate, int nrCandidatiInfo, int nrCandidatiCti);
    public int citireLicee(Liceu[] listaLicee, int nrLicee);
    public int citireProfesori(Profesor[] listaProfesori, int nrProfesori);
    public void citireContestatii(Candidat[] listaCandidati);
}
