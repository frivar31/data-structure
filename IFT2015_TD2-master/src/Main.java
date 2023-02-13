public class Main {
    public static void main(String[] args) {
        File f= new File();
        for (int i = 0; i <99 ; i++) {
            f.push(i);
        }
        f.push(40);
        f.pop();
        f.print();
        System.out.println(f.search(140));
        f.remove(12);
        f.remove(11);
        f.print();
        System.out.println(f.length());

    }}