public class Profesor extends Persoana {
    private String specializare;

    public Profesor(String nume, String prenume, String cnp, String adresa, String nrTelefon, String email, String specializare) {
        super(nume, prenume, cnp, adresa, nrTelefon, email);
        this.specializare = specializare;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public void afisare()
    {
        super.afisare();
        System.out.println("Specializare: " + this.specializare);
    }
}
