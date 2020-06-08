//add info window
package Project_HMRS;
/**
 * Project_CSE215Lab
 * Date: 04.06.20 
 * @Name: Md Rashad Tanjim ID: 1620952042
 * @Name: Abdullah Bin Khurshid ID: 1813050642
 * @Name: Sumaya Siddique ID: 1912180642
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.*;

public class AddGuest implements ActionListener {

    // declare all the components
    JFrame frame;
    JLabel room_noL;
    JLabel nameL;
    JLabel AddressL;
    JLabel ReserveL;

    JLabel AgeL;
    JLabel PersonL;
    JLabel statusL;
    JTextField room_no;
    JTextField name;
    JTextField Address;
    JTextField Age;
    JTextField Person;
    JTextField Reserve;
    JLabel ContactL;
    JTextField Contact;
    JLabel PaymentL;
    JTextField Payment;

    JComboBox status;
    JButton submit;
    JButton cancel;
    JButton main_menu;
    JButton exit;

    public AddGuest() {
        // initialize the components
        frame = new JFrame();

        room_noL = new JLabel("Room Number");
        AddressL = new JLabel("Address");
        AgeL = new JLabel("Age");
        nameL = new JLabel("Name");
        statusL = new JLabel("Room Status");
        PersonL = new JLabel("Person");
        ContactL = new JLabel("Contact No");
        ReserveL = new JLabel("Reservation Day(s)");
        PaymentL = new JLabel("Payment");

        room_no = new JTextField();
        name = new JTextField();
        Age = new JTextField();
        Address = new JTextField();
        Person = new JTextField();
        Reserve = new JTextField();
        Contact = new JTextField();
        Payment = new JTextField();
        String[] choices = {"Dulex", "Good", "Normal"};
        status = new JComboBox(choices);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        cancel = new JButton("Clear");
        cancel.addActionListener(this);
        main_menu = new JButton("Back to Main Memu");
        main_menu.addActionListener(this);
        exit = new JButton("Exit");
        exit.addActionListener(this);

        // initialize layout
        GridLayout g = new GridLayout(12, 2);
        frame.setLayout(g);

        // add the component into the frame
        frame.add(room_noL);
        frame.add(room_no);

        frame.add(ReserveL);
        frame.add(Reserve);

        frame.add(nameL);
        frame.add(name);

        frame.add(AgeL);
        frame.add(Age);

        frame.add(AddressL);
        frame.add(Address);

        frame.add(PersonL);
        frame.add(Person);

        frame.add(ContactL);
        frame.add(Contact);

        frame.add(PaymentL);
        frame.add(Payment);

        frame.add(statusL);
        frame.add(status);

        frame.add(submit);
        frame.add(cancel);
        frame.add(main_menu);
        frame.add(exit);

        // now display the frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setTitle("Hotel Management System");

    }

    public void actionPerformed(ActionEvent e) {
        // button actions goes in here

        if (e.getSource() == submit) { // submit button is clicked
            try {
                FileWriter fw = new FileWriter("clientInfo.txt", true);

                fw.write(room_no.getText());
                fw.write("\r\n");
                fw.write(Reserve.getText());
                fw.write("\r\n");
                fw.write(name.getText());
                fw.write("\r\n");
                fw.write(Age.getText());
                fw.write("\r\n");
                fw.write(Address.getText());
                fw.write("\r\n");
                fw.write(Person.getText());
                fw.write("\r\n");
                fw.write(Contact.getText());
                fw.write("\r\n");
                fw.write(Payment.getText());
                fw.write("\r\n");
                fw.write((String) status.getSelectedItem());
                fw.write("\r\n");
                fw.write("=====================");
                fw.write("\r\n");
                JOptionPane.showMessageDialog(null, room_no.getText() + "\nSuccesfully created");

                fw.close();

            } catch (Exception a) {

            }

            try {
                FileWriter fw1 = new FileWriter("userInfo.txt", true); //Hotel Room user info(only room no. & name)
                fw1.write(room_no.getText());
                fw1.write("\r\n");
                fw1.write(name.getText());
                fw1.write("\r\n");
                fw1.close();
            } catch (Exception a) {

            }
        }

        if (e.getSource() == cancel) {
            room_no.setText("");
            name.setText("");
            Age.setText("");
            Address.setText("");
            Person.setText("");
            Contact.setText("");
            Reserve.setText("");
            Payment.setText("");
            status.setSelectedIndex(0);

        }
        if (e.getSource() == exit) {

            frame.setVisible(false);
            System.exit(0);
        }
        if (e.getSource() == main_menu) {
            Main_Window log1 = new Main_Window();

            log1.frame.setVisible(false);

            frame.setVisible(false);

        }

    }
}
