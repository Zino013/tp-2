public class Animal {
    private String nom;
    private String regimeAlimentaire;
    private double poids;
    private Classe classe;
    private String espece;
    private double besoinAlimentaire;

    public Animal(String nom, String regimeAlimentaire, double poids, Classe classe, String espece){
        this.nom = nom;
        this.regimeAlimentaire = regimeAlimentaire;
        this.poids = poids;
        this.classe = classe;
        this.espece =espece;
        calculerBesoinAlimentaire();
    }

    public Classe getClasse() {
        return this.classe;
    }

    public String getNom() { return this.nom; }

    public String getEspece(){
        return this.espece;
    }
    public double getPoids(){
        return this.poids;
    }

    public void setPoids(int pourcentage) {
        switch (pourcentage) {
            case 1:
                poids = poids * 0.1;
                break;
            case 2:
                poids = poids / 0.2;
                break;
            case 5:
                poids = poids / 0.5;
                break;
            default:
                System.out.println("Pourcentage non valide");
        }
    }

    public void calculerBesoinAlimentaire(){
        switch (regimeAlimentaire){
            case "carnivore":
                besoinAlimentaire = poids * 0.05;
                break;
            case "herbivore":
                besoinAlimentaire = poids * 0.03;
                break;
            case "omnivore":
                besoinAlimentaire = poids * 0.02;
                break;
            case "piscivore":
                besoinAlimentaire = poids * 0.01;
                break;
            default:
                System.out.println("Régime alimentaire invalide");
        }

    }

    public double getBesoinAlimentaire() {
        return besoinAlimentaire;
    }

    public String toString(){
        return "Le " + getEspece() + " nommé " + getNom() + " pèse " + getPoids() + " kg et son besoin alimentaire " + getClasse() + " de " + getBesoinAlimentaire() + " kg" ;
    }






}
