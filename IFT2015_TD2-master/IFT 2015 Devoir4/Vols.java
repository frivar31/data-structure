import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int first, second, third;
    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {// Trouve le coût minimum d'un vol de la ville de départ à la ville de destination avec un nombre limité d'escales.
    public int CheapestFLight(int n,int flights[][],int src,int dst,int K) {
        // Créer une liste d'adjacence pour stocker les informations des vols

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // Initialiser la file de priorité avec la ville de départ, le coût et les arrêts restants
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.offer(new Tuple(0, src, K + 1));

        // Traiter les villes dans la file de priorité
        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int cost = curr.first, city = curr.second, stops = curr.third;

            // Si nous avons atteint la ville de destination, retourner le coût
            if (city == dst) return cost;

            // Si nous avons encore des arrêts, explorer les villes connectées et mettre à jour les coûts et les arrêts
            if (stops > 0) {
                for (Pair neighbor : graph.get(city)) {
                    pq.offer(new Tuple(cost + neighbor.second, neighbor.first, stops - 1));
                }
            }
        }

        // Si aucune route n'est trouvée, retourner -1
        return -1;
        // WRITE YOUR CODE HERE (~20 Lines)

        // END OF YOUR CODE HERE
    }
}

class tuf {

    public static void main(String[] args) {

        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        Solution obj = new Solution();
        int ans = obj.CheapestFLight(n,flights,src,dst,K);

        System.out.print(ans);
        System.out.println();

        // OUTPUT: 700
    }
}