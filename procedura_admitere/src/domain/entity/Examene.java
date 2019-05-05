package domain.entity;

public class Examene {
    private String numeSpecializare;
    private double nota1;
    private double nota2;
    private String numeDisciplina1;
    private String numeDisciplina2;
    private double medie;
    private double admis;
    private int index;
    private static int nrCandidati;
    private static int nrInformatica;
    private static int nrMatematica;
    private static int nrCti;

    public Examene(String numeSpecializare, double nota1, double nota2, String numeDisciplina1, String numeDisciplina2) {
        this.numeSpecializare = numeSpecializare;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.numeDisciplina1 = numeDisciplina1;
        this.numeDisciplina2 = numeDisciplina2;
        this.calculeazaMedia();
        this.calculeazaAdmis();
        this.calculeazaIndex();
        nrInformatica = nrMatematica = nrCandidati = nrCti = 1;
    }

    public String getNumeSpecializare() {
        return numeSpecializare;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public String getNumeDisciplina1() {
        return numeDisciplina1;
    }

    public String getNumeDisciplina2() {
        return numeDisciplina2;
    }

    public double getMedie() {
        return medie;
    }

    public double getAdmis() {
        return admis;
    }

    public int getIndex() {
        return index;
    }

    public static int getNrCandidati() {
        return nrCandidati;
    }

    public void setNumeSpecializare(String numeSpecializare) {
        this.numeSpecializare = numeSpecializare;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNumeDisciplina1(String numeDisciplina1) {
        this.numeDisciplina1 = numeDisciplina1;
    }

    public void setNumeDisciplina2(String numeDisciplina2) {
        this.numeDisciplina2 = numeDisciplina2;
    }

    public void setAdmis(int x){this.admis = x;}

    public void calculeazaMedia()
    {
        if (medie != 1)
            this.medie = (this.nota1 + this.nota2)/2;
    }

    public void calculeazaAdmis()
    {
        if (medie >= 5)
            admis = 1;
    }

    public void calculeazaIndex(){
        if(this.numeSpecializare.contains("info")){
            this.index = nrInformatica;
            cresteInformatica();
            return;
        }

        if(this.numeSpecializare.contains("mate")){
            this.index = nrMatematica;
            cresteMatematica();
            return;
        }


        if(this.numeSpecializare.contains("cti")){
            this.index = nrCti;
            cresteCti();
            return;
        }
    }

    public static void cresteInformatica(){
        nrInformatica++;
    }

    public static void cresteMatematica(){
        nrMatematica++;
    }

    public static void cresteCti(){
        nrCti++;
    }

    public void afisare(){
        System.out.print("Specializarea "+numeSpecializare);
        System.out.print("; Nota " + numeDisciplina1 +" "+ nota1);
        System.out.print("; Nota " + numeDisciplina2 +" "+ nota2);
        System.out.print("; admis: ");
        if(admis == 1) System.out.print("da");
        else System.out.print("nu");
        System.out.println("; numar legitimatie: ");
        if(numeSpecializare.contains("mate"))
            System.out.println(nrMatematica);
        if(numeSpecializare.contains("info"))
            System.out.println(nrInformatica);
        if(numeSpecializare.contains("cti"))
            System.out.println(nrCti);
    }
}
