package softwareproject;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //create scanner
        String input; //accepting input
        int iterator = 0;
        ArrayList<ProjectManager> projects = new ArrayList<ProjectManager>(); //list of all projects

        while (true) {
            System.out.println("\n\n----------Welcome to the Project Management System----------");
            System.out.println("\t* Create New Project (type new)");
            System.out.println("\t* Edit existing Project (not working right now)");
            System.out.println("\t* Exit (type exit)");
            System.out.println("------------------------------------------------------------");
            input = scan.nextLine();
            if (input.equals("new") || input.equals("New")) {
                projects.add(new ProjectManager());
            }
            if (input.equals("exit") || input.equals("Exit")) {
                break;
            }
            iterator++;
        }
    }
}
