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
}
