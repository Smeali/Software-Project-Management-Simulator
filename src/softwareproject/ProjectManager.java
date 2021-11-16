package softwareproject;

//Section created by Eli C. on 11/15/2021

import java.util.ArrayList; //importing arraylist
import java.util.Scanner; //importing scanner class

public class ProjectManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //create scanner
        ArrayList<String> members = new ArrayList<>(); //team members list
        ArrayList<String> risk = new ArrayList<>(); //risk list
        ArrayList<String> status = new ArrayList<>(); //risk status list
        String input; //stores user input in a string

        System.out.println("Enter owner or project manager name: "); //owner or project manager name
        String name = scan.nextLine(); //name string

        System.out.println("Enter description: "); //description of software project
        String desc = scan.nextLine(); //description string

        while(true) { //allows as many team members as needed
            System.out.println("Enter project team member (enter stop to stop): ");
            input = scan.nextLine();
            if (input.equals("stop") || input.equals("Stop")) {
                break;
            }
            members.add(input); //add one team member
        }

        while(true) { //inputting risk and risk status
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

        System.out.print("Team members: "); //prints team members as a list
        for(int i = 0; i < members.size()-1; i++) {
            System.out.print(members.get(i) + ", ");
        }
        System.out.print(members.get(members.size()-1));
        System.out.println(""); //adds a space line

        for(int j = 0; j < risk.size(); j++) { //prints risk and status (one of each per line)
            System.out.println("Risk: " + risk.get(j) + ", Status: " + status.get(j));
        }
        System.out.println("------------------------------------------------------------");

        //add more stuff here
    }
}
