import java.util.Scanner;
import java.util.Random;

public class UserServiceImpl implements UserService{
    private Candidat[] listaCandidati;
    private Candidat[] listaCandidatiInfo;
    private Candidat[] listaCandidatiMate;
    private Candidat[] listaCandidatiCti;
    private Profesor[] listaProfesori;
    private int nrCandidatiMate;
    private int nrCandidatiInfo;
    private int nrCandidatiCti;
    private Liceu[] listaLicee;
    private int nrLicee;
    private int nrCandidati;
    private int nrProfesori;

    public UserServiceImpl() {
        listaLicee = new Liceu[20];
        listaCandidati = new Candidat[20];
        listaCandidatiMate = new Candidat[20];
        listaCandidatiInfo = new Candidat[20];
        listaCandidatiCti = new Candidat[20];
        listaProfesori = new Profesor[20];
        nrLicee = nrCandidati = nrCandidatiCti = nrCandidatiInfo = nrCandidatiMate = nrProfesori = 0;
    }

    public int comparaLicee(Liceu a, Liceu b){
        if (a.getNume().contentEquals(b.getNume()))
            if(a.getLocalitate().contentEquals(b.getLocalitate()))
                return 1;
            return 0;
    }

    public Liceu adaugareLiceu(){
        int identic = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Numele liceului: ");
        String g = input.nextLine();
        System.out.println("Adresa liceului: ");
        String h = input.nextLine();
        System.out.println("Localitatea in care se afla liceul: ");
        String i = input.nextLine();
        Liceu liceuCand = new Liceu(g, h, i);
        for(int ind = 0; ind < nrLicee; ind++)
        {
            if (comparaLicee(listaLicee[ind], liceuCand) != 0)
                identic = 1;
        }
        if(identic == 0)
        {listaLicee[nrLicee] = new Liceu(g, h, i); nrLicee++;}
        return liceuCand;
    }

    public Bacalaureat adaugareBacalaureat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti notele la romana, proba de profil si proba la alegere: ");
        double a = Double.parseDouble(input.nextLine());
        double b = Double.parseDouble(input.nextLine());
        double c = Double.parseDouble(input.nextLine());
        System.out.println("Introduceti numele probei de profil: ");
        String d = input.nextLine();
        Bacalaureat bac = new Bacalaureat(a, b, c, d);
        return bac;
    }

    public Examene[] adaugareExamene(int nr){
        Examene[] exam = new Examene[20];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < nr; i++)
        {
            System.out.println("Numele specializarii: mate, info, cti: ");
            String a = input.nextLine();
            System.out.println("Nota obtinute la cele doua probe: ");
            double b = Double.parseDouble(input.nextLine());
            double c = Double.parseDouble(input.nextLine());
            System.out.println("Numele primei discipline: ");
            String d = input.nextLine();
            System.out.println("Numele celei de-a doua discipline: ");
            String e = input.nextLine();
            exam[i] = new Examene(a, b, c, d, e);
        }

        return exam;
    }

    public void adaugareCandidat(){

        Scanner input = new Scanner(System.in);
        System.out.println("Numele candidatului: ");
        String a = input.nextLine();
        System.out.println("Prenumele candidatului: ");
        String b = input.nextLine();
        System.out.println("CNP-ul candidatului: ");
        String c = input.nextLine();
        System.out.println("Adresa candidatului: ");
        String d = input.nextLine();
        System.out.println("Numarul de telefon: ");
        String e = input.nextLine();
        Tools t = new Tools();
        System.out.println("Adresa de e-mail: ");
        String f = input.nextLine();
        f = f.trim();
        while(t.emailMatcher(f)==false)
        {
            System.out.println("Adresa nu e valida. Reincercati; ");
            System.out.println("Adresa de e-mail: ");
            f = input.nextLine();

        }
        System.out.println("Introduceti informatii despre liceul absolvit: ");
        Liceu g = adaugareLiceu();
        System.out.println("Introduceti informatii despre bacalaureat: ");
        Bacalaureat h = adaugareBacalaureat();
        System.out.println("Introduceti informatii despre specializari: ");
        System.out.println("Introduceti numarul de specializari la care se sustine examenul: ");
        int i = input.nextInt();
        Examene[] j = adaugareExamene(i);
        listaCandidati[nrCandidati] = new Candidat(a, b, c, d, e, f, g, h, i, j);
        listaCandidati[nrCandidati].afisare();
        int[] specializari = listaCandidati[nrCandidati].getSpecializari();
        if(specializari[0] == 1) {
            listaCandidatiMate[nrCandidatiMate] = new Candidat(a, b, c, d, e, f, g, h, i, j);
            nrCandidatiMate++;
        }

        if(specializari[1] == 1) {
            listaCandidatiInfo[nrCandidatiInfo] = new Candidat(a, b, c, d, e, f, g, h, i, j);
            nrCandidatiInfo++;
        }

        if(specializari[2] == 1) {
            listaCandidatiCti[nrCandidatiCti] = new Candidat(a, b, c, d, e, f, g, h, i, j);
            nrCandidatiCti++;
        }

        nrCandidati++;
    }

    public void afisareCandidati(){
        for(int i = 0; i < nrLicee; i++)
        {
            System.out.println("CANDIDATUL " + (i+1));
            listaCandidati[i].afisare();
        }
    }

    public void afisareCandidatiSpecializare()
    {
        System.out.println("Alegeti specializarea: mate, info, cti");
        Scanner input = new Scanner(System.in);
        String specializare = input.nextLine();
        if(specializare.contains("mate")){
            for(int i = 0; i<nrCandidatiMate; i++){
                System.out.println("CANDIDATUL "+ (i+1));
                listaCandidatiMate[i].afisare();
            }
        }

        if(specializare.contains("info")){
            for(int i = 0; i<nrCandidatiInfo; i++){
                System.out.println("CANDIDATUL "+ (i+1));
                listaCandidatiInfo[i].afisare();
            }
        }

        if(specializare.contains("cti")){
            for(int i = 0; i<nrCandidatiCti; i++){
                System.out.println("CANDIDATUL "+ (i+1));
                listaCandidatiCti[i].afisare();
            }
        }

    }

    public void adaugareProfesor(){
        Scanner input = new Scanner(System.in);
        System.out.println("Numele profesorului: ");
        String a = input.nextLine();
        System.out.println("Prenumele profesorului: ");
        String b = input.nextLine();
        System.out.println("CNP-ul profesorului: ");
        String c = input.nextLine();
        System.out.println("Adresa profesorului: ");
        String d = input.nextLine();
        System.out.println("Numarul de telefon: ");
        String e = input.nextLine();
        System.out.println("Adresa de e-mail: ");
        String f = input.nextLine();
        Tools t = new Tools();
        f = f.trim();
        while(t.emailMatcher(f)==false)
        {
            System.out.println("Adresa nu e valida. Reincercati; ");
            System.out.println("Adresa de e-mail: ");
            f = input.nextLine();

        }
        System.out.println("Specializarea profesorului: ");
        String g = input.nextLine();
        listaProfesori[nrProfesori] = new Profesor (a, b, c, d, e, f, g);
        nrProfesori++;
    }

    public void afisareProfesori(){
        for(int i = 0; i < nrProfesori; i++){
            System.out.println("PROFESOR " + (i+1));
            listaProfesori[i].afisare();
        }
    }

    public void afisareLicee(){
        for(int i = 0; i < nrLicee; i++)
        {
            System.out.println("LICEUL " + (i+1));
            listaLicee[i].afisare();
        }
    }

    public void afisareCandidatiLiceu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti numele liceului: ");
        String a = input.nextLine();
        System.out.println("Introduceti adresa: ");
        String b = input.nextLine();
        System.out.println("Introduceti localitatea: ");
        String c = input.nextLine();
        Liceu x = new Liceu(a, b, c);
        for(int i = 0; i < nrCandidati; i++)
        {
            if (comparaLicee(listaCandidati[i].getLiceu(), x) == 1)
                listaCandidati[i].afisare();
        }
    }

    public void cautaProfesor(String disciplina){
        int exista = 0;
        for(int i = 0; i < nrProfesori; i++)
        {
            if (listaProfesori[i].getSpecializare().contentEquals(disciplina))
                exista = 1;
        }

        if(exista == 0)
        {
            System.out.println("Nu avem profesor de " + disciplina + "disponibil");
            System.out.println("Va rugam sa introduceti satele unui profesor cu specializarea " + disciplina);
            adaugareProfesor();
        }
    }

    public Profesor gasesteProfesor(String disciplina){
        int exista = 0;
        for(int i = 0; i < nrProfesori; i++)
        {
            if (listaProfesori[i].getSpecializare().contentEquals(disciplina))
                return listaProfesori[i];
        }
        Profesor p = new Profesor ("x", "y", "123", "strada nr", "0644", "email@prof.com", disciplina);
        listaProfesori[nrProfesori] = p;
        nrProfesori++;
        return p;
    }

    public void solicitareContestatie(){
        for(int i = 0; i < nrCandidati; i++)
        {
            System.out.println("CANDIDAT: " + i);
            listaCandidati[i].afisare();
        }
        System.out.println("alegeti indexul candidatului dorit");
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int index = input.nextInt();
        listaCandidati[index].afisare();
        System.out.println("Se recorecteaza lucrarile");
        Examene[] examene = listaCandidati[index].getOptiuni();
        int nrExamene = listaCandidati[index].getNrOptiuni();
        listaCandidati[index].setCerereContestatii(1);
        Contestatie [] cont = new Contestatie[4];
        for(int i = 0; i < nrExamene; i++)
        {
            String disciplina = examene[i].getNumeDisciplina1();
            cautaProfesor(disciplina);
            double notaVeche = examene[i].getNota1();
            int notaNoua = rand.nextInt(10);
            examene[i].setNota1(notaNoua);
            cont[i*2] = new Contestatie(notaVeche, notaNoua, gasesteProfesor(disciplina));
            disciplina = examene[i].getNumeDisciplina2();
            cautaProfesor(disciplina);
            notaVeche = examene[i].getNota2();
            notaNoua = rand.nextInt(10);
            examene[i].setNota2(notaNoua);
            cont[i*2+1] = new Contestatie(notaVeche, notaNoua, gasesteProfesor(disciplina));
        }
        listaCandidati[index].setOptiuni(examene);
        listaCandidati[index].setContestatii(cont);
    }

    public void vizualizareContestatii(){
        for(int i = 0; i < nrCandidati; i++)
        {
            if(listaCandidati[i].getCerereContestatii() == 1)
                listaCandidati[i].afisare();
        }
    }

    public void cautareCandidatNumeFamilie(){
        Scanner input = new Scanner(System.in);
        System.out.println("introduceti numele de familie al candidatului dorit: ");
        String nume = input.nextLine();
        int gasit = 0;
        for(int i = 0; i < nrCandidati; i++)
        {
            if (listaCandidati[i].getNume().contentEquals(nume))
            {
                gasit = 1;
                listaCandidati[i].afisare();
            }
        }
        if(gasit == 0)
            System.out.println("Nu a fost gasit niciun candidat cu acest nume");
    }

}
