package lesson_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    static String fileName = "list.txt";
    public static void main(String[] args) {
        File file =new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException ex){

        }
    }
}
