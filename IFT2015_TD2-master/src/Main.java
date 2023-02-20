public class Main {
    public static void main(String[] args) {
        Grid g = new Grid();
        g.print();
        System.out.println(g.check_complete());
        File f = new File();
        for (int i = 0; i < 100; i++) {
            f.push(i);

        }
        f.print();
        f.remove(4);
        f.print();
        f.remove(2);
        f.print();
        f.push(2);
        f.print();



    }
}
