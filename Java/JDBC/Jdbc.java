import java.sql.*;

public class Jdbc {
        private static final String url = "jdbc:mysql://localhost:3306/demo";
        private static final String user = "root";
        private static final String pass = "Rajamani@2005";
        
        public static Connection getConnection() throws Exception{
            return DriverManager.getConnection(url,user,pass);
        }
    
}