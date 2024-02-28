import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnowledgeBase {

    public static String[] base = new String[100000];

    public KnowledgeBase() {

    }


    public static void ReadFile(String pathname) {

        File file = new File(pathname);

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                System.out.println(str);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("dont stress");
        }

    }

}
