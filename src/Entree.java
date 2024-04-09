public class Entree {
    private int nombreEnclos;
    private Enclos[] lesEnclos;
    private double prix;
    private int nombreEnclosT;
    private Enclos[] enclosAttendus;
    private Enclos[] temp;

    public Entree(Visiteur visiteur, Zoo zoo) {
        this.lesEnclos = zoo.getLesEnclos();
        int nbAnimauxEnclo = zoo.getNombreTotalAnimaux();
        this.nombreEnclos = zoo.getNombreEnclos();
        temp = new Enclos[nombreEnclos];
        for (int i = 0; i < lesEnclos.length; i++) {
            for (int j = 0; j < lesEnclos[i].getAnimaux().length; j++) {
                for (int k = 0; k < visiteur.especes.length; k++) {
                        if (lesEnclos[i].getGardien() != null && visiteur.especes[k].equals(lesEnclos[i].getAnimaux()[j].getEspece())) {
                            temp[nombreEnclosT++] = lesEnclos[i];
                            break;
                        }
                }
            }
        }

        enclosAttendus = new Enclos[nombreEnclosT];
        for (int i = 0; i < nombreEnclosT; i++) {
            enclosAttendus[i] = temp[i];
        }
        enclosAttendus = getTableauValeur(enclosAttendus);
        nombreEnclosT = enclosAttendus.length;
        setLesEnclos(enclosAttendus);
        setNombreEnclos(enclosAttendus.length);


        if (nombreEnclosT > 0) {
            prix = 10 * nombreEnclosT;
            prix += nbAnimauxEnclo;
            if ((visiteur.getAge() >= 13 && visiteur.getAge() <= 17) || (visiteur.getAge() >= 65)) {
                prix *= 0.5;
            } else if (visiteur.getAge() < 12) {
                prix = 0;

            }

        }

    }

    public Enclos[] getTableauValeur(Enclos[] valeur) {
        Enclos[] temp4 = new Enclos[valeur.length];
        int index = 0;

        for (int i = 0; i < valeur.length; i++) {
            boolean valeurExistante = false;

            for (int j = 0; j < index; j++) {
                if (valeur[i].equals(temp4[j])) {
                    valeurExistante = true;
                    break;
                }
            }

            if (!valeurExistante) {
                temp4[index] = valeur[i];
                index++;
            }
        }

        Enclos[] result = new Enclos[index];

        for (int k = 0; k < index; k++) {
            result[k] = temp4[k];
        }

        return result;
    }



    public double getPrix() {
        return this.prix;
    }

    public void setNombreEnclos(int nombreEnclos) {
        this.nombreEnclos = nombreEnclos;
    }

    public int getNombreEnclos() {
        return nombreEnclos;
    }
    public void setLesEnclos(Enclos[] tab){
        this.lesEnclos = tab;

    }
    public Enclos[] getEnclos() {
        return lesEnclos;
    }



    public void afficherEnclos() {
        String resultat = "Ce billet permettra de visiter les " + nombreEnclosT + " enclos suivants: " ;
        for (int i = 0; i < enclosAttendus.length; i++) {
                resultat += enclosAttendus[i].getNom() + " ";
            }
        System.out.println(resultat);
    }
}
