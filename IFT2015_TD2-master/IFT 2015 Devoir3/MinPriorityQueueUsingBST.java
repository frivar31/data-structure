public class MinPriorityQueueUsingBST {
    private Node root;
    private static class Node {
        private int key;
        private Node left, right, p;
        private int size;
        private Node min; // to store the min node
        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
            this.min = null;
        }
    }
    public MinPriorityQueueUsingBST() {
        root = null;
    }
    public int getSize() {
        return (root==null) ? 0 : root.size;
    }

    public Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    private void updateMinNode(Node z) {
        // Si le node z est null, on sort de la fonction
        if (z != null) {
            Node min = z;
            if (z.left != null && z.left.min != null && z.left.min.key < min.key) {
                min = z.left.min;
            }
            if (z.right != null && z.right.min != null && z.right.min.key < min.key) {
                min = z.right.min;
            }
            z.min = min;
            updateMinNode(z.left);
            updateMinNode(z.right);
        }
    }
    private void transplant(Node u, Node v) {
        if (u.p == null) {
            root = v; // u était le root, donc on met v comme le root
        } else if (u == u.p.left) {
            u.p.left = v; // u était un fils gauche, donc on met v à sa place
        } else {
            u.p.right = v; // u était un fils droit, donc on met v à sa place
        }

        if (v != null) {
            v.p = u.p; // on met à jour le root de v
        }
    }

    public int getMinKey(){
        return extractMinEfficient(root).key;
    }
    public Node extractMinEfficient(Node z) {
        if (z == null) { // cas où l'arbre est vide
            return null;
        }

        if (z.left == null) { // cas où z n'a pas de sous-arbre gauche
            if (z.p != null) { // si z a un parent
                z.p.left = z.right; // remplacer z par son sous-arbre droit
                if (z.right != null) {
                    z.right.p = z.p; // met à jour le root de l'enfant droit de z
                }
            } else { // si z n'a pas de root, z est la racine
                root = z.right; // remplace la racine par le sous-arbre droit de z
                if (z.right != null) {
                    z.right.p = null; // met à jour le parent de la racine
                }
            }
            return z; // retourne z, le noeud supprimé
        }

        Node min = min(z.left); // cherche le nœud min dans le sous-arbre gauche de z
        transplant(z, min); // remplace z par le nœud min
        return z; // retourne z, le noeud supprimé

    }
    //permet d'insérer un nouveau noeud avec une clé donnée dans l'arbre binaire de recherche.on aura besoin pour
    //la question suivante
    public void insert(int key) {
        //// Crée un nouveau nœud avec la clé à insérer.
        Node newNode = new Node(key, 1);

        //Parcours de l'arbre pour trouver la position
        Node temp1 = null;
        Node temp2 = root;
        while (temp2 != null) {

            //// Sauvegarde du nœud parent temporaire et mise à jour de sa taille.
            temp1 = temp2;
            temp1.size++;
            // Détermine si la clé doit être insérée dans le sous-arbre gauche ou droit
            if (key < temp2.key) {
                temp2 = temp2.left;
            } else {
                temp2 = temp2.right;
            }
        }
        // Ajout du nouveau nœud à la bonne position dans l'arbre
        newNode.p = temp1;
        if (temp1 == null) {
            root = newNode;
        } else if (newNode.key < temp1.key) {
            temp1.left = newNode;
        } else {
            temp1.right = newNode;
        }
        // // Met à jour la référence du noeud minimum de l'arbre.
        updateMinNode(newNode);
    }
}


