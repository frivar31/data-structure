public class Pile {
    private int[] tab;
    private int index;

    public Pile() {
        tab= new int[100];
        index = -1;
    }

    public void push(int elem) {
        if (index <= 99) {      // capacite de la pile
            index++;
            tab[index] = elem; //on incremente la pile et on ajoute la valeur dans la pile

        }
    }

    public int top() {
        if (index >= 0) {
            return tab[index];  // on retoune la valeurs la plus haute dans la pile
        } else {
            return -1;
        }
    }

    public int pop() {
        if (index >= 0) {
            int elem = tab[index];
            index--;                // on decremente la pile
            return elem;            // on retoune la valeurs sorti
        } else {
            return -1;
        }
    }

    public int length() {
        return index + 1;       //la longeur de la pile
    }

    public void print() {

        System.out.print('(');
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i]);
            System.out.print(", ");
        }
        System.out.print(tab[tab.length - 1]);
        System.out.println(')');
    }
}

