import   javax.swing.*;
import   java.awt.*;
import   java.awt.event.*;
import   java.sql.*;
import   javax.swing.event.ListSelectionEvent;
import   javax.swing.event.ListSelectionListener;

public class finals extends JFrame implements
ItemListener,ActionListener, ListSelectionListener{
    String imagePathString = "logo.png";
    JLabel   imageLabel;
    JPanel panel= new JPanel ();
    JLabel label = new JLabel("University of Science and Technology of Southern Philippines ");
    Font a = new Font("Times", Font.BOLD, 20);
    JLabel label1 = new JLabel("Claro M Recto Avenue, Lapasan, Cagayan De Oro City");
    Font a1 = new Font("Times", Font.PLAIN, 12);
    JLabel label2 = new JLabel("Republic of the Philippines");
    Font a2 = new Font("Times", Font.PLAIN, 12);
    JLabel labelSIS = new JLabel("Basic Grading System");
    Font SIS = new Font("Arial", Font.BOLD, 18);
    JLabel label3 = new JLabel("Payment");
    Font a3 = new Font("Times", Font.PLAIN, 30);
    JLabel   labelstd = new JLabel("Student ID");
    JLabel   labelstdname= new JLabel("Student Name:");
    JLabel   labelstdcourse= new JLabel("Course");
    JLabel   labelstdsub = new JLabel("Subject:");
    JLabel   labelprelim= new JLabel("Prelim Grade: ");
    Font a4 = new Font("Times", Font.PLAIN, 12);
    JLabel   labelmid= new JLabel("Midterm Grade: ");
    Font a5 = new Font("Times", Font.PLAIN, 12);
    JLabel   labelprefin= new JLabel("Prefinal Grade: ");
    Font a6 = new Font("Times", Font.PLAIN, 12);
    JLabel   labelfin= new JLabel("Final grade:");
    JLabel   labelGender= new JLabel("Gender:");
    
    //float
    float prelim,midterm,prefinal,finalgrade;
    

    //JTextField

    JTextField   txtID=new JTextField ();
    JTextField   txtstdname= new JTextField ();
    JTextField   txtcourse= new JTextField (0);
    JTextField   txtsubject= new JTextField ();
    JTextField   txtprelim= new JTextField ();
    JTextField   txtmid= new JTextField ();
    JTextField   txtprefin= new JTextField ();
    JTextField   txtfinal= new JTextField ();
    JTextField   txtStatHolder = new JTextField();
    JTextField   txtRDiplomaHolder = new JTextField();
    JTextField   txtRForm137Holder = new JTextField();
    JTextField   txtRTorHolder = new JTextField();
    JTextField   txtRBirth = new JTextField();
    JTextField   txtGenderHolder = new JTextField();
    

    //RadioButton

    JRadioButton RBMale=new JRadioButton ("Male");
    JRadioButton RBFemale= new JRadioButton ("Female");
    JRadioButton RBHidden=new JRadioButton("Hidden");


    ButtonGroup bgroup= new ButtonGroup ();

    //checkbox

    JCheckBox   CBDiploma = new JCheckBox("Dipolama");
    JCheckBox   CBForm137 = new JCheckBox("Form 137");
    JCheckBox   CBTor= new JCheckBox ("Transcript of Record");
    JCheckBox   CBBirth= new JCheckBox ("Birth Certificate");

    // combobox

    String[] statchoice = {"Single", "Married", "Widow"};
    JComboBox<String> statbox = new JComboBox<>(statchoice);

    // Listbox
    


    //Button

    JButton    New= new JButton ("New");
    JButton    save= new JButton ("Save");
    JButton    update = new JButton ("Update");
    JButton    delete= new JButton ("Delete");
    JButton    search= new JButton ("Search");
    JButton    cancel=new JButton ("Cancel");
    JButton    exit=new JButton ("Exit");
    JButton    compute=new JButton("Compute");

    Connection cn;
    Statement st;
    PreparedStatement ps;

    
    public finals() {
    
    
    super ("Student Information System");
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    int yOffset = 100;
    panel.setLayout(null);
    
panel.setBackground(Color.WHITE);

//********************************************************JLabel

panel.add(label);
    label.setBounds(200, -5, 600, 100);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(a);
panel.add(label1);
    label1.setBounds(220, 15, 500, 100);
    label1.setHorizontalAlignment(JLabel.CENTER);
    label1.setFont(a1);
panel.add(label2);
    label2.setBounds(200, -25, 500, 100);
    label2.setHorizontalAlignment(JLabel.CENTER);
    label2.setFont(a2);
panel.add(labelSIS);
    labelSIS.setBounds(30, 70, 500, 100);
    labelSIS.setHorizontalAlignment(JLabel.LEFT);
    labelSIS.setFont(SIS);

imageLabel = new JLabel();

    

    add(imageLabel);
panel.add(imageLabel);
        ImageIcon imageIcon = new ImageIcon(imagePathString);
    imageLabel.setIcon(imageIcon);
    Image image = imageIcon.getImage();
    Image scaledImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(scaledImage);
    imageLabel.setIcon(imageIcon);
    
    imageLabel.setBounds(130, -60, 200, 200);

panel.add(labelstd );
    labelstd .setBounds (30,50+ yOffset,120,30);
// id.setForeground(Color.CYAN);

panel.add(labelstdname);
    labelstdname.setBounds (30,80+ yOffset,120,30);

panel.add (labelstdcourse)    ;
    labelstdcourse.setBounds (30,110+ yOffset,120,30);

panel.add (labelstdsub);
    labelstdsub.setBounds (30,140+ yOffset,120,30);

panel.add(labelfin);
    labelfin.setBounds (30,370+ yOffset,120,30);

panel.add(labelprelim);
    labelprelim.setBounds (30,280+ yOffset,120,30);
panel.add(labelmid);
    labelmid.setBounds (30,310+ yOffset,120,30);
panel.add(labelprefin);
    labelprefin.setBounds (30,340+ yOffset,120,30);
panel.add (labelGender);
    labelGender.setBounds (30,180+ yOffset,120,30);



panel.add (txtID);
    txtID.setBounds (120,50+ yOffset,120,30)    ;
    txtID.setHorizontalAlignment (JTextField.LEFT);

panel.add (txtstdname);
    txtstdname.setBounds (120,80+ yOffset,120,30);
    txtstdname.setHorizontalAlignment (JTextField.LEFT);

panel.add (txtcourse);
    txtcourse.setBounds (120,110+ yOffset,120,30);
    txtcourse.setHorizontalAlignment (JTextField.LEFT);
panel.add (txtsubject);
    txtsubject.setBounds (120,140+ yOffset,120,30);
    txtsubject.setHorizontalAlignment (JTextField.LEFT);

panel.add (txtprelim);
    txtprelim.setBounds (135,370+ yOffset,120,30);
    txtprelim.setHorizontalAlignment (JTextField.LEFT);
panel.add (txtmid);
    txtmid.setBounds (135,280+ yOffset,120,30);
    txtmid.setHorizontalAlignment (JTextField.LEFT);
panel.add (txtprefin);
    txtprefin.setBounds (135,310+ yOffset,120,30);
    txtprefin.setHorizontalAlignment (JTextField.LEFT);
panel.add (txtfinal);
    txtfinal.setBounds (135,340+ yOffset,120,30);
    txtfinal.setHorizontalAlignment (JTextField.LEFT);

//******************************************************RadioButton

panel.add (RBMale);
    RBMale.setBounds(120,180+ yOffset,70,30);
    RBMale.setBackground(Color.white);
txtGenderHolder.setText("male");

panel.add (RBFemale);
    RBFemale.setBounds (190,180+ yOffset,90,30);
    RBFemale.setBackground(Color.white);

    bgroup.add (RBMale);
    bgroup.add (RBFemale);
    bgroup.add (RBHidden);


    RBMale.addItemListener(this);
    RBFemale.addItemListener(this);
    RBMale.setEnabled(false);;
    RBFemale.setEnabled(false);;
    

    panel.add (New);
        New.setBounds (5,520+ yOffset,80,30);
    panel.add (save);
        save.setBounds (95,520+ yOffset,80,30);
    panel.add (update);
        update.setBounds (185,520+ yOffset,80,30);
       panel.add (delete);
           delete.setBounds (275,520+ yOffset,80,30);
       panel.add (search);
           search.setBounds (365,520+ yOffset,80,30);
       panel.add(cancel);
           cancel.setBounds (455,520+ yOffset,80,30);
       panel.add(exit);
           exit.setBounds (545,520+ yOffset,80,30);
        panel.add(compute);
           compute.setBounds (135,420+ yOffset,120,30);

                  txtID.setEnabled(false);
                  txtstdname.setEnabled(false);
                  txtcourse.setEnabled(false);
                  txtsubject.setEnabled(false);
                  txtprelim.setEnabled(false);
                  txtmid.setEnabled(false);
                  txtprefin.setEnabled(false);
                  txtfinal.setEnabled(false);
                  txtStatHolder.setEnabled(false);
                  txtRDiplomaHolder.setEnabled(false);
                  txtRForm137Holder.setEnabled(false);
                  txtRTorHolder.setEnabled(false);
                  txtRBirth.setEnabled(false);
                  txtGenderHolder.setEnabled(false);
                  CBBirth.setEnabled(false);
                  CBDiploma.setEnabled(false);
                  CBForm137.setEnabled(false);
                  CBTor.setEnabled(false);
 New.addActionListener (this);
 save.addActionListener (this);
 save.setEnabled(false);
 update.addActionListener (this);
 update.setEnabled(false);
 delete.addActionListener (this);
 delete.setEnabled(false);
 search.addActionListener (this);
search.setEnabled(true);
 cancel.addActionListener(this);
 exit.addActionListener(this);
 exit.setEnabled(true);
 compute.addActionListener(this);
 compute.setEnabled(true);



       setContentPane (panel);

try{
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              cn = DriverManager.getConnection("jdbc:odbc:Student");
          }catch(ClassNotFoundException e){
           System.err.println("Failed to Load Driver");
           e.printStackTrace();
       }catch (SQLException e){
           System.err.println("Unable to Connect");
           e.printStackTrace();
       }




}

public void clear(){

               txtID.setText("");
               txtstdname.setText("");
               txtcourse.setText("");
               txtsubject.setText("");
               txtprelim.setText("");
               txtmid.setText("");
               txtprefin.setText("");
               txtfinal.setText("");
               txtRDiplomaHolder.setText("");
               txtRForm137Holder.setText("");
               txtRTorHolder.setText("");
               txtRBirth.setText("");

               RBHidden.setEnabled(true);
               CBBirth.setSelected(false);
               CBDiploma.setSelected(false);
               CBForm137.setSelected(false);
               CBTor.setSelected(false);
               

}


public void actionPerformed (ActionEvent e){
        Object source = e.getSource();

        if (source == New) {
            RBMale.setEnabled(true);
            RBFemale.setEnabled(true);
            RBHidden.setEnabled(true);
    
            
            RBMale.setSelected(false);
            RBFemale.setSelected(false);
            RBHidden.setSelected(true);
    
            save.setEnabled(true);
            update.setEnabled(false);
            delete.setEnabled(false);
            search.setEnabled(false);
    
            txtID.setEnabled(true);
            txtstdname.setEnabled(true);
            txtcourse.setEnabled(true);
            txtsubject.setEnabled(true);
            txtprelim.setEnabled(true);
            
            txtmid.setEnabled(true);
            txtprefin.setEnabled(true);
            txtfinal.setEnabled(true);
            txtRDiplomaHolder.setEnabled(true);
            txtRForm137Holder.setEnabled(true);
            txtRTorHolder.setEnabled(true);
            txtRBirth.setEnabled(true);
            txtGenderHolder.setEnabled(true);
            CBBirth.setEnabled(true);
            CBDiploma.setEnabled(true);
            CBForm137.setEnabled(true);
            CBTor.setEnabled(true);
            CBBirth.setSelected(false);
            CBDiploma.setSelected(false);
            CBForm137.setSelected(false);
            CBTor.setSelected(false);
    
            txtID.setText("");
            txtstdname.setText("");
            txtcourse.setText("");
            txtsubject.setText("");
            txtprelim.setText("");
            txtmid.setText("");
            txtprefin.setText("");
            txtfinal.setText("");
            txtRDiplomaHolder.setText("");
            txtRForm137Holder.setText("");
            txtRTorHolder.setText("");
            txtRBirth.setText("");
            txtGenderHolder.setText("");
        }




if(source == save){
    String idf=txtID.getText();
    String ftname=txtstdname.getText();
        String mdname=txtcourse.getText();
        String ltname=txtsubject.getText();
        String gender=txtGenderHolder.getText();
        String status =txtStatHolder.getText();
        String agef = txtprelim.getText();
        String diploma =txtRDiplomaHolder.getText();
        String form137=txtRForm137Holder.getText();
        String TOR=txtRTorHolder.getText();
                    String birth=txtRBirth.getText();
                if (!status.equals("")&&!gender.equals("")&&!idf.equals("") &&
!ftname.equals("")&& !mdname.equals("") && !ltname.equals("") &&
!agef.equals("")){

                New.setEnabled (true);
                update.setEnabled (false);
                delete.setEnabled (false);
                search.setEnabled(true);
                //----------------------------Check--------------------
                int id=0;
                int idChecker=0;
                int age=0;
                int ageChecker=0;
                int checkerFirst=0;
                int checkerMid=0;
                int checkerLast=0;
                try{

                age=Integer.parseInt(txtprelim.getText());
                if(age==0) {
                    JOptionPane.showMessageDialog(
                        null,               // Parent component (or use a specific component)
                        "Change",           // Message to be displayed
                        "Age",              // Title of the dialog
                        JOptionPane.WARNING_MESSAGE  // Type of message (e.g., WARNING_MESSAGE)
                    );
                    ageChecker = 1; // This line of code will execute after the dialog is closed
                    
                }

                }catch(NumberFormatException nfe){
                     JOptionPane.showMessageDialog(null,"Age should be Numbers only","Warning",JOptionPane.WARNING_MESSAGE);
                     age=0;
                     ageChecker=1;
                }
                try{
                         id=Integer.parseInt(txtID.getText());

                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"ID should be Numbers only","Warning",JOptionPane.WARNING_MESSAGE);
                                 idChecker=1;

                }
                String checkFirstName=txtstdname.getText();
                String checkLastName=txtsubject.getText();
                String checkMidName=txtcourse.getText();
                if(checkFirstName.matches(".*\\d.*")){
                    JOptionPane.showMessageDialog(null,"Invalid input in First Name","Warning",JOptionPane.WARNING_MESSAGE);
                  checkerFirst=1;
                } else{
                  checkerFirst=0;
                }
                if(checkLastName.matches(".*\\d.*")){
                 JOptionPane.showMessageDialog(null,"Invalid input in Last Name","Warning",JOptionPane.WARNING_MESSAGE);
                  checkerLast=1;
                } else{
                  checkerLast=0;
                }

                if(checkMidName.matches(".*\\d.*")){
                 JOptionPane.showMessageDialog(null,"Invalid input in Mid Name","Warning",JOptionPane.WARNING_MESSAGE);
                  checkerMid=1;
                } else{
                  checkerMid=0;
                }




                if(txtcourse.getText().length()>1){
                JOptionPane.showMessageDialog(null,"Set Middle initial to one character only!","Warning",JOptionPane.WARNING_MESSAGE);
                checkerMid=1;

                  }

                  if(checkerFirst==1||checkerMid==1||checkerLast==1||idChecker==1||
ageChecker==1){

                  }

                  //----------------------------End of Check--------------------


                  else{
                      String idx = String.valueOf(id);

                  try{
                    if (!status.equals("")&&!gender.equals("")&&!idx.equals("")
&& !ftname.equals("")&& !mdname.equals("") && !ltname.equals("") && age!=0) {

                    st= cn.createStatement();
                    ps=cn.prepareStatement("INSERT INTO Login" +  "(ID,First,MI,Last,Age,Gender,Status,City,Diploma,Form137,TOR,Birth) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

                    ps.setString(1,txtID.getText());
                    ps.setString(2,txtstdname.getText());
                    ps.setString(3,txtcourse.getText());
                    ps.setString(4,txtsubject.getText());
                    ps.setString(5,txtprelim.getText());
                    ps.setString(6,txtGenderHolder.getText());
                    ps.setString(7,txtStatHolder.getText());
                    

                    if(diploma.equals("check")){

                        ps.setString(9,"check");
                    }
                    else{

                        ps.setString(9,"null");

                    }

                    if(form137.equals("check")){

                        ps.setString(10,"check");
                    }
                    else{

                        ps.setString(10,"null");
                    }

                    if(TOR.equals("check")){

                        ps.setString(11,"check");
                    }
                    else{

                        ps.setString(11,"null");
                    }

                    if(birth.equals("check")){

                        ps.setString(12,"check");
                    }
                    else{

                        ps.setString(12,"null");
                    }


                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"New account has been successfully added.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
                    txtID.setEnabled(false);
                    txtstdname.setEnabled(false);
                    txtcourse.setEnabled(false);
                    txtsubject.setEnabled(false);
                    txtprelim.setEnabled(false);
                    txtmid.setEnabled(false);
                    txtprefin.setEnabled(false);
                    txtfinal.setEnabled(false);
                    txtStatHolder.setEnabled(false);
                    txtRDiplomaHolder.setEnabled(false);
                    txtRForm137Holder.setEnabled(false);
                    txtRTorHolder.setEnabled(false);
                    txtRBirth.setEnabled(false);
                    txtGenderHolder.setEnabled(false);
                    CBBirth.setEnabled(false);
                    CBDiploma.setEnabled(false);
                    CBForm137.setEnabled(false);
                    CBTor.setEnabled(false);
                    st.close();
                    clear();
                    }
                        else{
                    JOptionPane.showMessageDialog(null,"Fill Up the Empty Fields!.","Student Information System",JOptionPane.ERROR_MESSAGE);

                }


                }catch(SQLException sqlEx){
                    sqlEx.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Unable to save! ID number already taken.","Student Information System",JOptionPane.ERROR_MESSAGE);}




            }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Fill Up the Empty Fields!.","Student Information System",JOptionPane.ERROR_MESSAGE);

                }
            }

            if (source==delete){
                New.setEnabled (true);
                save.setEnabled (true);
                delete.setEnabled (true);
                search.setEnabled (true);


            }




            if (source==search){
                delete.setEnabled(true);
                update.setEnabled(true);
                save.setEnabled(false);
                CBBirth.setSelected(false);
                CBForm137.setSelected(false);
                CBDiploma.setSelected(false);
                CBTor.setSelected(false);

                txtID.setEnabled(true);
                    txtstdname.setEnabled(true);
                    txtcourse.setEnabled(true);
                    txtsubject.setEnabled(true);
                    txtprelim.setEnabled(true);
                    
                    txtmid.setEnabled(true);
                    txtprefin.setEnabled(true);
                    txtfinal.setEnabled(true);
        
                    txtRDiplomaHolder.setEnabled(true);
                    txtRForm137Holder.setEnabled(true);
                    txtRTorHolder.setEnabled(true);
                     txtRBirth.setEnabled(true);
                     txtGenderHolder.setEnabled(true);
                     CBBirth.setEnabled(true);
                     CBDiploma.setEnabled(true);
                     CBForm137.setEnabled(true);
                     CBTor.setEnabled(true);




                String sUser ="";
                    int tmp= 0;
                    clear();
                    sUser = JOptionPane.showInputDialog(null,"Enter Student ID to search.","Student Information System",JOptionPane.QUESTION_MESSAGE);

                     if(!sUser.equals("")){
                         try{

                     st=cn.createStatement();
                     ResultSet rs=st.executeQuery("SELECT * FROM Login WHERE ID = '" + sUser + "'");

                        while(rs.next()){

                             txtID.setText(rs.getString(1));

                             txtstdname.setText(rs.getString(2));

                             txtcourse.setText(rs.getString(3));

                             txtsubject.setText(rs.getString(4));

                             txtprelim.setText(rs.getString(5));

                             txtGenderHolder.setText(rs.getString(6));

                             if(txtGenderHolder.equals("female")){
                                 RBFemale.setSelected(true);

                             }
                             else{
                                 RBMale.setSelected(true);
                             }

                             





if(rs.getString(9).equals("check")){
    CBDiploma.setSelected(true);
    txtRDiplomaHolder.setText(("check"));
}
else{
}
if(rs.getString(10).equals("check")){
    CBForm137.setSelected(true);
    txtRForm137Holder.setText("check");
}
else{
}
if(rs.getString(11).equals("check")){
    CBTor.setSelected(true);
    txtRTorHolder.setText("check");
}
else{
}
if(rs.getString(12).equals("check")){
    CBBirth.setSelected(true);
    txtRBirth.setText("check");
}
else{
}




tmp=1;
                           }
                       st.close();

                        if (tmp==0){
                            update.setEnabled(false);
                            delete.setEnabled(false);
                            JOptionPane.showMessageDialog(null,"No record found!!.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
                        }

                        }catch(SQLException s){
                    JOptionPane.showMessageDialog(null,"Unable to search!.","Student Information System",JOptionPane.ERROR_MESSAGE);
                    System.out.println("SQL Error" + s.toString() + " " +
s.getErrorCode() + " " + s.getSQLState());
                    }


                       }




            }
            if(source==update){
                    txtID.setEnabled(true);
                    txtstdname.setEnabled(true);
                    txtcourse.setEnabled(true);
                    txtsubject.setEnabled(true);
                    txtprelim.setEnabled(true);
                    
                    txtmid.setEnabled(false);
                    txtprefin.setEnabled(false);
                    txtfinal.setEnabled(false);
        
                    txtRDiplomaHolder.setEnabled(true);
                    txtRForm137Holder.setEnabled(true);
                    txtRTorHolder.setEnabled(true);
                    txtRBirth.setEnabled(true);
                    txtGenderHolder.setEnabled(true);
                    CBBirth.setEnabled(true);
                    CBDiploma.setEnabled(true);
                    CBForm137.setEnabled(true);
                    CBTor.setEnabled(true);
                    RBMale.setEnabled(false);
                    RBFemale.setEnabled(false);;

                            //----------------------------Check------------------

               int    id=0;
                int    idChecker=0;
                int    age=0;
                int    ageChecker=0;
                int    checkerFirst=0;
                int    checkerMid=0;
                int    checkerLast=0;

                try{

                age=Integer.parseInt(txtprelim.getText());
                if(age==0){ ageChecker=1;
                     JOptionPane.showMessageDialog(null,"Change Age","Warning",JOptionPane.WARNING_MESSAGE);
                }
                }catch(NumberFormatException nfe){
                     JOptionPane.showMessageDialog(null,"Age should be Numbers only","Warning",JOptionPane.WARNING_MESSAGE);
                     ageChecker=1;
                     age=0;
                }
                try{
                         id=Integer.parseInt(txtID.getText());

                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"ID should be Numbers only","Warning",JOptionPane.WARNING_MESSAGE);

                 idChecker=1;
                }
                String checkFirstName=txtstdname.getText();
                String checkLastName=txtsubject.getText();
                String checkMidName=txtcourse.getText();
                 if(checkFirstName.matches(".*\\d.*")){
                    JOptionPane.showMessageDialog(null,"Invalid input in First Name","Warning",JOptionPane.WARNING_MESSAGE);
                  checkerFirst=1;
                } else{
                  checkerFirst=0;
                }
                if(checkLastName.matches(".*\\d.*")){
                 JOptionPane.showMessageDialog(null,"Invalid input in Last Name","Warning",JOptionPane.WARNING_MESSAGE);
                  checkerLast=1;
                } else{
                  checkerLast=0;
                }
                if(checkMidName.matches(".*\\d.*")){
                 JOptionPane.showMessageDialog(null,"Invalid input in Mid Name","Warning",JOptionPane.WARNING_MESSAGE);
                  checkerMid=1;
                } else{
                  checkerMid=0;
                }




                if(txtcourse.getText().length()>1){
                JOptionPane.showMessageDialog(null,"Set Middle initial to one character only!","Warning",JOptionPane.WARNING_MESSAGE);
                    checkerMid=1;

                  }
                  if(checkerFirst==1||checkerMid==1||checkerLast==1||idChecker==1||
ageChecker==1){

                  }
                  

                  //----------------------------End of Check--------------------

                  else{

                        String idx = String.valueOf(id);
                        String ftname=txtstdname.getText();
                        String mdname=txtcourse.getText();
                        String ltname=txtsubject.getText();
                
                        String gender=txtGenderHolder.getText();
                        String diploma =txtRDiplomaHolder.getText();
                        String form137=txtRForm137Holder.getText();
                        String TOR=txtRTorHolder.getText();
                        String birth=txtRBirth.getText();
                    try{
                if (!gender.equals("")&&!idx.equals("") &&
!ftname.equals("")&& !mdname.equals("") && !ltname.equals("") && age>0) {
                    st=cn.createStatement();
                    PreparedStatement ps = cn.prepareStatement("UPDATE Login SET First = '" + ftname + "',MI = '" + mdname + "',Last= '" + ltname+ "',Age = '"+age+"',Gender='"+gender+"',Status='"+"'',Diploma='"+diploma+"',Form137='"+form137+"',TOR='"+TOR+"',Birth='"+birth+ "'WHERE ID = '" + id
+ "'");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Account has been successfully updated.","Student Information System",JOptionPane.INFORMATION_MESSAGE);
                        txtID.setEnabled(false);
                        txtstdname.setEnabled(false);
                        txtcourse.setEnabled(false);
                        txtsubject.setEnabled(false);
                        txtprelim.setEnabled(false);

                        txtmid.setEnabled(false);
                        txtprefin.setEnabled(false);
                        txtfinal.setEnabled(false);
                        txtStatHolder.setEnabled(false);
                        txtRDiplomaHolder.setEnabled(false);
                        txtRForm137Holder.setEnabled(false);
                        txtRTorHolder.setEnabled(false);
                        txtRBirth.setEnabled(false);
                        txtGenderHolder.setEnabled(false);
                        CBBirth.setEnabled(false);
                        CBDiploma.setEnabled(false);
                        CBForm137.setEnabled(false);
                        CBTor.setEnabled(false);
                        txtID.requestFocus(true);
                        clear();
                        st.close();
                }
                    else{
                            JOptionPane.showMessageDialog(null,"Please Fill Up The Empty Fields","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    }catch (SQLException y){
                    JOptionPane.showMessageDialog(null,"Unable to update!.","Student Information System",JOptionPane.ERROR_MESSAGE);
                    System.out.println("SQL Error" + y.toString() + " "
+y.getErrorCode() + " " + y.getSQLState());
                        if
(!gender.equals("")&&!idx.equals("") && !ftname.equals("")&&
!mdname.equals("") && !ltname.equals("") && age!=0) {
                        }
                        else{

                       delete.setEnabled(false);
                       update.setEnabled(false);
                       save.setEnabled(false);
                            }
                        }
                 }



            }
            
         if(source==delete){
            if(!txtID.getText().equalsIgnoreCase("")){

                 try{
                        PreparedStatement ps = cn.prepareStatement("DELETE FROM Login WHERE ID ='"+ txtID.getText() + "'");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Account has been successfully deleted.","Payroll System: User settings",JOptionPane.INFORMATION_MESSAGE);
                        txtID.setEnabled(false);
                        txtstdname.setEnabled(false);
                        txtcourse.setEnabled(false);
                        txtsubject.setEnabled(false);
                        txtprelim.setEnabled(false);

                        txtmid.setEnabled(false);
                        txtprefin.setEnabled(false);
                        txtfinal.setEnabled(false);
                        txtStatHolder.setEnabled(false);
                        txtRDiplomaHolder.setEnabled(false);
                        txtRForm137Holder.setEnabled(false);
                        txtRTorHolder.setEnabled(false);
                        txtRBirth.setEnabled(false);
                        txtGenderHolder.setEnabled(false);
                        CBBirth.setEnabled(false);
                        CBDiploma.setEnabled(false);
                        CBForm137.setEnabled(false);
                        CBTor.setEnabled(false);
                        txtID.requestFocus(true);
                        
                        clear();
                        st.close();
                    }catch(SQLException s){
                    JOptionPane.showMessageDialog(null,"Unable to delete!.","Student Information System",JOptionPane.ERROR_MESSAGE);

             }
         }
                 delete.setEnabled(false);
                 update.setEnabled(false);
                 save.setEnabled(false);
         }
          if(source==cancel){
             save.setEnabled(false);
             search.setEnabled(true);
             New.setEnabled(true);
             
             clear();
          }
            if(source==exit){
                System.exit(0);

            }
            
            
            compute.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        float prelim = Float.parseFloat(txtprelim.getText());
                        float midterm = Float.parseFloat(txtmid.getText());
                        float prefinal = Float.parseFloat(txtprefin.getText());
            
                        float average = (prelim + midterm + prefinal) / 3;
            
                        String message;
                        if (average >= 97 && average <= 100) {
                            message = "\nYour grade is 1.00 \nRemarks: Excellent";
                        } else if (average >= 94 && average <= 96) {
                            message = "\nYour grade is 1.25 \nRemarks: Excellent";
                        } else if (average >= 91 && average <= 93) {
                            message = "\nYour grade is 1.50 \nRemarks: Very Good";
                        } else if (average >= 88 && average <= 90) {
                            message = "\nYour grade is 1.75 \nRemarks: Very Good";
                        } else if (average >= 85 && average <= 87) {
                            message = "\nYour grade is 2.00 \nRemarks: Above Average";
                        } else if (average >= 82 && average <= 84) {
                            message = "\nYour grade is 2.25 \nRemarks: Above Average";
                        } else if (average >= 79 && average <= 81) {
                            message = "\nYour grade is 2.50 \nRemarks: Average";
                        } else if (average >= 76 && average <= 78) {
                            message = "\nYour grade is 2.75 \nRemarks: Average";
                        } else if (average == 75) {
                            message = "\nYour grade is 3.00 \nRemarks: Passing";
                        } else if (average >= 72 && average <= 74) {
                            message = "\nYour grade is 3.25 \nRemarks: Conditional";
                        } else if (average >= 69 && average <= 71) {
                            message = "\nYour grade is 3.50 \nRemarks: Conditional";
                        } else if (average >= 66 && average <= 68) {
                            message = "\nYour grade is 3.75 \nRemarks: Failed";
                        } else if (average == 65) {
                            message = "\nYour grade is 4.00 \nRemarks: Failed";
                        } else if (average <= 64) {
                            message = "\nYour grade is 5.00 \nRemarks: Failed";
                        } else {
                            message = "\nYour grade is INC or Drop with Failure";
                        }
            
                        JOptionPane.showMessageDialog(null, message, "Grade Calculation", JOptionPane.INFORMATION_MESSAGE);
            
                        // Clear the entry fields
                        txtprelim.setText("");
                        txtmid.setText("");
                        txtprefin.setText("");
                        txtfinal.setText("");
            
                        RBMale.setEnabled(true);
                        RBFemale.setEnabled(true);
                        RBHidden.setEnabled(true);
            
                        RBMale.setSelected(false);
                        RBFemale.setSelected(false);
                        RBHidden.setSelected(true);
            
                        txtID.setText("");
                        txtstdname.setText("");
                        txtcourse.setText("");
                        txtsubject.setText("");
                        txtRDiplomaHolder.setText("");
                        txtRForm137Holder.setText("");
                        txtRTorHolder.setText("");
                        txtRBirth.setText("");
                        txtGenderHolder.setText("");
                        CBBirth.setSelected(false);
                        CBDiploma.setSelected(false);
                        CBForm137.setSelected(false);
                        CBTor.setSelected(false);
            
                        compute.setEnabled(true);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error: Please enter valid numeric grades.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
        
}
    

     public void itemStateChanged (ItemEvent j)    {

          if(j.getSource().equals(RBFemale)){
              txtGenderHolder.setText("female");


          }
          if(j.getSource().equals(RBMale)){
              txtGenderHolder.setText("male");
          }




     }


    public void valueChanged(ListSelectionEvent e){

     }
     



     public static void main (String args []){
         JFrame frame= new finals();
         frame.setSize(950,700);
         frame.setVisible(true);
         frame.setResizable(true);

     }
}
