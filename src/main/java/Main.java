
import java.io.*;
import java.util.*;

import static java.lang.System.*;

public class Main {

    static private HashMap<String, Integer>  userList = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException{
        {
            readListFromFile();
            Integer i = 1;
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (i != 3) {
                readList();
                printOptions();
                i = Integer.parseInt(br.readLine());
                switch (i) {
                    case 1:
                        System.out.println("Podaj imię nowego użytkownika.");
                        String name = br.readLine();
                        System.out.println("Podaj imię wiek użytkownika " + name + ".");
                        Integer age =Integer.parseInt(br.readLine());
                        userList.put(name, age);
                        break;
                    case 2:
                        System.out.println("Podaj imię użytkowanika do usunięcia");
                        userList.remove(br.readLine());
                        break;
                    case 3:
                        out.println("Dziękuję za uwagę!");
                        saveListToFile();
                        exit(0);
                    default:
                        out.println("Nieprawidłowa opcja!");
                }
            }


        }
    }

    static private void  printOptions(){
        out.println("Wybierz jedną z poniższych opcji");
        out.println("1 - nowy użytkowik");
        out.println("2 - usuń użytkownika");
        out.println("3 - wyjście z programu");

    }

    static private void saveListToFile() throws FileNotFoundException{
        int i = 1;
        Iterator itrStr= userList.keySet().iterator();
        Iterator itrVal= userList.values().iterator();
        PrintWriter zapis = new PrintWriter("lista.txt");
        while (itrStr.hasNext()) {
            zapis.println(itrStr.next()+ " "+itrVal.next());
        }
        zapis.close();
    }
    static private void readListFromFile()  throws FileNotFoundException{
            Scanner in = new Scanner(new File("lista.txt"));
            while (in.hasNext()){
                userList.put(in.next(), in.nextInt());
            }
    }
    static private void readList(){
        Iterator itrStr= userList.keySet().iterator();
        Iterator itrVal= userList.values().iterator();
        System.out.println("Bieżąca lista użytkowników");
        while (itrStr.hasNext()) {
            System.out.println(itrStr.next()+ " "+itrVal.next());
        }
        System.out.println();
    }


}
