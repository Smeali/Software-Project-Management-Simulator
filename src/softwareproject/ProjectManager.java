package softwareproject; //package name, idk if this matters

import java.util.ArrayList; //importing arraylist
import java.util.Scanner; //importing scanner class

public class ProjectManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //create scanner
        boolean running = true; //while loop controller
        ArrayList<String> members = new ArrayList<String>(); //team members list
        ArrayList<String> risk = new ArrayList<String>();; //risk list
        ArrayList<String> status = new ArrayList<String>();; //risk status list
        String input; //stores user input in a string

        System.out.println("Enter owner or project name: "); //owner or project name
        String name = scan.nextLine(); //name string

        System.out.println("Enter description: "); //description of software project
        String desc = scan.nextLine(); //description string

        while(running) { //allows as many team members as needed
            System.out.println("Enter project team member (enter stop to stop): ");
            input = scan.nextLine();
            if (input.equals("stop") || input.equals("Stop")) {
                break;
            }
            members.add(input); //add one team member
        }

        while(running) { //inputting risk and risk status
            System.out.println("Enter a risk (enter stop to stop): ");
            input = scan.nextLine();
            if(input.equals("stop") || input.equals("Stop") ) {
                break;
            }
            risk.add(input); //add one risk

            System.out.println("Enter the status of the risk: ");
            input = scan.nextLine();
            status.add(input); //add one status
        }

        //testing out with prints
        System.out.println("------------------------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Desc: " + desc);

        System.out.print("Team members: ");
        for(int i = 0; i < members.size()-1; i++) {
            System.out.print(members.get(i) + ", ");
        }
        System.out.print(members.get(members.size()-1));
        System.out.println("");

        for(int j = 0; j < risk.size(); j++) {
            System.out.println("Risk: " + risk.get(j) + ", Status: " + status.get(j));
        }
        System.out.println("------------------------------------------------------------");
    }
}
