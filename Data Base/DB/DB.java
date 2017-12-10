package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


import flate.Flate;
import flate.Build;
import flate.BBuilder;


public class DB {

    public static Connection getNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Properties properties = PropertyManager.getProperties();
        String url = properties.getProperty("jdbc.url");
        return DriverManager.getConnection(url, properties);
    }

    private static void createBuildTable(Connection conn) throws SQLException {
        String prepCreate1="CREATE TABLE build\n" +
                "(id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                " streetName VARCHAR(50),\n" +
                " numberOfBuild VARCHAR(5) ,\n"+"" +
                " numberOfFlats INTEGER NOT NULL );";
        PreparedStatement prep1 =  conn.prepareStatement(prepCreate1);
        prep1.executeUpdate();
    }

    private static void createFlatsTable(Connection conn) throws SQLException {
        String prepCreate1="CREATE TABLE flat\n" +
                "(id INTEGER PRIMARY KEY  AUTO_INCREMENT NOT NULL,\n" +
                " number INTEGER NOT NULL,\n" +
                " roomsCount INTEGER NOT NULL,\n" +
                " square INTEGER NOT NULL,\n"  +
                " ownerName VARCHAR(50),\n"+
                " build_id INTEGER REFERENCES build(id) );";
        PreparedStatement prep1 =  conn.prepareStatement(prepCreate1);
        prep1.executeUpdate();
    }

    public static void setDatabase() throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();
        createBuildTable(conn);
        createFlatsTable(conn);
        conn.close();
    }

    public static void addFlat(Flate flat,Build build) throws ClassNotFoundException, SQLException {
        Connection conn = getNewConnection();
        Statement st = conn.createStatement();
        String preparedQuerry1="Insert into flat (number,roomsCount,square,ownerName,build_id) values(?,?,?,?,?)";
        PreparedStatement preparedStmt =  conn.prepareStatement(preparedQuerry1);
        preparedStmt.setInt(1,flat.getNumber());
        preparedStmt.setInt(2,flat.getRoomsCount());
        preparedStmt.setInt(3,flat.getSquare());
        preparedStmt.setString(4,flat.getOwnerName());
        preparedStmt.setInt(5,build.getBuildID());
        preparedStmt.executeUpdate();
    }
    public static Build addBuildWithoutFlats(Build build) throws ClassNotFoundException, SQLException{
        Connection conn = getNewConnection();
        String preparedUpdate1="Insert into build (streetName,nuberOfBuild, numberOfFlats) values(?,?,?);";
        PreparedStatement pr1= conn.prepareStatement(preparedUpdate1);
        pr1.setString(1, build.getStreetName());
        pr1.setString(2, build.getNumberOfBuild());
        pr1.setDouble(3, build.getNumberOfFlats());
        pr1.executeUpdate();

        String preparedQuery1="Select id FROM build WHERE numberOfBuild=? ;";
        PreparedStatement pr2= conn.prepareStatement(preparedQuery1);
        pr2.setString(1, build.getNumberOfBuild());
        ResultSet rs=pr2.executeQuery();
        if(rs.next())
            build.setBuildID(rs.getInt("id"));
        return build;
    }
    public static void addBuild(Build build) throws ClassNotFoundException, SQLException {
        build=addBuildWithoutFlats(build);

        for(Flate flat : build.getAr()) {
            addFlat(flat, build);
        }
    }

    public static Flate getFlatByNumber(int numberFlat) throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();
        String preparedQuerry1="SELECT f.number as number,"
                + "f.roomsCount as roomsCount,"
                + "f.square as square,"
                + "f.id as id,"
                + "f.ownerName as ownerName,"
                + "f.build_id as build_id FROM car c"
                +" WHERE  f.number=?;";

        PreparedStatement preparedStmt1=conn.prepareStatement(preparedQuerry1);
        preparedStmt1.setInt(1,numberFlat);
        ResultSet rs = preparedStmt1.executeQuery();

        Flate flat = null;
        if(rs.next()) {
            flat = new Flate.Builder().setNumber(rs.getInt("number")).createFlat();
            flat.setOwnerName(rs.getString("ownerName"));
            flat.setRoomsCount(rs.getInt("roomsCount"));
            flat.setSquare(rs.getInt("square.3"));
            flat.setFlatID(rs.getInt("id"));
            flat.setBuildID(rs.getInt("id"));
        }
        conn.close();
        return flat;
    }

    public static ArrayList<Flate> getFlatsByBuild(Build build) throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();
        String preparedQuerry1="SELECT * FROM flat WHERE build_id=?;";

        PreparedStatement preparedStmt1=conn.prepareStatement(preparedQuerry1);
        preparedStmt1.setInt(1,build.getBuildID());
        ResultSet rs = preparedStmt1.executeQuery();
        ArrayList<Flate> ResFlats = new ArrayList<Flate>();
        Flate flat = null;

        while (rs.next()) {
            flat =  new Flate.Builder().setNumber(rs.getInt("number")).createFlat();
            flat.setFlatID(rs.getInt("id"));
            flat.setBuildID(rs.getInt("build_id"));
            ResFlats.add(flat);
        }
        conn.close();
        return ResFlats;
    }

    public static Build getBuildByNumber(String numberOfBuild) throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();
        String preparedQuerry1="SELECT * FROM build WHERE numberOfBuild=?;";

        PreparedStatement preparedStmt1=conn.prepareStatement(preparedQuerry1);
        preparedStmt1.setString(1,numberOfBuild);
        ResultSet rs = preparedStmt1.executeQuery();
        Build build= null;

        if (rs.next()) {
            build = new BBuilder(rs.getString("streetName")).
                    setNumberOfFlats(rs.getInt("numberOfFlats")).setNumberOfBuild(rs.getString("numberOfBuild")).createBuild();
            build.setBuildID(rs.getInt("id"));
            ArrayList<Flate> flats = new ArrayList<Flate>();
            flats.addAll(getFlatsByBuild(build));
            for(Flate flat : flats) {
                build.add(flat);
            }
        }

        conn.close();
        return build;
    }

   

    public static void updateBuild(Build build) throws ClassNotFoundException, SQLException {
        Connection conn = getNewConnection();
        String prepUpdate1="UPDATE build SET numberOfBuild=?,numberOfFlats =?, streetName =?" +
                " WHERE ID=?;";
        String prepQuery1="Select * from flat where build_id= ? ;";

        PreparedStatement pr1= conn.prepareStatement(prepUpdate1);
        pr1.setString(1, build.getNumberOfBuild());
        pr1.setInt(2, build.getNumberOfFlats());
        pr1.setString(3, build.getStreetName());
        int res= pr1.executeUpdate();

        PreparedStatement pr2= conn.prepareStatement(prepQuery1);
        pr2.setInt(1, build.getBuildID());
        ResultSet rs1 = pr2.executeQuery();

        while(rs1.next())
            deleteFlat(rs1.getInt("number"));
        for(Flate flat :  build.getAr()) {
            addFlat(flat,build);
        }
        conn.close();
        if(res == 0) throw new IllegalArgumentException("G not found");
    }

    public static void deleteFlat(int number) throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();

        String prepQuery1="Select * from flat where number= ?;";
        String prepDelete1="DELETE FROM flat WHERE number= ? ;";
        PreparedStatement pr1= conn.prepareStatement(prepQuery1);
        pr1.setInt(1, number);
        ResultSet r1= pr1.executeQuery();

        if(r1.next())
        {Flate flat = new Flate.Builder().setNumber(number).createFlat();
            flat.setBuildID(r1.getInt("id"));

            PreparedStatement pr2= conn.prepareStatement(prepDelete1);
            pr2.setInt(1, flat.getNumber());
            int rs = pr2.executeUpdate();
            conn.close();
            if(rs == 0) throw new IllegalArgumentException("Flat not found");
        }
        }

    public static void deleteBuild(String numberOfBuild) throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();
        String prepQuery1="Select id from build where numberOfBuild= ? ;";
        String prepDelete1="DELETE FROM build WHERE numberOfBuild= ?;";
        String prepQuery2="Select number from flat where build_id = ?;";
        PreparedStatement pr1 = conn.prepareStatement(prepQuery1);
        pr1.setString(1, numberOfBuild);
        ResultSet r1= pr1.executeQuery();
        if(r1.next())
        {int idBuild = r1.getInt("build_id");

            PreparedStatement pr2 = conn.prepareStatement(prepDelete1);
            pr2.setString(1, numberOfBuild);
            int rs = pr2.executeUpdate();

            PreparedStatement pr3 = conn.prepareStatement(prepQuery2);
            pr3.setInt(1, idBuild);
            ResultSet r2 = pr3.executeQuery();

            while(r2.next()) {
                deleteFlat(r2.getInt("number"));
            }
            conn.close();
            if(rs == 0) throw new IllegalArgumentException("Build not found");
        }
        }
    public static Build getBuildByFlat (Flate flat) throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();
        String prepQuerry1="Select * from flat f inner join  build b "
                + "on b.id != f.build_id and f.number= ?;";
        PreparedStatement pr1 = conn.prepareStatement(prepQuerry1);
        pr1.setInt(1, flat.getNumber());
        ResultSet rs1=pr1.executeQuery();
        Build build=null;
        if(rs1.next()) {
            build=new BBuilder(rs1.getString("streetName")).setNumberOfFlats(rs1.getInt("garage_numberOfFlats"))
                    .setNumberOfBuild(String.valueOf(rs1.getString("numberOfBuild"))).createBuild();
            build.setBuildID(rs1.getInt("id"));
            ArrayList<Flate> flat1=new ArrayList<Flate>();
            flat1=getFlatsByBuild(build);
            for(Flate flat2 : flat1) {
                build.add(flat2);
            }
        }
        return build;
    }

    private static void drop() throws SQLException, ClassNotFoundException {
        Connection conn = getNewConnection();
        Statement st = conn.createStatement();
        st.executeUpdate("DROP TABLE IF EXISTS 'flat';");
        st.executeUpdate("DROP TABLE IF EXISTS 'build';");
        conn.close();
    }

}