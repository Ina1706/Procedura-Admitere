public class Persoana {
    protected final String nume;
    protected final String prenume;
    private final String cnp;
    private  String adresa;
    private  String nrTelefon;
    private String email;

    public Persoana(String nume, String prenume, String cnp, String adresa, String nrTelefon, String email) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.adresa = adresa;
        this.nrTelefon = nrTelefon;
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void afisare() {
        System.out.print("Nume: " + this.nume);
        System.out.print("; Prenume: " + this.prenume);
        System.out.println("; CNP: " + this.cnp);
        System.out.print("Adresa: " + this.adresa);
        System.out.print("; Telefon: " + this.nrTelefon);
        System.out.println("; Adresa e-mail: " + this.email);
    }
}
