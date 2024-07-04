import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
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
                0. Enter 0 to exit the programme
                ****************************************************
                """;

        Scanner scan = new Scanner(System.in);
        String[][] students = new String[2][100];

        while (true) {
            System.out.println(prn_op);
            System.out.print("Enter an option to execute: ");
            String option = scan.next();
            scan.nextLine(); // Consume newline

            switch (option) {
                case "1":
                    System.out.println("----------------Check available seats--------------------");
                    System.out.println();
                    check_Seats(students);
                    break;
                case "2":
                    System.out.println("-----------------Register student (with ID)----------------");
                    System.out.println();
                    register(students, scan);
                    break;
                case "3":
                    System.out.println("----------------------Delete Student------------------------");
                    System.out.println();
                    /**delete_std();**/
                    break;
                case "4":
                    System.out.println("-----------------------Find Student--------------------------");
                    System.out.println();
                    find_student(students, scan);
                    break;
                case "5":
                    System.out.println("------------------------Store students-------------------------");
                    System.out.println();
                    store_students(students);
                    break;
                case "6":
                    System.out.println("--------------------------Load Students-------------------------");
                    System.out.println();
                    load_file(students);
                    break;
                case "7":
                    System.out.println("------------------------View the student by name------------------");
                    System.out.println();
                    stud_sort(students);
                    break;
                case "0":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("------------------------------Invalid option-------------------------");
                    System.out.println();
                    break;
            }
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
            String answer = "yes";
            while (!answer.equals("no")) {
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
                            break;

                        }

                    }
                }
                System.out.println("Do you want to add more student Details(yes/no)");
                answer = scan.next().toLowerCase();
                while (!answer.equals("yes") && !answer.equals("no")) {
                    System.out.println("Please enter only 'yes' or 'no':");
                    answer = scan.next().toLowerCase();
                }
            }
        }
    }

    private static void find_student(String students[][], Scanner scan) {
        System.out.print("Enter the student Id:-");
        String stud_Id = scan.next().toLowerCase();
        try{
        for (int l = 0; l < students.length; l++) {
            for (int j = 0; j < students[l].length; j++) {

                    if (students[0][j].equals(stud_Id)) {
                        System.out.println("-----------------------------");
                        System.out.println("Student Id:-" + students[0][j]);
                        System.out.println("Name:-" + students[1][j]);
                        System.out.println("-----------------------------");
                        System.out.println();
                        return;
                    }

                }

            }

        }catch(NullPointerException e){
            System.out.println("Student Not Found,Please try again");
        }
    }

    private static void store_students(String students[][]) {
        try {
            File file = new File("std_dtls.txt");

            boolean file_created = file.createNewFile();
            if (file_created) {
                System.out.println("File Created" + file.getName());

            } else {
                if (file.exists()) {
                    System.out.println("File Already Exsisting");
                } else {
                    System.out.println("There is an error When Creating the" + file.getName() + "File");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter("std_dtls.txt")) {

                for (int j = 0; j < students[0].length; j++) {
                    if (students[0][j] != null) {
                        fileWriter.write(students[0][j] + "," + students[1][j] + "\n");
                        System.out.println("Succesfuly Data Saved");

                    }
                }

        } catch (IOException e) {
            System.out.println(students);
            e.printStackTrace();
        }

    }

    private static void load_file(String students[][]) {
        try {

            File file = new File("std_dtls.txt");
            if (file.exists()) {
                Scanner file_reader = new Scanner(file);
                int i = 0;
                while (file_reader.hasNextLine()) {
                    String text = file_reader.nextLine();
                    String[] dtls = text.split(",");
                    if (dtls.length == 2 && i<students[0].length) {
                        students[0][i] = dtls[0];
                        students[1][i] = dtls[1];
                        i++;



                    } else if (i>=students[0].length) {
                        System.out.println("Data does not loaded to file");

                    }
                }
                file_reader.close();
                System.out.println("Student Data Loaded Successfully");

            } else {
                System.out.println("The file" + file.getName() + "not existing");
            }
        } catch (IOException e) {
            System.out.println("Error While Loading The file");
            e.printStackTrace();
        }

    }
    private static void stud_sort(String students[][]) {
        int count = 0;

        for (int l = 0; l < students[0].length; l++) {
            if (students[0][l] != null) count++;
            else {
                System.out.println("There is no Any Student Details");
                break;
            }
        }



        for (int l = 0; l < count - 1; l++) {
            for (int j = 0; j < count - 1 - l; j++) {
                if (students[1][j].compareToIgnoreCase(students[1][j + 1]) > 0) {

                    String tempName = students[1][j];
                    students[1][j] = students[1][j + 1];
                    students[1][j + 1] = tempName;


                    String tempId = students[0][j];
                    students[0][j] = students[0][j + 1];
                    students[0][j + 1] = tempId;
                }
            }
        }


        System.out.println("------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println("Student Name: " + students[1][i]);
            System.out.println("Student ID: " + students[0][i]);
            System.out.println("------------------------");
        }
    }

    }





