import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnowledgeBase {

    public static BinarySearchTree<Record> base;

    public static int n = 0;

    public static boolean notFirstTime = false;

    public KnowledgeBase() {}

    public static void CreateBase() {

        base = new BinarySearchTree<Record>();

    }

    public static Record CreateRecord(String term, String stmnt, float confScore){

        return new Record(term, stmnt, confScore);

    }

    public static void AddToKB(Record record) {

        BinarySearchTree<Record>.BinaryTreeNode<Record> node = base.find(record);

        if (node != null && record.getConfScore() >= node.data.getConfScore())
            node.data.update(record);
        else
            base.insert(record);

    }

    public static Record FindByTerm(String term) {

        Record record = new Record(term, "", 0);
        return base.find(record).data;

    }

    public static Record FindByTermAndStmnt(String term, String stmnt) {

        Record record = new Record(term, stmnt, 0);
        return base.find(record).data;

    }

    public static Record LineToRecord(String line) {

        String[] arr = line.split("\t");
        return CreateRecord(arr[0], arr[1], Float.parseFloat(arr[2]));

    }


    public static void ReadFile(String pathname) {

        if (!notFirstTime)
            CreateBase();

        try {

            Scanner sc = new Scanner(new File(pathname));

            while (sc.hasNextLine()) {
                String str = sc.nextLine();

                AddToKB( LineToRecord( str ) );

            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("dont stress");
        }

    }

}
