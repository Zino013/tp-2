public class Pile {
    private final int TAILLE_INITIALE = 4;
    private final int RATIO_AGRANDISEMENT = 2;
    private Gardien[] gardiens;
    private int nbElements;
    private int capacite;

    public Gardien[] getGardiens() {
        return gardiens;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getNbElements() {
        return nbElements;
    }

    public String toString(){
        String resultat;
        resultat = getNbElements() + " gardien (capacité " + getCapacite() + "): ";
        for (int i = 0; i < getGardiens().length; i++) {
            resultat += "[" + getGardiens()[i] + "]";
        }
        return resultat;
    }
}
