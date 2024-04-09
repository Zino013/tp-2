public class Enclos{
    private String nom;
    private int nombreAnimaux;
    private int capaciteMax;
    private Animal[] animaux;
    private Veterinaire veterinaire;
    private Gardien gardien;


    public Enclos(String nom, int capaciteMax,Veterinaire veterinaire, Gardien gardien){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.veterinaire = veterinaire;
        this.gardien = gardien;

    }



    public int getCapaciteMax() {
        return this.capaciteMax;
    }

    public Gardien getGardien() {
        return this.gardien;
    }

    public void setGardien(Gardien gardien) {
        this.gardien = gardien;
    }

    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    public void ajouterAnimaux(Animal[] lesAnimaux) {
        this.animaux = lesAnimaux;
        this.nombreAnimaux = lesAnimaux.length;
    }

    public int getNombreAnimaux() {
        return nombreAnimaux;
    }

    public Animal[] getAnimaux() {
        return animaux;
    }

    public String getNom() {
        return nom;
    }

    public String toString(){
        String resultat = "L'enclos " + getNom() + "est peuplé avec " + getNombreAnimaux() + " animaux. Sa capacité est de " + getCapaciteMax();
        resultat += " animaux. Le vétérinaire assigné est " + getVeterinaire().toString() + ". Le gardien actuel est " + getGardien().toString() + ".\n" ;

        for (int i = 0; i < getAnimaux().length; i++) {
            resultat += getAnimaux()[i].toString() + "\n";
    }
        return resultat;
        }
}
