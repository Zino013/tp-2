public class Noeud {
    Visiteur valeur;
    private Noeud suivant;

    public Noeud getSuivant() {
        return this.suivant;
    }

    public Visiteur getValeur() {
        return this.valeur;
    }

    public String toString(){
        return "[" + valeur.getNom() + ", " + valeur.getAge() +"] -> [" + suivant.valeur.getNom() + ", " + suivant.valeur.getAge() +"]";
    }
}
