import java.util.LinkedList;

public class test {



    public static void main (String args[]){
        LinkedList<String> l = new LinkedList<String>();

        setUpList(l);
        printList(l);


    }


    public static LinkedList setUpList(LinkedList<String> l){

        String s = "Julia";
        l.add(s);

        l.add(s);

        l.add(s);
        return l;
    }

    public static void printList(LinkedList<String> l){
        String e = l.getFirst();
        while(l.pop() != null){
            System.out.println(e);
            e= l.pop();
        }

    }
}
