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
        System.out.println("[ " + getNom()+ " "  + getAge() + "  ] entre dans le zoo " + zoo.getNom());
    }

    public void entrerDansEnclo(Enclos enclos) {
        boolean entreeValide = false;


        for (int i = 0; i < enclos.getAnimaux().length; i++) {
            for (int j = 0; j < especes.length; j++) {
                if (especes[j].equals(enclos.getAnimaux()[i].getEspece())) {
                    System.out.println("[ " + getNom() + " " + getAge() + "  ] entre dans l'enclos " + enclos.getNom());
                    entreeValide = true;
                    break;
                }
            }
            if (entreeValide) {
                break;
            }
        }

    }


    public void quitterZoo(){
        System.out.println("[ " + getNom()+ " "  + getAge() + "  ] quitte le zoo ");
    }

    public void quitterEnclo(Enclos enclos){
        boolean  entreeValide= false;
        for (int i = 0; i < enclos.getAnimaux().length; i++) {
            for (int j = 0; j < especes.length; j++) {
                if (especes[j].equals(enclos.getAnimaux()[i].getEspece())) {
                    System.out.println("[ " + getNom() + " " + getAge() + "  ]  quitte l'enclos  " + enclos.getNom());
                    entreeValide = true;
                    break;
                }
            }
            if (entreeValide) {
                break;
            }
        }

    }
}
