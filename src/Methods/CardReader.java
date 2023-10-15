package Methods;
import java.io.*;
import java.util.ArrayList;

public class CardReader {
    //   ********** Loading Methods **********
    public static ArrayList<String> loadStringList(String fileName) {
        ArrayList<String> temp = new ArrayList();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            while (file.ready()) {
                temp.add(file.readLine());

               }//end while loop
            } catch (IOException e) {
                System.out.println(e);
            }
            return temp;
        } //end loadStringList()

    public static ArrayList<Integer> loadIntegerList (String fileName) {
        ArrayList<Integer> temp = new ArrayList();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));

            while (file.ready()) {
                temp.add(Integer.parseInt(file.readLine()));
            }//end while loop
        } catch (IOException e) {
            System.out.println(e);
        }
        return temp;
    } //end loadIntegerList()


    public static ArrayList<Boolean> loadBooleanList (String fileName) {
        ArrayList<Boolean> temp = new ArrayList();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            while (file.ready()) {
                temp.add(Boolean.parseBoolean(file.readLine()));


            }//end while loop
        } catch (IOException e) {
            System.out.println(e);
        }
        return temp;
    }//end loadBooleanList()


    public static ArrayList<Double> loadDoubleList (String fileName) {
        ArrayList<Double> temp = new ArrayList();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            while (file.ready()) {
                temp.add(Double.parseDouble(file.readLine()));


            }//end while loop
        } catch (IOException e) {
            System.out.println(e);
        }
        return temp;
    }//end loadDoubleList()


// ********** Saving Methods **********
        //if it doesn't find a specific file, it'll create one
        //write over top of the previous file
        //can be adapted to add to an existing file
    public static void saveStringList (String fileName, ArrayList<String> temp) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < temp.size(); i++) {
                file.println(temp.get(i));
            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }//end savesStringList


    public static void saveIntegerList (String fileName, ArrayList<Integer> temp) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < temp.size(); i++) {
                file.println(temp.get(i));
            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    } //end saveIntegerList

} //end class

