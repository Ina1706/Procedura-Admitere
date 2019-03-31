public class Contestatie {
    private int notaNoua;
    private double notaVeche;
    private Profesor profesorCorector;
    public Contestatie(double notaVche, int notaNoua, Profesor profesorCorector) {
        this.notaNoua = notaNoua;
        this.notaVeche = notaVche;
        this.profesorCorector = profesorCorector;
    }

    public int getNotaNoua() {
        return notaNoua;
    }

    public Profesor getProfesorCorector() {
        return profesorCorector;
    }

    public void setNotaNoua(int notaNoua) {
        this.notaNoua = notaNoua;
    }

    public double getNotaVeche() {
        return notaVeche;
    }

    public void setProfesorCorector(Profesor profesorCorector) {
        this.profesorCorector = profesorCorector;
    }

    public void afisare(){
        System.out.println("Nota veche: " + notaVeche + "; nota noua: " + notaNoua + "profesor corector: ");
        System.out.println("profesor corector: ");
        profesorCorector.afisare();
    }
}
