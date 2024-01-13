public class Node {
    int value;
    Node next;
    Node head;

    public Node(int value) {
        this.value = value;
        this.next = null;
        head = this;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
        head = this;
    }

    // la methode addvalue prend un argument (int value ) et elle ajoute la valeur ,en appelant recursivement la methode
    //addvaluerec cette derniere prend deux parametres  Si le nœud suivant est nul,
    // cela signifie que nous sommes à la fin de la liste, donc nous créons un nouveau nœud contenant
    // la valeur et le définissons comme nœud suivant du nœud actuel. Sinon, nous continuons de traverser la liste
    public void addvalue(int value) {

        // cas 1: aucun autre élément ajouté
        if (head == null) {head = new Node(value, null);}
            // cas 2: il y a déjà des éléments
        else addvalueRec(head, value);
    }

    public void addvalueRec(Node n, int v) {
        if (n.next == null) n.next = new Node(v, null);
        else addvalueRec(n.next, v);
    }


    // la methode ajoute un node et elle prend en parametre node next
    public void addNode(Node next) {

        // verifie si la liste est vide ,et set le head
        if (head == null) {
            head = next.head;
            return;
        }
        //parcourir jusqu'a le dernier node.
        Node n = head;
        while (n.next != null) n = n.next;
        n.next = next.next;


    }
    // la methode permet de supprimer le dernier element dans la liste recursivement en utilisant une methode
    //removelastRecursive qui prend en parametre un node elle verifie le prochain node est dernier.
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
        // si le node est le dernier
        if (node.next == null || node.next.next == null) {
            node.next = null;
            return;
        }
        removeLastRecursive(node.next);
    }


    // méthode permet de supprimer la valeur donnée dans une liste chaînée
    public void removeValue(int value){
        head = enleverRec(head, value);
    }

    private Node enleverRec(Node n, int r) {

        //etat de base si le node est vide
        if (n == null) {
            return null;
        }
        //si la valeur (r) est egale a la valeur supprime alors on retourne le node suivant.
        if (n.value == r) {
            return n.next;
        }
        //continue a supprimer.
        n.next = enleverRec(n.next, r);
        return n;
    }


    //méthode pour calculer la longueur d'une facon iterative et elle retourne la size de la liste

    public int lengthIteratif(){
        Node n = head;
        int size=0;

        //Si la liste est vide, sa longueur est 0
        if (head == null) return 0;
        // // Parcourir chaque node de la liste en incrémentant
        while (n != null)
        {
            size++;
            n = n.next;
        }
        return size;

    }
    // la methode vérifie si la liste est vide.Sinon, elle renvoie a la méthode récursive longueur()
    //
    public int lengthRecurssion(){
        if (head == null) return 0;
        else return longueur(head);
    }

    private int longueur(Node n)
    {//Si le node donné est null, cela signifie que la liste est vide
        if (n == null) return 0;

        //la longueur de la liste est 1 + la longueur de la sous-liste qui commence au noeud suivant
        else return 1+longueur(n.next);

    }



    // Cette méthode utilise la méthode auxiliaire lengthRecurssion().
    // pour calculer la longueur de la liste, puis parcoure la liste
    // à partir du début jusqu'au noeud correspondant à l'indice
    // de la n-ème valeur à partir de la fin.
    //Si l'indice de la n-ème valeur à partir de la fin n'est pas valide
    // (c'est-à-dire s'il est inférieur à zéro), la méthode retourne -1.

        public int returnNlast(int nLast){
            Node n = head;
            if (nLast>=0) {
                //Parcourir la liste pour atteindre le noeud correspondant
                // à l'indice de la n-ème valeur à partir de la fin
                for (int i = 0; i < lengthRecurssion() - nLast-1 ; i++){
                    n=n.next;
                }
                removeValue(n.value);
                return n.value;
            }
            return -1;
        }


 // la fonction prend un argument et elle ajoute un element dans une liste deja ordonnee


    public void addValueOrdered(int value) {
        head = recursiveHelper(head, value);
    }

    private Node recursiveHelper(Node current, int value) {
        //la liste est vide ou si la valeur à insérer est plus petite que la valeur du premier node
        if (current == null || current.value >= value) {

            Node n = new Node(value);
            n.next = current;
            return n;
        } else {
            //ajouter la valeur dans le reste de la liste triée

            current.next = recursiveHelper(current.next, value);
            return current;
        }
    }

 // la methode insert sort trier la liste chaînée par ordre croissant.
    public void insertSort() {

        if (head == null || head.next == null) {
            return;
        }
        Node newH = null;
        Node courant = head;
        //Parcours de la liste
        while (courant != null) {
            Node suivant = courant.next;
            // Si la nouvelle tête est nulle ou la valeur du node courant est inférieure à la nouvelle tête (newH),
            // le node courant devient la nouvelle tête de la liste.
            if (newH == null || courant.value < newH.value) {
                courant.next = newH;
                newH = courant;
            } else {
                Node trierCourant = newH;
                // on cherche où insérer le node courant dans la liste triée
                while (trierCourant.next != null && courant.value >= trierCourant.next.value) {
                    trierCourant = trierCourant.next;
                }
                courant.next = trierCourant.next;
                trierCourant.next = courant;
            }
            courant = suivant;
        }
        head = newH;
    }





 // la mothode pour afficher la liste
    public void display (){
        Node temp = head ;
        while (temp!= null) {
            System.out.print(temp.value + " =>");
            temp = temp.next ;
        }
        System.out.println("Null");
    }
}
