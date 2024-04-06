public class File {
    private Noeud premier;
    private int nbElements;

    public boolean estVide(){
        if(nbElements == 0) {
            return true;
        }
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
