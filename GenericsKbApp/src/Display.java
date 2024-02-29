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
                case "1" :
                    System.out.print("Filename: \n");
                    input = sc.next();
                    Main.LoadFile(input);
                    System.out.println(KnowledgeBase.base[10000]);
                    break;

                case "5":

                    break;
            }

            System.out.println(CHOOSE);
            input = sc.next();

        }



    }
}
