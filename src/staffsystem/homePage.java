/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lcooper2
 */
public final class homePage extends javax.swing.JFrame {

    int childIndex;
    int relativeIndex;
    int staffIndex;
    int roomIndex;
    int bookingIndex;
    int todayBreakfastNumbers;
    int todaySnowdropNumbers;
    int todayButtercupNumbers;
    int todayBluebellNumbers;
    int todayFoxgloveNumbers;
    int todayOSCAmNumbers;
    int todayOSCPmNumbers;
    
    String selectedChild;
    String selectedRelative;
    String selectedStaff;
    String selectedRoom;
    String selectedBooking;
    String todayBreakfast;
    String todaySnowdrop;
    String todayButtercup;
    String todayBluebell;
    String todayFoxglove;
    String todayOSCAm;
    String todayOSCPm;
    
    String[] childInfo;
    String[] relativeInfo;
    String[] staffInfo;
    String[] roomInfo;
    String[] bookingInfo;
    String[] staffRoomInfo;
    String[] childRoomInfo;
    
    Object thisChild;
    Object thisRelative;
    Object thisStaff;
    Object thisRoom;
    Object thisBooking;
    
    Boolean childBreakfast;
    Boolean childSnowdrop;
    Boolean childButtercup;
    Boolean childBluebell;
    Boolean childFoxglove;
    Boolean childOSCam;
    Boolean childOSCpm;
    Boolean staffBreakfast;
    Boolean staffSnowdrop;
    Boolean staffButtercup;
    Boolean staffBluebell;
    Boolean staffFoxglove;
    Boolean staffOSCam;
    Boolean staffOSCpm;

    Child child;
    ChildList childList = new ChildList();
    Relative relative;
    RelativeList relativeList = new RelativeList();
    Relative relativeChild;
    RelativeList relativeChildList = new RelativeList();
    Relationship relationship;
    RelationshipList relativeRelationshipList = new RelationshipList();
    RelationshipList childRelationshipList = new RelationshipList();
    Staff staff;
    StaffList staffList = new StaffList();
    Room room;
    RoomList roomList = new RoomList();
    Booking booking;
    BookingList bookingList = new BookingList();
    BookingList todayBreakfastBookingList = new BookingList();
    BookingList todaySnowdropBookingList = new BookingList();
    BookingList todayButtercupBookingList = new BookingList();
    BookingList todayBluebellBookingList = new BookingList();
    BookingList todayFoxgloveBookingList = new BookingList();
    BookingList todayOSCAmBookingList = new BookingList();
    BookingList todayOSCPmBookingList = new BookingList();
    BookingList registersBreakfastBookingList = new BookingList();
    BookingList registersSnowdropBookingList = new BookingList();
    BookingList registersButtercupBookingList = new BookingList();
    BookingList registersBluebellBookingList = new BookingList();
    BookingList registersFoxgloveBookingList = new BookingList();
    BookingList registersOSCAmBookingList = new BookingList();
    BookingList registersOSCPmBookingList = new BookingList();
    ChildRoom childRoom;
    ChildRoomList childRoomList = new ChildRoomList();
    StaffsRoom staffRoom;
    StaffsRoomList staffRoomList = new StaffsRoomList();
    
    DBConnection connect;
    private int registersBreakfastNumbers;
    private String registersBreakfast;
    private int registersSnowdropNumbers;
    private String registersSnowdrop;
    private int registersButtercupNumbers;
    private String registersButtercup;
    private int registersBluebellNumbers;
    private String registersBluebell;
    private int registersFoxgloveNumbers;
    private String registersFoxglove;
    private int registersOSCAmNumbers;
    private String registersOSCAm;
    private int registersOSCPmNumbers;
    private String registersOSCPm;
    private int staffRoomIndex;
    private Object thisStaffRoom;
    private String selectedStaffRoom;
    private int childRoomIndex;
    private Object thisChildRoom;
    private String selectedChildRoom;
    /**
     * Creates new form homePage
     */
    public homePage() throws SQLException, ClassNotFoundException {
        initComponents();
        getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        
        connect = new DBConnection();
        this.connect.dbConnect();
        
        setRoomList();
        setChildList();
        setRelativeList();
        setStaffList();
        setBookingList();
        setTodayBreakfastList();
        setTodayBreakfastNumbers();
        setTodaySnowdropList();
        setTodaySnowdropNumbers();
        setTodayButtercupList();
        setTodayButtercupNumbers();
        setTodayBluebellList();
        setTodayBluebellNumbers();
        setTodayFoxgloveList();
        setTodayFoxgloveNumbers();
        setTodayOSCAmList();
        setTodayOSCAmNumbers();
        setTodayOSCPmList();
        setTodayOSCPmNumbers();
        setRegistersBreakfastList();
        
        setRegistersSnowdropList();
        setRegistersSnowdropNumbers();
        setRegistersButtercupList();
        setRegistersButtercupNumbers();
        setRegistersBluebellList();
        setRegistersBluebellNumbers();
        setRegistersFoxgloveList();
        setRegistersFoxgloveNumbers();
        setRegistersOSCAmList();
        setRegistersOSCAmNumbers();
        setRegistersOSCPmList();
        setRegistersOSCPmNumbers();
    }
    
    public void setChildList() throws SQLException{
        this.childList = this.connect.viewAllChildren();
        jListChildren.setListData(this.childList.getAllChildren());
        jListChildren.setSelectedIndex(0);
        
        updateChildList();
    }
    
    public void searchChildList() throws SQLException{
        this.childList = this.connect.searchAllChildren(jTextFieldSearchChild.getText());
        jListChildren.setListData(this.childList.getAllChildren());
        jListChildren.setSelectedIndex(0);
        
        updateChildList();
    }
    
    public void updateChildList() throws SQLException{
        childIndex = jListChildren.getSelectedIndex();
        thisChild = jListChildren.getModel().getElementAt(childIndex);
        selectedChild = thisChild.toString();
        childInfo = selectedChild.split(": ");
        child = this.childList.getChildAt(childInfo[0]);
        
        this.relativeRelationshipList = this.connect.getChildRelatives(childInfo[0]);
        this.childRoomList = this.connect.getChildRoom(childInfo[0]);

        //Set text boxes to child selected
        jTextFieldFirstNameChild.setText(child.getFirstName());
        jTextFieldSurnameChild.setText(child.getSurname());
        jTextFieldKnownAsChild.setText(child.getKnownAs());
        jTextFieldDOBChild.setText(child.getDateOfBirth());
        jTextFieldSexChild.setText(child.getSex());
        jTextFieldPositionChild.setText(child.getPositionAsString());
        jTextFieldReligionChild.setText(child.getReligion());
        jTextFieldEthnicOriginChild.setText(child.getEthnicOrigin());
        jTextFieldLanguagesChild.setText(child.getLanguagesSpoken());
        jTextFieldMedicalChild.setText(child.getMedicalConditions());
        jTextFieldImmunisationsChild.setText(child.getImmunisations());
        jTextFieldDietaryNeedsChild.setText(child.getDietaryNeeds());
        jTextAreaNotes.setText(child.getNotes());
        jListRelativesChildren.setListData(this.relativeRelationshipList.getAllRelationships());
        //jListChildRoom.setListData(this.childRoomList.getChildRoomNames(Integer.parseInt(childInfo[0])).toArray());
        jListChildRoom.setListData(this.childRoomList.getAllChildRooms());
        jListChildRoom.setSelectedIndex(0);

        updateChildRoomList();
    }
    
    public void updateChildRoomList() throws SQLException{
        childRoomIndex = jListChildRoom.getSelectedIndex();
        thisChildRoom = jListChildRoom.getModel().getElementAt(childRoomIndex);
        selectedChildRoom = thisChildRoom.toString();
        childRoomInfo = selectedChildRoom.split(": ");
        childRoom = this.childRoomList.getChildRoomAt(childInfo[0]);
        
        this.childRoomList = this.connect.getChildRoom(childInfo[0]);
    }
    
    public void setRelativeList() throws SQLException{
        this.relativeList = this.connect.viewAllRelatives();
        jListRelatives.setListData(this.relativeList.getAllRelatives());
        jListRelatives.setSelectedIndex(0);
        
        updateRelativeList();
    }
    
    public void searchRelativeList() throws SQLException{
        this.relativeList = this.connect.searchAllRelatives(jTextFieldSearchRelatives.getText());
        jListRelatives.setListData(this.relativeList.getAllRelatives());
        jListRelatives.setSelectedIndex(0);
        
        updateRelativeList();
    }
    
    public void updateRelativeList() throws SQLException{
        relativeIndex = jListRelatives.getSelectedIndex();
        thisRelative = jListRelatives.getModel().getElementAt(relativeIndex);
        selectedRelative = thisRelative.toString();
        relativeInfo = selectedRelative.split(": ");
        relative = this.relativeList.getRelativeAt(relativeInfo[0]);
        
        this.childRelationshipList = this.connect.getRelativesChild(relativeInfo[0]);
        
        //set text boxes equal to relative selected
        jTextFieldFirstNameRelative.setText(relative.getFirstName());
        jTextFieldSurnameRelative.setText(relative.getSurname());
        jTextFieldAddress1Relative.setText(relative.getAddressLine1());
        jTextFieldAddress2Relative.setText(relative.getAddressLine2());
        jTextFieldPostCodeRelative.setText(relative.getPostCode());
        jTextFieldContactNumRelative.setText(relative.getContactNumber());
        jTextFieldMobileNumRelative.setText(relative.getMobileNumber());
        jTextFieldEmailRelative.setText(relative.getEmailAddress());
        jTextFieldPasswordRelative.setText(relative.getPassword());
        jListChildrenRelative.setListData(this.childRelationshipList.getAllRelationships());
    }
    
    public void setStaffList() throws SQLException{
        this.staffList = this.connect.viewAllStaff();
        jListStaff.setListData(this.staffList.getAllStaff());
        jListStaff.setSelectedIndex(0);
        
        updateStaffList();
    }
    
    public void searchStaffList() throws SQLException{
        this.staffList = this.connect.searchAllStaff(jTextFieldSearchStaff.getText());
        jListStaff.setListData(this.staffList.getAllStaff());
        jListStaff.setSelectedIndex(0);
        
        updateStaffList();
    }
    
    public void updateStaffList() throws SQLException{
        staffIndex = jListStaff.getSelectedIndex();
        thisStaff = jListStaff.getModel().getElementAt(staffIndex);
        selectedStaff = thisStaff.toString();
        staffInfo = selectedStaff.split(": ");
        staff = this.staffList.getStaffAt(staffInfo[0]);

        //set text boxes equal to staff member selected
        jTextFieldFirstNameStaff.setText(staff.getFirstName());
        jTextFieldSurnameStaff.setText(staff.getSurname());
        jTextFieldDOBStaff.setText(staff.getDateOfBirth());
        jTextFieldAddress1Staff.setText(staff.getAddressLine1());
        jTextFieldAddress2Staff.setText(staff.getAddressLine2());
        jTextFieldPostCodeStaff.setText(staff.getPostCode());
        jTextFieldContactNumStaff.setText(staff.getContactNumber());
        jTextFieldMobileNumStaff.setText(staff.getMobileNumber());
        jTextFieldMedicalConditionsStaff.setText(staff.getMedicalConditions());
        jTextFieldDietaryNeedsStaff.setText(staff.getDietaryNeeds());
        jTextFieldUsernameStaff.setText(staff.getUsername());
        jTextFieldPasswordStaff.setText(staff.getPassword());
        
        this.staffRoomList = this.connect.getStaffRoom(staffInfo[0]);
        jListStaffRoom.setListData(this.staffRoomList.getAllStaffRoom());
        jListStaffRoom.setSelectedIndex(0);

        updateStaffRoomList();
    }
    
    public void updateStaffRoomList() throws SQLException{
        staffRoomIndex = jListStaffRoom.getSelectedIndex();
        thisStaffRoom = jListStaffRoom.getModel().getElementAt(staffRoomIndex);
        selectedStaffRoom = thisStaffRoom.toString();
        staffRoomInfo = selectedStaffRoom.split(": ");
        staffRoom = this.staffRoomList.getStaffRoomAt(staffInfo[0]);
        
        this.staffRoomList = this.connect.getStaffRoom(staffInfo[0]);
    }
    
    public void setRoomList() throws SQLException{
        this.roomList = this.connect.viewAllRooms();
        jListRooms.setListData(this.roomList.getAllRooms());
        jListRooms.setSelectedIndex(0);
        
        updateRoomList();
    }
    
    public void searchRoomList() throws SQLException{
        this.roomList = this.connect.searchAllRooms(jTextFieldSearchRooms.getText());
        jListRooms.setListData(this.roomList.getAllRooms());
        jListRooms.setSelectedIndex(0);
        
        updateRoomList();
    }
    
    public void updateRoomList(){
        roomIndex = jListRooms.getSelectedIndex();
        thisRoom = jListRooms.getModel().getElementAt(roomIndex);
        selectedRoom = thisRoom.toString();
        roomInfo = selectedRoom.split(", ");
        room = this.roomList.getRoomAt(roomInfo[0]);
        
        //set text boxes to relevant room item
        jTextFieldRoomNameRooms.setText(room.getRoomName());
        jTextFieldAgeMinRooms.setText(room.getAgeMin());
        jTextFieldAgeMaxRooms.setText(room.getAgeMax());
        jTextFieldRatioRooms.setText(room.getStaffToChildRatio());
        jTextFieldMaxNumberChildrenRooms.setText(room.getMaxNumChildren());
    }
    
    public void setBookingList() throws SQLException{
        this.bookingList = this.connect.viewAllBookings();
        jListBookings.setListData(this.bookingList.getAllBookings());
        jListBookings.setSelectedIndex(0);
        
        updateBookingList();
    }
    
    public void searchBookingList() throws SQLException{
        this.bookingList = this.connect.searchAllBookings(jTextFieldSearchBookings.getText());
        jListBookings.setListData(this.bookingList.getAllBookings());
        jListBookings.setSelectedIndex(0);
        
        updateBookingList();
    }
    
    public void updateBookingList(){
        bookingIndex = jListBookings.getSelectedIndex();
        thisBooking = jListBookings.getModel().getElementAt(bookingIndex);
        selectedBooking = thisBooking.toString();
        bookingInfo = selectedBooking.split(": ");
        booking = this.bookingList.getBookingAt(bookingInfo[0]);
        
        //set text boxes to selected booking item
        jTextFieldChildBookings.setText(booking.getChildIDAsString());
        jTextFieldRoomBookings.setText(booking.getRoomIDAsString());
        jTextFieldDateBookings.setText(booking.getDate());
        jTextFieldSessionBookings.setText(booking.getSession());
        jTextAreaNotesBookings.setText(booking.getNotes());
    }
    
    public void setTodayBreakfastList() throws SQLException{
        this.todayBreakfastBookingList = this.connect.ViewTodayBreakfastBookings();
        jListTodayBreakfast.setListData(this.todayBreakfastBookingList.getAllBookings());
        jListTodayBreakfast.setSelectedIndex(0);
        
        updateTodayBreakfastList();
    }
    
    public void updateTodayBreakfastList(){
        try{
            bookingIndex = jListTodayBreakfast.getSelectedIndex();
            thisBooking = jListTodayBreakfast.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.todayBreakfastBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildTodayBreakfast.setText(booking.getChildIDAsString());
            jTextFieldDOBTodayBreakfast.setText(booking.getChildIDAsString());
            jTextFieldSessionTodayBreakfast.setText(booking.getSession());
            jTextAreaNotesTodayBreakfast.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }

    }
    
    public void setTodayBreakfastNumbers() throws SQLException{
        todayBreakfastNumbers = this.todayBreakfastBookingList.size();
        todayBreakfast = todayBreakfastNumbers + "";
        jTextFieldTodayBreakfast.setText(todayBreakfast);
    }
    
    public void setTodaySnowdropList() throws SQLException{
        this.todaySnowdropBookingList = this.connect.ViewTodaySnowdropBookings();
        jListTodaySnowdrop.setListData(this.todaySnowdropBookingList.getAllBookings());
        jListTodaySnowdrop.setSelectedIndex(0);
        
        updateTodaySnowdropList();
    }
    
    public void updateTodaySnowdropList(){
        try{
            bookingIndex = jListTodaySnowdrop.getSelectedIndex();
            thisBooking = jListTodaySnowdrop.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.todaySnowdropBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildTodaySnowdrop.setText(booking.getChildIDAsString());
            jTextFieldDOBTodaySnowdrop.setText(booking.getChildIDAsString());
            jTextFieldSessionTodaySnowdrop.setText(booking.getSession());
            jTextAreaNotesTodaySnowdrop.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setTodaySnowdropNumbers() throws SQLException{
        todaySnowdropNumbers = this.todaySnowdropBookingList.size();
        todaySnowdrop = todaySnowdropNumbers + "";
        jTextFieldTodaySnowdrop.setText(todaySnowdrop);
    }
    
    public void setTodayButtercupList() throws SQLException{
        this.todayButtercupBookingList = this.connect.ViewTodayButtercupBookings();
        jListTodayButtercup.setListData(this.todayButtercupBookingList.getAllBookings());
        jListTodayButtercup.setSelectedIndex(0);
        
        updateTodayButtercupList();
    }
    
    public void updateTodayButtercupList(){
        try{
            bookingIndex = jListTodayButtercup.getSelectedIndex();
            thisBooking = jListTodayButtercup.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.todayButtercupBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildTodayButtercup.setText(booking.getChildIDAsString());
            jTextFieldDOBTodayButtercup.setText(booking.getChildIDAsString());
            jTextFieldSessionTodayButtercup.setText(booking.getSession());
            jTextAreaNotesTodayButtercup.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setTodayButtercupNumbers() throws SQLException{
        todayButtercupNumbers = this.todayButtercupBookingList.size();
        todayButtercup = todayButtercupNumbers + "";
        jTextFieldTodayButtercup.setText(todayButtercup);
    }
    
    public void setTodayBluebellList() throws SQLException{
        this.todayBluebellBookingList = this.connect.ViewTodayBluebellBookings();
        jListTodayBluebell.setListData(this.todayBluebellBookingList.getAllBookings());
        jListTodayBluebell.setSelectedIndex(0);
        
        updateTodayBluebellList();
    }
    
    public void updateTodayBluebellList(){
        try{
            bookingIndex = jListTodayBluebell.getSelectedIndex();
            thisBooking = jListTodayBluebell.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.todayBluebellBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildTodayBluebell.setText(booking.getChildIDAsString());
            jTextFieldDOBTodayBluebell.setText(booking.getChildIDAsString());
            jTextFieldSessionTodayBluebell.setText(booking.getSession());
            jTextAreaNotesTodayBluebell.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setTodayBluebellNumbers() throws SQLException{
        todayBluebellNumbers = this.todayBluebellBookingList.size();
        todayBluebell = todayBluebellNumbers + "";
        jTextFieldTodayBluebell.setText(todayBluebell);
    }
    
    public void setTodayFoxgloveList() throws SQLException{
        this.todayFoxgloveBookingList = this.connect.ViewTodayFoxgloveBookings();
        jListTodayFoxglove.setListData(this.todayFoxgloveBookingList.getAllBookings());
        jListTodayFoxglove.setSelectedIndex(0);
        
        updateTodayFoxgloveList();
    }
    
    public void updateTodayFoxgloveList(){
        try{
            bookingIndex = jListTodayFoxglove.getSelectedIndex();
            thisBooking = jListTodayFoxglove.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.todayFoxgloveBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildTodayFoxglove.setText(booking.getChildIDAsString());
            jTextFieldDOBTodayFoxglove.setText(booking.getChildIDAsString());
            jTextFieldSessionTodayFoxglove.setText(booking.getSession());
            jTextAreaNotesTodayFoxglove.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setTodayFoxgloveNumbers() throws SQLException{
        todayFoxgloveNumbers = this.todayFoxgloveBookingList.size();
        todayFoxglove = todayFoxgloveNumbers + "";
        jTextFieldTodayFoxglove.setText(todayFoxglove);
    }
    
    public void setTodayOSCAmList() throws SQLException{
        this.todayOSCAmBookingList = this.connect.ViewTodayOSCAmBookings();
        jListTodayOSCam.setListData(this.todayOSCAmBookingList.getAllBookings());
        jListTodayOSCam.setSelectedIndex(0);
        
        updateTodayOSCAmList();
    }
    
    public void updateTodayOSCAmList(){
        try{
            bookingIndex = jListTodayOSCam.getSelectedIndex();
            thisBooking = jListTodayOSCam.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.todayOSCAmBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildTodayOSCam.setText(booking.getChildIDAsString());
            jTextFieldDOBTodayOSCam.setText(booking.getChildIDAsString());
            jTextFieldSessionTodayOSCam.setText(booking.getSession());
            jTextAreaNotesTodayOSCam.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setTodayOSCAmNumbers() throws SQLException{
        todayOSCAmNumbers = this.todayOSCAmBookingList.size();
        todayOSCAm = todayOSCAmNumbers + "";
        jTextFieldTodayOSCAm.setText(todayOSCAm);
    }
    
    public void setTodayOSCPmList() throws SQLException{
        this.todayOSCPmBookingList = this.connect.ViewTodayOSCPmBookings();
        jListTodayOSCpm.setListData(this.todayOSCPmBookingList.getAllBookings());
        jListTodayOSCpm.setSelectedIndex(0);
        
        updateTodayOSCPmList();
    }
    
    public void updateTodayOSCPmList(){
        try{
            bookingIndex = jListTodayOSCpm.getSelectedIndex();
            thisBooking = jListTodayOSCpm.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.todayOSCPmBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildTodayOSCpm.setText(booking.getChildIDAsString());
            jTextFieldDOBTodayOSCpm.setText(booking.getChildIDAsString());
            jTextFieldSessionTodayOSCpm.setText(booking.getSession());
            jTextAreaNotesTodayOSCpm.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setTodayOSCPmNumbers() throws SQLException{
        todayOSCPmNumbers = this.todayOSCPmBookingList.size();
        todayOSCPm = todayOSCPmNumbers + "";
        jTextFieldTodayOSCPm.setText(todayOSCPm);
    }
    
    public void setRegistersBreakfastList() throws SQLException{
        this.registersBreakfastBookingList = this.connect.ViewRegistersBreakfastBookings(jTextFieldDateBreakfast.getText());
        jListRegistersBreakfast.setListData(this.registersBreakfastBookingList.getAllBookings());
        jListRegistersBreakfast.setSelectedIndex(0);
        
        updateRegistersBreakfastList();
        setRegistersBreakfastNumbers();
    }
    
    public void updateRegistersBreakfastList(){
        try{
            bookingIndex = jListRegistersBreakfast.getSelectedIndex();
            thisBooking = jListRegistersBreakfast.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.registersBreakfastBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildRegistersBreakfast.setText(booking.getChildIDAsString());
            jTextFieldDOBRegistersBreakfast.setText(booking.getChildIDAsString());
            jTextFieldSessionRegistersBreakfast.setText(booking.getSession());
            jTextAreaNotesRegistersBreakfast.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setRegistersBreakfastNumbers(){
        registersBreakfastNumbers = this.registersBreakfastBookingList.size();
        registersBreakfast = registersBreakfastNumbers + "";
        jTextFieldRegistersBreakfast.setText(registersBreakfast);
    }
    
    public void setRegistersSnowdropList() throws SQLException{
        this.registersSnowdropBookingList = this.connect.ViewRegistersSnowdropBookings(jTextFieldDateSnowdrop.getText());
        jListRegistersSnowdrop.setListData(this.registersSnowdropBookingList.getAllBookings());
        jListRegistersSnowdrop.setSelectedIndex(0);
        
        updateRegistersSnowdropList();
        setRegistersSnowdropNumbers();
    }
    
    public void updateRegistersSnowdropList(){
        try{
            bookingIndex = jListRegistersSnowdrop.getSelectedIndex();
            thisBooking = jListRegistersSnowdrop.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.registersSnowdropBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildRegistersSnowdrop.setText(booking.getChildIDAsString());
            jTextFieldDOBRegistersSnowdrop.setText(booking.getChildIDAsString());
            jTextFieldSessionRegistersSnowdrop.setText(booking.getSession());
            jTextAreaNotesRegistersSnowdrop.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setRegistersSnowdropNumbers(){
        registersSnowdropNumbers = this.registersSnowdropBookingList.size();
        registersSnowdrop = registersSnowdropNumbers + "";
        jTextFieldRegistersSnowdrop.setText(registersSnowdrop);
    }
    
    public void setRegistersButtercupList() throws SQLException{
        this.registersButtercupBookingList = this.connect.ViewRegistersButtercupBookings(jTextFieldDateButtercup.getText());
        jListRegistersButtercup.setListData(this.registersButtercupBookingList.getAllBookings());
        jListRegistersButtercup.setSelectedIndex(0);
        
        updateRegistersButtercupList();
        setRegistersButtercupNumbers();
    }
    
    public void updateRegistersButtercupList(){
        try{
            bookingIndex = jListRegistersButtercup.getSelectedIndex();
            thisBooking = jListRegistersButtercup.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.registersButtercupBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildRegistersButtercup.setText(booking.getChildIDAsString());
            jTextFieldDOBRegistersButtercup.setText(booking.getChildIDAsString());
            jTextFieldSessionRegistersButtercup.setText(booking.getSession());
            jTextAreaNotesRegistersButtercup.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setRegistersButtercupNumbers(){
        registersButtercupNumbers = this.registersButtercupBookingList.size();
        registersButtercup = registersButtercupNumbers + "";
        jTextFieldRegistersButtercup.setText(registersButtercup);
    }
    
    public void setRegistersBluebellList() throws SQLException{
        this.registersBluebellBookingList = this.connect.ViewRegistersBluebellBookings(jTextFieldDateBluebell.getText());
        jListRegistersBluebell.setListData(this.registersBluebellBookingList.getAllBookings());
        jListRegistersBluebell.setSelectedIndex(0);
        
        updateRegistersBluebellList();
        setRegistersBluebellNumbers();
    }
    
    public void updateRegistersBluebellList(){
        try{
            bookingIndex = jListRegistersBluebell.getSelectedIndex();
            thisBooking = jListRegistersBluebell.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.registersBluebellBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildRegistersBluebell.setText(booking.getChildIDAsString());
            jTextFieldDOBRegistersBluebell.setText(booking.getChildIDAsString());
            jTextFieldSessionRegistersBluebell.setText(booking.getSession());
            jTextAreaNotesRegistersBluebell.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setRegistersBluebellNumbers(){
        registersBluebellNumbers = this.registersBluebellBookingList.size();
        registersBluebell = registersBluebellNumbers + "";
        jTextFieldRegistersBluebell.setText(registersBluebell);
    }
    
    public void setRegistersFoxgloveList() throws SQLException{
        this.registersFoxgloveBookingList = this.connect.ViewRegistersFoxgloveBookings(jTextFieldDateFoxglove.getText());
        jListRegistersFoxglove.setListData(this.registersFoxgloveBookingList.getAllBookings());
        jListRegistersFoxglove.setSelectedIndex(0);
        
        updateRegistersFoxgloveList();
        setRegistersFoxgloveNumbers();
    }
    
    public void updateRegistersFoxgloveList(){
        try{
            bookingIndex = jListRegistersFoxglove.getSelectedIndex();
            thisBooking = jListRegistersFoxglove.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.registersFoxgloveBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildRegistersFoxglove.setText(booking.getChildIDAsString());
            jTextFieldDOBRegistersFoxglove.setText(booking.getChildIDAsString());
            jTextFieldSessionRegistersFoxglove.setText(booking.getSession());
            jTextAreaNotesRegistersFoxglove.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setRegistersFoxgloveNumbers(){
        registersFoxgloveNumbers = this.registersFoxgloveBookingList.size();
        registersFoxglove = registersFoxgloveNumbers + "";
        jTextFieldRegistersFoxglove.setText(registersFoxglove);
    }
    
    public void setRegistersOSCAmList() throws SQLException{
        this.registersOSCAmBookingList = this.connect.ViewRegistersOSCAmBookings(jTextFieldDateOSCAm.getText());
        jListRegistersOSCam.setListData(this.registersOSCAmBookingList.getAllBookings());
        jListRegistersOSCam.setSelectedIndex(0);
        
        updateRegistersOSCAmList();
        setRegistersOSCAmNumbers();
    }
    
    public void updateRegistersOSCAmList(){
        try{
            bookingIndex = jListRegistersOSCam.getSelectedIndex();
            thisBooking = jListRegistersOSCam.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.registersOSCAmBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildRegistersOSCam.setText(booking.getChildIDAsString());
            jTextFieldDOBRegistersOSCAm.setText(booking.getChildIDAsString());
            jTextFieldSessionRegistersOSCam.setText(booking.getSession());
            jTextAreaNotesRegistersOSCam.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setRegistersOSCAmNumbers(){
        registersOSCAmNumbers = this.registersOSCAmBookingList.size();
        registersOSCAm = registersOSCAmNumbers + "";
        jTextFieldRegistersOSCam.setText(registersOSCAm);
    }
    
    public void setRegistersOSCPmList() throws SQLException{
        this.registersOSCPmBookingList = this.connect.ViewRegistersOSCPmBookings(jTextFieldDateOSCPm.getText());
        jListRegistersOSCpm.setListData(this.registersOSCPmBookingList.getAllBookings());
        jListRegistersOSCpm.setSelectedIndex(0);
        
        updateRegistersOSCPmList();
        setRegistersOSCPmNumbers();
    }
    
    public void updateRegistersOSCPmList(){
        try{
            bookingIndex = jListRegistersOSCpm.getSelectedIndex();
            thisBooking = jListRegistersOSCpm.getModel().getElementAt(bookingIndex);
            selectedBooking = thisBooking.toString();
            bookingInfo = selectedBooking.split(": ");
            booking = this.registersOSCPmBookingList.getBookingAt(bookingInfo[0]);

            jTextFieldChildRegistersOSCpm.setText(booking.getChildIDAsString());
            jTextFieldDOBRegistersOSCPm.setText(booking.getChildIDAsString());
            jTextFieldSessionRegistersOSCpm.setText(booking.getSession());
            jTextAreaNotesRegistersOSCpm.setText(booking.getNotes());
        } catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
    
    public void setRegistersOSCPmNumbers(){
        registersOSCPmNumbers = this.registersOSCPmBookingList.size();
        registersOSCPm = registersOSCPmNumbers + "";
        jTextFieldRegistersOSCpm.setText(registersOSCPm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneHomePage = new javax.swing.JTabbedPane();
        jPanelToday = new javax.swing.JPanel();
        jTabbedPaneToday = new javax.swing.JTabbedPane();
        jPanelTodayBreakfast = new javax.swing.JPanel();
        jLabelChildNameTodayBreakfast = new javax.swing.JLabel();
        jLabelDOBTodayBreakfast = new javax.swing.JLabel();
        jLabelSessionTodayBreakfast = new javax.swing.JLabel();
        jLabelNotesTodayBreakfast = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextAreaNotesTodayBreakfast = new javax.swing.JTextArea();
        jTextFieldSessionTodayBreakfast = new javax.swing.JTextField();
        jTextFieldChildTodayBreakfast = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        jListTodayBreakfast = new javax.swing.JList();
        jLabelTodayBreakfast = new javax.swing.JLabel();
        jTextFieldTodayBreakfast = new javax.swing.JTextField();
        jTextFieldDOBTodayBreakfast = new javax.swing.JTextField();
        jPanelTodaySnowdrop = new javax.swing.JPanel();
        jLabelChildNameTodaySnowdrop = new javax.swing.JLabel();
        jTextFieldChildTodaySnowdrop = new javax.swing.JTextField();
        jLabelSessionTodaySnowdrop = new javax.swing.JLabel();
        jLabelDOBTodaySnowdrop = new javax.swing.JLabel();
        jLabelNotesTodaySnowdrop = new javax.swing.JLabel();
        jTextFieldSessionTodaySnowdrop = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextAreaNotesTodaySnowdrop = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        jListTodaySnowdrop = new javax.swing.JList();
        jLabelTodaySnowdrop = new javax.swing.JLabel();
        jTextFieldTodaySnowdrop = new javax.swing.JTextField();
        jTextFieldDOBTodaySnowdrop = new javax.swing.JTextField();
        jPanelTodayButtercup = new javax.swing.JPanel();
        jTextFieldChildTodayButtercup = new javax.swing.JTextField();
        jLabelChildNameTodayButtercup = new javax.swing.JLabel();
        jLabelDOBTodayButtercup = new javax.swing.JLabel();
        jTextFieldSessionTodayButtercup = new javax.swing.JTextField();
        jLabelSessionTodayButtercup = new javax.swing.JLabel();
        jLabelNotesTodayButtercup = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextAreaNotesTodayButtercup = new javax.swing.JTextArea();
        jScrollPane21 = new javax.swing.JScrollPane();
        jListTodayButtercup = new javax.swing.JList();
        jLabelTodayButtercup = new javax.swing.JLabel();
        jTextFieldTodayButtercup = new javax.swing.JTextField();
        jTextFieldDOBTodayButtercup = new javax.swing.JTextField();
        jPanelTodayBluebell = new javax.swing.JPanel();
        jLabelChildNameTodayBluebell = new javax.swing.JLabel();
        jTextFieldChildTodayBluebell = new javax.swing.JTextField();
        jLabelDOBTodayBluebell = new javax.swing.JLabel();
        jLabelSessionTodayBluebell = new javax.swing.JLabel();
        jTextFieldSessionTodayBluebell = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextAreaNotesTodayBluebell = new javax.swing.JTextArea();
        jLabelNotesTodayBluebell = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jListTodayBluebell = new javax.swing.JList();
        jLabelTodayBluebell = new javax.swing.JLabel();
        jTextFieldTodayBluebell = new javax.swing.JTextField();
        jTextFieldDOBTodayBluebell = new javax.swing.JTextField();
        jPanelTodayFoxglove = new javax.swing.JPanel();
        jLabelChildNameTodayFoxglove = new javax.swing.JLabel();
        jTextFieldChildTodayFoxglove = new javax.swing.JTextField();
        jLabelDOBTodayFoxglove = new javax.swing.JLabel();
        jLabelSessionTodayFoxglove = new javax.swing.JLabel();
        jTextFieldSessionTodayFoxglove = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextAreaNotesTodayFoxglove = new javax.swing.JTextArea();
        jLabelNotesTodayFoxglove = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jListTodayFoxglove = new javax.swing.JList();
        jLabelTodayFoxglove = new javax.swing.JLabel();
        jTextFieldTodayFoxglove = new javax.swing.JTextField();
        jTextFieldDOBTodayFoxglove = new javax.swing.JTextField();
        jPanelTodayOSCam = new javax.swing.JPanel();
        jLabelChildNameTodayOSCam = new javax.swing.JLabel();
        jTextFieldChildTodayOSCam = new javax.swing.JTextField();
        jLabelDOBTodayOSCam = new javax.swing.JLabel();
        jLabelSessionTodayOSCam = new javax.swing.JLabel();
        jTextFieldSessionTodayOSCam = new javax.swing.JTextField();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextAreaNotesTodayOSCam = new javax.swing.JTextArea();
        jLabelNotesTodayOSCam = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jListTodayOSCam = new javax.swing.JList();
        jLabelTodayOSCamNum = new javax.swing.JLabel();
        jTextFieldTodayOSCAm = new javax.swing.JTextField();
        jTextFieldDOBTodayOSCam = new javax.swing.JTextField();
        jPanelTodayOSCpm = new javax.swing.JPanel();
        jLabelChildNameTodayOSCpm = new javax.swing.JLabel();
        jTextFieldChildTodayOSCpm = new javax.swing.JTextField();
        jLabelDOBTodayOSCpm = new javax.swing.JLabel();
        jLabelSessionTodayOSCpm = new javax.swing.JLabel();
        jTextFieldSessionTodayOSCpm = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextAreaNotesTodayOSCpm = new javax.swing.JTextArea();
        jLabelNotesTodayOSCpm = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jListTodayOSCpm = new javax.swing.JList();
        jLabelTodayOSCpmNum = new javax.swing.JLabel();
        jTextFieldTodayOSCPm = new javax.swing.JTextField();
        jTextFieldDOBTodayOSCpm = new javax.swing.JTextField();
        jPanelRegisters = new javax.swing.JPanel();
        jTabbedPaneRegisters = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jListRegistersBreakfast = new javax.swing.JList();
        jLabelChildNameRegistersBreakfast = new javax.swing.JLabel();
        jTextFieldChildRegistersBreakfast = new javax.swing.JTextField();
        jLabelDOBRegistersBreakfast = new javax.swing.JLabel();
        jTextFieldSessionRegistersBreakfast = new javax.swing.JTextField();
        jLabelSessionRegistersBreakfast = new javax.swing.JLabel();
        jLabelNotesRegistersBreakfast = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTextAreaNotesRegistersBreakfast = new javax.swing.JTextArea();
        jLabelRegistersBreakfast = new javax.swing.JLabel();
        jTextFieldRegistersBreakfast = new javax.swing.JTextField();
        jLabelDateBreakfast = new javax.swing.JLabel();
        jTextFieldDateBreakfast = new javax.swing.JTextField();
        jTextFieldDOBRegistersBreakfast = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jListRegistersSnowdrop = new javax.swing.JList();
        jLabelChildNameRegistersSnowdrop = new javax.swing.JLabel();
        jLabelDOBRegistersSnowdrop = new javax.swing.JLabel();
        jLabelSessionRegistersSnowdrop = new javax.swing.JLabel();
        jLabelNotesRegistersSnowdrop = new javax.swing.JLabel();
        jLabelRegistersSnowdrop = new javax.swing.JLabel();
        jTextFieldRegistersSnowdrop = new javax.swing.JTextField();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextAreaNotesRegistersSnowdrop = new javax.swing.JTextArea();
        jTextFieldSessionRegistersSnowdrop = new javax.swing.JTextField();
        jTextFieldChildRegistersSnowdrop = new javax.swing.JTextField();
        jTextFieldDateSnowdrop = new javax.swing.JTextField();
        jLabelDateSnowdrop = new javax.swing.JLabel();
        jTextFieldDOBRegistersSnowdrop = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        jListRegistersButtercup = new javax.swing.JList();
        jLabelChildNameRegistersButtercup = new javax.swing.JLabel();
        jLabelDOBRegistersButtercup = new javax.swing.JLabel();
        jLabelSessionRegistersButtercup = new javax.swing.JLabel();
        jLabelNotesRegistersButtercup = new javax.swing.JLabel();
        jLabelRegistersButtercup = new javax.swing.JLabel();
        jTextFieldRegistersButtercup = new javax.swing.JTextField();
        jScrollPane30 = new javax.swing.JScrollPane();
        jTextAreaNotesRegistersButtercup = new javax.swing.JTextArea();
        jTextFieldSessionRegistersButtercup = new javax.swing.JTextField();
        jTextFieldChildRegistersButtercup = new javax.swing.JTextField();
        jTextFieldDateButtercup = new javax.swing.JTextField();
        jLabelDateButtercup = new javax.swing.JLabel();
        jTextFieldDOBRegistersButtercup = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane31 = new javax.swing.JScrollPane();
        jListRegistersBluebell = new javax.swing.JList();
        jLabelChildNameRegistersBluebell = new javax.swing.JLabel();
        jLabelDOBRegistersBluebell = new javax.swing.JLabel();
        jLabelSessionRegistersBluebell = new javax.swing.JLabel();
        jLabelNotesRegistersBluebell = new javax.swing.JLabel();
        jLabelRegistersBluebell = new javax.swing.JLabel();
        jTextFieldRegistersBluebell = new javax.swing.JTextField();
        jScrollPane32 = new javax.swing.JScrollPane();
        jTextAreaNotesRegistersBluebell = new javax.swing.JTextArea();
        jTextFieldSessionRegistersBluebell = new javax.swing.JTextField();
        jTextFieldChildRegistersBluebell = new javax.swing.JTextField();
        jTextFieldDateBluebell = new javax.swing.JTextField();
        jLabelDateBluebell = new javax.swing.JLabel();
        jTextFieldDOBRegistersBluebell = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane33 = new javax.swing.JScrollPane();
        jListRegistersFoxglove = new javax.swing.JList();
        jLabelChildNameRegistersFoxglove = new javax.swing.JLabel();
        jLabelDOBRegistersFoxglove = new javax.swing.JLabel();
        jLabelSessionRegistersFoxglove = new javax.swing.JLabel();
        jLabelNotesRegistersFoxglove = new javax.swing.JLabel();
        jLabelRegistersFoxglove = new javax.swing.JLabel();
        jTextFieldRegistersFoxglove = new javax.swing.JTextField();
        jScrollPane34 = new javax.swing.JScrollPane();
        jTextAreaNotesRegistersFoxglove = new javax.swing.JTextArea();
        jTextFieldSessionRegistersFoxglove = new javax.swing.JTextField();
        jTextFieldChildRegistersFoxglove = new javax.swing.JTextField();
        jTextFieldDateFoxglove = new javax.swing.JTextField();
        jLabelDateFoxglove = new javax.swing.JLabel();
        jTextFieldDOBRegistersFoxglove = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane35 = new javax.swing.JScrollPane();
        jListRegistersOSCam = new javax.swing.JList();
        jLabelChildNameRegistersOSCam = new javax.swing.JLabel();
        jLabelDOBRegistersOSCam = new javax.swing.JLabel();
        jLabelSessionRegistersOSCam = new javax.swing.JLabel();
        jLabelNotesRegistersOSCam = new javax.swing.JLabel();
        jLabelRegistersOSCamNum = new javax.swing.JLabel();
        jTextFieldRegistersOSCam = new javax.swing.JTextField();
        jScrollPane36 = new javax.swing.JScrollPane();
        jTextAreaNotesRegistersOSCam = new javax.swing.JTextArea();
        jTextFieldSessionRegistersOSCam = new javax.swing.JTextField();
        jTextFieldChildRegistersOSCam = new javax.swing.JTextField();
        jTextFieldDateOSCAm = new javax.swing.JTextField();
        jLabelDateOSCAm = new javax.swing.JLabel();
        jTextFieldDOBRegistersOSCAm = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane37 = new javax.swing.JScrollPane();
        jListRegistersOSCpm = new javax.swing.JList();
        jLabelChildNameRegistersOSCpm = new javax.swing.JLabel();
        jLabelDOBRegistersOSCpm = new javax.swing.JLabel();
        jLabelSessionRegistersOSCpm = new javax.swing.JLabel();
        jLabelNotesRegistersOSCpm = new javax.swing.JLabel();
        jLabelRegistersOSCpmNum = new javax.swing.JLabel();
        jTextFieldRegistersOSCpm = new javax.swing.JTextField();
        jScrollPane38 = new javax.swing.JScrollPane();
        jTextAreaNotesRegistersOSCpm = new javax.swing.JTextArea();
        jTextFieldSessionRegistersOSCpm = new javax.swing.JTextField();
        jTextFieldChildRegistersOSCpm = new javax.swing.JTextField();
        jTextFieldDateOSCPm = new javax.swing.JTextField();
        jLabelDateOSCPm = new javax.swing.JLabel();
        jTextFieldDOBRegistersOSCPm = new javax.swing.JTextField();
        jPanelChildren = new javax.swing.JPanel();
        jTextFieldReligionChild = new javax.swing.JTextField();
        jLabelEthnicOriginChild = new javax.swing.JLabel();
        jLabelChildHeading = new javax.swing.JLabel();
        jTextFieldPositionChild = new javax.swing.JTextField();
        jLabelReligionChild = new javax.swing.JLabel();
        jTextFieldKnownAsChild = new javax.swing.JTextField();
        jLabelPosChild = new javax.swing.JLabel();
        jTextFieldSexChild = new javax.swing.JTextField();
        jLabelKnownAs = new javax.swing.JLabel();
        jTextFieldEthnicOriginChild = new javax.swing.JTextField();
        jLabelLanguagesChild = new javax.swing.JLabel();
        jLabelSexChild = new javax.swing.JLabel();
        jLabelDOBChild = new javax.swing.JLabel();
        jTextFieldSurnameChild = new javax.swing.JTextField();
        jLabelSurnameChild = new javax.swing.JLabel();
        jTextFieldFirstNameChild = new javax.swing.JTextField();
        jLabelFirstNameChild = new javax.swing.JLabel();
        jScrollPaneNotesChild = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jTextFieldMedicalChild = new javax.swing.JTextField();
        jTextFieldImmunisationsChild = new javax.swing.JTextField();
        jLabelMedicalChild = new javax.swing.JLabel();
        jLabelImmunisationsChild = new javax.swing.JLabel();
        jLabelDietaryNeedsChild = new javax.swing.JLabel();
        jLabelNotesChild = new javax.swing.JLabel();
        jTextFieldDietaryNeedsChild = new javax.swing.JTextField();
        jTextFieldLanguagesChild = new javax.swing.JTextField();
        jLabelAddChild = new javax.swing.JLabel();
        jLabelEditChild = new javax.swing.JLabel();
        jLabelDeleteChild = new javax.swing.JLabel();
        jLabelViewBookingsChild = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListRelativesChildren = new javax.swing.JList();
        jLabelRelativesChildren = new javax.swing.JLabel();
        jLabelAddRelationshipChild = new javax.swing.JLabel();
        jLabelChildRoom = new javax.swing.JLabel();
        jTextFieldSearchChild = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListChildren = new javax.swing.JList();
        jTextFieldDOBChild = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListChildRoom = new javax.swing.JList();
        jLabelSearchChild = new javax.swing.JLabel();
        jLabelChildRoomList = new javax.swing.JLabel();
        jLabelDeleteRoomChild = new javax.swing.JLabel();
        jPanelRelatives = new javax.swing.JPanel();
        jTextFieldSearchRelatives = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListRelatives = new javax.swing.JList();
        jLabelRelativeHeading = new javax.swing.JLabel();
        jLabelAddRelative = new javax.swing.JLabel();
        jLabelEditRelative = new javax.swing.JLabel();
        jLabelDeleteRelative = new javax.swing.JLabel();
        jLabelFirstNameRelative = new javax.swing.JLabel();
        jLabelSurnameRelative = new javax.swing.JLabel();
        jTextFieldSurnameRelative = new javax.swing.JTextField();
        jTextFieldFirstNameRelative = new javax.swing.JTextField();
        jLabelAddress1Relative = new javax.swing.JLabel();
        jTextFieldAddress1Relative = new javax.swing.JTextField();
        jLabelAddress2Relative = new javax.swing.JLabel();
        jTextFieldAddress2Relative = new javax.swing.JTextField();
        jLabelPostCodeRelative = new javax.swing.JLabel();
        jTextFieldPostCodeRelative = new javax.swing.JTextField();
        jLabelChildrenRelative = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListChildrenRelative = new javax.swing.JList();
        jLabelContactNumRelative = new javax.swing.JLabel();
        jLabelMobileNumRelative = new javax.swing.JLabel();
        jLabelEmailRelative = new javax.swing.JLabel();
        jLabelPasswordRelative = new javax.swing.JLabel();
        jTextFieldContactNumRelative = new javax.swing.JTextField();
        jTextFieldEmailRelative = new javax.swing.JTextField();
        jTextFieldPasswordRelative = new javax.swing.JTextField();
        jLabelAddRelationshipRelative = new javax.swing.JLabel();
        jTextFieldMobileNumRelative = new javax.swing.JTextField();
        jLabelSearchRelatives = new javax.swing.JLabel();
        jPanelBookings = new javax.swing.JPanel();
        jTextFieldSearchBookings = new javax.swing.JTextField();
        jLabelAddBooking = new javax.swing.JLabel();
        jLabelEditBooking = new javax.swing.JLabel();
        jLabelDeleteBooking = new javax.swing.JLabel();
        jLabelBookingHeading = new javax.swing.JLabel();
        jLabelChildBookings = new javax.swing.JLabel();
        jLabelRoomBookings = new javax.swing.JLabel();
        jLabelSessionBookings = new javax.swing.JLabel();
        jLabelNotesBookings = new javax.swing.JLabel();
        jScrollPaneNotesChild1 = new javax.swing.JScrollPane();
        jTextAreaNotesBookings = new javax.swing.JTextArea();
        jTextFieldSessionBookings = new javax.swing.JTextField();
        jTextFieldRoomBookings = new javax.swing.JTextField();
        jTextFieldChildBookings = new javax.swing.JTextField();
        jLabelDateBooking = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListBookings = new javax.swing.JList();
        jTextFieldDateBookings = new javax.swing.JTextField();
        jLabelSearchBookings = new javax.swing.JLabel();
        jPanelStaff = new javax.swing.JPanel();
        jTextFieldSearchStaff = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListStaff = new javax.swing.JList();
        jLabelAddStaff = new javax.swing.JLabel();
        jLabelEditStaff = new javax.swing.JLabel();
        jLabelDeleteStaff = new javax.swing.JLabel();
        jLabelStaffHeading = new javax.swing.JLabel();
        jLabelFirstNameStaff = new javax.swing.JLabel();
        jLabelSurnameStaff = new javax.swing.JLabel();
        jLabelDOBStaff = new javax.swing.JLabel();
        jLabelAddress1Staff = new javax.swing.JLabel();
        jLabelAddress2Staff = new javax.swing.JLabel();
        jLabelPostCodeStaff = new javax.swing.JLabel();
        jLabelContactNumStaff = new javax.swing.JLabel();
        jTextFieldAddress2Staff = new javax.swing.JTextField();
        jTextFieldAddress1Staff = new javax.swing.JTextField();
        jTextFieldSurnameStaff = new javax.swing.JTextField();
        jTextFieldFirstNameStaff = new javax.swing.JTextField();
        jTextFieldPostCodeStaff = new javax.swing.JTextField();
        jLabelMobileNumStaff = new javax.swing.JLabel();
        jLabelMedicalConditionsStaff = new javax.swing.JLabel();
        jLabelDietaryNeedsStaff = new javax.swing.JLabel();
        jLabelUsernameStaff = new javax.swing.JLabel();
        jLabelPasswordStaff = new javax.swing.JLabel();
        jTextFieldMedicalConditionsStaff = new javax.swing.JTextField();
        jTextFieldMobileNumStaff = new javax.swing.JTextField();
        jTextFieldContactNumStaff = new javax.swing.JTextField();
        jTextFieldDietaryNeedsStaff = new javax.swing.JTextField();
        jTextFieldUsernameStaff = new javax.swing.JTextField();
        jTextFieldPasswordStaff = new javax.swing.JTextField();
        jLabelRoomStaff = new javax.swing.JLabel();
        jTextFieldDOBStaff = new javax.swing.JTextField();
        jLabelSearchStaff = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListStaffRoom = new javax.swing.JList();
        jLabelStaffRoomList = new javax.swing.JLabel();
        jLabelDeleteRoomStaff = new javax.swing.JLabel();
        jPanelRooms = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListRooms = new javax.swing.JList();
        jTextFieldSearchRooms = new javax.swing.JTextField();
        jLabelAddRoom = new javax.swing.JLabel();
        jLabelEditRoom = new javax.swing.JLabel();
        jLabelDeleteRoom = new javax.swing.JLabel();
        jLabelRoomHeading = new javax.swing.JLabel();
        jLabelRoomNameRooms = new javax.swing.JLabel();
        jLabelAgeMinRooms = new javax.swing.JLabel();
        jLabelAgeMaxRooms = new javax.swing.JLabel();
        jLabelRatioRooms = new javax.swing.JLabel();
        jLabelMaxNumberChildrenRooms = new javax.swing.JLabel();
        jTextFieldMaxNumberChildrenRooms = new javax.swing.JTextField();
        jTextFieldRatioRooms = new javax.swing.JTextField();
        jTextFieldAgeMaxRooms = new javax.swing.JTextField();
        jTextFieldAgeMinRooms = new javax.swing.JTextField();
        jTextFieldRoomNameRooms = new javax.swing.JTextField();
        jLabelSearchRoom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jTabbedPaneHomePage.setBackground(new java.awt.Color(255, 255, 255));

        jPanelToday.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPaneToday.setBackground(new java.awt.Color(255, 255, 255));

        jPanelTodayBreakfast.setBackground(new java.awt.Color(255, 255, 255));

        jLabelChildNameTodayBreakfast.setText("Child");

        jLabelDOBTodayBreakfast.setText("Date Of Birth");

        jLabelSessionTodayBreakfast.setText("Session");

        jLabelNotesTodayBreakfast.setText("Notes");

        jTextAreaNotesTodayBreakfast.setColumns(20);
        jTextAreaNotesTodayBreakfast.setRows(5);
        jScrollPane18.setViewportView(jTextAreaNotesTodayBreakfast);

        jListTodayBreakfast.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTodayBreakfast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTodayBreakfastMousePressed(evt);
            }
        });
        jScrollPane19.setViewportView(jListTodayBreakfast);

        jLabelTodayBreakfast.setText("Children");

        javax.swing.GroupLayout jPanelTodayBreakfastLayout = new javax.swing.GroupLayout(jPanelTodayBreakfast);
        jPanelTodayBreakfast.setLayout(jPanelTodayBreakfastLayout);
        jPanelTodayBreakfastLayout.setHorizontalGroup(
            jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayBreakfastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayBreakfastLayout.createSequentialGroup()
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameTodayBreakfast)
                            .addComponent(jLabelSessionTodayBreakfast)
                            .addComponent(jLabelTodayBreakfast))
                        .addGap(42, 42, 42)
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldChildTodayBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTodayBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTodayBreakfastLayout.createSequentialGroup()
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDOBTodayBreakfast)
                            .addComponent(jLabelNotesTodayBreakfast))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDOBTodayBreakfast, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldSessionTodayBreakfast, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelTodayBreakfastLayout.setVerticalGroup(
            jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayBreakfastLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayBreakfastLayout.createSequentialGroup()
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameTodayBreakfast)
                            .addComponent(jTextFieldChildTodayBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBTodayBreakfast)
                            .addComponent(jTextFieldDOBTodayBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionTodayBreakfast)
                            .addComponent(jTextFieldSessionTodayBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesTodayBreakfast)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTodayBreakfastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTodayBreakfast)
                            .addComponent(jTextFieldTodayBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneToday.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/breakfast_button.png")), jPanelTodayBreakfast); // NOI18N

        jPanelTodaySnowdrop.setBackground(new java.awt.Color(255, 255, 255));

        jLabelChildNameTodaySnowdrop.setText("Child");

        jLabelSessionTodaySnowdrop.setText("Session");

        jLabelDOBTodaySnowdrop.setText("Date Of Birth");

        jLabelNotesTodaySnowdrop.setText("Notes");

        jTextAreaNotesTodaySnowdrop.setColumns(20);
        jTextAreaNotesTodaySnowdrop.setRows(5);
        jScrollPane11.setViewportView(jTextAreaNotesTodaySnowdrop);

        jListTodaySnowdrop.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTodaySnowdrop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTodaySnowdropMousePressed(evt);
            }
        });
        jScrollPane20.setViewportView(jListTodaySnowdrop);

        jLabelTodaySnowdrop.setText("Children");

        javax.swing.GroupLayout jPanelTodaySnowdropLayout = new javax.swing.GroupLayout(jPanelTodaySnowdrop);
        jPanelTodaySnowdrop.setLayout(jPanelTodaySnowdropLayout);
        jPanelTodaySnowdropLayout.setHorizontalGroup(
            jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodaySnowdropLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodaySnowdropLayout.createSequentialGroup()
                        .addComponent(jLabelDOBTodaySnowdrop)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNotesTodaySnowdrop)
                    .addComponent(jLabelTodaySnowdrop)
                    .addGroup(jPanelTodaySnowdropLayout.createSequentialGroup()
                        .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameTodaySnowdrop)
                            .addComponent(jLabelSessionTodaySnowdrop))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldChildTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelTodaySnowdropLayout.setVerticalGroup(
            jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodaySnowdropLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanelTodaySnowdropLayout.createSequentialGroup()
                        .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameTodaySnowdrop)
                            .addComponent(jTextFieldChildTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBTodaySnowdrop)
                            .addComponent(jTextFieldDOBTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionTodaySnowdrop)
                            .addComponent(jTextFieldSessionTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesTodaySnowdrop)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTodaySnowdropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTodaySnowdrop)
                            .addComponent(jTextFieldTodaySnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneToday.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/snowdrop_button.png")), jPanelTodaySnowdrop); // NOI18N

        jPanelTodayButtercup.setBackground(new java.awt.Color(255, 255, 255));

        jLabelChildNameTodayButtercup.setText("Child");

        jLabelDOBTodayButtercup.setText("Date Of Birth");

        jLabelSessionTodayButtercup.setText("Session");

        jLabelNotesTodayButtercup.setText("Notes");

        jTextAreaNotesTodayButtercup.setColumns(20);
        jTextAreaNotesTodayButtercup.setRows(5);
        jScrollPane12.setViewportView(jTextAreaNotesTodayButtercup);

        jListTodayButtercup.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTodayButtercup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTodayButtercupMousePressed(evt);
            }
        });
        jScrollPane21.setViewportView(jListTodayButtercup);

        jLabelTodayButtercup.setText("Children");

        javax.swing.GroupLayout jPanelTodayButtercupLayout = new javax.swing.GroupLayout(jPanelTodayButtercup);
        jPanelTodayButtercup.setLayout(jPanelTodayButtercupLayout);
        jPanelTodayButtercupLayout.setHorizontalGroup(
            jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayButtercupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayButtercupLayout.createSequentialGroup()
                        .addComponent(jLabelDOBTodayButtercup)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNotesTodayButtercup)
                    .addGroup(jPanelTodayButtercupLayout.createSequentialGroup()
                        .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameTodayButtercup)
                            .addComponent(jLabelSessionTodayButtercup)
                            .addComponent(jLabelTodayButtercup))
                        .addGap(42, 42, 42)
                        .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldChildTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelTodayButtercupLayout.setVerticalGroup(
            jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayButtercupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanelTodayButtercupLayout.createSequentialGroup()
                        .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameTodayButtercup)
                            .addComponent(jTextFieldChildTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBTodayButtercup)
                            .addComponent(jTextFieldDOBTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionTodayButtercup)
                            .addComponent(jTextFieldSessionTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesTodayButtercup)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTodayButtercupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTodayButtercup)
                            .addComponent(jTextFieldTodayButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneToday.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/buttercup_button.png")), jPanelTodayButtercup); // NOI18N

        jPanelTodayBluebell.setBackground(new java.awt.Color(255, 255, 255));

        jLabelChildNameTodayBluebell.setText("Child");

        jLabelDOBTodayBluebell.setText("Date Of Birth");

        jLabelSessionTodayBluebell.setText("Session");

        jTextAreaNotesTodayBluebell.setColumns(20);
        jTextAreaNotesTodayBluebell.setRows(5);
        jScrollPane13.setViewportView(jTextAreaNotesTodayBluebell);

        jLabelNotesTodayBluebell.setText("Notes");

        jListTodayBluebell.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTodayBluebell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTodayBluebellMousePressed(evt);
            }
        });
        jScrollPane22.setViewportView(jListTodayBluebell);

        jLabelTodayBluebell.setText("Children");

        javax.swing.GroupLayout jPanelTodayBluebellLayout = new javax.swing.GroupLayout(jPanelTodayBluebell);
        jPanelTodayBluebell.setLayout(jPanelTodayBluebellLayout);
        jPanelTodayBluebellLayout.setHorizontalGroup(
            jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayBluebellLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayBluebellLayout.createSequentialGroup()
                        .addComponent(jLabelDOBTodayBluebell)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNotesTodayBluebell)
                    .addGroup(jPanelTodayBluebellLayout.createSequentialGroup()
                        .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameTodayBluebell)
                            .addComponent(jLabelSessionTodayBluebell)
                            .addComponent(jLabelTodayBluebell))
                        .addGap(42, 42, 42)
                        .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldChildTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelTodayBluebellLayout.setVerticalGroup(
            jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayBluebellLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanelTodayBluebellLayout.createSequentialGroup()
                        .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameTodayBluebell)
                            .addComponent(jTextFieldChildTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBTodayBluebell)
                            .addComponent(jTextFieldDOBTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionTodayBluebell)
                            .addComponent(jTextFieldSessionTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesTodayBluebell)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTodayBluebellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTodayBluebell)
                            .addComponent(jTextFieldTodayBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneToday.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/bluebell_button.png")), jPanelTodayBluebell); // NOI18N

        jPanelTodayFoxglove.setBackground(new java.awt.Color(255, 255, 255));

        jLabelChildNameTodayFoxglove.setText("Child");

        jLabelDOBTodayFoxglove.setText("Date Of Birth");

        jLabelSessionTodayFoxglove.setText("Session");

        jTextAreaNotesTodayFoxglove.setColumns(20);
        jTextAreaNotesTodayFoxglove.setRows(5);
        jScrollPane14.setViewportView(jTextAreaNotesTodayFoxglove);

        jLabelNotesTodayFoxglove.setText("Notes");

        jListTodayFoxglove.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTodayFoxglove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTodayFoxgloveMousePressed(evt);
            }
        });
        jScrollPane23.setViewportView(jListTodayFoxglove);

        jLabelTodayFoxglove.setText("Children");

        javax.swing.GroupLayout jPanelTodayFoxgloveLayout = new javax.swing.GroupLayout(jPanelTodayFoxglove);
        jPanelTodayFoxglove.setLayout(jPanelTodayFoxgloveLayout);
        jPanelTodayFoxgloveLayout.setHorizontalGroup(
            jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayFoxgloveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayFoxgloveLayout.createSequentialGroup()
                        .addComponent(jLabelDOBTodayFoxglove)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNotesTodayFoxglove)
                    .addGroup(jPanelTodayFoxgloveLayout.createSequentialGroup()
                        .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameTodayFoxglove)
                            .addComponent(jLabelSessionTodayFoxglove)
                            .addComponent(jLabelTodayFoxglove))
                        .addGap(42, 42, 42)
                        .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldChildTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelTodayFoxgloveLayout.setVerticalGroup(
            jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayFoxgloveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanelTodayFoxgloveLayout.createSequentialGroup()
                        .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameTodayFoxglove)
                            .addComponent(jTextFieldChildTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBTodayFoxglove)
                            .addComponent(jTextFieldDOBTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionTodayFoxglove)
                            .addComponent(jTextFieldSessionTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesTodayFoxglove)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTodayFoxgloveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTodayFoxglove)
                            .addComponent(jTextFieldTodayFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneToday.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/foxglove_button.png")), jPanelTodayFoxglove); // NOI18N

        jPanelTodayOSCam.setBackground(new java.awt.Color(255, 255, 255));

        jLabelChildNameTodayOSCam.setText("Child");

        jLabelDOBTodayOSCam.setText("Date Of Birth");

        jLabelSessionTodayOSCam.setText("Session");

        jTextAreaNotesTodayOSCam.setColumns(20);
        jTextAreaNotesTodayOSCam.setRows(5);
        jScrollPane15.setViewportView(jTextAreaNotesTodayOSCam);

        jLabelNotesTodayOSCam.setText("Notes");

        jListTodayOSCam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTodayOSCam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTodayOSCamMousePressed(evt);
            }
        });
        jScrollPane24.setViewportView(jListTodayOSCam);

        jLabelTodayOSCamNum.setText("Children");

        javax.swing.GroupLayout jPanelTodayOSCamLayout = new javax.swing.GroupLayout(jPanelTodayOSCam);
        jPanelTodayOSCam.setLayout(jPanelTodayOSCamLayout);
        jPanelTodayOSCamLayout.setHorizontalGroup(
            jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayOSCamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayOSCamLayout.createSequentialGroup()
                        .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameTodayOSCam)
                            .addComponent(jLabelSessionTodayOSCam))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldChildTodayOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTodayOSCAm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionTodayOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTodayOSCamLayout.createSequentialGroup()
                        .addComponent(jLabelDOBTodayOSCam)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBTodayOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNotesTodayOSCam)
                    .addComponent(jLabelTodayOSCamNum))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelTodayOSCamLayout.setVerticalGroup(
            jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayOSCamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayOSCamLayout.createSequentialGroup()
                        .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameTodayOSCam)
                            .addComponent(jTextFieldChildTodayOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBTodayOSCam)
                            .addComponent(jTextFieldDOBTodayOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionTodayOSCam)
                            .addComponent(jTextFieldSessionTodayOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesTodayOSCam)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTodayOSCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTodayOSCamNum)
                            .addComponent(jTextFieldTodayOSCAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneToday.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/schoolAM_button.png")), jPanelTodayOSCam); // NOI18N

        jPanelTodayOSCpm.setBackground(new java.awt.Color(255, 255, 255));

        jLabelChildNameTodayOSCpm.setText("Child");

        jLabelDOBTodayOSCpm.setText("Date Of Birth");

        jLabelSessionTodayOSCpm.setText("Session");

        jTextAreaNotesTodayOSCpm.setColumns(20);
        jTextAreaNotesTodayOSCpm.setRows(5);
        jScrollPane16.setViewportView(jTextAreaNotesTodayOSCpm);

        jLabelNotesTodayOSCpm.setText("Notes");

        jListTodayOSCpm.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListTodayOSCpm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListTodayOSCpmMousePressed(evt);
            }
        });
        jScrollPane25.setViewportView(jListTodayOSCpm);

        jLabelTodayOSCpmNum.setText("Children");

        javax.swing.GroupLayout jPanelTodayOSCpmLayout = new javax.swing.GroupLayout(jPanelTodayOSCpm);
        jPanelTodayOSCpm.setLayout(jPanelTodayOSCpmLayout);
        jPanelTodayOSCpmLayout.setHorizontalGroup(
            jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTodayOSCpmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayOSCpmLayout.createSequentialGroup()
                        .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameTodayOSCpm)
                            .addComponent(jLabelSessionTodayOSCpm))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldChildTodayOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTodayOSCPm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionTodayOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTodayOSCpmLayout.createSequentialGroup()
                        .addComponent(jLabelDOBTodayOSCpm)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBTodayOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNotesTodayOSCpm)
                    .addComponent(jLabelTodayOSCpmNum))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanelTodayOSCpmLayout.setVerticalGroup(
            jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTodayOSCpmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTodayOSCpmLayout.createSequentialGroup()
                        .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameTodayOSCpm)
                            .addComponent(jTextFieldChildTodayOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBTodayOSCpm)
                            .addComponent(jTextFieldDOBTodayOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionTodayOSCpm)
                            .addComponent(jTextFieldSessionTodayOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesTodayOSCpm)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTodayOSCpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTodayOSCpmNum)
                            .addComponent(jTextFieldTodayOSCPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneToday.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/schoolPM_button.png")), jPanelTodayOSCpm); // NOI18N

        javax.swing.GroupLayout jPanelTodayLayout = new javax.swing.GroupLayout(jPanelToday);
        jPanelToday.setLayout(jPanelTodayLayout);
        jPanelTodayLayout.setHorizontalGroup(
            jPanelTodayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneToday)
        );
        jPanelTodayLayout.setVerticalGroup(
            jPanelTodayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneToday)
        );

        jTabbedPaneHomePage.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/today_button.png")), jPanelToday); // NOI18N

        jPanelRegisters.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jListRegistersBreakfast.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane26.setViewportView(jListRegistersBreakfast);

        jLabelChildNameRegistersBreakfast.setText("Child");

        jLabelDOBRegistersBreakfast.setText("Date Of Birth");

        jLabelSessionRegistersBreakfast.setText("Session");

        jLabelNotesRegistersBreakfast.setText("Notes");

        jTextAreaNotesRegistersBreakfast.setColumns(20);
        jTextAreaNotesRegistersBreakfast.setRows(5);
        jScrollPane27.setViewportView(jTextAreaNotesRegistersBreakfast);

        jLabelRegistersBreakfast.setText("Children");

        jLabelDateBreakfast.setText("Date");

        jTextFieldDateBreakfast.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDateBreakfastKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameRegistersBreakfast)
                            .addComponent(jLabelSessionRegistersBreakfast)
                            .addComponent(jLabelRegistersBreakfast))
                        .addGap(42, 42, 42)
                        .addComponent(jTextFieldRegistersBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDOBRegistersBreakfast)
                            .addComponent(jLabelNotesRegistersBreakfast))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldChildRegistersBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldDOBRegistersBreakfast, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldSessionRegistersBreakfast, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(jLabelDateBreakfast)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldDateBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameRegistersBreakfast)
                            .addComponent(jTextFieldChildRegistersBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDateBreakfast)
                            .addComponent(jTextFieldDateBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBRegistersBreakfast)
                            .addComponent(jTextFieldDOBRegistersBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionRegistersBreakfast)
                            .addComponent(jTextFieldSessionRegistersBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesRegistersBreakfast)
                            .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRegistersBreakfast)
                            .addComponent(jTextFieldRegistersBreakfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane26))
                .addContainerGap())
        );

        jTabbedPaneRegisters.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/breakfast_button.png")), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jListRegistersSnowdrop.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane28.setViewportView(jListRegistersSnowdrop);

        jLabelChildNameRegistersSnowdrop.setText("Child");

        jLabelDOBRegistersSnowdrop.setText("Date Of Birth");

        jLabelSessionRegistersSnowdrop.setText("Session");

        jLabelNotesRegistersSnowdrop.setText("Notes");

        jLabelRegistersSnowdrop.setText("Children");

        jTextAreaNotesRegistersSnowdrop.setColumns(20);
        jTextAreaNotesRegistersSnowdrop.setRows(5);
        jScrollPane17.setViewportView(jTextAreaNotesRegistersSnowdrop);

        jTextFieldDateSnowdrop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDateSnowdropKeyReleased(evt);
            }
        });

        jLabelDateSnowdrop.setText("Date");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelChildNameRegistersSnowdrop)
                    .addComponent(jLabelSessionRegistersSnowdrop)
                    .addComponent(jLabelDOBRegistersSnowdrop)
                    .addComponent(jLabelNotesRegistersSnowdrop)
                    .addComponent(jLabelRegistersSnowdrop))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldChildRegistersSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRegistersSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldSessionRegistersSnowdrop, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldDOBRegistersSnowdrop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(jLabelDateSnowdrop)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldDateSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDateSnowdrop)
                                .addComponent(jTextFieldDateSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelChildNameRegistersSnowdrop)
                                .addComponent(jTextFieldChildRegistersSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBRegistersSnowdrop)
                            .addComponent(jTextFieldDOBRegistersSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionRegistersSnowdrop)
                            .addComponent(jTextFieldSessionRegistersSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesRegistersSnowdrop)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRegistersSnowdrop)
                            .addComponent(jTextFieldRegistersSnowdrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneRegisters.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/snowdrop_button.png")), jPanel3); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jListRegistersButtercup.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane29.setViewportView(jListRegistersButtercup);

        jLabelChildNameRegistersButtercup.setText("Child");

        jLabelDOBRegistersButtercup.setText("Date Of Birth");

        jLabelSessionRegistersButtercup.setText("Session");

        jLabelNotesRegistersButtercup.setText("Notes");

        jLabelRegistersButtercup.setText("Children");

        jTextAreaNotesRegistersButtercup.setColumns(20);
        jTextAreaNotesRegistersButtercup.setRows(5);
        jScrollPane30.setViewportView(jTextAreaNotesRegistersButtercup);

        jTextFieldDateButtercup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDateButtercupKeyReleased(evt);
            }
        });

        jLabelDateButtercup.setText("Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameRegistersButtercup)
                            .addComponent(jLabelSessionRegistersButtercup))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldChildRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelNotesRegistersButtercup)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelRegistersButtercup)
                        .addGap(42, 42, 42)
                        .addComponent(jTextFieldRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelDOBRegistersButtercup)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(jLabelDateButtercup)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldDateButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDateButtercup)
                                .addComponent(jTextFieldDateButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelChildNameRegistersButtercup)
                                .addComponent(jTextFieldChildRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBRegistersButtercup)
                            .addComponent(jTextFieldDOBRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionRegistersButtercup)
                            .addComponent(jTextFieldSessionRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesRegistersButtercup)
                            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRegistersButtercup)
                            .addComponent(jTextFieldRegistersButtercup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneRegisters.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/buttercup_button.png")), jPanel4); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jListRegistersBluebell.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane31.setViewportView(jListRegistersBluebell);

        jLabelChildNameRegistersBluebell.setText("Child");

        jLabelDOBRegistersBluebell.setText("Date Of Birth");

        jLabelSessionRegistersBluebell.setText("Session");

        jLabelNotesRegistersBluebell.setText("Notes");

        jLabelRegistersBluebell.setText("Children");

        jTextAreaNotesRegistersBluebell.setColumns(20);
        jTextAreaNotesRegistersBluebell.setRows(5);
        jScrollPane32.setViewportView(jTextAreaNotesRegistersBluebell);

        jTextFieldDateBluebell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDateBluebellKeyReleased(evt);
            }
        });

        jLabelDateBluebell.setText("Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelRegistersBluebell)
                                .addGap(42, 42, 42)
                                .addComponent(jTextFieldRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelDOBRegistersBluebell)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDOBRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelChildNameRegistersBluebell)
                                .addGap(58, 58, 58)
                                .addComponent(jTextFieldChildRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
                        .addComponent(jLabelDateBluebell)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDateBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelSessionRegistersBluebell)
                                .addGap(45, 45, 45)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSessionRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelNotesRegistersBluebell))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDateBluebell)
                                .addComponent(jTextFieldDateBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelChildNameRegistersBluebell)
                                .addComponent(jTextFieldChildRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBRegistersBluebell)
                            .addComponent(jTextFieldDOBRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionRegistersBluebell)
                            .addComponent(jTextFieldSessionRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesRegistersBluebell)
                            .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRegistersBluebell)
                            .addComponent(jTextFieldRegistersBluebell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneRegisters.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/bluebell_button.png")), jPanel5); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jListRegistersFoxglove.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane33.setViewportView(jListRegistersFoxglove);

        jLabelChildNameRegistersFoxglove.setText("Child");

        jLabelDOBRegistersFoxglove.setText("Date Of Birth");

        jLabelSessionRegistersFoxglove.setText("Session");

        jLabelNotesRegistersFoxglove.setText("Notes");

        jLabelRegistersFoxglove.setText("Children");

        jTextAreaNotesRegistersFoxglove.setColumns(20);
        jTextAreaNotesRegistersFoxglove.setRows(5);
        jScrollPane34.setViewportView(jTextAreaNotesRegistersFoxglove);

        jTextFieldDateFoxglove.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDateFoxgloveKeyReleased(evt);
            }
        });

        jLabelDateFoxglove.setText("Date");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameRegistersFoxglove)
                            .addComponent(jLabelSessionRegistersFoxglove))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldChildRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelNotesRegistersFoxglove)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelRegistersFoxglove)
                        .addGap(42, 42, 42)
                        .addComponent(jTextFieldRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelDOBRegistersFoxglove)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(jLabelDateFoxglove)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldDateFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane33, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDateFoxglove)
                                .addComponent(jTextFieldDateFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelChildNameRegistersFoxglove)
                                .addComponent(jTextFieldChildRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDOBRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDOBRegistersFoxglove))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionRegistersFoxglove)
                            .addComponent(jTextFieldSessionRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesRegistersFoxglove)
                            .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRegistersFoxglove)
                            .addComponent(jTextFieldRegistersFoxglove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPaneRegisters.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/foxglove_button.png")), jPanel6); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jListRegistersOSCam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane35.setViewportView(jListRegistersOSCam);

        jLabelChildNameRegistersOSCam.setText("Child");

        jLabelDOBRegistersOSCam.setText("Date Of Birth");

        jLabelSessionRegistersOSCam.setText("Session");

        jLabelNotesRegistersOSCam.setText("Notes");

        jLabelRegistersOSCamNum.setText("Children");

        jTextAreaNotesRegistersOSCam.setColumns(20);
        jTextAreaNotesRegistersOSCam.setRows(5);
        jScrollPane36.setViewportView(jTextAreaNotesRegistersOSCam);

        jTextFieldDateOSCAm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDateOSCAmKeyReleased(evt);
            }
        });

        jLabelDateOSCAm.setText("Date");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRegistersOSCamNum)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelChildNameRegistersOSCam)
                                .addGap(58, 58, 58)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldChildRegistersOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldRegistersOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
                        .addComponent(jLabelDateOSCAm)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDateOSCAm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelSessionRegistersOSCam)
                                .addGap(45, 45, 45)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSessionRegistersOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelNotesRegistersOSCam)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelDOBRegistersOSCam)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDOBRegistersOSCAm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDateOSCAm)
                                .addComponent(jTextFieldDateOSCAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelChildNameRegistersOSCam)
                                .addComponent(jTextFieldChildRegistersOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBRegistersOSCam)
                            .addComponent(jTextFieldDOBRegistersOSCAm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionRegistersOSCam)
                            .addComponent(jTextFieldSessionRegistersOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesRegistersOSCam)
                            .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRegistersOSCamNum)
                            .addComponent(jTextFieldRegistersOSCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneRegisters.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/schoolAM_button.png")), jPanel7); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jListRegistersOSCpm.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane37.setViewportView(jListRegistersOSCpm);

        jLabelChildNameRegistersOSCpm.setText("Child");

        jLabelDOBRegistersOSCpm.setText("Date Of Birth");

        jLabelSessionRegistersOSCpm.setText("Session");

        jLabelNotesRegistersOSCpm.setText("Notes");

        jLabelRegistersOSCpmNum.setText("Children");

        jTextAreaNotesRegistersOSCpm.setColumns(20);
        jTextAreaNotesRegistersOSCpm.setRows(5);
        jScrollPane38.setViewportView(jTextAreaNotesRegistersOSCpm);

        jTextFieldDateOSCPm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDateOSCPmKeyReleased(evt);
            }
        });

        jLabelDateOSCPm.setText("Date");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChildNameRegistersOSCpm)
                            .addComponent(jLabelSessionRegistersOSCpm))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldChildRegistersOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldRegistersOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSessionRegistersOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelNotesRegistersOSCpm)
                    .addComponent(jLabelRegistersOSCpmNum)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabelDOBRegistersOSCpm)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDOBRegistersOSCPm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(jLabelDateOSCPm)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldDateOSCPm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildNameRegistersOSCpm)
                            .addComponent(jTextFieldChildRegistersOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOBRegistersOSCpm)
                            .addComponent(jTextFieldDOBRegistersOSCPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSessionRegistersOSCpm)
                            .addComponent(jTextFieldSessionRegistersOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNotesRegistersOSCpm)
                            .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRegistersOSCpmNum)
                            .addComponent(jTextFieldRegistersOSCpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDateOSCPm)
                            .addComponent(jTextFieldDateOSCPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane37, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneRegisters.addTab("PM", new javax.swing.ImageIcon(getClass().getResource("/images/schoolPM_button.png")), jPanel8); // NOI18N

        javax.swing.GroupLayout jPanelRegistersLayout = new javax.swing.GroupLayout(jPanelRegisters);
        jPanelRegisters.setLayout(jPanelRegistersLayout);
        jPanelRegistersLayout.setHorizontalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneRegisters, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelRegistersLayout.setVerticalGroup(
            jPanelRegistersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneRegisters, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneHomePage.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/registers_button.png")), jPanelRegisters); // NOI18N

        jPanelChildren.setBackground(new java.awt.Color(255, 255, 255));
        jPanelChildren.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelChildren.setFocusCycleRoot(true);

        jLabelEthnicOriginChild.setText("Ethnic Origin");

        jLabelChildHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/childrenHeading.png"))); // NOI18N

        jLabelReligionChild.setText("Religion");

        jLabelPosChild.setText("Position In Family");

        jLabelKnownAs.setText("Known As");

        jLabelLanguagesChild.setText("Languages Spoken");

        jLabelSexChild.setText("Sex");

        jLabelDOBChild.setText("Date Of Birth");

        jLabelSurnameChild.setText("Surname");

        jLabelFirstNameChild.setText("First Name");

        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setRows(5);
        jScrollPaneNotesChild.setViewportView(jTextAreaNotes);

        jLabelMedicalChild.setText("Medical Conditions");

        jLabelImmunisationsChild.setText("Immunisations");

        jLabelDietaryNeedsChild.setText("Dietary Needs");

        jLabelNotesChild.setText("Notes");

        jLabelAddChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addNew_button.png"))); // NOI18N
        jLabelAddChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddChildMouseClicked(evt);
            }
        });

        jLabelEditChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_button.png"))); // NOI18N
        jLabelEditChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelEditChildMousePressed(evt);
            }
        });

        jLabelDeleteChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteChildMousePressed(evt);
            }
        });

        jLabelViewBookingsChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewBooking_button.png"))); // NOI18N
        jLabelViewBookingsChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelViewBookingsChildMouseClicked(evt);
            }
        });

        jListRelativesChildren.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jListRelativesChildren);

        jLabelRelativesChildren.setText("Relatives");

        jLabelAddRelationshipChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addRelationship_button.png"))); // NOI18N
        jLabelAddRelationshipChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddRelationshipChildMouseClicked(evt);
            }
        });

        jLabelChildRoom.setText("Room");

        jTextFieldSearchChild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchChildKeyReleased(evt);
            }
        });

        jListChildren.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListChildren.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListChildrenMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListChildren);

        jListChildRoom.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListChildRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListChildRoomMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(jListChildRoom);

        jLabelSearchChild.setText("Search");

        jLabelChildRoomList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addRoom_button.png"))); // NOI18N
        jLabelChildRoomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelChildRoomListMousePressed(evt);
            }
        });

        jLabelDeleteRoomChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteRoomChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteRoomChildMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelChildrenLayout = new javax.swing.GroupLayout(jPanelChildren);
        jPanelChildren.setLayout(jPanelChildrenLayout);
        jPanelChildrenLayout.setHorizontalGroup(
            jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelChildrenLayout.createSequentialGroup()
                        .addComponent(jLabelSearchChild)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearchChild))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChildrenLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabelChildHeading)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelChildrenLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRelativesChildren)
                            .addComponent(jLabelFirstNameChild)
                            .addComponent(jLabelSurnameChild)
                            .addComponent(jLabelKnownAs)
                            .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelPosChild)
                                .addComponent(jLabelSexChild)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChildrenLayout.createSequentialGroup()
                                    .addComponent(jLabelDOBChild)
                                    .addGap(37, 37, 37)
                                    .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldKnownAsChild, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                        .addComponent(jTextFieldSurnameChild)
                                        .addComponent(jTextFieldPositionChild, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldFirstNameChild)
                                        .addComponent(jTextFieldSexChild)
                                        .addComponent(jTextFieldDOBChild, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                .addComponent(jLabelAddRelationshipChild)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelViewBookingsChild)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                .addComponent(jLabelDeleteRoomChild)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelChildRoomList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDeleteChild)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEditChild)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAddChild))
                            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                        .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelMedicalChild)
                                            .addComponent(jLabelImmunisationsChild)
                                            .addComponent(jLabelDietaryNeedsChild)
                                            .addComponent(jLabelEthnicOriginChild))
                                        .addGap(20, 20, 20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChildrenLayout.createSequentialGroup()
                                        .addComponent(jLabelLanguagesChild)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldLanguagesChild)
                                    .addComponent(jTextFieldDietaryNeedsChild)
                                    .addComponent(jTextFieldEthnicOriginChild, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldReligionChild, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldImmunisationsChild)
                                    .addComponent(jTextFieldMedicalChild)))
                            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                .addComponent(jLabelReligionChild)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                        .addComponent(jLabelChildRoom)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPaneNotesChild, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNotesChild))))
                        .addContainerGap())))
        );
        jPanelChildrenLayout.setVerticalGroup(
            jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChildrenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChildrenLayout.createSequentialGroup()
                        .addComponent(jLabelChildHeading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChildrenLayout.createSequentialGroup()
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldFirstNameChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFirstNameChild))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldSurnameChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSurnameChild))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldKnownAsChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelKnownAs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDOBChild)
                                    .addComponent(jTextFieldDOBChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldSexChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSexChild))
                                .addGap(9, 9, 9)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldPositionChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPosChild))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChildrenLayout.createSequentialGroup()
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelReligionChild)
                                    .addComponent(jTextFieldReligionChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEthnicOriginChild)
                                    .addComponent(jTextFieldEthnicOriginChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldLanguagesChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLanguagesChild))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldMedicalChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMedicalChild))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelImmunisationsChild)
                                    .addComponent(jTextFieldImmunisationsChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDietaryNeedsChild)
                                    .addComponent(jTextFieldDietaryNeedsChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)))
                        .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                .addComponent(jLabelRelativesChildren)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAddRelationshipChild, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelAddChild)
                                        .addComponent(jLabelEditChild)
                                        .addComponent(jLabelDeleteChild))
                                    .addComponent(jLabelViewBookingsChild, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelChildrenLayout.createSequentialGroup()
                                        .addComponent(jLabelNotesChild)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPaneNotesChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelChildRoom))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelChildRoomList, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelDeleteRoomChild, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelChildrenLayout.createSequentialGroup()
                        .addGroup(jPanelChildrenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearchChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearchChild))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        jTabbedPaneHomePage.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/child_button.png")), jPanelChildren); // NOI18N

        jPanelRelatives.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldSearchRelatives.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchRelativesKeyReleased(evt);
            }
        });

        jListRelatives.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRelatives.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListRelativesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jListRelatives);

        jLabelRelativeHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relativesHeading.png"))); // NOI18N

        jLabelAddRelative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addNew_button.png"))); // NOI18N
        jLabelAddRelative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddRelativeMouseClicked(evt);
            }
        });

        jLabelEditRelative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_button.png"))); // NOI18N
        jLabelEditRelative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelEditRelativeMousePressed(evt);
            }
        });

        jLabelDeleteRelative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteRelative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteRelativeMousePressed(evt);
            }
        });

        jLabelFirstNameRelative.setText("First Name");

        jLabelSurnameRelative.setText("Surname");

        jLabelAddress1Relative.setText("Address Line 1");

        jLabelAddress2Relative.setText("Address Line 2");

        jLabelPostCodeRelative.setText("Post Code");

        jLabelChildrenRelative.setText("Children");

        jListChildrenRelative.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jListChildrenRelative);

        jLabelContactNumRelative.setText("Contact number");

        jLabelMobileNumRelative.setText("Mobile number");

        jLabelEmailRelative.setText("Email address");

        jLabelPasswordRelative.setText("Password");

        jLabelAddRelationshipRelative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addRelationship_button.png"))); // NOI18N
        jLabelAddRelationshipRelative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddRelationshipRelativeMouseClicked(evt);
            }
        });

        jLabelSearchRelatives.setText("Search");

        javax.swing.GroupLayout jPanelRelativesLayout = new javax.swing.GroupLayout(jPanelRelatives);
        jPanelRelatives.setLayout(jPanelRelativesLayout);
        jPanelRelativesLayout.setHorizontalGroup(
            jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRelativesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRelativesLayout.createSequentialGroup()
                        .addComponent(jLabelSearchRelatives)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearchRelatives, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRelativesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRelativesLayout.createSequentialGroup()
                                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRelativesLayout.createSequentialGroup()
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelFirstNameRelative)
                                            .addComponent(jLabelSurnameRelative)
                                            .addComponent(jLabelAddress1Relative)
                                            .addComponent(jLabelAddress2Relative)
                                            .addComponent(jLabelPostCodeRelative)
                                            .addComponent(jLabelChildrenRelative))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldPostCodeRelative, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelRelativesLayout.createSequentialGroup()
                                                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldAddress2Relative, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldAddress1Relative)
                                                    .addComponent(jTextFieldSurnameRelative, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldFirstNameRelative))
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelContactNumRelative)
                                                    .addComponent(jLabelMobileNumRelative)
                                                    .addComponent(jLabelPasswordRelative)
                                                    .addComponent(jLabelEmailRelative))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldEmailRelative, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldPasswordRelative, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextFieldMobileNumRelative, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldContactNumRelative, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(295, 295, 295))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRelativesLayout.createSequentialGroup()
                                .addComponent(jLabelAddRelationshipRelative)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 562, Short.MAX_VALUE)
                                .addComponent(jLabelDeleteRelative)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEditRelative)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAddRelative)
                                .addContainerGap())))
                    .addGroup(jPanelRelativesLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabelRelativeHeading)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelRelativesLayout.setVerticalGroup(
            jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRelativesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRelativesLayout.createSequentialGroup()
                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearchRelatives, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearchRelatives))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanelRelativesLayout.createSequentialGroup()
                        .addComponent(jLabelRelativeHeading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRelativesLayout.createSequentialGroup()
                                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelRelativesLayout.createSequentialGroup()
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldFirstNameRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelFirstNameRelative))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldSurnameRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelSurnameRelative))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelAddress1Relative)
                                            .addComponent(jTextFieldAddress1Relative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelAddress2Relative)
                                            .addComponent(jTextFieldAddress2Relative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelPasswordRelative)))
                                    .addGroup(jPanelRelativesLayout.createSequentialGroup()
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelContactNumRelative)
                                            .addComponent(jTextFieldContactNumRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelMobileNumRelative)
                                            .addComponent(jTextFieldMobileNumRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldEmailRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelEmailRelative))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPasswordRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPostCodeRelative)
                                    .addComponent(jTextFieldPostCodeRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabelChildrenRelative)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanelRelativesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAddRelative)
                                    .addComponent(jLabelEditRelative, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelDeleteRelative, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRelativesLayout.createSequentialGroup()
                                .addGap(341, 341, 341)
                                .addComponent(jLabelAddRelationshipRelative)))))
                .addContainerGap())
        );

        jTabbedPaneHomePage.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/relative_button.png")), jPanelRelatives); // NOI18N

        jPanelBookings.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldSearchBookings.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchBookingsKeyReleased(evt);
            }
        });

        jLabelAddBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addNew_button.png"))); // NOI18N
        jLabelAddBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddBookingMouseClicked(evt);
            }
        });

        jLabelEditBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_button.png"))); // NOI18N
        jLabelEditBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelEditBookingMousePressed(evt);
            }
        });

        jLabelDeleteBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteBookingMousePressed(evt);
            }
        });

        jLabelBookingHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookingsHeading.png"))); // NOI18N

        jLabelChildBookings.setText("Child");

        jLabelRoomBookings.setText("Room");

        jLabelSessionBookings.setText("Session");

        jLabelNotesBookings.setText("Notes");

        jTextAreaNotesBookings.setColumns(20);
        jTextAreaNotesBookings.setRows(5);
        jScrollPaneNotesChild1.setViewportView(jTextAreaNotesBookings);

        jLabelDateBooking.setText("Date");

        jListBookings.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListBookingsMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(jListBookings);

        jLabelSearchBookings.setText("Search");

        javax.swing.GroupLayout jPanelBookingsLayout = new javax.swing.GroupLayout(jPanelBookings);
        jPanelBookings.setLayout(jPanelBookingsLayout);
        jPanelBookingsLayout.setHorizontalGroup(
            jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBookingsLayout.createSequentialGroup()
                        .addComponent(jLabelSearchBookings)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearchBookings)))
                .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBookingsLayout.createSequentialGroup()
                        .addGap(0, 740, Short.MAX_VALUE)
                        .addComponent(jLabelDeleteBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEditBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAddBooking)
                        .addGap(10, 10, 10))
                    .addGroup(jPanelBookingsLayout.createSequentialGroup()
                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookingsLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabelBookingHeading))
                            .addGroup(jPanelBookingsLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelBookingsLayout.createSequentialGroup()
                                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelChildBookings)
                                            .addComponent(jLabelDateBooking))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldChildBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldDateBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNotesBookings)
                                        .addComponent(jScrollPaneNotesChild1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelBookingsLayout.createSequentialGroup()
                                        .addComponent(jLabelRoomBookings)
                                        .addGap(27, 27, 27)
                                        .addComponent(jTextFieldRoomBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelBookingsLayout.createSequentialGroup()
                                        .addComponent(jLabelSessionBookings)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldSessionBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelBookingsLayout.setVerticalGroup(
            jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBookingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBookingsLayout.createSequentialGroup()
                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearchBookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearchBookings))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                    .addGroup(jPanelBookingsLayout.createSequentialGroup()
                        .addComponent(jLabelBookingHeading)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelChildBookings)
                            .addComponent(jTextFieldChildBookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRoomBookings)
                            .addComponent(jTextFieldRoomBookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDateBooking)
                            .addComponent(jTextFieldDateBookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSessionBookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSessionBookings))
                        .addGap(25, 25, 25)
                        .addComponent(jLabelNotesBookings)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneNotesChild1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelEditBooking, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelAddBooking, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabelDeleteBooking))))
                .addContainerGap())
        );

        jTabbedPaneHomePage.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/booking_button.png")), jPanelBookings); // NOI18N

        jPanelStaff.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldSearchStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchStaffKeyReleased(evt);
            }
        });

        jListStaff.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListStaffMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jListStaff);

        jLabelAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addNew_button.png"))); // NOI18N
        jLabelAddStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddStaffMouseClicked(evt);
            }
        });

        jLabelEditStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_button.png"))); // NOI18N
        jLabelEditStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelEditStaffMousePressed(evt);
            }
        });

        jLabelDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaffMousePressed(evt);
            }
        });

        jLabelStaffHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staffHeading.png"))); // NOI18N

        jLabelFirstNameStaff.setText("First Name");

        jLabelSurnameStaff.setText("Surname");

        jLabelDOBStaff.setText("Date Of Birth");

        jLabelAddress1Staff.setText("Address Line 1");

        jLabelAddress2Staff.setText("Address Line 2");

        jLabelPostCodeStaff.setText("Post Code");

        jLabelContactNumStaff.setText("Contact Number");

        jLabelMobileNumStaff.setText("Mobile Number");

        jLabelMedicalConditionsStaff.setText("Medical Conditions");

        jLabelDietaryNeedsStaff.setText("Dietary Needs");

        jLabelUsernameStaff.setText("Username");

        jLabelPasswordStaff.setText("Password");

        jLabelRoomStaff.setText("Room");

        jLabelSearchStaff.setText("Search");

        jListStaffRoom.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListStaffRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListStaffRoomMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(jListStaffRoom);

        jLabelStaffRoomList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addRoom_button.png"))); // NOI18N
        jLabelStaffRoomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelStaffRoomListMousePressed(evt);
            }
        });

        jLabelDeleteRoomStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteRoomStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteRoomStaffMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelStaffLayout = new javax.swing.GroupLayout(jPanelStaff);
        jPanelStaff.setLayout(jPanelStaffLayout);
        jPanelStaffLayout.setHorizontalGroup(
            jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStaffLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelStaffLayout.createSequentialGroup()
                        .addComponent(jLabelSearchStaff)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearchStaff)))
                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStaffLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDeleteStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEditStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAddStaff))
                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelStaffLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabelStaffHeading))
                            .addGroup(jPanelStaffLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSurnameStaff)
                                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                                        .addComponent(jLabelFirstNameStaff)
                                        .addGap(37, 37, 37)
                                        .addComponent(jTextFieldFirstNameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelStaffLayout.createSequentialGroup()
                                            .addComponent(jLabelAddress1Staff)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldAddress1Staff))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelStaffLayout.createSequentialGroup()
                                            .addComponent(jLabelAddress2Staff)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldAddress2Staff, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelStaffLayout.createSequentialGroup()
                                            .addComponent(jLabelDOBStaff)
                                            .addGap(25, 25, 25)
                                            .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldSurnameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldDOBStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                                        .addComponent(jLabelPostCodeStaff)
                                        .addGap(39, 39, 39)
                                        .addComponent(jTextFieldPostCodeStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                                        .addComponent(jLabelRoomStaff)
                                        .addGap(61, 61, 61)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelStaffLayout.createSequentialGroup()
                                                .addComponent(jLabelDeleteRoomStaff)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelStaffRoomList))
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(119, 119, 119)
                                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMedicalConditionsStaff)
                                    .addComponent(jLabelMobileNumStaff)
                                    .addComponent(jLabelDietaryNeedsStaff)
                                    .addComponent(jLabelContactNumStaff)
                                    .addComponent(jLabelUsernameStaff)
                                    .addComponent(jLabelPasswordStaff))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDietaryNeedsStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldMedicalConditionsStaff)
                                        .addComponent(jTextFieldContactNumStaff)
                                        .addComponent(jTextFieldMobileNumStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldUsernameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPasswordStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 211, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelStaffLayout.setVerticalGroup(
            jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStaffLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearchStaff))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelStaffLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelFirstNameStaff)
                                            .addComponent(jTextFieldFirstNameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelSurnameStaff)
                                            .addComponent(jTextFieldSurnameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelDOBStaff)
                                            .addComponent(jTextFieldDOBStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelAddress1Staff)
                                            .addComponent(jTextFieldAddress1Staff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelAddress2Staff)
                                            .addComponent(jTextFieldAddress2Staff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelPostCodeStaff)
                                            .addComponent(jTextFieldPostCodeStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelStaffLayout.createSequentialGroup()
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelContactNumStaff)
                                            .addComponent(jTextFieldContactNumStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelMobileNumStaff)
                                            .addComponent(jTextFieldMobileNumStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelMedicalConditionsStaff)
                                            .addComponent(jTextFieldMedicalConditionsStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelDietaryNeedsStaff)
                                            .addComponent(jTextFieldDietaryNeedsStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelUsernameStaff)
                                            .addGroup(jPanelStaffLayout.createSequentialGroup()
                                                .addComponent(jTextFieldUsernameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jTextFieldPasswordStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelPasswordStaff)))))))
                            .addComponent(jLabelStaffHeading))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEditStaff, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAddStaff, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDeleteStaff, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelStaffLayout.createSequentialGroup()
                                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRoomStaff))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 73, Short.MAX_VALUE)
                                .addGroup(jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStaffRoomList, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelDeleteRoomStaff, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );

        jTabbedPaneHomePage.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/staff_button.png")), jPanelStaff); // NOI18N

        jPanelRooms.setBackground(new java.awt.Color(255, 255, 255));

        jListRooms.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListRooms.setFocusable(false);
        jListRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListRoomsMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jListRooms);

        jTextFieldSearchRooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchRoomsKeyReleased(evt);
            }
        });

        jLabelAddRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addNew_button.png"))); // NOI18N
        jLabelAddRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddRoomMouseClicked(evt);
            }
        });

        jLabelEditRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_button.png"))); // NOI18N
        jLabelEditRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelEditRoomMousePressed(evt);
            }
        });

        jLabelDeleteRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_button.png"))); // NOI18N
        jLabelDeleteRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDeleteRoomMousePressed(evt);
            }
        });

        jLabelRoomHeading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/roomsHeading.png"))); // NOI18N

        jLabelRoomNameRooms.setText("Room Name");

        jLabelAgeMinRooms.setText("Age Minimum");

        jLabelAgeMaxRooms.setText("Age Maximum");

        jLabelRatioRooms.setText("Staff To Child Ratio");

        jLabelMaxNumberChildrenRooms.setText("Maximum Number Of Children");

        jLabelSearchRoom.setText("Search");

        javax.swing.GroupLayout jPanelRoomsLayout = new javax.swing.GroupLayout(jPanelRooms);
        jPanelRooms.setLayout(jPanelRoomsLayout);
        jPanelRoomsLayout.setHorizontalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRoomsLayout.createSequentialGroup()
                        .addComponent(jLabelSearchRoom)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSearchRooms)))
                .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRoomsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDeleteRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEditRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAddRoom))
                    .addGroup(jPanelRoomsLayout.createSequentialGroup()
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabelRoomHeading))
                            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMaxNumberChildrenRooms)
                                    .addComponent(jLabelRatioRooms)
                                    .addComponent(jLabelAgeMaxRooms)
                                    .addComponent(jLabelAgeMinRooms)
                                    .addComponent(jLabelRoomNameRooms))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldRoomNameRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldAgeMaxRooms, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldAgeMinRooms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldRatioRooms, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldMaxNumberChildrenRooms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 666, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRoomsLayout.setVerticalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRoomsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRoomsLayout.createSequentialGroup()
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearchRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearchRoom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                    .addGroup(jPanelRoomsLayout.createSequentialGroup()
                        .addComponent(jLabelRoomHeading)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRoomNameRooms)
                            .addComponent(jTextFieldRoomNameRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAgeMinRooms)
                            .addComponent(jTextFieldAgeMinRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAgeMaxRooms)
                            .addComponent(jTextFieldAgeMaxRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRatioRooms)
                            .addComponent(jTextFieldRatioRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMaxNumberChildrenRooms)
                            .addComponent(jTextFieldMaxNumberChildrenRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEditRoom)
                            .addComponent(jLabelDeleteRoom)
                            .addComponent(jLabelAddRoom))))
                .addContainerGap())
        );

        jTabbedPaneHomePage.addTab("", new javax.swing.ImageIcon(getClass().getResource("/images/rooms_button.png")), jPanelRooms); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneHomePage, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneHomePage, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneHomePage.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAddBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddBookingMouseClicked
        addBooking addBooking = null;
        this.dispose();
        try {
            addBooking = new addBooking();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addBooking.setVisible(true); 
    }//GEN-LAST:event_jLabelAddBookingMouseClicked

    private void jLabelAddRelativeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddRelativeMouseClicked
        addRelative addRelative = null;
        this.dispose();
        try {
            addRelative = new addRelative();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addRelative.setVisible(true);
    }//GEN-LAST:event_jLabelAddRelativeMouseClicked

    private void jLabelAddRelationshipRelativeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddRelationshipRelativeMouseClicked
        addRelationship addRelationship = null;
        this.dispose();
        try {
            addRelationship = new addRelationship();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addRelationship.setVisible(true);
    }//GEN-LAST:event_jLabelAddRelationshipRelativeMouseClicked

    private void jLabelAddRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddRoomMouseClicked
        addRoom addRoom = null;
        this.dispose();
        try {
            addRoom = new addRoom();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addRoom.setVisible(true);
    }//GEN-LAST:event_jLabelAddRoomMouseClicked

    private void jLabelAddStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddStaffMouseClicked
        addStaff addStaff = null;
        this.dispose();
        try {
            addStaff = new addStaff();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addStaff.setVisible(true);
    }//GEN-LAST:event_jLabelAddStaffMouseClicked

    private void jLabelAddRelationshipChildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddRelationshipChildMouseClicked
        addRelationship addRelationship = null;
        this.dispose();
        try {
            addRelationship = new addRelationship();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addRelationship.setVisible(true);
    }//GEN-LAST:event_jLabelAddRelationshipChildMouseClicked

    private void jLabelViewBookingsChildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelViewBookingsChildMouseClicked
        viewBookings viewBookings = null;
        this.dispose();
        try {
            viewBookings = new viewBookings(childInfo[0]);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewBookings.setVisible(true);
    }//GEN-LAST:event_jLabelViewBookingsChildMouseClicked

    private void jLabelAddChildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddChildMouseClicked
        addChild addChild = null;
        this.dispose();
        try {
            addChild = new addChild();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addChild.setVisible(true);
    }//GEN-LAST:event_jLabelAddChildMouseClicked

    private void jListChildrenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListChildrenMousePressed
        try {
            updateChildList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListChildrenMousePressed

    private void jListRelativesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRelativesMousePressed
        try {
            updateRelativeList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListRelativesMousePressed

    private void jListStaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListStaffMousePressed
        try {
            updateStaffList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListStaffMousePressed

    private void jListRoomsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRoomsMousePressed
        updateRoomList();
    }//GEN-LAST:event_jListRoomsMousePressed

    private void jListBookingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListBookingsMousePressed
        updateBookingList();
    }//GEN-LAST:event_jListBookingsMousePressed

    private void jListTodayBreakfastMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTodayBreakfastMousePressed
        updateTodayBreakfastList();
    }//GEN-LAST:event_jListTodayBreakfastMousePressed

    private void jListTodaySnowdropMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTodaySnowdropMousePressed
        updateTodaySnowdropList();
    }//GEN-LAST:event_jListTodaySnowdropMousePressed

    private void jListTodayButtercupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTodayButtercupMousePressed
        updateTodayButtercupList();
    }//GEN-LAST:event_jListTodayButtercupMousePressed

    private void jListTodayBluebellMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTodayBluebellMousePressed
        updateTodayBluebellList();
    }//GEN-LAST:event_jListTodayBluebellMousePressed

    private void jListTodayFoxgloveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTodayFoxgloveMousePressed
        updateTodayFoxgloveList();
    }//GEN-LAST:event_jListTodayFoxgloveMousePressed

    private void jListTodayOSCamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTodayOSCamMousePressed
        updateTodayOSCAmList();
    }//GEN-LAST:event_jListTodayOSCamMousePressed

    private void jListTodayOSCpmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTodayOSCpmMousePressed
        updateTodayOSCPmList();
    }//GEN-LAST:event_jListTodayOSCpmMousePressed

    private void jTextFieldDateBreakfastKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDateBreakfastKeyReleased
        try {
            setRegistersBreakfastList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDateBreakfastKeyReleased

    private void jLabelDeleteChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteChildMousePressed
        try {
            connect.deleteChild(childInfo[0]);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setChildList();
            jTextFieldSearchChild.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteChildMousePressed

    private void jLabelDeleteRelativeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteRelativeMousePressed
        try {
            connect.deleteRelative(relativeInfo[0]);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setRelativeList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteRelativeMousePressed

    private void jLabelDeleteBookingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteBookingMousePressed
        try {
            connect.deleteBooking(bookingInfo[0]);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setBookingList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteBookingMousePressed

    private void jLabelDeleteStaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaffMousePressed
        try {
            connect.deleteStaff(staffInfo[0]);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setStaffList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteStaffMousePressed

    private void jLabelDeleteRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteRoomMousePressed
        try {
            connect.deleteRoom(roomInfo[0]);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setRoomList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteRoomMousePressed

    private void jLabelEditChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditChildMousePressed
        connect.editChild(childInfo[0], jTextFieldFirstNameChild.getText(),
                jTextFieldSurnameChild.getText(),
                jTextFieldKnownAsChild.getText(), jTextFieldSexChild.getText(),
                jTextFieldDOBChild.getText(),
                Integer.parseInt(jTextFieldPositionChild.getText()),
                jTextFieldReligionChild.getText(),
                jTextFieldEthnicOriginChild.getText(),
                jTextFieldLanguagesChild.getText(),
                jTextFieldMedicalChild.getText(),
                jTextFieldImmunisationsChild.getText(),
                jTextFieldDietaryNeedsChild.getText(), jTextAreaNotes.getText());
        try {
            setChildList();
            jTextFieldSearchChild.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelEditChildMousePressed

    private void jLabelEditRelativeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditRelativeMousePressed
        connect.editRelative(relativeInfo[0],
                jTextFieldFirstNameRelative.getText(),
                jTextFieldSurnameRelative.getText(),
                jTextFieldAddress1Relative.getText(),
                jTextFieldAddress2Relative.getText(),
                jTextFieldPostCodeRelative.getText(),
                jTextFieldContactNumRelative.getText(),
                jTextFieldMobileNumRelative.getText(),
                jTextFieldEmailRelative.getText(),
                jTextFieldPasswordRelative.getText());
        try {
            setRelativeList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelEditRelativeMousePressed

    private void jLabelEditBookingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditBookingMousePressed
        connect.editBooking(bookingInfo[0], jTextFieldDateBookings.getText(),
                jTextFieldSessionBookings.getText(), jTextAreaNotes.getText());
        try{
            setBookingList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelEditBookingMousePressed

    private void jLabelEditStaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaffMousePressed
        connect.editStaff(staffInfo[0], jTextFieldFirstNameStaff.getText(),
                jTextFieldSurnameStaff.getText(), jTextFieldDOBStaff.getText(),
                jTextFieldAddress1Staff.getText(),
                jTextFieldAddress2Staff.getText(),
                jTextFieldPostCodeStaff.getText(),
                jTextFieldContactNumStaff.getText(),
                jTextFieldMobileNumStaff.getText(),
                jTextFieldMedicalConditionsStaff.getText(),
                jTextFieldDietaryNeedsStaff.getText(),
                jTextFieldUsernameStaff.getText(),
                jTextFieldPasswordStaff.getText());
        try {
            setStaffList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelEditStaffMousePressed

    private void jLabelEditRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditRoomMousePressed
        connect.editRoom(roomInfo[0], jTextFieldRoomNameRooms.getText(),
                jTextFieldAgeMinRooms.getText(),
                jTextFieldAgeMaxRooms.getText(), jTextFieldRatioRooms.getText(),
                jTextFieldMaxNumberChildrenRooms.getText());
        try {
            setRoomList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelEditRoomMousePressed

    private void jTextFieldDateSnowdropKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDateSnowdropKeyReleased
        try {
            setRegistersSnowdropList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDateSnowdropKeyReleased

    private void jTextFieldDateButtercupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDateButtercupKeyReleased
        try {
            setRegistersButtercupList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDateButtercupKeyReleased

    private void jTextFieldDateBluebellKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDateBluebellKeyReleased
        try {
            setRegistersBluebellList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDateBluebellKeyReleased

    private void jTextFieldDateFoxgloveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDateFoxgloveKeyReleased
        try {
            setRegistersFoxgloveList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDateFoxgloveKeyReleased

    private void jTextFieldDateOSCAmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDateOSCAmKeyReleased
        try {
            setRegistersOSCAmList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDateOSCAmKeyReleased

    private void jTextFieldDateOSCPmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDateOSCPmKeyReleased
        try {
            setRegistersOSCPmList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldDateOSCPmKeyReleased

    private void jTextFieldSearchChildKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchChildKeyReleased
        try {
            searchChildList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchChildKeyReleased

    private void jTextFieldSearchRelativesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchRelativesKeyReleased
        try {
            searchRelativeList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchRelativesKeyReleased

    private void jTextFieldSearchBookingsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchBookingsKeyReleased
        try {
            searchBookingList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchBookingsKeyReleased

    private void jTextFieldSearchStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchStaffKeyReleased
        try {
            searchStaffList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchStaffKeyReleased

    private void jTextFieldSearchRoomsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchRoomsKeyReleased
        try {
            searchRoomList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchRoomsKeyReleased

    private void jLabelStaffRoomListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStaffRoomListMousePressed
        addRoomStaff addRoomStaff = null;
        this.dispose();
        try {
            addRoomStaff = new addRoomStaff();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        addRoomStaff.setVisible(true);
    }//GEN-LAST:event_jLabelStaffRoomListMousePressed

    private void jLabelDeleteRoomStaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteRoomStaffMousePressed
        try {
            connect.deleteStaffRoom(staffRoomInfo[0]);
            updateStaffList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteRoomStaffMousePressed

    private void jListStaffRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListStaffRoomMousePressed
        try {
            updateStaffRoomList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListStaffRoomMousePressed

    private void jLabelChildRoomListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChildRoomListMousePressed
        try {
            addRoomChild addRoomChild = null;
            this.dispose();
            addRoomChild = new addRoomChild();
            addRoomChild.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelChildRoomListMousePressed

    private void jLabelDeleteRoomChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteRoomChildMousePressed
        try {
            connect.deleteChildRoom(childRoomInfo[0]);
            updateChildList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDeleteRoomChildMousePressed

    private void jListChildRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListChildRoomMousePressed
        try {
            updateChildRoomList();
        } catch (SQLException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListChildRoomMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new homePage().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddBooking;
    private javax.swing.JLabel jLabelAddChild;
    private javax.swing.JLabel jLabelAddRelationshipChild;
    private javax.swing.JLabel jLabelAddRelationshipRelative;
    private javax.swing.JLabel jLabelAddRelative;
    private javax.swing.JLabel jLabelAddRoom;
    private javax.swing.JLabel jLabelAddStaff;
    private javax.swing.JLabel jLabelAddress1Relative;
    private javax.swing.JLabel jLabelAddress1Staff;
    private javax.swing.JLabel jLabelAddress2Relative;
    private javax.swing.JLabel jLabelAddress2Staff;
    private javax.swing.JLabel jLabelAgeMaxRooms;
    private javax.swing.JLabel jLabelAgeMinRooms;
    private javax.swing.JLabel jLabelBookingHeading;
    private javax.swing.JLabel jLabelChildBookings;
    private javax.swing.JLabel jLabelChildHeading;
    private javax.swing.JLabel jLabelChildNameRegistersBluebell;
    private javax.swing.JLabel jLabelChildNameRegistersBreakfast;
    private javax.swing.JLabel jLabelChildNameRegistersButtercup;
    private javax.swing.JLabel jLabelChildNameRegistersFoxglove;
    private javax.swing.JLabel jLabelChildNameRegistersOSCam;
    private javax.swing.JLabel jLabelChildNameRegistersOSCpm;
    private javax.swing.JLabel jLabelChildNameRegistersSnowdrop;
    private javax.swing.JLabel jLabelChildNameTodayBluebell;
    private javax.swing.JLabel jLabelChildNameTodayBreakfast;
    private javax.swing.JLabel jLabelChildNameTodayButtercup;
    private javax.swing.JLabel jLabelChildNameTodayFoxglove;
    private javax.swing.JLabel jLabelChildNameTodayOSCam;
    private javax.swing.JLabel jLabelChildNameTodayOSCpm;
    private javax.swing.JLabel jLabelChildNameTodaySnowdrop;
    private javax.swing.JLabel jLabelChildRoom;
    private javax.swing.JLabel jLabelChildRoomList;
    private javax.swing.JLabel jLabelChildrenRelative;
    private javax.swing.JLabel jLabelContactNumRelative;
    private javax.swing.JLabel jLabelContactNumStaff;
    private javax.swing.JLabel jLabelDOBChild;
    private javax.swing.JLabel jLabelDOBRegistersBluebell;
    private javax.swing.JLabel jLabelDOBRegistersBreakfast;
    private javax.swing.JLabel jLabelDOBRegistersButtercup;
    private javax.swing.JLabel jLabelDOBRegistersFoxglove;
    private javax.swing.JLabel jLabelDOBRegistersOSCam;
    private javax.swing.JLabel jLabelDOBRegistersOSCpm;
    private javax.swing.JLabel jLabelDOBRegistersSnowdrop;
    private javax.swing.JLabel jLabelDOBStaff;
    private javax.swing.JLabel jLabelDOBTodayBluebell;
    private javax.swing.JLabel jLabelDOBTodayBreakfast;
    private javax.swing.JLabel jLabelDOBTodayButtercup;
    private javax.swing.JLabel jLabelDOBTodayFoxglove;
    private javax.swing.JLabel jLabelDOBTodayOSCam;
    private javax.swing.JLabel jLabelDOBTodayOSCpm;
    private javax.swing.JLabel jLabelDOBTodaySnowdrop;
    private javax.swing.JLabel jLabelDateBluebell;
    private javax.swing.JLabel jLabelDateBooking;
    private javax.swing.JLabel jLabelDateBreakfast;
    private javax.swing.JLabel jLabelDateButtercup;
    private javax.swing.JLabel jLabelDateFoxglove;
    private javax.swing.JLabel jLabelDateOSCAm;
    private javax.swing.JLabel jLabelDateOSCPm;
    private javax.swing.JLabel jLabelDateSnowdrop;
    private javax.swing.JLabel jLabelDeleteBooking;
    private javax.swing.JLabel jLabelDeleteChild;
    private javax.swing.JLabel jLabelDeleteRelative;
    private javax.swing.JLabel jLabelDeleteRoom;
    private javax.swing.JLabel jLabelDeleteRoomChild;
    private javax.swing.JLabel jLabelDeleteRoomStaff;
    private javax.swing.JLabel jLabelDeleteStaff;
    private javax.swing.JLabel jLabelDietaryNeedsChild;
    private javax.swing.JLabel jLabelDietaryNeedsStaff;
    private javax.swing.JLabel jLabelEditBooking;
    private javax.swing.JLabel jLabelEditChild;
    private javax.swing.JLabel jLabelEditRelative;
    private javax.swing.JLabel jLabelEditRoom;
    private javax.swing.JLabel jLabelEditStaff;
    private javax.swing.JLabel jLabelEmailRelative;
    private javax.swing.JLabel jLabelEthnicOriginChild;
    private javax.swing.JLabel jLabelFirstNameChild;
    private javax.swing.JLabel jLabelFirstNameRelative;
    private javax.swing.JLabel jLabelFirstNameStaff;
    private javax.swing.JLabel jLabelImmunisationsChild;
    private javax.swing.JLabel jLabelKnownAs;
    private javax.swing.JLabel jLabelLanguagesChild;
    private javax.swing.JLabel jLabelMaxNumberChildrenRooms;
    private javax.swing.JLabel jLabelMedicalChild;
    private javax.swing.JLabel jLabelMedicalConditionsStaff;
    private javax.swing.JLabel jLabelMobileNumRelative;
    private javax.swing.JLabel jLabelMobileNumStaff;
    private javax.swing.JLabel jLabelNotesBookings;
    private javax.swing.JLabel jLabelNotesChild;
    private javax.swing.JLabel jLabelNotesRegistersBluebell;
    private javax.swing.JLabel jLabelNotesRegistersBreakfast;
    private javax.swing.JLabel jLabelNotesRegistersButtercup;
    private javax.swing.JLabel jLabelNotesRegistersFoxglove;
    private javax.swing.JLabel jLabelNotesRegistersOSCam;
    private javax.swing.JLabel jLabelNotesRegistersOSCpm;
    private javax.swing.JLabel jLabelNotesRegistersSnowdrop;
    private javax.swing.JLabel jLabelNotesTodayBluebell;
    private javax.swing.JLabel jLabelNotesTodayBreakfast;
    private javax.swing.JLabel jLabelNotesTodayButtercup;
    private javax.swing.JLabel jLabelNotesTodayFoxglove;
    private javax.swing.JLabel jLabelNotesTodayOSCam;
    private javax.swing.JLabel jLabelNotesTodayOSCpm;
    private javax.swing.JLabel jLabelNotesTodaySnowdrop;
    private javax.swing.JLabel jLabelPasswordRelative;
    private javax.swing.JLabel jLabelPasswordStaff;
    private javax.swing.JLabel jLabelPosChild;
    private javax.swing.JLabel jLabelPostCodeRelative;
    private javax.swing.JLabel jLabelPostCodeStaff;
    private javax.swing.JLabel jLabelRatioRooms;
    private javax.swing.JLabel jLabelRegistersBluebell;
    private javax.swing.JLabel jLabelRegistersBreakfast;
    private javax.swing.JLabel jLabelRegistersButtercup;
    private javax.swing.JLabel jLabelRegistersFoxglove;
    private javax.swing.JLabel jLabelRegistersOSCamNum;
    private javax.swing.JLabel jLabelRegistersOSCpmNum;
    private javax.swing.JLabel jLabelRegistersSnowdrop;
    private javax.swing.JLabel jLabelRelativeHeading;
    private javax.swing.JLabel jLabelRelativesChildren;
    private javax.swing.JLabel jLabelReligionChild;
    private javax.swing.JLabel jLabelRoomBookings;
    private javax.swing.JLabel jLabelRoomHeading;
    private javax.swing.JLabel jLabelRoomNameRooms;
    private javax.swing.JLabel jLabelRoomStaff;
    private javax.swing.JLabel jLabelSearchBookings;
    private javax.swing.JLabel jLabelSearchChild;
    private javax.swing.JLabel jLabelSearchRelatives;
    private javax.swing.JLabel jLabelSearchRoom;
    private javax.swing.JLabel jLabelSearchStaff;
    private javax.swing.JLabel jLabelSessionBookings;
    private javax.swing.JLabel jLabelSessionRegistersBluebell;
    private javax.swing.JLabel jLabelSessionRegistersBreakfast;
    private javax.swing.JLabel jLabelSessionRegistersButtercup;
    private javax.swing.JLabel jLabelSessionRegistersFoxglove;
    private javax.swing.JLabel jLabelSessionRegistersOSCam;
    private javax.swing.JLabel jLabelSessionRegistersOSCpm;
    private javax.swing.JLabel jLabelSessionRegistersSnowdrop;
    private javax.swing.JLabel jLabelSessionTodayBluebell;
    private javax.swing.JLabel jLabelSessionTodayBreakfast;
    private javax.swing.JLabel jLabelSessionTodayButtercup;
    private javax.swing.JLabel jLabelSessionTodayFoxglove;
    private javax.swing.JLabel jLabelSessionTodayOSCam;
    private javax.swing.JLabel jLabelSessionTodayOSCpm;
    private javax.swing.JLabel jLabelSessionTodaySnowdrop;
    private javax.swing.JLabel jLabelSexChild;
    private javax.swing.JLabel jLabelStaffHeading;
    private javax.swing.JLabel jLabelStaffRoomList;
    private javax.swing.JLabel jLabelSurnameChild;
    private javax.swing.JLabel jLabelSurnameRelative;
    private javax.swing.JLabel jLabelSurnameStaff;
    private javax.swing.JLabel jLabelTodayBluebell;
    private javax.swing.JLabel jLabelTodayBreakfast;
    private javax.swing.JLabel jLabelTodayButtercup;
    private javax.swing.JLabel jLabelTodayFoxglove;
    private javax.swing.JLabel jLabelTodayOSCamNum;
    private javax.swing.JLabel jLabelTodayOSCpmNum;
    private javax.swing.JLabel jLabelTodaySnowdrop;
    private javax.swing.JLabel jLabelUsernameStaff;
    private javax.swing.JLabel jLabelViewBookingsChild;
    private javax.swing.JList jListBookings;
    private javax.swing.JList jListChildRoom;
    private javax.swing.JList jListChildren;
    private javax.swing.JList jListChildrenRelative;
    private javax.swing.JList jListRegistersBluebell;
    private javax.swing.JList jListRegistersBreakfast;
    private javax.swing.JList jListRegistersButtercup;
    private javax.swing.JList jListRegistersFoxglove;
    private javax.swing.JList jListRegistersOSCam;
    private javax.swing.JList jListRegistersOSCpm;
    private javax.swing.JList jListRegistersSnowdrop;
    private javax.swing.JList jListRelatives;
    private javax.swing.JList jListRelativesChildren;
    private javax.swing.JList jListRooms;
    private javax.swing.JList jListStaff;
    private javax.swing.JList jListStaffRoom;
    private javax.swing.JList jListTodayBluebell;
    private javax.swing.JList jListTodayBreakfast;
    private javax.swing.JList jListTodayButtercup;
    private javax.swing.JList jListTodayFoxglove;
    private javax.swing.JList jListTodayOSCam;
    private javax.swing.JList jListTodayOSCpm;
    private javax.swing.JList jListTodaySnowdrop;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelBookings;
    private javax.swing.JPanel jPanelChildren;
    private javax.swing.JPanel jPanelRegisters;
    private javax.swing.JPanel jPanelRelatives;
    private javax.swing.JPanel jPanelRooms;
    private javax.swing.JPanel jPanelStaff;
    private javax.swing.JPanel jPanelToday;
    private javax.swing.JPanel jPanelTodayBluebell;
    private javax.swing.JPanel jPanelTodayBreakfast;
    private javax.swing.JPanel jPanelTodayButtercup;
    private javax.swing.JPanel jPanelTodayFoxglove;
    private javax.swing.JPanel jPanelTodayOSCam;
    private javax.swing.JPanel jPanelTodayOSCpm;
    private javax.swing.JPanel jPanelTodaySnowdrop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneNotesChild;
    private javax.swing.JScrollPane jScrollPaneNotesChild1;
    private javax.swing.JTabbedPane jTabbedPaneHomePage;
    private javax.swing.JTabbedPane jTabbedPaneRegisters;
    private javax.swing.JTabbedPane jTabbedPaneToday;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextArea jTextAreaNotesBookings;
    private javax.swing.JTextArea jTextAreaNotesRegistersBluebell;
    private javax.swing.JTextArea jTextAreaNotesRegistersBreakfast;
    private javax.swing.JTextArea jTextAreaNotesRegistersButtercup;
    private javax.swing.JTextArea jTextAreaNotesRegistersFoxglove;
    private javax.swing.JTextArea jTextAreaNotesRegistersOSCam;
    private javax.swing.JTextArea jTextAreaNotesRegistersOSCpm;
    private javax.swing.JTextArea jTextAreaNotesRegistersSnowdrop;
    private javax.swing.JTextArea jTextAreaNotesTodayBluebell;
    private javax.swing.JTextArea jTextAreaNotesTodayBreakfast;
    private javax.swing.JTextArea jTextAreaNotesTodayButtercup;
    private javax.swing.JTextArea jTextAreaNotesTodayFoxglove;
    private javax.swing.JTextArea jTextAreaNotesTodayOSCam;
    private javax.swing.JTextArea jTextAreaNotesTodayOSCpm;
    private javax.swing.JTextArea jTextAreaNotesTodaySnowdrop;
    private javax.swing.JTextField jTextFieldAddress1Relative;
    private javax.swing.JTextField jTextFieldAddress1Staff;
    private javax.swing.JTextField jTextFieldAddress2Relative;
    private javax.swing.JTextField jTextFieldAddress2Staff;
    private javax.swing.JTextField jTextFieldAgeMaxRooms;
    private javax.swing.JTextField jTextFieldAgeMinRooms;
    private javax.swing.JTextField jTextFieldChildBookings;
    private javax.swing.JTextField jTextFieldChildRegistersBluebell;
    private javax.swing.JTextField jTextFieldChildRegistersBreakfast;
    private javax.swing.JTextField jTextFieldChildRegistersButtercup;
    private javax.swing.JTextField jTextFieldChildRegistersFoxglove;
    private javax.swing.JTextField jTextFieldChildRegistersOSCam;
    private javax.swing.JTextField jTextFieldChildRegistersOSCpm;
    private javax.swing.JTextField jTextFieldChildRegistersSnowdrop;
    private javax.swing.JTextField jTextFieldChildTodayBluebell;
    private javax.swing.JTextField jTextFieldChildTodayBreakfast;
    private javax.swing.JTextField jTextFieldChildTodayButtercup;
    private javax.swing.JTextField jTextFieldChildTodayFoxglove;
    private javax.swing.JTextField jTextFieldChildTodayOSCam;
    private javax.swing.JTextField jTextFieldChildTodayOSCpm;
    private javax.swing.JTextField jTextFieldChildTodaySnowdrop;
    private javax.swing.JTextField jTextFieldContactNumRelative;
    private javax.swing.JTextField jTextFieldContactNumStaff;
    private javax.swing.JTextField jTextFieldDOBChild;
    private javax.swing.JTextField jTextFieldDOBRegistersBluebell;
    private javax.swing.JTextField jTextFieldDOBRegistersBreakfast;
    private javax.swing.JTextField jTextFieldDOBRegistersButtercup;
    private javax.swing.JTextField jTextFieldDOBRegistersFoxglove;
    private javax.swing.JTextField jTextFieldDOBRegistersOSCAm;
    private javax.swing.JTextField jTextFieldDOBRegistersOSCPm;
    private javax.swing.JTextField jTextFieldDOBRegistersSnowdrop;
    private javax.swing.JTextField jTextFieldDOBStaff;
    private javax.swing.JTextField jTextFieldDOBTodayBluebell;
    private javax.swing.JTextField jTextFieldDOBTodayBreakfast;
    private javax.swing.JTextField jTextFieldDOBTodayButtercup;
    private javax.swing.JTextField jTextFieldDOBTodayFoxglove;
    private javax.swing.JTextField jTextFieldDOBTodayOSCam;
    private javax.swing.JTextField jTextFieldDOBTodayOSCpm;
    private javax.swing.JTextField jTextFieldDOBTodaySnowdrop;
    private javax.swing.JTextField jTextFieldDateBluebell;
    private javax.swing.JTextField jTextFieldDateBookings;
    private javax.swing.JTextField jTextFieldDateBreakfast;
    private javax.swing.JTextField jTextFieldDateButtercup;
    private javax.swing.JTextField jTextFieldDateFoxglove;
    private javax.swing.JTextField jTextFieldDateOSCAm;
    private javax.swing.JTextField jTextFieldDateOSCPm;
    private javax.swing.JTextField jTextFieldDateSnowdrop;
    private javax.swing.JTextField jTextFieldDietaryNeedsChild;
    private javax.swing.JTextField jTextFieldDietaryNeedsStaff;
    private javax.swing.JTextField jTextFieldEmailRelative;
    private javax.swing.JTextField jTextFieldEthnicOriginChild;
    private javax.swing.JTextField jTextFieldFirstNameChild;
    private javax.swing.JTextField jTextFieldFirstNameRelative;
    private javax.swing.JTextField jTextFieldFirstNameStaff;
    private javax.swing.JTextField jTextFieldImmunisationsChild;
    private javax.swing.JTextField jTextFieldKnownAsChild;
    private javax.swing.JTextField jTextFieldLanguagesChild;
    private javax.swing.JTextField jTextFieldMaxNumberChildrenRooms;
    private javax.swing.JTextField jTextFieldMedicalChild;
    private javax.swing.JTextField jTextFieldMedicalConditionsStaff;
    private javax.swing.JTextField jTextFieldMobileNumRelative;
    private javax.swing.JTextField jTextFieldMobileNumStaff;
    private javax.swing.JTextField jTextFieldPasswordRelative;
    private javax.swing.JTextField jTextFieldPasswordStaff;
    private javax.swing.JTextField jTextFieldPositionChild;
    private javax.swing.JTextField jTextFieldPostCodeRelative;
    private javax.swing.JTextField jTextFieldPostCodeStaff;
    private javax.swing.JTextField jTextFieldRatioRooms;
    private javax.swing.JTextField jTextFieldRegistersBluebell;
    private javax.swing.JTextField jTextFieldRegistersBreakfast;
    private javax.swing.JTextField jTextFieldRegistersButtercup;
    private javax.swing.JTextField jTextFieldRegistersFoxglove;
    private javax.swing.JTextField jTextFieldRegistersOSCam;
    private javax.swing.JTextField jTextFieldRegistersOSCpm;
    private javax.swing.JTextField jTextFieldRegistersSnowdrop;
    private javax.swing.JTextField jTextFieldReligionChild;
    private javax.swing.JTextField jTextFieldRoomBookings;
    private javax.swing.JTextField jTextFieldRoomNameRooms;
    private javax.swing.JTextField jTextFieldSearchBookings;
    private javax.swing.JTextField jTextFieldSearchChild;
    private javax.swing.JTextField jTextFieldSearchRelatives;
    private javax.swing.JTextField jTextFieldSearchRooms;
    private javax.swing.JTextField jTextFieldSearchStaff;
    private javax.swing.JTextField jTextFieldSessionBookings;
    private javax.swing.JTextField jTextFieldSessionRegistersBluebell;
    private javax.swing.JTextField jTextFieldSessionRegistersBreakfast;
    private javax.swing.JTextField jTextFieldSessionRegistersButtercup;
    private javax.swing.JTextField jTextFieldSessionRegistersFoxglove;
    private javax.swing.JTextField jTextFieldSessionRegistersOSCam;
    private javax.swing.JTextField jTextFieldSessionRegistersOSCpm;
    private javax.swing.JTextField jTextFieldSessionRegistersSnowdrop;
    private javax.swing.JTextField jTextFieldSessionTodayBluebell;
    private javax.swing.JTextField jTextFieldSessionTodayBreakfast;
    private javax.swing.JTextField jTextFieldSessionTodayButtercup;
    private javax.swing.JTextField jTextFieldSessionTodayFoxglove;
    private javax.swing.JTextField jTextFieldSessionTodayOSCam;
    private javax.swing.JTextField jTextFieldSessionTodayOSCpm;
    private javax.swing.JTextField jTextFieldSessionTodaySnowdrop;
    private javax.swing.JTextField jTextFieldSexChild;
    private javax.swing.JTextField jTextFieldSurnameChild;
    private javax.swing.JTextField jTextFieldSurnameRelative;
    private javax.swing.JTextField jTextFieldSurnameStaff;
    private javax.swing.JTextField jTextFieldTodayBluebell;
    private javax.swing.JTextField jTextFieldTodayBreakfast;
    private javax.swing.JTextField jTextFieldTodayButtercup;
    private javax.swing.JTextField jTextFieldTodayFoxglove;
    private javax.swing.JTextField jTextFieldTodayOSCAm;
    private javax.swing.JTextField jTextFieldTodayOSCPm;
    private javax.swing.JTextField jTextFieldTodaySnowdrop;
    private javax.swing.JTextField jTextFieldUsernameStaff;
    // End of variables declaration//GEN-END:variables
}
