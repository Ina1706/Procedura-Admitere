package services;

import domain.entity.Candidat;
import domain.entity.Liceu;
import domain.entity.Profesor;

public interface FileWriterService {
    public void adaugareCandidat(Candidat c);
    public void adaugareLiceu(Liceu l);
    public void adaugareProfesor(Profesor p);
    public void adaugareContestatie(Candidat c);
}
