public class App {
    public static void main(String[] args) throws Exception {
        File f = new File();
        f.print();
        System.out.println(f.length());

        for (int i = 1; i <= 100; i++) {
            f.push(i);
        }
        System.out.println(f.length());
        f.print();
        f.pop();
        f.pop();
        f.print();
        System.out.println(f.length());
        f.push(67);
        f.push(68);
        f.print();
        f.remove(5);
        f.print();
        System.out.println(f.search(68));
        System.out.println("________________________________________________________");
        Grid g = new Grid();
        g.print();
        System.out.println(g.check_complete());
        System.out.println(g.move(g.getGrid()[0]));
        System.out.println(g.move(g.getGrid()[10]));
        g.print();

        System.out.println("________________________________________________________");

        Node n = new Node(32) ;
        n.addvalue(15);
        n.addvalue(20);
        n.addvalue(2);
        n.addvalue(1);
        n.addvalue(14);
        n.addvalue(108);
        n.addvalue(10);
        n.addvalue(15);
        n.addvalue(55);
        n.addvalue(110);
        n.addvalue(56);
        n.addvalue(100);
        n.addvalue(55);
        n.display();
        n.removeValue(110);
        n.display();
        n.removeLast();
        n.lengthRecurssion();
        n.lengthIteratif();
        n.display();
        n.insertSort();
        n.display();






    }
}
