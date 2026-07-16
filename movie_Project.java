import java.sql.*;
import java.util.Scanner;
class movie_Project{
    static final String url="jdbc:mysql://localhost:3306/kongu";
    static final String user = "root";
    static final String password = "dharshini";
    static Connection con;
    static Scanner sc = new Scanner(System.in);
    //module1
    public static void connect(){
        try{
            con=DriverManager.getConnection(url,user,password);
            System.out.println("Connection started Successfully");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //module 2
    public static void addMovie() throws SQLException{
        String name, director, music;
        int year;
        System.out.println("Enter the movie name: ");
        name = sc.nextLine();
        System.out.println("Enter the movie year: ");
        year = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the movie director: ");
        director = sc.nextLine();
        System.out.println("Enter the movie music: ");
        music = sc.nextLine();

        String sql = "INSERT INTO movie (myname, myyear, mydirector, mymusic) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,name);
        pst.setInt(2,year);
        pst.setString(3,director);
        pst.setString(4,music);

        int rows=pst.executeUpdate();
        if(rows>0)
            System.out.println("Movie added successfully");
        else
           System.out.println("Failed to add movie");
    }
    public static void viewMovies() throws SQLException{
        try{
            String sql = "SELECT * FROM Movie";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("\n---Movie List---");
            while(rs.next()){
                System.out.println(
    rs.getInt("movie_id") + " | " +
    rs.getString("myname") + " | " +
    rs.getInt("myyear") + " | " +
    rs.getString("mydirector") + " | " +
    rs.getString("mymusic")
);

            }

        }
        catch(Exception e){
            System.out.println("Error fetch movies: "+e);
        }
    }

    //mainmethod

    public static void main(String[] args)throws Exception{
        connect();
        int choice;

        do{
            System.out.println("\n---Movie Database Menu---");
            System.out.println("1.Add Movie");
            System.out.println("2.View All Movie");
            System.out.println("3.Search Movie by year");
            System.out.println("4.Search Movie by director");
            System.out.println("5.Update Music");
            System.out.println("6.Delete Movie");
            System.out.println("7.Exit");
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: addMovie();break;
                case 2: viewMovies();break;
                //case 3: searchMovieByYear();break;
                //case 4: searchMovieBydirector();break;
                //case 5: updateMovieMusic();break;
                //case 6: deleteMovie();break;
                case 7:
                    System.out.println("Existing...");break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

           while(choice!=7);
            try{
                con.close();
            }
            catch(Exception e){
                System.out.println("Error closing connection: "+e);
            }
           
    }


}