import java.sql.*;

class DBConnect {
    public static void main(String args[]) {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kongu", "root", "dharshini"
            );

            // ----------------- INSERT -----------------
            String insertQuery = "INSERT IGNORE INTO movie (myname, myyear, mydirector, mymusic) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertQuery);

            // Insert movie "Spider-Man"
            psInsert.setString(1, "Spider-Man");
            psInsert.setInt(2, 2023);
            psInsert.setString(3, "Jon Watts");
            psInsert.setString(4, "Michael Giacchino");
            int insertRows = psInsert.executeUpdate();
            System.out.println(insertRows + " row(s) inserted.");

            // ----------------- UPDATE -----------------
            String updateQuery = "UPDATE movie SET mymusic = ? WHERE myname = ?";
            PreparedStatement psUpdate = con.prepareStatement(updateQuery);

            // Update music director of "Spider-Man"
            psUpdate.setString(1, "Updated Music Director");
            psUpdate.setString(2, "Spider-Man");
            int updateRows = psUpdate.executeUpdate();
            System.out.println(updateRows + " row(s) updated.");

            // ----------------- DELETE -----------------
            String deleteQuery = "DELETE FROM movie WHERE myname = ?";
            PreparedStatement psDelete = con.prepareStatement(deleteQuery);

            // Delete movie "Thunivu"
            psDelete.setString(1, "Thunivu");
            int deleteRows = psDelete.executeUpdate();
            System.out.println(deleteRows + " row(s) deleted.");

            // ----------------- SELECT -----------------
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movie");

            System.out.println("\n--- Movie List ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("movie_id") + " | " +
                    rs.getString("myname") + " | " +
                    rs.getInt("myyear") + " | " +
                    rs.getString("mydirector") + " | " +
                    rs.getString("mymusic")
                );
            }

            // Close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
