//info window

package Project_HMRS;
/**
 * Project_CSE215Lab
 * Date: 04.06.20 
 * @Name: Md Rashad Tanjim ID: 1620952042
 * @Name: Abdullah Bin Khurshid ID: 1813050642
 * @Name: Sumaya Siddique ID: 1912180642
 */
public class Guest {

    private String room_no;
    private String Reserve;
    private String name;
    private String Age;
    private String Address;
    private String Person;
    private String Contact;
    private String Payment;
    private String status;

    public Guest(String room_no, String Reserve, String name, String Age, String Address, String Person,
            String Contact, String Payment, String status) {
        this.room_no = room_no;
        this.Reserve = Reserve;
        this.name = name;
        this.Age = Age;
        this.Address = Address;
        this.Person = Person;
        this.Contact = Contact;
        this.Payment = Payment;
        this.status = status;

    }

    Guest() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.room_no = room_no;
        this.Reserve = Reserve;
        this.name = name;
        this.Age = Age;
        this.Address = Address;
        this.Person = Person;
        this.Contact = Contact;
        this.Payment = Payment;
        this.status = status;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerson() {
        return Person;
    }

    public void setPerson(String Person) {
        this.Person = Person;
    }

    public String getReserve() {
        return Reserve;
    }

    public void setReserve(String Reserve) {
        this.Reserve = Reserve;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String Payment) {
        this.Payment = Payment;

    }
}
