
    public class File {
        public int[] elements;
        public int start;
        public int end;

        public File(){
           elements = new int[100];
           start=-1;
           end= -1;
        }

        public boolean isEmpty(){
            if(end==-1 && start==-1){       // ca veux dire qu'on a pas d'elements
                return true;
            }
            return false;
        }

        public boolean isFull(){
            if(start==end+1){           // le cas ou il y'a une colision hors
                return true;
            }
            if(start==0 && end==99){    // le cas ou la file est pleine
                return true;
            }
            return false;
        }
        public void push(int element){
            if (isFull()){              // verifier si notre file est pleine
                System.out.println("file pleine");
            }
            else {
            if (start==-1){         // si notre file est vide on va incrementer le start
                start++;
            }
            end=(end+1)%100;        // a chaque fois qu'on ajoute un element on increment end et on fait mod 100 si jamais-
                                    // il est au dernier element du tableau
            elements[end]=element;
        }
        }

        public int pop(){
            int x;
            if(isEmpty()){                    // verifier si notre file vide
                return -1;
            }
            else {
                x = elements[start];
                if (start == end) {         // si on a uniquement un element dans la file on dois reset les parametres
                    start = -1;
                    end = -1;
                }
                else {                      // sinon elle contient des elements
                    elements[start]=0;      // on reinisialise a 0 l'element enlever
                    start = (start+1)%100; // et on incremente start mod 100 si jamais on est pas au dernier element
                    }
                return x;

                }
        }
        public int length(){
            if(isEmpty()){
                return 0;
            }
            if (start>end){             // si le start est placer plus haut dans la file
                return start-end+1;
            }
            return end-start+1;
        }
        public void print(){// on le print comme un tableau
            System.out.print('(');
            for (int i = 0; i < elements.length - 1; i++) {
                System.out.print(elements[i]);
                System.out.print(", ");
            }
            System.out.print(elements[elements.length - 1]);
            System.out.println(')');
        }
        public boolean search(int element){
            for (int i = 0; i <elements.length; i++) {// on parcours notre file si on trouve l'elements on retourne vrais
                if(i==element){
                    return true;
                }
            }
            return false;
        }
        // fonction qui enlever la premiere valeurs trouver et on doit decaler le tableau a chaque fois
        public void remove(int value){
            for (int i = 0; i <elements.length; i++) {
                if (elements[i]==value){                            // on chercher la valeurs donner
                    for (int j = i; j < elements.length-1; j++) {  // puis on decale tout les autres
                        elements[j] = elements[j + 1];
                    }
                }
                if (i== elements.length-1){// la valeurs la plus haute dois etre enlever et on decrement end
                    elements[i]=0;
                    end--;
                }

            }

        }
    }

