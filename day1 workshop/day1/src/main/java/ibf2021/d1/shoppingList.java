package ibf2021.d1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Console;

public class shoppingList {
    private List<String> itemsList=new ArrayList<>(0);
    private String input= "";
    private String [] inputList= new String[0];

    public shoppingList(){

    }

    public shoppingList(List<String> itemsList, String input, String[] inputList){
        this.itemsList=itemsList;
        this.input=input;
        this.inputList=inputList;

    }



    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        commands.add(0, "list");
        commands.add(1, "add");
        commands.add(2, "delete");
        shoppingList myList = new shoppingList();

        System.out.println("Welcome to your shopping cart");
        myList.checkInput();

        while(!myList.input.contains("exit")){

            if((myList.input.equals(commands.get(0)))){
                if (myList.itemsList.isEmpty()){
                System.out.println("Your cart is empty");
                }
            myList.getItem();
            myList.checkInput();

            }
            else if((myList.input.equals(commands.get(1)))){
                for(int i=1;i<myList.inputList.length;i++){
                    myList.addItem(myList.inputList[i]);
                }
                myList.checkInput();
            }
            else if ((myList.input.equals(commands.get(2)))){
                myList.removeItem(Integer.parseInt(myList.inputList[1])-1);
                myList.checkInput();
            }
            else{

            
                System.out.println("Please enter one of the following commands:\nlist\nadd\ndelete\nexit");
                myList.checkInput();
            }
    
            
            }
        }
                

    private void getItem(){
        for(int i=0;i<this.itemsList.size();i++){
            System.out.printf("%d. %s%n", i+1,this.itemsList.get(i));

        }
    }
    public void addItem(String item){
         if (!this.itemsList.contains(item)){
            this.itemsList.add(item);
            System.out.printf("%s added to your your cart\n", item);
            }
        else{
            System.out.printf("You have %s in your cart\n", item);

            }
    }
    public void removeItem(int ind){
        if(ind>=this.itemsList.size()){
            System.out.println("Incorrect item index\n");

        }
        else{
            String removedItem= this.itemsList.remove(ind);
            System.out.printf("%s removed from your cart\n", removedItem);
        }
        
    }

    public void checkInput(){
        this.input="";
        this.inputList=new String[0];
        Console cons= System.console();
        input=cons.readLine(">");
        this.inputList=this.input.trim().toLowerCase().split("[, ]+",0);
        this.input=inputList[0];


    }
 
    }


