import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * KnowledgeBase is the memory where the data is loaded and contained. It is uses the array data structure and
 *  binary search tree data structure for the respective apps.
 *
 *
 */
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

    /**
     * Adds a Record to the KnowledgeBase. It first checks if the Record exists in the KB, if so then that
     *  Record is replaced if the new confidence score is higher, if not, for the array app, it is not added unless
     *  it is the first file loaded, for the BST app is added as a leaf.
     *
     * @param record    Record to be added
     */
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

    /**
     * Searches KB for a Record using only the unique term.
     * @param term  Unique string key as search term
     * @return  Desired Record is returned
     */
    public static Record FindByTerm(String term) {

        for (int i = 0; i < n; i++) {

            if (term.equals(base[i].getTerm())) {

                return base[i];

            }

        }
        System.out.println("None found");
        return null;
    }

    /**
     * Searches KB for a Record using the unique term and it's statement.
     * @param term  THe term we want to find
     * @param stmnt The statement we want to find
     * @return  Desired Record is returned
     */
    public static Record FindByTermAndStmnt(String term, String stmnt) {

        for (int i = 0; i < n; i++) {

            if (term.equals(base[i].getTerm()) && stmnt.equals(base[i].getStmnt())) {

                return base[i];

            }

        }
        System.out.println("None found");
        return null;

    }

    /**
     * A line containing the term, tab, statement, tab and confidence score converted to a Record
     * @param line  The String in aforementioned format
     * @return  The Record using details from the line
     */
    public static Record LineToRecord(String line) {

        String[] arr = line.split("\t");
        return CreateRecord(arr[0], arr[1], Float.parseFloat(arr[2]));

    }

    public static void Traverse() {
        for (int i = 0; i < n; i++) {
            System.out.println(base[i]);
        }
    }

    /**
     * A textfile is read using a Scanner and a loop. The lines are converted to Records and then stored in the
     *  KnowledgeBase
     * @param pathname  The name of the textfile that must be in the same location
     *  as the java file (directory should work as well)
     */
    public static void ReadFile(String pathname) {

        try {

            Scanner sc = new Scanner(new File(pathname));
            System.out.println("File has been found.");
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
