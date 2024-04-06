public class Veterinaire {
    private String nom;
    private Classe specialite;

    public Veterinaire(String nom, Classe specialite){
        this.nom = nom;
        this.specialite = specialite;
    }

    public String getNom() {return this.nom;}

    public Classe getSpecialite() {return this.specialite;}

    public void soignerAnimal(Animal animal){
    animal.calculerBesoinAlimentaire();
    }

    public String toString(){return "[" + getNom() + ", " + getSpecialite() + "]" ;}
}
