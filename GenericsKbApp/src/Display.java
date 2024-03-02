import java.util.Scanner;

public class Display {

    private static final String CHOOSE = "Enter an option\n1.Load\n2. Add statement\n3. Search by term\n" +
            "4. Search by term and stmnt\n5. Quit\n";

    public static String input;

    public static void Prompt() {

        Scanner sc = new Scanner(System.in);

        System.out.println(CHOOSE);
        input = sc.next();

        while( !input.equals("5") ){

            switch (input) {
                case "1" -> {
                    clearBuffer(sc);
                    System.out.print("Filename: ");
                    input = sc.next();
                    Main.LoadFile(input);
                    System.out.println(KnowledgeBase.base[10000]);
                }
                case "2" -> {
                    clearBuffer(sc);
                    System.out.println("Enter the term (lowercase): ");
                    String term = sc.nextLine(); // Use nextLine() to read the entire line
                    System.out.println("Enter the statement (first letter uppercase): ");
                    String stmnt = sc.nextLine(); // Use nextLine() to read the entire line
                    System.out.println("Enter the conf_score: ");
                    float confScore = sc.nextFloat();
                    System.out.println(term + stmnt + confScore);

                    KnowledgeBase.AddToKB(new Record(term, stmnt, confScore));

                    System.out.println("Added to KB");
                }

                case "3" -> {
                    clearBuffer(sc);
                    System.out.println("Enter search term: (lowercase)");
                    input = sc.nextLine();

                    System.out.println(KnowledgeBase.FindByTerm( input ));

                }

                case "5" -> {
                }
            }

            System.out.println(CHOOSE);
            input = sc.next();

        }
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
