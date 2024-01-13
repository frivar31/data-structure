
public class Problem {
    //La fonction calculateCost(int[] ropes) prend en entrée un tableau de nombres entiers représentant
    // la longueur de n cordes, et elle renvoie le coût minimum pour relier toutes ces cordes en une seule corde.
    // Elle utilise la classe MinPriorityQueueUsingBST pour implémenter une file de priorité qui stocke
    // les longueurs des cordes.
    public static int calculateCost(int[] ropes) {

        //creation de la nouvelle file
        MinPriorityQueueUsingBST queue = new MinPriorityQueueUsingBST();

        // Inserer toutes les cordes dans la file de priorite
        for (int rope : ropes) {
            queue.insert(rope);
        }
        // Calcul du coût total
        int totalCost = 0;
        while (queue.getSize() > 1) {
            //extraire les deux elements mini de la file
            int minCorde1 = queue.getMinKey();
            int minCorde2 = queue.getMinKey();
            //calculer le cout de la fusion des deux cordes

            int newRope = minCorde1 + minCorde2;
            totalCost += newRope;
            queue.insert(newRope);
        }
        //le coût total
        return totalCost;
    }

    public static void main(String[] args) {

    }
}






