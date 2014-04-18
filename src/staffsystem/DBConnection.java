/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lewis
 */
public class DBConnection {

    Connection conn = null;
    String query;
    String todayDate;
    String date;
    int count;
    private PreparedStatement statement;
    private ResultSet result;
    
    ChildList childList;
    RelativeList relativeList;
    RelationshipList relationshipList;
    StaffList staffList;
    RoomList roomList;
    BookingList bookingList;
    ChildRoomList childRoomList;
    StaffsRoomList staffRoomList;

    public void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/nurserybooking","root","root");
        } catch (SQLException ex) {
            // handle errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public void closeConnection() throws SQLException{
        conn.close();
    } 
    
    public boolean checkLogin(String userName, char[] password) throws SQLException{
        boolean correct = false;
        int i = 0;
        
        String pass = new String(password);
        
        query = "SELECT * FROM STAFF WHERE USERNAME = '"+ userName +
                "' AND PASSWORD = '"+ pass + "'";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        while(result.next()){
            i++;
        } 
        
        if(i > 0){
            correct = true;
        }
        return correct;
    }
    
    public boolean addChild(String firstName, String surname,
            String knownAs, String sex, String dateOfBirth, int position,
            String religion, String ethnicOrigin, String languages,
            String medicalConditions, String immunisations, String dietaryNeeds,
            String notes) throws SQLException, ClassNotFoundException{
        boolean temp = false;
        try{
            query = "INSERT INTO child VALUES (NULL, '" + firstName + "','" +
                    surname + "','" + knownAs + "','" + sex + "','" +
                    dateOfBirth + "'," + position + ",'" + religion + "','" +
                    ethnicOrigin + "','" + languages + "','" + medicalConditions
                    + "','" + immunisations + "','" + dietaryNeeds + "','" +
                    notes + "')";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch(Exception e){
             System.out.println(e);
        }
        return temp;
    }
    
    public ChildList viewAllChildren() throws SQLException{
        query = "SELECT * FROM child ORDER BY surname";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.childList = new ChildList(result);

        return this.childList;
    }
    
    public ChildList searchAllChildren(String search) throws SQLException{
        query = "SELECT * FROM child WHERE firstName LIKE '%"+search+"%' OR "
                + "surname LIKE '%"+search+"%' ORDER BY surname";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.childList = new ChildList(result);

        return this.childList;
    }
    
    public BookingList getChildBookings(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "SELECT * FROM booking WHERE childID = " + id;
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);
        return this.bookingList;
    }
    
    public BookingList searchChildBookings(int id, String search) throws SQLException{
        query = "SELECT * FROM booking WHERE Date LIKE '%"+search+"%' AND childID = "+id+" OR "
                + "Session LIKE '%"+search+"%' AND childID = "+id+" ORDER BY Date";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public RelationshipList getChildRelatives(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "SELECT * FROM relationship WHERE childID = " + id;
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();
        
        this.relationshipList = new RelationshipList(result);
        
        return this.relationshipList;
    }
    
    public ChildRoomList getChildRoom(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "SELECT childroom.childRoomID, childroom.ChildID, room.roomID "
                + "FROM room JOIN childroom ON room.roomID = "
                + "childroom.roomID JOIN child ON child.childID = "
                + "childRoom.childID WHERE childroom.childID = " + id;
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();
        
        this.childRoomList = new ChildRoomList(result);
        
        return this.childRoomList;
    }
    
    public Boolean editChild(String stringID, String firstName, String surname,
            String knownAs, String sex, String dateOfBirth, int position,
            String religion, String ethnic, String languages, String medical,
            String immunisations, String dietary, String notes){
        int id = Integer.parseInt(stringID);
        Boolean temp = false;
        try{
            query = "UPDATE child SET firstName='"+firstName+
                    "',surname='"+surname+"', knownAs='"+knownAs+
                    "', sex='"+sex+"', dateOfBirth='"+
                    dateOfBirth+"', positionInFamily="+position+
                    ", religion='" + religion + "', ethnicOrigin='" + ethnic
                    + "' , languagesSpoken='"+languages+"', medicalConditions='"
                    + medical+"', immunisations='"+immunisations+"', "
                    + "dietaryNeeds='"+dietary+"', notes ='" + notes +
                    " ' WHERE childID = "+id;
            
                    statement = conn.prepareStatement(query);
                    statement.executeUpdate();
                    temp = true;    
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return temp;
    }
    
    public void deleteChild(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "DELETE FROM child WHERE childID = " + id;
        statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }
    
    public boolean addRelative(String firstName, String surname, String address1,
            String address2, String postCode, String contactNumber,
            String mobileNumber, String email, String password){
        boolean temp = false;
        try{
            query = "INSERT INTO relative VALUES (NULL, '" + firstName + "','" +
                    surname + "','" + address1 + "','" + address2 + "','" +
                    postCode + "', '" + contactNumber +"','" + mobileNumber +
                    "','" + email + "','" + password + "')";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch(Exception e){
             System.out.println(e);
        }
        return temp;
    }
    
    public RelationshipList getRelativesChild(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "SELECT * FROM relationship WHERE relativeID = " + id;
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();
        
        this.relationshipList = new RelationshipList(result);
        
        return this.relationshipList;
    }
    
    public RelativeList viewAllRelatives() throws SQLException{
        query = "SELECT * FROM relative ORDER BY surname";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.relativeList = new RelativeList(result);

        return this.relativeList;
    }
    
    public RelativeList searchAllRelatives(String search) throws SQLException{
        query = "SELECT * FROM relative WHERE firstName LIKE '%"+search+"%' OR "
                + "surname LIKE '%"+search+"%' ORDER BY surname";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.relativeList = new RelativeList(result);

        return this.relativeList;
    }
    
    public Boolean editRelative(String stringID, String firstName, String surname,
            String address1, String address2, String postCode, String contact,
            String mobile, String email, String password){
        int id = Integer.parseInt(stringID);
        Boolean temp = false;
        try{
            query = "UPDATE relative SET firstName='"+firstName+
                    "',surname='"+surname+"', addressLine1='"+address1+
                    "', addressLine2='"+address2+"', postCode='"+
                    postCode+"', contactNumber="+contact+
                    ", mobileNumber='" + mobile + "', emailAddress='" + email
                    + "' , password='"+password+"' WHERE relativeID = "+id;     

                    statement = conn.prepareStatement(query);
                    statement.executeUpdate();
                    temp = true;    
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return temp;
    }
    
    public void deleteRelative(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "DELETE FROM relative WHERE relativeID = " + id;
        statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }
    
    public boolean addRelationship(String childID, String relativeID, String relation, String legal){
        boolean temp = false;
        try{
            query = "INSERT INTO relationship VALUES (NULL, '" + childID + "','" +
                    relativeID + "','" + relation + "','" + legal + "')";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch(Exception e){
             System.out.println(e);
        }
        return temp;
    }
    
    public boolean addStaff(String firstName, String surname, String dateOfBirth,
            String addressLine1, String addressLine2, String postCode,
            String contactNumber, String mobileNumber, String medicalConditions,
            String dietaryNeeds, String username, String password) {
        boolean temp = false;
        try{
            query = "INSERT INTO staff VALUES (NULL, '" + firstName + "','" +
                    surname + "','" + dateOfBirth + "','" + addressLine1 + "','" +
                    addressLine2 + "','" + postCode + "','" + contactNumber + "','" +
                    mobileNumber + "','" + medicalConditions + "','" + dietaryNeeds
                    + "','" + username + "','" + password + "')";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch(Exception e){
             System.out.println(e);
        }
        return temp;
    }
    
    public StaffList viewAllStaff() throws SQLException{
        query = "SELECT * FROM staff ORDER BY surname";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.staffList = new StaffList(result);

        return this.staffList;
    }
    
    public StaffList searchAllStaff(String search) throws SQLException{
        query = "SELECT * FROM staff WHERE firstName LIKE '%"+search+"%' OR "
                + "surname LIKE '%"+search+"%' ORDER BY surname";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.staffList = new StaffList(result);

        return this.staffList;
    }
    
    public StaffsRoomList getStaffRoom(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "SELECT * FROM staffsroom WHERE staffID = " + id;
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();
        
        this.staffRoomList = new StaffsRoomList(result);
        
        return this.staffRoomList;
    }
    
    public void deleteStaff(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "DELETE FROM staff WHERE staffID = " + id;
        statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }
    
    public boolean addRoom(String roomName, String ageMin, String ageMax,
            String ratio, String maxNumChildren){
        boolean temp = false;
        try{
            query = "INSERT INTO room VALUES (NULL, '" + roomName + "','" +
                    ageMin + "','" + ageMax + "','" + ratio + "','" +
                    maxNumChildren + "')";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch(Exception e){
             System.out.println(e);
        }
        return temp;
    }
    
    public RoomList viewAllRooms() throws SQLException{
        query = "SELECT * FROM room ORDER BY ageMin";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.roomList = new RoomList(result);

        return this.roomList;
    }
    
    public RoomList searchAllRooms(String search) throws SQLException{
        query = "SELECT * FROM room WHERE roomName LIKE '%"+search+"%' ORDER BY"
                + " ageMin";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.roomList = new RoomList(result);

        return this.roomList;
    }
    
    public void deleteRoom(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "DELETE FROM room WHERE roomID = " + id;
        statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }

    public boolean addBooking(String childID, String roomID, String date, String session, String notes) {
        boolean temp = false;
        try{
            query = "INSERT INTO booking VALUES (NULL, '" + childID + "','" +
                    roomID + "','" + date + "','" + session + "','" + notes + "')";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch(Exception e){
             System.out.println(e);
        }
        return temp;
    }
    
    public BookingList viewAllBookings() throws SQLException{
        query = "SELECT * FROM booking ORDER BY Date";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList searchAllBookings(String search) throws SQLException{
        query = "SELECT * FROM booking WHERE Date LIKE '%"+search+"%' OR "
                + "Session LIKE '%"+search+"%' ORDER BY Date";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewTodayBreakfastBookings() throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        todayDate = dateFormat.format(cal.getTime());
        query = "SELECT * FROM booking WHERE date = '" + todayDate + "' AND roomID = 17";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewTodaySnowdropBookings() throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        todayDate = dateFormat.format(cal.getTime());
        query = "SELECT * FROM booking WHERE date = '" + todayDate + "' AND roomID = 11";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewTodayButtercupBookings() throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        todayDate = dateFormat.format(cal.getTime());
        query = "SELECT * FROM booking WHERE date = '" + todayDate + "' AND roomID = 12";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewTodayBluebellBookings() throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        todayDate = dateFormat.format(cal.getTime());
        query = "SELECT * FROM booking WHERE date = '" + todayDate + "' AND roomID = 13";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewTodayFoxgloveBookings() throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        todayDate = dateFormat.format(cal.getTime());
        query = "SELECT * FROM booking WHERE date = '" + todayDate + "' AND roomID = 14";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewTodayOSCAmBookings() throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        todayDate = dateFormat.format(cal.getTime());
        query = "SELECT * FROM booking WHERE date = '" + todayDate + "' AND roomID = 15";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewTodayOSCPmBookings() throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        todayDate = dateFormat.format(cal.getTime());
        query = "SELECT * FROM booking WHERE date = '" + todayDate + "' AND roomID = 16";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewRegistersBreakfastBookings(String date) throws SQLException{
        query = "SELECT * FROM booking WHERE date like '%" + date + "%' AND roomID = 17";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewRegistersSnowdropBookings(String date) throws SQLException{
        query = "SELECT * FROM booking WHERE date like '%" + date + "%' AND roomID = 11";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewRegistersButtercupBookings(String date) throws SQLException{
        query = "SELECT * FROM booking WHERE date like '%" + date + "%' AND roomID = 12";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewRegistersBluebellBookings(String date) throws SQLException{
        query = "SELECT * FROM booking WHERE date like '%" + date + "%' AND roomID = 13";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewRegistersFoxgloveBookings(String date) throws SQLException{
        query = "SELECT * FROM booking WHERE date like '%" + date + "%' AND roomID = 14";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewRegistersOSCAmBookings(String date) throws SQLException{
        query = "SELECT * FROM booking WHERE date like '%" + date + "%' AND roomID = 15";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }
    
    public BookingList ViewRegistersOSCPmBookings(String date) throws SQLException{
        query = "SELECT * FROM booking WHERE date like '%" + date + "%' AND roomID = 16";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();

        this.bookingList = new BookingList(result);

        return this.bookingList;
    }

    public void deleteBooking(String stringID) throws SQLException{
        int id = Integer.parseInt(stringID);
        
        query = "DELETE FROM booking WHERE bookingID = " + id;
        statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }

    public Boolean editBooking(String stringID, String date, String session, String notes) {
        int id = Integer.parseInt(stringID);
        
        Boolean temp = false;
        try{
            query = "UPDATE booking SET Date='"+date+
                    "',Session='"+session+"', Notes='"+notes+
                    "' WHERE bookingID = "+id;     

                    statement = conn.prepareStatement(query);
                    statement.executeUpdate();
                    temp = true;    
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return temp;
    }

    public Boolean editStaff(String stringID, String firstName, String surname,
            String dateOfBirth, String address1, String address2,
            String postCode, String contact, String mobile, String medical,
            String dietary, String username, String password){
        int id = Integer.parseInt(stringID);
        Boolean temp = false;
        try{
            query = "UPDATE staff SET firstName='"+ firstName+"', surname='"+
                    surname+"',dateOfBirth='"+dateOfBirth+"',addressLine1='"+
                    address1+"',addressLine2='"+address2+"',postCode='"+postCode
                    +"',contactNumber='"+contact+"',mobileNumber='"+mobile+
                    "',medicalConditions='"+medical+"',dietaryNeeds='"+dietary+
                    "',userName='"+username+"',password='"+password+"' WHERE"
                    + " staffID = " + id;
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return temp;
    }

    public Boolean editRoom(String stringID, String roomName, String ageMin, String ageMax,
            String ratio, String maxNum) {
        int id = Integer.parseInt(stringID);
        Boolean temp = false;
        try{
        query = "UPDATE room SET roomName='"+ roomName+"', ageMin='"+
                    ageMin+"',ageMax='"+ageMax+"',staffToChildRatio='"+
                    ratio+"',maxNumChildren='"+maxNum+"' WHERE roomID = " + id;
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
            temp = true;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return temp;
    }

    void addStaffRoom(String stringStaffID, String stringRoomID) {
        int staffID = Integer.parseInt(stringStaffID);
        int roomID = Integer.parseInt(stringRoomID);
        try{
            query = "INSERT INTO staffsRoom VALUES (NULL, "+staffID+","+roomID+")";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    public void deleteStaffRoom(String stringStaffRoomID) {
        int staffRoomID = Integer.parseInt(stringStaffRoomID);
        try{
            query = "DELETE FROM staffsRoom WHERE staffsRoomID = "+staffRoomID;
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    void addChildRoom(String stringChildID, String stringRoomID) {
        int childID = Integer.parseInt(stringChildID);
        int roomID = Integer.parseInt(stringRoomID);
        try{
            query = "INSERT INTO childRoom VALUES (NULL, "+childID+","+roomID+")";
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteChildRoom(String stringChildRoomID) {
        int childRoomID = Integer.parseInt(stringChildRoomID);
        try{
            query = "DELETE FROM childRoom WHERE childRoomID = "+childRoomID;
            statement = conn.prepareStatement(query);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
    
}
