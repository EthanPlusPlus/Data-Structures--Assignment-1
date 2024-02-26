import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        KnowledgeBase kb = new KnowledgeBase();

        KnowledgeBase.ReadFile("/Users/ethan/Documents/UCT/second-year/CSC-F/Assignments/Repos/Assignment1/Data-Structures--Assignment-1/GenericsKbApp/src/GenericsKB.txt");
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