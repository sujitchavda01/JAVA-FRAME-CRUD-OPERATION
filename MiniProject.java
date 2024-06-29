
package miniproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class MiniProject implements ActionListener,ItemListener,javax.swing.event.ChangeListener{
    JFrame jf;
    JTabbedPane jtp;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    JPanel insert,update,delete,select;
    Label l1,l1i,l1i2,l1i3,l2,l3,l2i,l1i4,l4,l2i3;
    TextField tfinsert,tfupdate,tfinsert1,tfinsert2,tfinsert3,tfupdate2,tfupdate3,tfupdate4;
    Button insertbtn,updatebtn,deletebtn;
    JComboBox cb1,cb2;
    JTable tblData = new JTable();
    JScrollPane sp = new JScrollPane(tblData);
    
    MiniProject(){
        
        jf=new JFrame("GALLERY TABLE");
        jtp=new JTabbedPane();
         
//        insert 
        insert=new JPanel();
        insert.setLayout(null);
        l1=new Label("Enter Photo id:");
        l1.setBounds(50, 50, 150, 50);
        l1.setFont(new Font("Arial", Font.PLAIN, 16));
        tfinsert=new TextField();
        tfinsert.setBounds(210, 60, 180, 30);
        tfinsert.setFont(new Font("Arial", Font.PLAIN, 16));
        
        l1i=new Label("Photo Name :");
        l1i.setBounds(450, 50, 150, 50);
        l1i.setFont(new Font("Arial", Font.PLAIN, 16));
        tfinsert1=new TextField();
        tfinsert1.setBounds(610, 60, 180, 30);
        tfinsert1.setFont(new Font("Arial", Font.PLAIN, 16));
        
        l1i2=new Label("Date of Post :");
        l1i2.setBounds(50, 100, 150, 50);
        l1i2.setFont(new Font("Arial", Font.PLAIN, 16));
        tfinsert2=new TextField();
        tfinsert2.setBounds(210, 110, 180, 30);
        tfinsert2.disable();
       LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        tfinsert2.setText(date);
        tfinsert2.setFont(new Font("Arial", Font.PLAIN, 16));
        
        
        l1i3=new Label("Photo Category:");
        l1i3.setBounds(450, 100, 150, 50);
        l1i3.setFont(new Font("Arial", Font.PLAIN, 16));
        tfinsert3=new TextField();
        tfinsert3.setBounds(610, 110, 180, 30);
        tfinsert3.setFont(new Font("Arial", Font.PLAIN, 16));
        
        
        insertbtn=new Button("Insert");
        insertbtn.setBounds(280, 200, 340, 30);
        insertbtn.setFont(new Font("Arial", Font.PLAIN, 16));
        insertbtn.addActionListener(this);
        
        insert.add(l1i2);
        insert.add(tfinsert3);
        insert.add(l1i3);
        insert.add(tfinsert2);
        insert.add(l1i3);
        insert.add(tfinsert1);
        insert.add(l1i);
        insert.add(insertbtn);
        insert.add(l1);
        insert.add(tfinsert);
        jtp.addTab("Insert", insert);
        
//        update
        update=new JPanel();
        update.setLayout(null);
        l2=new Label("Select Photo id:");
        l2.setBounds(50, 10, 150, 50);
        l2.setFont(new Font("Arial", Font.PLAIN, 16));
        
        cb1=new JComboBox();    
        cb1.setBounds(210, 20,180,30); 
        cb1.addItemListener(this);
        cb1.setFont(new Font("Arial", Font.PLAIN, 16));
        
         l3=new Label("Enter Photo id:");
        l3.setBounds(50, 50, 150, 50);
        l3.setFont(new Font("Arial", Font.PLAIN, 16));
        tfupdate=new TextField();
        tfupdate.setBounds(210, 60, 180, 30);
        tfupdate.setFont(new Font("Arial", Font.PLAIN, 16));
        
        l2i=new Label("Photo Name :");
        l2i.setBounds(450, 50, 150, 50);
        l2i.setFont(new Font("Arial", Font.PLAIN, 16));
        tfupdate2=new TextField();
        tfupdate2.setBounds(610, 60, 180, 30);
        tfupdate2.setFont(new Font("Arial", Font.PLAIN, 16));
        
        l2i3=new Label("Date of Post :");
        l2i3.setBounds(50, 100, 150, 50);
        l2i3.setFont(new Font("Arial", Font.PLAIN, 16));
        tfupdate3=new TextField();
        tfupdate3.setBounds(210, 110, 180, 30);
        tfupdate3.disable();
        tfupdate3.setText(date);
        tfupdate3.setFont(new Font("Arial", Font.PLAIN, 16));
        
        
        l1i4=new Label("Photo Category:");
        l1i4.setBounds(450, 100, 150, 50);
        l1i4.setFont(new Font("Arial", Font.PLAIN, 16));
        tfupdate4=new TextField();
        tfupdate4.setBounds(610, 110, 180, 30);
        tfupdate4.setFont(new Font("Arial", Font.PLAIN, 16));
        
        
        updatebtn=new Button("Update");
        updatebtn.setBounds(280, 200, 340, 30);
        updatebtn.setFont(new Font("Arial", Font.PLAIN, 16));
        updatebtn.addActionListener(this);
        
       
        update.add(l2);
        update.add(tfupdate);
        update.add(l2i3);
        update.add(tfupdate2);
        update.add(l2i);
        update.add(tfupdate3);
        update.add(l1i4);
        update.add(tfupdate4);
        update.add(cb1);
        update.add(updatebtn);
        update.add(l2);
        update.add(l3);
        update.add(tfupdate);
        jtp.addTab("Update", update);
        
        delete=new JPanel();
        delete.setLayout(null);
        l4=new Label("Select Photo id:");
        l4.setBounds(50, 50, 150, 50);
        l4.setFont(new Font("Arial", Font.PLAIN, 16));
        
        cb2=new JComboBox();    
        cb2.setBounds(210, 60,180,30); 
        cb2.setFont(new Font("Arial", Font.PLAIN, 16));
        
        deletebtn=new Button("Delete");
        deletebtn.setBounds(50, 170, 340, 30);
        deletebtn.setFont(new Font("Arial", Font.PLAIN, 16));
        deletebtn.addActionListener(this);
        
        delete.add(l4);
        delete.add(cb2);
        delete.add(deletebtn);
        jtp.addTab("Delete", delete);
        
        select=new JPanel();
        select.setLayout(new BorderLayout());
        select.add(sp);
        jtp.addTab("Retrive", select);
        
        jtp.addChangeListener(this);
        jf.setSize(1100, 700);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jf.getContentPane().add(jtp);
    }
    
    public static void main(String[] args) {
        new MiniProject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==insertbtn)
               {
                   if(!tfinsert.getText().equals("") &&  !tfinsert1.getText().equals("")&& !tfinsert2.getText().equals("")&& !tfinsert3.getText().equals(""))
                   {
                   try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/gpp", "root", "");
                    st = con.createStatement();
                    st.executeUpdate("INSERT INTO `gallery`(`Photo_id`, `Photo`, `Date_of_post`, `Function_categories`) VALUES ('"+tfinsert.getText()+"','"+tfinsert1.getText()+"','"+tfinsert2 .getText()+"','"+tfinsert3.getText()+"')");
                    
                     
                    JOptionPane.showMessageDialog(jf,"Data Inserted Sucessfully");
                    tfinsert.setText("");
                   tfinsert1.setText("");
                   tfinsert3.setText("");
                    st.close();
                    rs.close();
                    } catch(Exception x) {
                        
                    }
                   }
                   else{
                       JOptionPane.showMessageDialog(jf,"Please Enter Values","Error",JOptionPane.WARNING_MESSAGE);
                   }
               }
    
               if(e.getSource()==updatebtn)
               {
                   if(cb1.getSelectedIndex()!=-1)
                   {
                    if(!tfupdate.getText().equals("") && !tfupdate2.getText().equals("")&& !tfupdate3.getText().equals("")&&!tfupdate4.getText().equals(""))
                   {
                   try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/gpp", "root", "");
                    st = con.createStatement();
                st.executeUpdate("UPDATE `gallery` SET `Photo_id`='"+tfupdate.getText()+"',`Photo`='"+tfupdate2.getText()+"',`Date_of_post`='"+tfupdate3.getText()+"',`Function_categories`='"+tfupdate4.getText()+"' WHERE Photo_id="+""+cb1.getSelectedItem()+"");
                
                  tfupdate.setText("");
                tfupdate2.setText("");
                tfupdate3.setText("");
                tfupdate4.setText("");
                    
                    JOptionPane.showMessageDialog(jf,"Data Updated Sucessfully");
                    tfinsert.setText("");
                   tfinsert1.setText("");
                   tfinsert3.setText("");
                   cb1.setSelectedIndex(-1);
                    st.close();
                    rs.close();
                    } catch(Exception x) {
                       
                    }
                   }
                    else{
                       JOptionPane.showMessageDialog(jf,"Please Enter Value","Error",JOptionPane.WARNING_MESSAGE);
                     }
                   }
                   else{
                       JOptionPane.showMessageDialog(jf,"Please Select id","Error",JOptionPane.WARNING_MESSAGE);
                   }
                   
               }
               if(e.getSource()==deletebtn)
               {     
                   if(cb2.getSelectedIndex()!=(-1))
                   {
                        try {
                         Class.forName("com.mysql.jdbc.Driver");
                         con = DriverManager.getConnection("jdbc:mysql://localhost/gpp", "root", "");
                         st = con.createStatement();
                         st.executeUpdate("delete from gallery where Photo_id="+cb2.getSelectedItem());
                         JOptionPane.showMessageDialog(jf,"Data Deleted Sucessfully");
                         cb2.setSelectedIndex(-1);
                         st.close();
                         rs.close();
                         } catch(Exception x) {

                         }
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(jf,"Please Select id","Error",JOptionPane.WARNING_MESSAGE);
                   }
                   
               }
    }
    
     public void stateChanged(ChangeEvent e) {
  
        int selectedIndex = jtp.getSelectedIndex();
        cb1.setSelectedIndex(-1);
        cb2.setSelectedIndex(-1);

        
        switch (selectedIndex) {
            case 0:
                System.out.println("Tab 1 is selected");
                break;
            case 1:
                System.out.println("Tab 2 is selected");
                try {
                    cb1.removeAllItems();
                    cb2.removeAllItems();
                    choice_retrive("cb1");
                    } catch (SQLException ex) {
                        
                }
                break;
            case 2:
                System.out.println("Tab 3 is selected");
                try {
                    cb1.removeAllItems();
                    cb2.removeAllItems();
                    choice_retrive("cb2");

                } catch (SQLException ex) {
                    
                }
                break;
            case 3:
                System.out.println("Tab 4 is selected");
                fetchData();
                break;
            default:
                
                break;
        }
    }
    
      public void choice_retrive(String str2) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connectiong to database");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gpp", "root", "");
            stmt = conn.createStatement();
            String sql = "Select Photo_id from gallery";
            ResultSet rs = stmt.executeQuery(sql);
            cb1.setEnabled(false);
            cb2.setEnabled(false);

            while (rs.next()) {
                if (str2.equals("cb1")) {
                    cb1.addItem(rs.getString(1));
                } else {
                    cb2.addItem(rs.getString(1));

                }
            }
            cb1.setEnabled(true);
            cb2.setEnabled(true);
            cb1.setSelectedIndex(-1);
            cb2.setSelectedIndex(-1);

        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        } catch (SQLException ex) {
            System.out.print(ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            System.out.println("Finally connection close");

        }
    }
     
    void fetchData() {
        Connection conn = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connectiong to database");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/gpp", "root", "");
            stmt = conn.createStatement();
            String sql = "Select * from gallery;";
            System.out.println("Jtable");
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++) {
                colName[i] = rsmd.getColumnLabel(i + 1);
            }
            DefaultTableModel model = new DefaultTableModel(colName, 0);
            model.setColumnIdentifiers(colName);
            
            while(rs.next()){
           Object[] rowData = new Object[cols];
            
            for (int i = 0; i < cols; i++) {
                rowData[i] = rs.getObject(i + 1); 
            }
            
            // Add the row data to the model
            model.addRow(rowData);
            tblData.setModel(model);    
            }
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        } catch (SQLException ex) {
            System.out.print(ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            System.out.println("Finally connection close");

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
         int index = jtp.getSelectedIndex();

        if (index == 1) {
            if (cb1.getSelectedIndex() == -1) {
                tfupdate.setText("");
                tfupdate2.setText("");
                tfupdate4.setText("");

            } else if (e.getStateChange() == ItemEvent.SELECTED) {
                String s1 = cb1.getSelectedItem().toString();
                Connection conn = null;
                Statement stmt = null;

                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("Connectiong to database");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/gpp", "root", "");
                    stmt = conn.createStatement();
                    String sql = "Select * from gallery where Photo_id = '" + s1 + "'";
                    ResultSet rs = stmt.executeQuery(sql);

                    while (rs.next()) {
                        tfupdate.setText(rs.getString(1));
                        tfupdate2.setText(rs.getString(2));
                        tfupdate4.setText(rs.getString(4));
                    }

                } catch (ClassNotFoundException ex) {
                    System.out.print(ex);
                } catch (SQLException ex) {
                    System.out.print(ex);
                } finally {
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (SQLException se2) {

                    }
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    System.out.println("Finally connection close");

                }
            }
    }
    }
    
}
