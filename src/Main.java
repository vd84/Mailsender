import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


        try {
            new GUI();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
