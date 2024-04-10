public class Gardien {
    private String nom;
    private int competence;
    private int id = 999;
    private static int dernierId = 999;

    public Gardien(String nom, int competence){
        this.nom = nom;
        this.competence = competence;
        id = ++dernierId  ;
    }




    public void entrainerAnimal(Animal animal, double temps) {
        temps = Math.round( temps * 10.0) / 10.0;
        if (temps < 10) {
            animal.setPoids(1);
        } else if (temps >= 10 && temps <= 30) {
            animal.setPoids(2);
        } else if (temps > 30) {
            animal.setPoids(5);
        }
        this.competence++;
        System.out.println("Le Gardien " + getNom() + " entraine l'animal Neptune " + temps + " min et augmente sa propre compétence");
    }


    public int getCompetence() {
        return this.competence;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String toString(){
        return "[" + getNom() + ", (" + getId() + "), " + getCompetence() + "]";
    }

}
