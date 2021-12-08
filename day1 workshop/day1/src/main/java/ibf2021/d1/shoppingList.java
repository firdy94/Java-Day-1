package ibf2021.d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import ibf2021.d1.ShoppingCartDB.*;

public class ShoppingList {

    private List<String> itemsList=new ArrayList<>(0);
    private String input= "";
    private String [] inputList= new String[0];
    private String username="";
    private int login_count=0;


    public ShoppingList(){

    }
    public ShoppingList(List<String> itemsList, String input, String[] inputList){
        this.itemsList=itemsList;
        this.input=input;
        this.inputList=inputList;
    }

    public static void main(String[] args) throws IOException {
        String inputpathDB="/"+"cartdb"; //need to add args[0]
        ShoppingCartDB ShopDB = new ShoppingCartDB();
    

        ShoppingList myList = new ShoppingList();

        System.out.println("Welcome to your shopping cart");
        myList.checkInput();

   
        while(!myList.input.contains("exit")){
            while(!myList.input.equals("login")){
                if(myList.login_count<1){
                System.out.println("Please enter the command login followed by your name ");
                myList.checkInput();
                }
                else{
                    break;
                }
            }
            switch(myList.input){

                case "list":
                    if (myList.itemsList.isEmpty()){
                        System.out.println("Your cart is empty");
                    }
                    myList.getItem();
                    myList.checkInput();
                    break;
                case "add":
                    for(int i=1;i<myList.inputList.length;i++){
                        myList.addItem(myList.inputList[i]);
                    }
                    myList.checkInput();
                    break;
                case "delete":
                    myList.removeItem(Integer.parseInt(myList.inputList[1])-1);
                    myList.checkInput();
                    break;
                case "login":
                    if (myList.login_count>=1){
                        System.out.println("Only one user can be logged in at a time");;
                        myList.checkInput();
                        break;
                    }
                    myList.setUsername (myList.getInputList()[1]);
                    inputpathDB=inputpathDB+"/"+myList.getUsername()+".db";
                    List<String> existingItems= ShopDB.loadShoppingCart(inputpathDB,myList.getUsername());
                    if (existingItems.size()!=0){
                        for(String item: existingItems){
                            myList.itemsList.add(item);
                        }
                    }
                    myList.login_count+=1;
                    myList.checkInput();
                    break;
                case "save":
                    ShopDB.saveShoppingCart(myList.itemsList);
                    System.out.println("Yout cart has been saved");
                    myList.checkInput();
                    break;

                case "users":
                System.out.println("the following users are registered");
                    ShopDB.listUsers();
                    myList.checkInput();
                    break;

                default:
                System.out.println("Please enter one of the following commands:\nlogin\nsave\nusers\nlist\nadd\ndelete\nexit");
                myList.checkInput();
                break;
                }
        }
    }
                

    public void getItem(){
        for(int i=0;i<getItemsList().size();i++){
            System.out.printf("%d. %s%n", i+1,getItemsList().get(i));

        }
    }
    public void addItem(String item){
         if (!getItemsList().contains(item)){
            getItemsList().add(item);
            System.out.printf("%s added to your your cart\n", item);
            }
        else{
            System.out.printf("You have %s in your cart\n", item);

            }
    }
    public  void removeItem(int ind){
        if(ind>=getItemsList().size()){
            System.out.println("Incorrect item index\n");

        }
        else{
            String removedItem= getItemsList().remove(ind);
            System.out.printf("%s removed from your cart\n", removedItem);
        }
        
    }
    public void checkInput(){
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

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String s){
        this.username=s;
    }
}

