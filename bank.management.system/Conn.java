import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystems", "root", "@VISHAL_MAURYA055");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
