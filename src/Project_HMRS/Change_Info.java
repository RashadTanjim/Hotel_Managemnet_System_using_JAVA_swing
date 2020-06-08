//Info Change, Correction, Update Window
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
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.*;

public class Change_Info implements ActionListener {

    // declare all the components
    JFrame frame;
    JLabel message;
    JLabel info;
    JButton ok;
    JButton back;
    JTextField searchT;
    JButton search;
    JTextField infoT;

    public Change_Info() {
        // initialize the components

        frame = new JFrame();

        message = new JLabel("Type The Previous Info:");
        info = new JLabel("Type The New Info");
        searchT = new JTextField();
        infoT = new JTextField();

        ok = new JButton("Exit");
        ok.addActionListener(this);
        back = new JButton("Main Menu");
        back.addActionListener(this);
        search = new JButton("Update Info");
        search.addActionListener(this);

        GridLayout g = new GridLayout(4, 0);
        frame.setLayout(g);

        // add the component into the frame
        frame.add(message);
        frame.add(searchT);
        frame.add(info);
        frame.add(infoT);
        frame.add(search);
        frame.add(ok);
        frame.add(back);

        // now display the frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setTitle("Info Change, Correction Window - HMRS");

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ok) {
            System.exit(0);
        }
        if (e.getSource() == search) {
            Update mga = new Update();
            Guest[] obj = mga.GuestInitialization();
            Guest mb = new Guest();
            String key = searchT.getText();
            String key2 = infoT.getText();
            boolean found = false;

            try {
                for (int i = 0; i < obj.length; i++) {

                    if (key.equals(obj[i].getRoom_no())) {

                        obj[i].setRoom_no(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getName())) {

                        obj[i].setName(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getAddress())) {

                        obj[i].setRoom_no(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getContact())) {

                        obj[i].setContact(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getPerson())) {

                        obj[i].setPerson(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getStatus())) {

                        obj[i].setStatus(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getAge())) {

                        obj[i].setAge(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getPayment())) {

                        obj[i].setPayment(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    } else if (key.equals(obj[i].getReserve())) {

                        obj[i].setReserve(key2);
                        modifyFile(i);
                        JOptionPane.showMessageDialog(null, searchT.getText() + " is Updated \n");
                        found = true;
                        break;
                    }
                }
            } catch (Exception s) {
            }

            if (found == false) {
                JOptionPane.showMessageDialog(null, key + " is Invalid!!!"
                        + "\nCan not be Updated");
            }
        }

        if (e.getSource() == back) {
            frame.setVisible(false);
            Main_Window log1 = new Main_Window();
            log1.frame.setVisible(true);

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

    //public static void main(String[] args) {
       // Change_Info abcd = new Change_Info();
    //}

}
