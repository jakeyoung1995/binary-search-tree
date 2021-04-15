public class Test {
    public static void main(String[] args) {

        IntegerSet iS1 = new IntegerSet(new int[]{4, 2, 1, 3, 15});

        IntegerSet iS2 = new IntegerSet(new int[]{8, 4, 6, 1});

        System.out.println("Set1 : "+iS1.toString());

        System.out.println("Set2 : "+iS2.toString());

        System.out.println("----------Testing Contains Method ------------");
        System.out.println("iS1.contains(3) : "+iS1.contains(3));
        System.out.println("iS1.contains(6) : "+iS1.contains(6));
        System.out.println("iS2.contains(8) : "+iS2.contains(8));
        System.out.println("iS2.contains(2) : "+iS2.contains(2));

        System.out.println("Union : "+iS1.union(iS2));

        System.out.println("Intersection : "+iS1.intersection(iS2));


        System.out.println("-----------Adding new integers to the sets ------------");

        System.out.println("Adding 5 to set 1");
        iS1.add(5);

        System.out.println("Adding 7 to set 2");
        iS2.add(7);

        System.out.println("Set 1: " + iS1.toString());
        System.out.println("Set 2: " + iS2.toString());


        System.out.println("------------Testing adding duplicate integer----------");

        iS1.add(1);

        iS2.add(4);

        System.out.println(iS1);

        System.out.println(iS2);

        System.out.println("------------Testing if the tree is balanced------------");

        System.out.println("Is Set 1 balanced?");
        iS1.autoBalance(iS1);

        System.out.println();

        System.out.println("Is Set 2 balanced?");
        iS2.autoBalance(iS2);

    }
}
