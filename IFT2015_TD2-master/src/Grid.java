public class Grid {
    private Cell[] grid ; // cree un tableau de cell pour mettre nos valeurs initial
    public class Cell { // chaque cell a 4 pointeur haut, droite , gauche ,bas et une valeurs
        private int valeur;
        private Cell haut;
        private Cell droite;
        private Cell gauche;
        private Cell bas;

        public Cell(int val){   // constructeur de notre cell
            haut=null;
            droite=null;
            gauche=null;
            bas=null;
            valeur=val;
        }

        public void setHaut(Cell haut) {
            this.haut = haut;
        }
        public void setDroite(Cell droite) {
            this.droite = droite;
        }
        public void setGauche(Cell gauche) {
            this.gauche = gauche;
        }
        public void setBas(Cell bas) {
            this.bas = bas;
        }
        public void setValeur(int valeur) {
            this.valeur = valeur;
        }


        public Cell getDroite() {
            return droite;
        }
        public int getValeur() {
            return valeur;
        }
        public Cell getHaut() {
            return haut;
        }
        public Cell getGauche() {
            return gauche;
        }
        public Cell getBas() {return bas;}
    }
    public  Grid(){ // on cree notre tableau
        grid = new Cell[12];

        grid[0]=new Cell(25);
        grid[1]=new Cell(10);
        grid[2]=new Cell(1);
        grid[3]=new Cell(10);
        grid[4]=new Cell(1);
        grid[5]=new Cell(5);
        grid[6]=new Cell(5);
        grid[7]=new Cell(10);
        grid[8]=new Cell(1);
        grid[9]=new Cell(10);
        grid[10]=new Cell(1);
        grid[11]=new Cell(-1);

        grid[0].setDroite(grid[1]);
        grid[1].setDroite(grid[2]);
        grid[2].setDroite(grid[3]);
        grid[4].setDroite(grid[5]);
        grid[5].setDroite(grid[6]);
        grid[6].setDroite(grid[7]);
        grid[8].setDroite(grid[9]);
        grid[9].setDroite(grid[10]);
        grid[10].setDroite(grid[11]);

        grid[3].setGauche(grid[2]);
        grid[2].setGauche(grid[1]);
        grid[1].setGauche(grid[0]);
        grid[7].setGauche(grid[6]);
        grid[6].setGauche(grid[5]);
        grid[5].setGauche(grid[4]);
        grid[11].setGauche(grid[10]);
        grid[10].setGauche(grid[9]);
        grid[9].setGauche(grid[8]);

        grid[4].setHaut(grid[0]);
        grid[5].setHaut(grid[1]);
        grid[6].setHaut(grid[2]);
        grid[7].setHaut(grid[3]);
        grid[8].setHaut(grid[4]);
        grid[9].setHaut(grid[5]);
        grid[10].setHaut(grid[6]);
        grid[11].setHaut(grid[7]);

        grid[0].setBas(grid[4]);
        grid[1].setBas(grid[5]);
        grid[2].setBas(grid[6]);
        grid[3].setBas(grid[7]);
        grid[4].setBas(grid[8]);
        grid[5].setBas(grid[9]);
        grid[6].setBas(grid[10]);
        grid[7].setBas(grid[11]);

    }

    public Cell[] getGrid() {
        return grid;
    }// pour get nos valeurs du tableau et les moves
    public void setGrid(Cell[] grid) {
        this.grid = grid;
    }


    // fonction pour echanger les elements du tableau
    public boolean move(Cell box) {

        //box dois pas etre vide et la droite de box doit etre vide et ne doit pas pointer vers null
        if (box.getDroite()!=null && box.getDroite().getValeur() == -1 && box.getValeur() != -1 ) {
            box.getDroite().setValeur(box.getValeur());                                  // mettre la valeurs de box dans la case vide
            box.setValeur(-1);                                                           // et mettre la box a -1( deviens notre case vide)

            return true;

        } else if (box.getGauche()!=null && box.getGauche().getValeur() == -1 && box.getValeur() != -1) { //la meme logique que droite
            box.getGauche().setValeur(box.getValeur());                                  //swap les case ( meme logique que droite)
            box.setValeur(-1);
            return true;
        } else if (box.getBas()!=null && box.getBas().getValeur() == -1 && box.getValeur() != -1) {
            box.getBas().setValeur(box.getValeur());
            box.setValeur(-1);
            return true;
        } else if (box.getHaut()!=null &&box.getHaut().getValeur() == -1 && box.getValeur() != -1) {
            box.getHaut().setValeur(box.getValeur());
            box.setValeur(-1);
            return true;
        }
        return false;
    }

    //fonction qui verifie si le jeux est complete revoie true
    public boolean check_complete(){
        for (int i = 0; i <= 3; i++) {                      // on verifier si dans la grid les valeurs de la premiere-
            if (grid[i].getValeur()!=grid[i+8].getValeur()){// ligne != a la derniere alors il est pas terminer
                return false;
            }
        }

        return true;
    }
    public void print(){        // on imprime les elements comme un tableau de 3x4
        System.out.print("(");
        for (int i = 0; i <12 ; i++) {
            if (i==4||i==8){
                System.out.println("");
            }
            System.out.print(grid[i].getValeur());
            System.out.print(",");
        }
        System.out.print(")");
    }

    public void solve_game(){   // pas fini
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                // TODO: 2023-02-19
            }

        }

    }
}
