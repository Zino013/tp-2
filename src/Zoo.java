public class Zoo {
    private String nom;
    private Pile pileGardiens;
    private File fileVisiteurs;
    private int nombreEnclos;
    private Enclos[] lesEnclos;
    private int nombreTotalAnimaux;
    public Zoo(String nom){
        this.nom = nom;
    }

    public boolean ajouterEnclos(Enclos[] lesEnclos) {
        int point = 0;
        for (int i = 0; i < pileGardiens.getGardiens().length; i++) {
            point += pileGardiens.getGardiens()[i].getCompetence();
        }
        if (point < 20) {
            return false;
        }
        this.lesEnclos = lesEnclos;
        return true;
    }
    public Visiteur retirerVisiteur(){
        Noeud nouveau = fileVisiteurs.getPremier();
        Visiteur enleverVisiteur = nouveau.getValeur();
        fileVisiteurs.setPremier(nouveau.getSuivant());
        fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() -1);
        return enleverVisiteur;
    }

    public void arriveeVisiteur(Visiteur visiteur){

        Noeud nouveauNoeud = new Noeud(visiteur);
        Noeud courant = fileVisiteurs.getPremier();
        if(fileVisiteurs.getNbElements() == 0){
            fileVisiteurs.setPremier(nouveauNoeud);
            fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() + 1);
            return;
        }
        if(visiteur.getAge() >= 65){
            while (courant.getValeur().getAge() < 65){
                courant = courant.getSuivant();
            }
            Noeud noeudAuMilieu = courant.getSuivant();
            courant.setSuivant(nouveauNoeud);
            nouveauNoeud.setSuivant(noeudAuMilieu);
            fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() + 1);
            return;
        }

        while (courant.getSuivant() != null){
            courant = courant.getSuivant();
        }
        courant.setSuivant(nouveauNoeud);
        fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() + 1);
    }
    public void ajouterGardien(Gardien gardien){

    }
}
