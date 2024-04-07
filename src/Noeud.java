public class Noeud {
    Visiteur valeur;
    private Noeud suivant;

    public Noeud getSuivant() {
        return this.suivant;
    }
    public Noeud(Visiteur visiteur){
        this.visiteur =visiteur;
    }

    public void setValeur(Visiteur valeur) {
        this.valeur = valeur;
    }

    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }

    public Visiteur getValeur() {
        return this.valeur;
    }

    public String toString(){
        return "[" + valeur.getNom() + ", " + valeur.getAge() +"] -> [" + suivant.valeur.getNom() + ", " + suivant.valeur.getAge() +"]";
    }
}
