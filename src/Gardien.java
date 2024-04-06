public class Gardien {
    private String nom;
    private int competence;
    private int id = 999;

    public Gardien(String nom, int competence){
        this.nom = nom;
        this.competence = competence;
        id++;
    }
    public void entrainerAnimal(Animal animal, double temps) {

        if (temps < 10) {
            animal.setPoids(1);
        } else if (temps >= 10 && temps <= 30) {
            animal.setPoids(2);
        } else if (temps > 30) {
            animal.setPoids(5);
        }
    }

}
