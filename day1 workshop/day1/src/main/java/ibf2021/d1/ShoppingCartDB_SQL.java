package ibf2021.d1;

import java.nio.MappedByteBuffer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDB_SQL {


  public static void main( String[] args ) {


     
  
}
   public Connection connectDatabase(String name ){
      Connection c = null;
      try {
         String urlString= String .format("jdbc:sqlite:/Users/mac_sur/Desktop/Module 1/Java-Day-1/cartdb//%s.db",name);
         c = DriverManager.getConnection(urlString);
      } catch ( SQLException e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      return c;
   }
   public void createTable(String name){
      String sqlStmnt = "CREATE TABLE IF NOT EXISTS shoppinglist (\n"
               + "	id integer PRIMARY KEY,\n"
               + "	item text NOT NULL\n"
               + ");";

      try {
       Connection conn= connectDatabase(name);  
       Statement stmt = conn.createStatement();
         // create a new table
         stmt.execute(sqlStmnt);
      } 
      catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   public void insertEntry(String name,String item){
      String sqlStmnt = "INSERT INTO shoppinglist(item) VALUES(?)";


      try{
         Connection conn= connectDatabase(name);
         PreparedStatement pstmt = conn.prepareStatement(sqlStmnt);
            pstmt.setString(1, item);
            pstmt.executeUpdate();


      }
      catch (SQLException e ){
         System.out.println(e.getMessage());
      }
   }

   public void printTable(String name){
      String sqlStmnt = "SELECT ROW_NUMBER() OVER(ORDER by id) num_row, item FROM shoppinglist";

      try{
         Connection conn= connectDatabase(name);
         Statement stmmnt = conn.createStatement();
         ResultSet rs =stmmnt.executeQuery(sqlStmnt);
         while (rs.next()){
            System.out.println(rs.getInt("num_row")+". "+rs.getString("item"));
         }
      }
      catch(SQLException e){
         System.out.println(e.getMessage());
      }
   }
   public List<String> getTable(String name){
      List<String> itemList =new ArrayList<>();
   
      String sqlStmnt = "SELECT ROW_NUMBER() OVER(ORDER by id) num_row, item FROM shoppinglist";
   
      try{
         Connection conn= connectDatabase(name);
         Statement stmmnt = conn.createStatement();
         ResultSet rs =stmmnt.executeQuery(sqlStmnt);
         while (rs.next()){
            itemList.add(rs.getString("item"));
         }
            
      }
      catch(SQLException e){
         System.out.println(e.getMessage());
      }
      return itemList;
   }

   // public void removeEntry(String name,int  index){
   //    String subsql="SELECT id, ROW_NUMBER() OVER(ORDER by id) num_row FROM shoppinglist ";
   //    String sqlStmnt = "DELETE FROM shoppinglist WHERE id =?";

   //    int delID=0;

   //    try{
   //       Connection conn= connectDatabase(name);
   //       PreparedStatement pstmt2 = conn.prepareStatement(subsql);

   //       PreparedStatement pstmt = conn.prepareStatement(sqlStmnt);


   //          pstmt2.setInt(2, index);
   //          ResultSet rs= pstmt2.executeQuery();

   //          while(rs.next()){
   //             if (rs.getInt("num_row")==index){
   //                delID=rs.getInt("id");
   //             }
   //          }

            

   //          pstmt.setInt(1, delID);
   //          pstmt.executeUpdate();

   //    }
   //    catch (SQLException e ){
   //       System.out.println(e.getMessage());
   //    }
   // }


}



