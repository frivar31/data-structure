
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
            if(end==-1 && start==-1){
                return true;
            }
            return false;
        }
        public boolean isFull(){
            if(start==end+1){
                return true;
            }
            if(start==0 && end==99){
                return true;
            }
            return false;
        }
        public void push(int element){
            if (isFull()){ // verifier si notre file est pleine
                System.out.println("file pleine");
            }
            else {
            if (start==-1){      // si notre file est vide on va incrementer le start
                start++;
            }
            end=(end+1)%100;    // a chaque fois qu'on ajoute un element on increment end et on fait mod 100 si jamais
                                // il est au dernier element du tableau
            elements[end]=element;
        }
        }

        public int pop(){
            int x;
            if(isEmpty()){ // file vide
                return -1;
            }
            else {
                x = elements[start];
                if (start == end) { // si on a uniquement un element dans la file on dois reset les paramettres
                    start = -1;
                    end = -1;
                }
                else { // sinon a chaque element ajoute en incremente start
                    start = (start+1)%100;
                    }
                return x;
                }
        }

        public int length(){
            if (start>end){
                return start-end+1;
            }
            return end-start+1;
        }

        public void print(){
            System.out.print('(');
            for (int i = 0; i < elements.length - 1; i++) {
                System.out.print(elements[i]);
                System.out.print(", ");
            }
            System.out.print(elements[elements.length - 1]);
            System.out.println(')');
        }


        public boolean search(int element){
            for (int i = 0; i <elements.length; i++) {
                if(i==element){
                    return true;
                }
            }
            return false;
        }

        public void remove(int value){
            for (int i = 0; i <elements.length; i++) {
                if(i==value){
                    elements[i]=0;
                }
            }
        }
    }

