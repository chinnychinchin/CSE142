public class Song {
    public static void main(String[] args) {

        verse1();
        System.out.println();
        verse2();
        System.out.println();
        verse3();
        System.out.println();
        verse4();
        System.out.println();
        verse5();
        System.out.println();
        verse6();
        System.out.println();
        verse7();


    }

    private static void printSecondLine() {
        System.out.println("She swallowed the dog to catch the cat,");
    }

    private static void printThirdLine() {
        System.out.println("She swallowed the cat to catch the bird,");
    }

    private static void printFourthLine() {
        System.out.println("She swallowed the bird to catch the spider,");
    }

    private static void printFifthLine() {
        System.out.println("She swallowed the spider to catch the fly,");
    }

    private static void printSixthLine() {
        System.out.println("I don't know why she swallowed that fly,");
    }

    private static void printLastLine() {
        System.out.println("Perhaps she'll die.");
    }




    private static void verse1 () {

        System.out.println("There was an old woman who swallowed a fly.");
        printSixthLine();
        printLastLine();
    }

    private static void verse2 () {

        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        printFifthLine();
        printSixthLine();
        printLastLine();

    }

    private static void verse3 () {

        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        printFourthLine();
        printFifthLine();
        printSixthLine();
        printLastLine();

    }

    private static void verse4 () {

        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        printThirdLine();
        printFourthLine();
        printFifthLine();
        printSixthLine();
        printLastLine();

    }

    private static void verse5 () {

        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        printSecondLine();
        printThirdLine();
        printFourthLine();
        printFifthLine();
        printSixthLine();
        printLastLine();

    }

    private static void verse6 () {

        System.out.println("There was an old woman who swallowed a centipede,");
        System.out.println("One would think that makes her a creep.");
        System.out.println("She swallowed the centipede to catch the dog,");
        printSecondLine();
        printThirdLine();
        printFourthLine();
        printFifthLine();
        printSixthLine();
        printLastLine();

    }

    private static void verse7() {
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }

}
