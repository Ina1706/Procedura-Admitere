public class Liceu {
    private final String nume;
    private final String adresa;
    private final String localitate;

    public Liceu(String nume, String adresa, String localitate) {
        this.nume = nume;
        this.adresa = adresa;
        this.localitate = localitate;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void afisare(){
        System.out.print("Nume liceu: " + nume);
        System.out.print("; Adresa: " + adresa);
        System.out.println("; Localitate: " + localitate);
    }
}
