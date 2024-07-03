
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String prn_op = """
                *************************
                *      Menu Section     *
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
        Scanner scan = new Scanner(System.in);
        String[][] students = new String[2][100];

        try {
            System.out.print("Enter an option to execute:");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Check available seats");
                    check_Seats(students);
                    break;
                case 2:
                    System.out.println("Register student (with ID)");
                    register(students, scan);
                    break;


                case 3:
                    System.out.println("Delete Students");



                    break;
                case 4:
                    System.out.println("Find Student");
                    find_student(students,scan);

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
                    int no_students = students.length;
                    System.out.println(no_students);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Enter only numbers between 1 and 7");
        }
    }

    private static void check_Seats(String[][] students) {
        int count = 0;
        for (int l = 0; l < students.length; l++) {
            for (int j = 0; j < students[l].length; j++) {
                if (students[l][j] == null) {
                    count = count + 1;
                }


            }
        }
        System.out.println("The Number of Seats Available is" + " " + (count / 2));
    }

    private static void register(String[][] students, Scanner scan) {
        int availableSeats = 0;
        for (int l = 0; l < students.length; l++) {
            for (int j = 0; j < students[l].length; j++) {
                if (students[l][j] == null) {
                    availableSeats++;
                }
            }
        }
        if (availableSeats < 1) {
            System.out.print("Sorry there are no Seats Available");
        } else {
            String answer="yes";
            while(!answer.equals("no")){
                System.out.println("Enter the Student ID Number");
                String Student_ID = scan.next();
                System.out.println("Enter the name of the Student");
                String Student_Name = scan.next();
                boolean included = false;
                for (int l = 0; l < students.length && !included; l++) {
                    for (int j = 0; j < students[l].length; j++) {
                    if (students[l][j] == null) {
                        students[0][j] = Student_ID;
                        students[1][j] = Student_Name;
                        included = true;

                    }

                    }
                }
                System.out.println("Do you want to add more student Details");
                answer = scan.next().toLowerCase();
            }
        }
    }
    private static void find_student(String students[][], Scanner scan){
        System.out.println("Enter the student Id");
        String stud_Id= scan.next();
        for (int l = 0; l < students.length; l++) {
            for (int j = 0; j < students[l].length; j++) {
                if (students[0][j].equals(stud_Id)) {
                    System.out.println("Name:-"+students[0][j]);
                    System.out.println("Student Id:-"+students[1][j]);
                    break;
                } else  {
                    continue;
                }

            }
                }
            }

    }
