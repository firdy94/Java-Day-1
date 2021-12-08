package ibf2021.d1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class ShoppingCartDB {

    private String defaultpathDB="/Users/mac_sur/Desktop/Module 1/Java-Day-1/day1 workshop/day1/db";
    private String inputPathDB= "";
    private String filePath=new File("").getAbsolutePath();
    private List<String> existingItems= new ArrayList<>(0);

    public static void main(String[] args) throws IOException {
        
       
    }


    public List<String> loadShoppingCart(String s, String name) throws IOException{
        filePath=filePath+"/"+s;
        File inputpathDBFile = Paths.get(filePath).toFile();
        File defaultpathDBFile= Paths.get(defaultpathDB+"/"+name+".db").toFile();

        if ((inputpathDBFile.exists())){
            inputPathDB=filePath;
            System.out.println();
            System.out.println("Welcome back "+name+", your cart contains the following items:");
            BufferedReader bfread = new BufferedReader(new FileReader(inputPathDB));
            Stream<String> myStream = bfread.lines().sequential();
            existingItems = myStream.toList();

            for(int i=0; i<existingItems.size();i++){
                System.out.println((i+1)+". "+existingItems.get(i));
            }
            bfread.close();
        }
        else if ((defaultpathDBFile.exists())){
            inputPathDB=defaultpathDB+"/"+name+".db";
            System.out.println();
            System.out.println("Welcome back "+name+", your cart contains the following items:");
            BufferedReader bfread = new BufferedReader(new FileReader(inputPathDB));
            Stream<String> myStream = bfread.lines().sequential();
            existingItems = myStream.toList();

            for(int i=0; i<existingItems.size();i++){
                System.out.println((i+1)+". "+existingItems.get(i));
            }
            bfread.close();
        }
        else{

            inputPathDB=defaultpathDB+"/"+name+".db";
            inputpathDBFile=Paths.get(inputPathDB).toFile();
            inputpathDBFile.createNewFile();
            System.out.println("Welcome "+name+", your cart is empty:");

        }
        return existingItems;
    }

    public void saveShoppingCart(List<String> itemList) throws IOException{
        BufferedWriter bfwrite = new BufferedWriter(new FileWriter(inputPathDB));
        Stream<String> myStream =itemList.stream().sequential();
        Iterator myIterate = myStream.iterator();

        

        while(myIterate.hasNext()){
            bfwrite.write(myIterate.next().toString());
            bfwrite.newLine();
        }

        
        bfwrite.flush();
        bfwrite.close();

    }

    public void listUsers(){
        String[] stringList=inputPathDB.split("/");
        String folderPath = String.join("/", Arrays.copyOfRange(stringList, 0, stringList.length-1));
        File folderpathDB= Paths.get(folderPath).toFile();
        int count=1;
        for(File f: folderpathDB.listFiles()){

            String name =f.getName();
            String[] nameAndFormat=name.split("\\.");
            if (nameAndFormat[1].equals("db")){
                System.out.println(count+". "+nameAndFormat[0]);
            count++;
            }
            
        }

    }
    
}
