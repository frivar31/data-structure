import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// A Linked List Node
class Node
{
	int data;
	Node next;

	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}
class Merge
{
	public static Node mergeKLists(Node[] lists)
	{
		PriorityQueue<Node> pq;
		pq = new PriorityQueue<>(Comparator.comparingInt(a -> ((Node) a).data));
		Node head = null, last = null;

		if (lists==null){				// si la liste est vide on retourn null
			return null;
		}
		pq.addAll(Arrays.asList(lists));// on ajoute toutes les têtes de liste dans la file de priorité
		while (!pq.isEmpty()) {		// on retire le minimum de la file de priorité et ajoute son noeud suivant dans la file
			                        // si elle est pas vide
			Node min = pq.poll(); 	// le plus petit noeud
			if (head == null) { 	// alors on a pas encore ajouter de noeud a la liste et on lajoute
				head = min;
			} else { 				// alors il y'a deja un noeud dans la liste et on l'ajoute
				last.next = min;
			}
			last = min;
			if (min.next != null) { // on ajoute a chaque fois le noeud suivant de min a notre liste si il est pas null
				pq.add(min.next);
			}
		}
		return head; 				// on retourne le head de notre liste
}}