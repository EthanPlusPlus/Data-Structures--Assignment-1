import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Display.Prompt();

        //KnowledgeBase.LineToRecord("criminologist\tCriminologists are workers.\t1.0");

        //KnowledgeBase kb = new KnowledgeBase();

        //ReadFile("/Users/ethan/Documents/UCT/second-year/CSC-F/Assignments/Repos/Assignment1/Data-Structures--Assignment-1/GenericsKbApp/src/GenericsKB.txt");
    }

    public static void LoadFile(String file) {

        KnowledgeBase.ReadFile(file);
        KnowledgeBase.notFirstTime = true;

    }

    public static void AddStmnt(String stmnt) {



    }



}