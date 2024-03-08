import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        //testDisplayPromptAndOthers();

        //testKBCreateRecord();

        //testKBAddToKB();

        //testKBLineToRecord();

        //testRecordupdate();
    }

    /**
     * here we assume AddToKB is working as we do test it afterwards
     */
    private static void testDisplayPromptAndOthers() {

        /* Input: 1; test.txt; 5; 3; water; 2; water; A delicious drink; 1.0;
            3; water; 4; water; A delicious drink; 1; test2.txt; 5; "Random word123"
         */

        Display.Prompt();

    }

    public static void testKBCreateRecord() {
        System.out.println(KnowledgeBase.CreateRecord("a term",
                "This is a statement", 1));
    }

    public static void testKBAddToKB() {
        Record r1 = new Record("1", "1", 0);
        Record r2 = new Record("2", "2", 0);
        Record r12 = new Record("1", "12", 1);

        KnowledgeBase.AddToKB(r1);

        System.out.println("\n");
        KnowledgeBase.AddToKB(r2);
        KnowledgeBase.Traverse();
        System.out.println("\n");
        KnowledgeBase.AddToKB(r12);
        KnowledgeBase.Traverse();
    }

    public static void testKBLineToRecord() {
        System.out.println(KnowledgeBase.LineToRecord(
                "a term\tThis is a statement\t1.0"));
    }

    public static void testRecordupdate() {
        Record r1 = new Record("1", "1111", 1);
        Record r2 = new Record("2", "2222", 0.2222F);

        System.out.println(r1);
        System.out.println(r2);
        r1.update(r2);
        System.out.println(r1);
    }


}
