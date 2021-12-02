package softwareproject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectMenu {

    static ProjectManager project;
    static Scanner scan = new Scanner(System.in); //create scanner
    static ArrayList<ProjectManager> projectsList = new ArrayList<ProjectManager>(); //list of all projects

    public static void main(String[] args) {
        String input; //accepting input
        int iterator = 0;

        while (true) {
            System.out.println("\n\n----------Welcome to the Project Management System----------");
            System.out.println("\t* Create New Project (type new)");
            System.out.println("\t* Edit existing Project (type edit)");
            System.out.println("\t* List existing projects (type list)");
            System.out.println("\t* Exit (type exit)");
            System.out.println("------------------------------------------------------------");
            System.out.print("PMS>");
            input = scan.nextLine();
            if (input.equals("new") || input.equals("New")) {
                projectsList.add(CreateProject());
            }
            if (input.equals("edit") || input.equals("Edit"))
                ModifyProjects();
            if(input.equals("list") || input.equals("List"))
                ListProjects(projectsList);
            if (input.equals("exit") || input.equals("Exit")) {
                break;
            }

            iterator++;
        }
    }


    public static void ModifyProjects()
    {
        int i = 0;
        for(ProjectManager item:projectsList)
        {
            i++;
            System.out.println(i+") Project: " + item.GetName());
        }
        System.out.print("Select a project to edit: ");
        String input = scan.nextLine();
        int convertedString = Integer.parseInt(input);

        projectsList.remove(convertedString - 1);
        projectsList.add(CreateProject());
    }

    // Method for creating a new project
    public static ProjectManager CreateProject()
    {
        String name;
        String owner;
        String desc;
        ArrayList<String> members;
        ArrayList<String> risks;
        ArrayList<String> status;
        String[][] requirements;


        System.out.print("Enter project name: "); //owner or project manager name
        name = scan.nextLine(); //name string

        System.out.print("Enter Project owner: ");
        owner = scan.nextLine();

        System.out.print("Enter description: "); //description of software project
        desc = scan.nextLine(); //description string

        members = new ArrayList<>();
        // Allows as many members to be added as needed
        while(true) {
            System.out.print("Enter project team member (or stop): ");
            String input = scan.nextLine();
            if (input.equals("stop") || input.equals("Stop")) {
                break;
            }
            members.add(input); //add one team member
        }

        risks = new ArrayList<>();
        status = new ArrayList<>();
        while(true) { //inputting risk and risk status
            System.out.print("Enter a risk (or stop): ");
            String input = scan.nextLine();
            if(input.equals("stop") || input.equals("Stop") ) {
                break;
            }
            risks.add(input); //add one risk

            System.out.print("Enter the status of the risk: ");
            input = scan.nextLine();
            status.add(input); //add one status
        }

        // PART B - Add Requirements
        int l = 0;

        // Allows custom requirements size -- For some reason, this fix was
        System.out.print("Enter the total number of requirements for this project: ");
        String size = scan.nextLine();
        int newSize = Integer.parseInt(size);

        requirements = new String[newSize][7];

        while(true) {

            System.out.print("Requirement type: 1 - Functional | 2 - Non-Functional (or stop): ");
            String input = scan.nextLine();
            String choice;
            choice = "";

            if(input.equals("stop")) {
                break;
            }
            else if (input.equals("1")) {
                choice = "Functional";
            }
            else if (input.equals("2")) {
                choice = "Non-Functional";
            }


           // If user input is not empty it stores value AND whether requirement is functional/non-functional otherwise it does nothing
            if (!input.isEmpty()) {
                requirements[l][0] = choice;
            }
            requirements[l][0] = choice;

            System.out.print("Enter the requirement: ");
            input = scan.nextLine();

            requirements[l][1] = input;
            l++;

        }



        //  Part C

        //  Have a feature that allows the user to enter (at a daily or weekly basis)
        //  the effort in number of person hours expended on Requirements
        //  Analysis, Designing, Coding, Testing,Project Management (by each of the earlier entered requirements)

        String input;
        for(int i = 0; i < requirements.length; i++) {
            if (requirements[i][1] != null) {
                System.out.print("\nPerson hours expended on: \"" + requirements[i][1] + "\"\nRequirements Analysis: ");
                input = scan.nextLine();
                requirements[i][2] = input;

                System.out.print("Designing: ");
                input = scan.nextLine();
                requirements[i][3] = input;

                System.out.print("Coding: ");
                input = scan.nextLine();
                requirements[i][4] = input;

                System.out.print("Testing: ");
                input = scan.nextLine();
                requirements[i][5] = input;

                System.out.print("Project Management: ");
                input = scan.nextLine();
                requirements[i][6] = input;
            } else {
                break;
            }

        }

        project = new ProjectManager(name, owner, desc, members, risks, status, requirements);
        return project;
    }

    public static void ListProjects(ArrayList<ProjectManager> list){
        for (int i = 0; i < list.size(); i ++)
        {
            list.get(i).GetProjectInfo();
        }
    }
}
