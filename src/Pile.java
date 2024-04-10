public class Pile {
    private final int TAILLE_INITIALE = 4;
    private final int RATIO_AGRANDISEMENT = 2;
    private Gardien[] gardiens = new Gardien[TAILLE_INITIALE];
    private int nbElements;
    private int capacite = 8;




    public Gardien[] getGardiens() {
        return gardiens;
    }

    public Gardien[] aggrandissement(Gardien[] lesGardiens) {
        Gardien[] nouveau = new Gardien[lesGardiens.length + RATIO_AGRANDISEMENT];
        for (int i = 0; i < lesGardiens.length; i++) {
            nouveau[i] = lesGardiens[i];
        }
        this.gardiens = nouveau;
        return nouveau;
    }

    public void setNbElements(int nbElements) {
        ++nbElements;
        this.nbElements = nbElements;
    }

    public void setGardiensretire(Gardien[] gardiens) {
        this.gardiens = gardiens;
        --nbElements;
    }

    public void setGardiensajout(Gardien gardien) {
        Gardien[] nouveauGardiens = new Gardien[this.gardiens.length + RATIO_AGRANDISEMENT];
        if(nouveauGardiens.length > capacite){
            nouveauGardiens = new Gardien[capacite];
        }
        int index = 0;
        for (int i = 0; i < this.gardiens.length; i++) {
            if (this.gardiens[i] != null) {
                nouveauGardiens[index++] = this.gardiens[i];
            }
        }
        nouveauGardiens[index] = gardien;
        nbElements++;
        this.gardiens = nouveauGardiens;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getNbElements() {
        return nbElements;
    }

    public String toString(){
        if(getGardiens() != null);{

            String resultat;
            resultat = getNbElements() + " gardien (capacité " + getCapacite() + "): ";
            for (int i = 0; i < getGardiens().length; i++) {
                if (getGardiens()[i] == null){
                    resultat += "[" + getGardiens()[i] + "]" ;
                }else {
                    resultat +=  getGardiens()[i] ;
                }
            }

            return resultat;
        }

    }
}
