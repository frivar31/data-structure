public class Pile_bonus <T> {
    private Object[] tab;
    private int index;

    public Pile_bonus () {
        tab = new Object[100];
        index = -1;
    }
    public void push( T elem) {
        if (index <= 99) {   // capacite de la pile
            index++;
            tab[index] = elem; // on incremente la pile et on ajoute la valeur dans la pile
        }
    }

    public Object top() {
        if (index >= 0) {
            Object elem = tab[index];
            return elem ;           // on retoune la valeurs la plus haute dans la pile
        } else {
            return null;
        }
    }

    public Object pop() {
        if (index >= 0) {
            Object elem = tab[index];
            index--;
            return elem;  // on decremente la pile et on retoune la valeurs sorti
        } else {
            return null;
        }
    }

    public int length() {
        return index + 1; // la longeur de la pile
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




