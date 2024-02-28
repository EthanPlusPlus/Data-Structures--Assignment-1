import java.util.Scanner;

public class Display {

    private static final String CHOOSE = "Enter an option\n1.Load\n2. Add statement\n3. Search by term\n" +
            "4. Search by term and stmnt\n5. Quit";

    public static String input;

    public static void Prompt() {

        Scanner sc = new Scanner(System.in);

        System.out.println(CHOOSE);
        input = sc.next();

        while( !input.equals("5") ){

            switch (input) {
                case "1" :
                    input = sc.next();
                    Main.LoadFile(input);
                    break;

                case "5":

            }

            System.out.println(CHOOSE);
            input = sc.next();

        }



    }
}
