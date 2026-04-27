import java.sql.*;

public class Student{
    public void insertstudent(int id, String name, int marks){
        try{
            Connection con = Jdbc.getConnection();

            String query = "INSERT INTO STUDENT(id,name,marks) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,marks);

            ps.executeUpdate();
            System.out.println("student inserted");
            con.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void updatestudent(int id, String name, int marks){
        try{
            Connection con = Jdbc.getConnection();

            String query = "UPDATE STUDENT SET name =? , marks=? WHERE id =? ";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1,name);
            ps.setInt(2,marks);
            ps.setInt(3,id);
            
            ps.executeUpdate();
            System.out.println("student updated");
            con.close();
            

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void deletestudent(int id){
        try{
            Connection con = Jdbc.getConnection();

            String query = "DELETE FROM STUDENT WHERE id =? ";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1,id);
            
            ps.executeUpdate();
            System.out.println("Student Deleted");
            con.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void getallstudent(){
        try{
            Connection con = Jdbc.getConnection();

            String query = "SELECT * FROM STUDENT";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("marks"));
            }
            
            System.out.println("Student has been get from the table...");
            con.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}