import java.util.*;

class Driver {
    private int id;
    private String name;
    private String contact;
    private float experience;

    public Driver(int id, String name, String contact, float experience) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.experience = experience;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getContact() { return contact; }
    public float getExperience() { return experience; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setContact(String contact) { this.contact = contact; }
    public void setExperience(float experience) { this.experience = experience; }
}

class Truck {
    private int id;
    private String name;
    private float milesTravelled;
    private Driver driver;

    public Truck(int id, String name, float milesTravelled, Driver driver) {
        this.id = id;
        this.name = name;
        this.milesTravelled = milesTravelled;
        this.driver = driver;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public float getMilesTravelled() { return milesTravelled; }
    public Driver getDriver() { return driver; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMilesTravelled(float milesTravelled) { this.milesTravelled = milesTravelled; }
    public void setDriver(Driver driver) { this.driver = driver; }
}


public class TruckDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Truck[] trucks = new Truck[n];

        // Input
        for (int i = 0; i < n; i++) {
            int tid = sc.nextInt();
            String tname = sc.next();
            float miles = sc.nextFloat();

            int did = sc.nextInt();
            String dname = sc.next();
            String contact = sc.next();
            float exp = sc.nextFloat();

            Driver d = new Driver(did, dname, contact, exp);
            trucks[i] = new Truck(tid, tname, miles, d);
        }

        float minMiles = sc.nextFloat();

        // Filter
        Truck[] filtered = new Truck[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (trucks[i].getMilesTravelled() >= minMiles) {
                filtered[count++] = trucks[i];
            }
        }

        // Sort (Descending by experience)
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (filtered[i].getDriver().getExperience()< filtered[j].getDriver().getExperience()) {

                    Truck temp = filtered[i];
                    filtered[i] = filtered[j];
                    filtered[j] = temp;
                }
            }
        }

        // Output
        if (count == 0) {
            System.out.println("No trucks found");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(
                    filtered[i].getId() + " " +
                    filtered[i].getName() + " " +
                    filtered[i].getDriver().getName() + " " +
                    filtered[i].getDriver().getExperience()
                );
            }
        }
    }
}