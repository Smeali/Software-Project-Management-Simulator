package softwareproject;

//Section created by Eli C. on 11/15/2021

import java.util.ArrayList; //importing arraylist
import java.util.Scanner; //importing scanner class

public class ProjectManager {

   // static { main(); }
    private String name;
    private String desc;
    private String owner;

    private ArrayList<String> members = new ArrayList<>(); //team members list
    private ArrayList<String> risks = new ArrayList<>(); //risk list
    private ArrayList<String> status = new ArrayList<>(); //risk status list
    private String[][] requirements; // = new String[10][7];

    //Default Constructor
    public ProjectManager()
    {

    }

    public ProjectManager(String name, String owner, String desc, ArrayList<String> members, ArrayList<String> risks, ArrayList<String> status, String[][] requirements)
    {
        this.name = name;
        this.owner = owner;
        this.desc = desc;
        this.members = members;
        this.risks = risks;
        this.status = status;
        this.requirements = requirements;
    }

    //Getter and Setter for name
    public String GetName() { return this.name; }
    public void SetName(String newName) { this.name = newName; }

    //Getter and Setter for owner
    public String GetOwner() {return this.owner; }
    public void SetOwner(String newOwner) { this.owner = newOwner; }

    //Getter and setter for description
    public String GetDesc() {return this.desc; }
    public void SetDesc(String newDesc) { this.desc = newDesc; }




/***

    public static void main() {
        Scanner scan = new Scanner(System.in); //create scanner
        String input; //stores user input in a string

        System.out.print("Enter project  name: "); //owner or project manager name
        name = scan.nextLine(); //name string

        System.out.print("Enter Project owner: ");
        owner = scan.nextLine();

        System.out.print("Enter description: "); //description of software project
        desc = scan.nextLine(); //description string

        while(true) { //allows as many team members as needed
            System.out.print("Enter project team member (or stop): ");
            input = scan.nextLine();
            if (input.equals("stop") || input.equals("Stop")) {
                break;
            }
            members.add(input); //add one team member
        }

        while(true) { //inputting risk and risk status
            System.out.print("Enter a risk (or stop): ");
            input = scan.nextLine();
            if(input.equals("stop") || input.equals("Stop") ) {
                break;
            }
            risk.add(input); //add one risk

            System.out.print("Enter the status of the risk: ");
            input = scan.nextLine();
            status.add(input); //add one status
        }

//      PART B
//      Add requirements

        int size = 10;

        int l = 0;

        while(true) {
            System.out.print("Type of requirement -- 1 for functional -- 2 for non-functional (or stop): ");
            input = scan.nextLine();
            if(input.toUpperCase().equals("STOP")) {
                break;
            }
            if (input.equals("1")) {
                input = "Functional";
            }
            else if (input.equals("2")) {
                input = "Non-Functional";
            }
            else {
                while (true){
                    System.out.println("Please type 'functional' or 'non-functional' to classify the requirement: ");
                    input = scan.nextLine();
                    if(input.equals("functional") || input.equals("non-functional")){
                        break;
                    }
                }
            }

            /* If user input is not empty it stores value AND whether requirement is functional/non-functional otherwise it does nothing
            if (!input.isEmpty()) {
                requirements[l][0] = input;
            }
            requirements[l][0] = input;

            System.out.print("Enter the requirement: ");
            input = scan.nextLine();

            requirements[l][1] = input;
            l++;

        }



//      Part C

//      Have a feature that allows the user to enter (at a daily or weekly basis)
//      the effort in number of person hours expended on Requirements
//      Analysis, Designing, Coding, Testing,Project Management (by each of the earlier entered requirements)

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
            };

        }


    }
**/


    public void GetProjectInfo()
    {
        //printing out the project data
        System.out.println("\n\n----------Project Info----------");
        System.out.println("\tName: " + name);
        System.out.println("\tOwner: " + owner);
        System.out.println("\tDesc: " + desc);

        System.out.print("\tTeam members: "); //prints team members as a list
        for(int i = 0; i < members.size()-1; i++) {
            System.out.print(members.get(i) + ", ");
        }
        if (!members.isEmpty()) {
            System.out.print(members.get(members.size()-1));
        }
        System.out.println("");

        for(int j = 0; j < risks.size(); j++) { //prints risk and status (one of each per line)
            System.out.println("\tRisk: " + risks.get(j) + ", Status: " + status.get(j));
        }



//      Have a feature that allows the user to view the total expended hours by requirement
//      analysis, designing, coding, testing, project management (by each of the requirement entered)
        for (int i = 0; i < requirements.length; i++) {
            if (requirements[i][0] != null) {

                System.out.println("----------" + "Requirement: \"" + requirements[i][1] + "\"----------" +
                        "\n\tType: \t" + requirements[i][0] +
                        "\n\tAnalysis: \t" + requirements[i][2] +
                        "\n\tDesigning: \t" + requirements[i][3] +
                        "\n\tCoding: \t" + requirements[i][4] +
                        "\n\tTesting: \t" + requirements[i][5] +
                        "\n\tProj Mgmt: \t" + requirements[i][6]);

            }
        }
        System.out.println("--------------------------------");
        int projectHours = 0;
        String totalHours = "";

        for (int i = 0; i < requirements.length; i ++)
        {
            totalHours = requirements[i][2] + ":" +
                                requirements[i][3] + ":" +
                                requirements[i][4] + ":" +
                                requirements[i][5] + ":" +
                                requirements[i][6];
        }
        String[] arrayOfStrings = totalHours.split(":");
        for (String item: arrayOfStrings)
        {
            int x = Integer.parseInt(item);
            projectHours += x;
        }

        System.out.println("Total Project Hours: " + projectHours);
        System.out.println("--------------------------------");
    }


}
