public class File {
    private Noeud premier;
    private int nbElements = 0;

    public boolean estVide(){
        if(nbElements == 0) {
            return true;
        }
        return false;
    }

    public void setNbElements (int nbElements){
        this.nbElements = nbElements;
    }

    public int getNbElements() {
        return this.nbElements;
    }

    public Noeud getPremier() {
        return this.premier;
    }
    public void setPremier(Noeud premier){
        this.premier = premier;
    }

    public String toString(){
        Noeud courant = premier;
        String resultat = nbElements + " visiteur: [";
        while (courant != null) {
            resultat += courant.getValeur() + "] -> [";
            courant = courant.getSuivant();
        }
        return resultat += "]";
    }

}
