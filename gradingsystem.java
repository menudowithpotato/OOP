

/*******************************************************/
/* Developed By : Joshua R Galon */
/* Mobile : 09362594875 */
/* Date : Dec 1, 2023 */
/* Address : Barra Opol Mis Or*/
/* E-mail : joshuagalon28@gmail.com*/
/*******************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Frame1 extends JFrame implements ActionListener {
    String imagePathString = "Images/logo.png";
    // initializa the lbl with caption name is employee information.
    JLabel lbl = new JLabel("Basic Grading System");
    Font f = new Font("Times", Font.BOLD, 30);
    Font f1 = new Font("Times", Font.BOLD, 16);
    Font f2 = new Font("Times", Font.BOLD, 12);

    JLabel label = new JLabel("University of Science and Technology of Southern Philippines ");
    Font a = new Font("Times", Font.BOLD, 15);
    JLabel label1 = new JLabel("Claro M Recto Avenue, Lapasan, Cagayan De Oro City");
    Font a1 = new Font("Times", Font.PLAIN, 12);
    JLabel label2 = new JLabel("Republic of the Philippines");
    Font a2 = new Font("Times", Font.PLAIN, 12);
    

    JLabel lblstdid, lblstdname, lblcourse, lblsubject, lblprelim, lblmidterm, lblprefinal, lblfinal, lblsubmit;
    
    JTextField txtstdid, txtstdname, txtcourse, txtsubject, txtprelim, txtmidterm, txtprefinal, txtfinal;
    JButton btnadd, btnsave, btnupdate, btndelete, btnexit;
    
    JButton btncompute;
    String gen;
    ResultSet rs = null;
    Connection con = null;
    Statement stmt = null;

    int Average, Prelim_Grade, Midterm_Grade, PreFinal_Grade, Final_Grade;
    JLabel imageLabel;

    Frame1() {

        super("Employees Information ");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);

            }
        });

        // set layout to null
        setLayout(null);
        lblsubmit = new JLabel("Developed By : Joshua R. Galon");
        add(lblsubmit);
        lblsubmit.setHorizontalAlignment(JLabel.CENTER);
        lblsubmit.setBounds(175, 525, 450, 20);
        lblsubmit.setFont(f1);

        // add lbl label on form.
        add(label);
        add(lbl);
        add(label1);
        add(label2);

        // set the particular position on a screen
        lbl.setBounds(200, 60, 500, 100);
        lbl.setHorizontalAlignment(JLabel.CENTER);

        // set the font of lbl label
        lbl.setFont(f);

        label.setBounds(200, -5, 500, 100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(a);
        label1.setBounds(200, 15, 500, 100);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(a1);
        label2.setBounds(200, -25, 500, 100);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(a2);
        // initializa all the label which are declared in the example above with its
        // caption name
        //add your desire image if necessar
        imageLabel = new JLabel();

        ImageIcon imageIcon = new ImageIcon(imagePathString);
        imageLabel.setIcon(imageIcon);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH); // Change dimensions as needed
        imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);
        
        imageLabel.setBounds(150, -60, 200, 200);
        add(imageLabel);
        lblstdid = new JLabel("ID");
        lblstdname = new JLabel("Name");
        lblcourse = new JLabel("Course");
        lblsubject = new JLabel("Subject");
        lblprelim = new JLabel("Prelim Grade");
        lblmidterm = new JLabel("Midterm Grade");
        lblprefinal = new JLabel("PreFinal Grade");
        lblfinal = new JLabel("Final Grade");

        lblstdid.setBounds(300, 150, 100, 20);
        lblstdname.setBounds(300, 190, 100, 20);
        lblcourse.setBounds(300, 220, 100, 20);
        lblsubject.setBounds(300, 250, 100, 20);
        lblprelim.setBounds(300, 280, 100, 20);
        lblmidterm.setBounds(300, 310, 100, 20);
        lblprefinal.setBounds(300, 340, 100, 20);
        lblfinal.setBounds(300, 370, 100, 20);

        // add all the label on the frame
        add(lblstdid);
        add(lblstdname);
        add(lblcourse);
        add(lblsubject);
        add(lblprelim);
        add(lblmidterm);
        add(lblprefinal);
        add(lblfinal);

        // set font
        lblstdid.setFont(f2);
        lblstdname.setFont(f2);
        lblcourse.setFont(f2);
        lblsubject.setFont(f2);
        lblprelim.setFont(f2);
        lblmidterm.setFont(f2);
        lblprefinal.setFont(f2);
        lblfinal.setFont(f2);

        // initialize the textfield with size
        txtstdid = new JTextField(15);
        txtstdname = new JTextField(15);
        txtcourse = new JTextField(15);
        txtsubject = new JTextField(15);
        txtprelim = new JTextField(15);
        txtmidterm = new JTextField(15);
        txtprefinal = new JTextField(15);
        txtfinal = new JTextField(15);

        // set a particular position on a screen with setbounds constructor
        txtstdid.setBounds(400, 140, 150, 20);
        txtstdname.setBounds(400, 180, 150, 20);
        txtcourse.setBounds(400, 220, 150, 20);
        txtsubject.setBounds(400, 250, 150, 20);
        txtprelim.setBounds(400, 280, 150, 20);
        txtmidterm.setBounds(400, 310, 150, 20);
        txtprefinal.setBounds(400, 340, 150, 20);
        txtfinal.setBounds(400, 370, 150, 20);

        // add textfield on a Frame
        add(txtstdid);
        add(txtstdname);
        add(txtcourse);
        add(txtsubject);
        add(txtprelim);
        add(txtmidterm);
        add(txtprefinal);
        add(txtfinal);

        // initializa button with its caption
        btnadd = new JButton("Add");
        btnsave = new JButton("Save");
        btnupdate = new JButton("Update");
        btndelete = new JButton("Delete");

        // To add tooltip in the buttons
        btnadd.setToolTipText("Click this button to Add record in the Database.");
        btnsave.setToolTipText("Click this button to Save record in the Database.");
        btnupdate.setToolTipText("Click this button to Update record in the Database.");
        btndelete.setToolTipText("Click this button to Delete record in the Database.");

        // set a particular position on a Frame
        btnadd.setBounds(200, 400, 100, 30);
        btnsave.setBounds(310, 400, 100, 30);
        btnupdate.setBounds(420, 400, 100, 30);
        btndelete.setBounds(530, 400, 100, 30);

        // add button on a frame
        add(btnadd);
        add(btnsave);
        add(btndelete);
        add(btnupdate);

        // register all the button
        btnadd.addActionListener(this);
        btnsave.addActionListener(this);
        btnupdate.addActionListener(this);
        btndelete.addActionListener(this);

       
        btnexit = new JButton("Exit");
        btnexit.setToolTipText("Click this button to Quit Program.");
        btnexit.setBounds(360, 480, 100, 30);
        add(btnexit);
        btnexit.addActionListener(this);
        btncompute = new JButton("Compute");
        btncompute.setBounds(360, 440, 100, 30);
        add(btncompute);
        btncompute.addActionListener(this);

        // open database connection
        // here we call a dbopen() method
        
    }

   

 
     public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getActionCommand().equals("Add")) {
                // Clear text fields
                txtstdid.setText("");
                txtstdname.setText("");
                txtcourse.setText("");
                txtsubject.setText("");
                txtprelim.setText("");
                txtmidterm.setText("");
                txtprefinal.setText("");
                txtfinal.setText("");
            } else if (ae.getActionCommand().equals("Compute")) {
                // Retrieve grades from text fields
                Prelim_Grade = Integer.parseInt(txtprelim.getText());
                Midterm_Grade = Integer.parseInt(txtmidterm.getText());
                PreFinal_Grade = Integer.parseInt(txtprefinal.getText());
                Final_Grade = Integer.parseInt(txtfinal.getText());

                Average = (Prelim_Grade + Midterm_Grade + PreFinal_Grade + Final_Grade) / 4;

                
                JOptionPane.showMessageDialog(this, "Computed Average Grade: " + Average);
            } else if (ae.getActionCommand().equals("Exit")) {
                System.exit(0);
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid grades in numeric format.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class gradingsystem {
    public static void main(String args[]) throws Exception {
        Frame1 f1 = new Frame1();
        f1.setSize(900, 600);
        f1.setVisible(true);
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
}
