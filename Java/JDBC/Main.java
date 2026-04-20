import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student db = new Student();

        while(true){
            System.out.println("\n1. Insert");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
        
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String dname = sc.next();
                    System.out.print("Enter Marks: ");
                    int dmarks = sc.nextInt();
                    db.insertstudent(did, dname, dmarks);
                    break;

                case 2:
                    db.getallstudent();
                    break;
                
                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    db.updatestudent(id, name, marks);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int ddid = sc.nextInt();
                    db.deletestudent(ddid);
                    break;

                case 5:
                    System.exit(0);
            }       
        
        }
        
    }
}