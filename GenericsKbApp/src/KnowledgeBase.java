import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnowledgeBase {

    public static Record[] base = new Record[100000];
    public static int n = 0;

    public KnowledgeBase() {

    }

    public static Record CreateRecord(String term, String stmnt, float confScore){

        return new Record(term, stmnt, confScore);

    }

    public static void AddToKB(Record record) {

        base[n] = record;
        n++;

    }

    public static Record LineToRecord(String line) {

        String[] arr = line.split("\t");
        return CreateRecord(arr[0], arr[1], Float.parseFloat(arr[2]));

    }


    public static void ReadFile(String pathname) {

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
