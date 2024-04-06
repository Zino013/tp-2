public class Visiteur {
    private String nom;
    private int age;
    private int nombreAnimaux;
    String[] especes;

    public Visiteur(String nom, int age, String[] especes){
        this.nom = nom;
        this.age = age;
        this.especes = especes;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String[] getEspeces() {
        return especes;
    }

    public void entrerDansZoo(Zoo zoo){
        System.out.println("[ " + getNom()+ " "  + getAge() + "  ] entre dans le zoo " + zoo);
    }

    public void entrerDansEnclo(Enclos enclos){
        System.out.println("[ " + getNom()+ " "  + getAge() + "  ] entre dans l'enclos " + enclos.getNom());

    }

    public void quitterZoo(Zoo zoo){
        System.out.println("[ " + getNom()+ " "  + getAge() + "  ] quitte le zoo " + zoo);
    }

    public void quitterEnclo(Enclos enclos){
        System.out.println("[ " + getNom()+ " "  + getAge() + "  ] quitte l'enclos " + enclos.getNom());
    }
}
