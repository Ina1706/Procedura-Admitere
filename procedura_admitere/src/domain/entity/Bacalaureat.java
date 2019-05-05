package domain.entity;

public class Bacalaureat {
    private final double notaRomana;
    private final double notaProbaProfil;
    private final double notaProbAlegere;
    private final String tipProbaProfil;
    private double medie;
    private int admis;

    public Bacalaureat(double notaRomana, double notaProbaProfil, double notaProbAlegere, String tipProbaProfil) {
        this.notaRomana = notaRomana;
        this.notaProbaProfil = notaProbaProfil;
        this.notaProbAlegere = notaProbAlegere;
        this.tipProbaProfil = tipProbaProfil;
        this.calculeazaMedie();
        this.calculeazaAdmis();
    }

    public double getNotaRomana() {
        return notaRomana;
    }

    public double getNotaProbaProfil() {
        return notaProbaProfil;
    }

    public double getNotaProbAlegere() {
        return notaProbAlegere;
    }

    public String getTipProbaProfil() {
        return tipProbaProfil;
    }

    public int getAdmis() {
        return admis;
    }

    public void setAdmis(int admis) {
        this.admis = admis;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    public void calculeazaMedie(){
        this.medie = (this.notaRomana + this.notaProbaProfil + this.notaProbAlegere) / 3;
    }

    public void calculeazaAdmis(){
        if (this.notaRomana >= 5.0 && this.notaProbaProfil >= 5.0 && this.notaProbAlegere >= 5.0 && this.medie >= 6.0)
            admis = 1;
        else admis = 0;
    }

    public void afisare(){
        System.out.print("Note romana + proba profil + proba alegere: " + notaRomana + " " + notaProbaProfil + " " + notaProbAlegere);
        System.out.print("; Medie bacalaureat: " + medie);
        System.out.print("; Bacalureat promovat: ");
        if(admis == 0) System.out.println("nu");
        else System.out.println("da");
    }
}
