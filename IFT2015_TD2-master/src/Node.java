public class Node {
    int value;
    Node next;
    Node head;



    public Node() {

    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    // if (head == null) {
    // head = new Node(value);

    //} else {
    //Node n = head;
    //while (n.next != null) {
    //  n = n.next;
    //}
    //n.next = new Node(value);}
    // cas 1: aucun autre élément ajouté
    public void addvalue(int value) {

        // cas 1: aucun autre élément ajouté
        if (head == null) head = new Node(value, null);
            // cas 2: il y a déjà des éléments
        else addvalue(head, value);
    }

    public void addvalue(Node n, int v) {
        if (n.next == null) n.next = new Node(v, null);
        else addvalue(n.next, v);
    }


    public void concat(Node next) {
        head = concatRec(head, next.head);
    }

    private Node concatRec(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        n1.next = concatRec(n1.next, n2);
        return n1;
    }


    public void addNode(Node next) {
        if (head == null) {
            head = next.head;
            return;
        }    
        Node n = head;
        while (n.next != null) n = n.next;
        n.next = next.next;


    }
    public void removeLast(){
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        removeLastRecursive(head);
    }
//
    private void removeLastRecursive(Node node) {
        if (node.next == null || node.next.next == null) {
            node.next = null;
            return;
        }
        removeLastRecursive(node.next);
    }

    public void removeValue(int value){
        head = enleverRec(head, value);
    }

    private Node enleverRec(Node n, int v) {
        if (n == null) {
            return null;
        }
        if (n.value == v) {
            return n.next;
        }
        n.next = enleverRec(n.next, v);
        return n;
    }




    public int lengthIteratif(){
        Node n = head;
        int size=0;
        if (head == null) return 0;
        while (n != null)
        {
            size++;
            n = n.next;
        }
        return size;

    }

    public int lengthRecurssion(){
        if (head == null) return 0;
        else return longueur(head);
    }

    private int longueur(Node n)
    {
        if (n == null) return 0;
        else return 1+longueur(n.next);
    }


        public int returnNlast(int nLast){
            Node n = head;
            if (nLast>=0) {
                for (int i = 0; i < lengthRecurssion() - nLast-1 ; i++){
                    n=n.next;
                }
                removeValue(n.value);
                return n.value;
            }
            return -1;
        }




    public void addValueOrdered(int value) {
        head = recursiveHelper(head, value);
    }

    private Node recursiveHelper(Node current, int value) {
        if (current == null || current.value >= value) {
            Node n = new Node(value);
            n.next = current;
            return n;
        } else {
            current.next = recursiveHelper(current.next, value);
            return current;
        }
    }


    public void insertSort() {

        if (head == null || head.next == null) {
            return;
        }
        Node nouvelleTete = null;
        Node courant = head;
        while (courant != null) {
            Node suivant = courant.next;
            if (nouvelleTete == null || courant.value < nouvelleTete.value) {
                courant.next = nouvelleTete;
                nouvelleTete = courant;
            } else {
                Node trierCourant = nouvelleTete;
                while (trierCourant.next != null && courant.value >= trierCourant.next.value) {
                    trierCourant = trierCourant.next;
                }
                courant.next = trierCourant.next;
                trierCourant.next = courant;
            }
            courant = suivant;
        }
        head = nouvelleTete;
}





    public void display (){
        Node temp = head ;
        while (temp!= null) {
            System.out.print(temp.value + " =>");
            temp = temp.next ;
        }
    }
}
