import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args){
      String prn_op= """
              *************************
                        Menu
              *************************
              1. Check available seats
              2. Register student (with ID)
              3. Delete student
              4. Find student (with student ID)
              5. Store student details into a file
              6. Load student details from the file to the system
              7. View the list of students based on their names
              ****************************************************
              """;
      System.out.println(prn_op);
      Scanner scan=new Scanner(System.in);




      try{
          System.out.println("Enter a option to execute:-");
          int option= scan.nextInt();
          switch (option){
              case 1:
                  System.out.println("Check available seats");
                  break;
              case 2:
                  System.out.println("Register student (with ID)");
                  break;
              case 3:
                  System.out.println("Delete Students");
                  break;
              case 4:
                  System.out.println("Find Student");
                  break;
              case 5:
                  System.out.println("Store students");
                  break;
              case 6:
                  System.out.println("Load Students");
                  break;
              case 7:
                  System.out.println("View the student by name");
                  break;
              default:
                  System.out.println("Invalid option");
                  break;
          }

      }catch (Exception e){
          System.out.println("Enter only numbers between 1 and 7");
      }
      private static void checkSeats(){

      }


  }
}