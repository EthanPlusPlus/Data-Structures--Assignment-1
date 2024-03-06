import java.util.Scanner;

/**
 * This class controls everything to do with displaying and user input
 */
public class Display {

    private static final String CHOOSE = "Enter an option:\n1. Load a textfile into the knowledge base\n2. Add knowledge to the knowledge base\n3. Search knowledge base by term\n" +
            "4. Search knowledge base by term and statement\n5. Display the whole knowledge base (large files may take a while)\n6. Quit\n";

    public static String input;

    /**
     * Begins the input loop and the entire program
     * @param args
     */
    public static void main(String[] args) {

        Prompt();

    }

    /**
     * Start the input loop into the console
     */
    public static void Prompt() {

        Scanner sc = new Scanner(System.in);

        System.out.println(CHOOSE);
        input = sc.next();

        while( true ){

            switch (input) {
                case "1" -> {
                    clearBuffer(sc);
                    System.out.print("Filename: ");
                    input = sc.next();
                    KnowledgeBase.ReadFile(input);
                }
                case "2" -> {
                    clearBuffer(sc);
                    System.out.println("Enter the term (lowercase): ");
                    String term = sc.nextLine(); // Use nextLine() to read the entire line
                    System.out.println("Enter the statement (first letter uppercase): ");
                    String stmnt = sc.nextLine(); // Use nextLine() to read the entire line
                    System.out.println("Enter the confidence score: ");
                    float confScore = sc.nextFloat();
                    System.out.println(term + stmnt + confScore);

                    KnowledgeBase.AddToKB(new Record(term, stmnt, confScore));

                    System.out.println("Successfully updated the knowledge base!");
                }

                case "3" -> {
                    clearBuffer(sc);
                    System.out.println("Enter search term: (lowercase)");
                    input = sc.nextLine();

                    System.out.println(KnowledgeBase.FindByTerm( input ));

                }

                case "4" -> {
                    clearBuffer(sc);
                    System.out.println("Enter search term: (lowercase)");
                    clearBuffer(sc);
                    String term = sc.nextLine();
                    System.out.println("Enter search stmnt: (first letter uppercase)");
                    String stmnt = sc.nextLine();
                    System.out.println(KnowledgeBase.FindByTermAndStmnt( term, stmnt ));
                }

                case "5" -> {
                    KnowledgeBase.base.preOrder();
                }

                case "6" -> {
                    System.exit(0);
                }

                default -> {
                    clearBuffer(sc);
                    System.out.println("Invalid input! Please try again.");
                }
            }

            System.out.println(CHOOSE);
            input = sc.next();

        }
    }

    /**
     * Clear leftover input or lines in the Scanner after reading
     * @param scanner Current scanner
     */
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
