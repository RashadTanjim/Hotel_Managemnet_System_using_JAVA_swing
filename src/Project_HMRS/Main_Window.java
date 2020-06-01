//main window
package Project_HMRS;
/**
 * Project_CSE215Lab
 * Date: 10.03.20 
 * @Name: Md Rashad Tanjim ID: 1620952042
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.*;

public class Main_Window implements ActionListener {

    // declare all the components
    JFrame frame;
    JTextField deleteL;
    JTextField searchL;

    JButton delete;
    JButton exit;
    JButton clear;
    JButton view;
    JButton search;
    JButton Checkin;
    JButton CheckOut;
    JButton Information;
    JButton calculator;
    

    public Main_Window() {
        // initialize the components
        frame = new JFrame();

        deleteL = new JTextField();
        searchL = new JTextField();
        delete = new JButton("Delete");
        delete.addActionListener(this);
        view = new JButton("View Info");
        view.addActionListener(this);
        search = new JButton("Search");
        search.addActionListener(this);
        exit = new JButton("Exit");
        exit.addActionListener(this);
        clear = new JButton("Clear Text");
        clear.addActionListener(this);
        Checkin = new JButton("Check In");
        Checkin.addActionListener(this);
        CheckOut = new JButton("Check Out (Update)");
        CheckOut.addActionListener(this);
        Information = new JButton("Information");
        Information.addActionListener(this);
        calculator = new JButton("Payment Calculator");
        calculator.addActionListener(this);

        // initialize layout
        GridLayout g = new GridLayout(6, 2);
        frame.setLayout(g);
        frame.setBackground(Color.yellow);

        frame.add(Checkin);
        frame.add(CheckOut);
        frame.add(Information);
        //frame.add(submit);

        frame.add(view);
        frame.add(searchL);
        frame.add(search);
        frame.add(deleteL);
        frame.add(delete);
        frame.add(clear);
        frame.add(calculator);
        frame.add(exit);

        // now display the frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        frame.setTitle("Hotel Management System (HMRS)");

    }

    public void actionPerformed(ActionEvent e) {
        // button actions goes in here
        if (e.getSource() == Checkin) {
            AddGuest add = new AddGuest();
            add.frame.setVisible(true);

        }
        if (e.getSource() == calculator) {
            Payment_Window cal = new Payment_Window();
            cal.setVisible(true);

        }
        if (e.getSource() == Information) {

            frame.setVisible(false);
            Info add2 = new Info();
            add2.setVisible(true);

        }

        if (e.getSource() == view) {
            View_Window log = new View_Window();

            log.frame.setVisible(true);

        }

        if (e.getSource() == search) {

            Update mga = new Update();
            Guest[] obj = mga.GuestInitialization();
            Guest mb = new Guest();
            String key = searchL.getText();
            boolean found = false;
            try {
                for (int i = 0; i < obj.length; i++) {
                    if (key.equals(obj[i].getRoom_no())) {
                        //JOptionPane.showMessageDialog(null, .getText() + " is Found \n");
                        JOptionPane.showMessageDialog(null, "Room No : " + searchL.getText() + ""
                                + "\nThe Room is Booked! Search for another room. ");
                        Guest ci = new Guest();

                        found = true;
                        break;
                    }
                }
            } catch (Exception s) {
            }

            if (found == false) {
                JOptionPane.showMessageDialog(null, key + " Room is Empty\n");
            }

        }
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (e.getSource() == clear) {
            deleteL.setText("");
            searchL.setText("");
        }
        if (e.getSource() == CheckOut) {
            frame.setVisible(false);
            CheckOut out = new CheckOut();
            out.setVisible(true);
        }
        if (e.getSource() == delete) {
            Update mga = new Update();
            Guest[] obj = mga.GuestInitialization();
            Guest mb = new Guest();
            String key = deleteL.getText();
            boolean found = false;

            try {
                for (int i = 0; i < obj.length; i++) {

                    if (key.equals(obj[i].getRoom_no())) {
                        JOptionPane.showMessageDialog(null, deleteL.getText() + " will be deleted \n");
                        obj[i].setRoom_no(null);
                        obj[i].setName(null);
                        obj[i].setStatus(null);
                        obj[i].setAddress(null);
                        obj[i].setContact(null);
                        obj[i].setPerson(null);
                        obj[i].setAge(null);
                        obj[i].setPayment(null);
                        obj[i].setReserve(null);

                        modifyFile(i);

                        JOptionPane.showMessageDialog(null, deleteL.getText() + " is deleted \n");
                        found = true;
                        break;
                    }
                }
            } catch (Exception s) {
            }

            if (found == false) {
                JOptionPane.showMessageDialog(null, key + " is INVALID"
                        + "\nCan not be Deleted");
            }

        }
    }

    public void modifyFile(int index) {
        String[] info = new String[1000];
        int count = 0;
        try {
            File f = new File("clientInfo.txt");
            Scanner input = new Scanner(f);

            for (int i = 0; input.hasNextLine(); i++) {
                info[i] = input.nextLine();
                count++;
            }

            int startIndex = index * 6;
            int endIndex = startIndex + 6;

            for (int i = startIndex; i < endIndex; i++) {
                info[i] = "--------";
            }

        } catch (Exception f) {
            System.out.println(f.toString());
        }

        try {
            FileWriter fw = new FileWriter("clientInfo.txt", false);
            for (int i = 0; i < count; i++) {
                fw.write(info[i]);
                fw.write("\r\n");
            }
            fw.close();
        } catch (Exception s) {
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) {
        Main_Window s = new Main_Window();
    }

}
