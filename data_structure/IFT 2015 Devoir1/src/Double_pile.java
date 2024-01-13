public class Double_pile {
    private int tab[];
    private int index1;
    private int index2;

    public Double_pile() {
        tab= new int[100];
        index1= -1;
        index2= 100;
    }

    public boolean full() {
        if (index1 == index2) {               // conlision des deux piles, le tab est plein
            return true;
    }
        return false;
    }
    public boolean push(boolean one , int elem){
        if (full()==true ){                     // si les deux piles sont remplie
            return false ;
        }
        if (one == true ) {                     // on choisi la premier pile
            index1++;
            tab[index1]= elem ;             // on increment et on rejoute l'element
            return true ;
        }
        else {                                  // on choisi la deuxieme pile
            index2--;
            tab[index2]= elem ;             // on increment et on rejoute l'element
            return true ;
        }
    }

        public int top(boolean one){
            if (one == true && index1 >= 0) {        // on choisi la premier pile et ne dois pas etre vide
                return tab[index1];                   // on retoune la valeurs la plus haute dans la pile1
            } else if (one == false && index2<100) { // on choisi la deuxieme pile et ne dois pas etre vide
                return tab[index2];                 // on retoune la valeurs la plus haute dans la pile1
            }
            else return -1;
        }

    public int pop(boolean one) {
        if (one == true && index1 >= 0) {       // on choisi la premier pile
            int elem =tab[index1];
            index1--;
            return elem;                          // on decremente la pile on retoune la valeurs sorti
        }
        else if (one == false && index2<100) {  // on choisi la deuxieme pile
            int elem = tab[index2];
            index2++;
            return elem;                         // on increment la pile on retoune la valeurs sorti
        }
       else {
            return -1;
        }
    }

        public int length(boolean one) {
            if (one == true) {
                return index1+1;                // longeur de la pile 1
            }
            else {
                return index2-1;                // longeur de la pile 2
            }
        }
    public void print () {
        System.out.print('(');
        for (int i=0; i<tab.length-1; i++){
            System.out.print(tab[i]);
            System.out.print(", ");
        }
        System.out.print(tab[tab.length-1]);
        System.out.println(')');
    }
}






