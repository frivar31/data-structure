import java.util.Random;
// A Treap Node
class TreapNode
{
	int data;
	int priority;
	TreapNode left, right;

	// constructor
	TreapNode(int data)
	{
		this.data = data;
		this.priority = new Random().nextInt(100);
		this.left = this.right = null;
	}
}

class Treap
{
	public static TreapNode rotateLeft(TreapNode root)
	{
		TreapNode R = root.right;
		TreapNode X = root.right.left;

		// rotate
		R.left = root;
		root.right = X;

		// set a new root
		return R;
	}
	public static TreapNode rotateRight(TreapNode root)
	{
		TreapNode L = root.left;
		TreapNode Y = root.left.right;

		// rotate
		L.right = root;
		root.left = Y;

		// set a new root
		return L;
	}
	
	public static TreapNode insertNode(TreapNode root, int data){
		if (root == null) {		//si larbre est vide on cree un nouveau
			return new TreapNode(data);
		}
		//  si la vbaleurs(data) est plus petit que la valeurs de la racine
		if (data < root.data) {
			// on l'ajoute a la gauche
			root.left = insertNode(root.left, data);

			// si la priorité de la nouvelle racine du sous-arbre gauche est plus grande à celle de la racine
			// on corrige pour pas viole la propriete du monceau
			if (root.left.priority > root.priority) {
				root = rotateRight(root);// on fait une rotation a droite
			}
		} else {
				// on l'ajoute a la droite
			root.right = insertNode(root.right, data);
			if (root.right.priority > root.priority) {// la nouvelle racine du sous-arbre droit est plus grande à celle de la racine
				// on la corrige aussi par une rotation a gauche
				root = rotateLeft(root);
			}
		}
		return root;
	}
	public static boolean searchNode(TreapNode root, int key)
	{// meme implementation qu'un abr
		// si la noeud est null, alors le noeud existe pas et on retourne false
		if (root == null )//
			return false;
		if (root.data == key){ //si on trouve la valeurs du noeud on retourne true
			return true;
		}
		// si la valeurs(key) est plus grande que la valeurs du noeaud
		if (root.data < key)
			return searchNode(root.right, key);
		else {
		//si la valeurs( key) est plus petite que la valeurs du noeaud
		return searchNode(root.left, key);}
	}
	public static TreapNode deleteNode(TreapNode root, int key) {
		// si le l'arbre est vide
		if (root == null) {
		return null;
		}
		// si la valeurs du noeud a supprimer est plus petite de celle de la racine
		if (key < root.data) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.data) {// si la valeurs du noeud a supprimer est grande de celle de la racine
			root.right = deleteNode(root.right, key);
		} else {
			// cas où nous avons trouvé le nœud à supprimer si il a un ou 0 enfant
			if (root.left == null) {// la racine n'a pas d'enfant a gauche
				return root.right;
			} else if (root.right == null) {// la racine n'a pas d'enfant a droite
				return root.left;
			} else {
				// cas où la racine à supprimer a deux enfants, on doit maintenir la propriete du monceau
				if (root.left.priority < root.right.priority) {
					root = rotateLeft(root);// on fait la correction a gauche
					root.left = deleteNode(root.left, key);
				} else {
					root = rotateRight(root);// on fait la correction a droite
					root.right = deleteNode(root.right, key);
				}
			}
		}
		return root;
	}
}