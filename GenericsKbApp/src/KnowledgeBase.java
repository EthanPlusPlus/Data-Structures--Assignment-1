import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnowledgeBase {

    public static Record[] base = new Record[100000];
    public static int n = 0;
    public static boolean notFirstBase = false;

    public KnowledgeBase() {}

    /**
     * Creates new Record
     *
     * @param term  lowercase word acts as unique key in BST
     * @param stmnt first letter uppercase and belongs to term
     * @param confScore represents the validity of statement
     * @return  newly created Record
     */
    public static Record CreateRecord(String term, String stmnt, float confScore){

        return new Record(term, stmnt, confScore);

    }

    public static void AddToKB(Record record) {

        for (int i = 0; i < n; i++) {

            if (base[i].getTerm().equals(record.getTerm()) && record.getConfScore() >= base[i].getConfScore()){
                base[i] = record;
                return;
            }

        }

        if(!notFirstBase) {
            base[n] = record;
            n++;
        }
    }

    public static Record FindByTerm(String term) {

        for (int i = 0; i < n; i++) {

            if (term.equals(base[i].getTerm())) {

                return base[i];

            }

        }
        System.out.println("None found");
        return null;
    }

    public static Record FindByTermAndStmnt(String term, String stmnt) {

        for (int i = 0; i < n; i++) {

            if (term.equals(base[i].getTerm()) && stmnt.equals(base[i].getStmnt())) {

                return base[i];

            }

        }
        System.out.println("None found");
        return null;

    }

    public static Record LineToRecord(String line) {

        String[] arr = line.split("\t");
        return CreateRecord(arr[0], arr[1], Float.parseFloat(arr[2]));

    }

    public static void Traverse() {
        for (int i = 0; i < n; i++) {
            System.out.println(base[i]);
        }
    }

    public static void ReadFile(String pathname) {

        try {

            Scanner sc = new Scanner(new File(pathname));

            while (sc.hasNextLine()) {
                String str = sc.nextLine();

                AddToKB( LineToRecord( str ) );

            }
            notFirstBase = true;
            sc.close();
            System.out.println("Successfully updated the knowledge base!\n");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found! Please try again.\n");
        }

    }

}
