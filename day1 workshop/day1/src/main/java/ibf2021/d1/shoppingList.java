package ibf2021.d1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class shoppingList {

    private List<String> itemsList=new ArrayList<>(0);
    private String input= "";
    private String [] inputList= new String[0];
    private static final List<String> commands = new ArrayList<>(Arrays.asList("list","add", "delete"));


    public shoppingList(){

    }
    public shoppingList(List<String> itemsList, String input, String[] inputList){
        this.itemsList=itemsList;
        this.input=input;
        this.inputList=inputList;

    }



    public static void main(String[] args) {
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
        for(int i=0;i<getItemsList().size();i++){
            System.out.printf("%d. %s%n", i+1,getItemsList().get(i));

        }
    }
    private void addItem(String item){
         if (!getItemsList().contains(item)){
            getItemsList().add(item);
            System.out.printf("%s added to your your cart\n", item);
            }
        else{
            System.out.printf("You have %s in your cart\n", item);

            }
    }
    private void removeItem(int ind){
        if(ind>=getItemsList().size()){
            System.out.println("Incorrect item index\n");

        }
        else{
            String removedItem= getItemsList().remove(ind);
            System.out.printf("%s removed from your cart\n", removedItem);
        }
        
    }
    private void checkInput(){
        setInput("");
        setInputList(new String[0]);
        Scanner myScan = new Scanner (System.in);
        System.out.print(">");
        setInput(myScan.nextLine());
        // Console cons= System.console();
        // input=cons.readLine(">");
        setInputList(getInput().trim().toLowerCase().split("[, ]+",0));
        setInput(inputList[0]);


    }
 

    public List<String> getItemsList() {
        return this.itemsList;
    }
    public void setItemsList(List<String> itemsList) {
        this.itemsList = itemsList;
    }
    public String getInput() {
        return this.input;
    }
    public void setInput(String s) {
        this.input = s;
    }
    public String[] getInputList() {
        return this.inputList;
    }
    public void setInputList(String[] input) {
        this.inputList = input;
    }
}

