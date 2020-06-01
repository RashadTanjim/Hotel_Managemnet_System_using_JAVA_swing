//view window
package Project_HMRS;
/**
 * Project_CSE215Lab
 * Date: 10.03.20 
 * @Name: Md Rashad Tanjim ID: 1620952042
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

public class View_Window implements ActionListener {

    // declare all the components
    JFrame frame;
    JLabel messageL;
    JButton ok;
    JButton back;
    JTextField message;

    public View_Window() {
        // initialize the components

        frame = new JFrame();

        messageL = new JLabel("View Window - HMRS");
        message = new JTextField();
        ok = new JButton("ok");
        back = new JButton("Main Menu");
        back.addActionListener(this);

        ok.addActionListener(this);

        GridLayout g = new GridLayout(2, 2);
        frame.setLayout(g);

        // add the component into the frame
        frame.add(messageL);
        frame.add(message);
        frame.add(ok);
        frame.add(back);

        // now display the frame
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setTitle("View Window");

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            Main_Window log1 = new Main_Window();

            log1.frame.setVisible(false);

            frame.setVisible(false);
        }
        if (e.getSource() == ok) {
            Update mga = new Update();
            Guest[] obj = mga.GuestInitialization();
            Guest mb = new Guest();
            String key = message.getText();
            boolean found = false;
            try {
                for (int i = 0; i < obj.length; i++) {
                    if (key.equals(obj[i].getRoom_no())) {
                        //JOptionPane.showMessageDialog(null, .getText() + " is Found \n");
                        JOptionPane.showMessageDialog(null, "Room No : " + message.getText() + ""
                                + "\nName  : " + obj[i].getName() + "\nAddress : " + obj[i].getAddress()
                                + "\nMobile : " + obj[i].getContact() + "\nRoom Status: " + obj[i].getStatus() + "\nPerson : " + obj[i].getPerson() + "\nPayment : " + obj[i].getPayment());
                        Guest ci = new Guest();

                        found = true;
                        break;
                    }
                }
            } catch (Exception s) {
            }

            if (found == false) {
                JOptionPane.showMessageDialog(null, key + " is INVALID\n");
            }
        }
    }

}
