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

    public Gardien getGardien() {
        return gardien;
    }

    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    public void ajouterAnimaux(Animal[] lesAnimaux) {
        Animal[] lesanimeaux2 = new Animal[lesAnimaux.length];
        for (int i = 0; i < lesAnimaux.length; i++) {
            lesAnimaux[i] = lesanimeaux2[i];
            nombreAnimaux++;
        }
        this.animaux = lesanimeaux2;
    }

    public int getNombreAnimaux() {
        return nombreAnimaux;
    }

    public Animal[] getAnimaux() {
        return animaux;
    }



    public String toString(){
        return "";
    }
}
