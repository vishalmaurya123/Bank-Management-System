import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdraw,ministatement,pinchange,fastcash,balenceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){

        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(170,240,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(110,370,135,27);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(325,370,135,27);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(110,405,135,27);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(325,405,135,27);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(110,440,135,27);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balenceenquiry = new JButton(" Rs 100000");
        balenceenquiry.setBounds(325,440,135,27);
        balenceenquiry.addActionListener(this);
        image.add(balenceenquiry);

        exit = new JButton("Back");
        exit.setBounds(325,475,135,27);
        exit.addActionListener(this);
        image.add(exit);

      
        setSize(800,800);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);//RS 500
            Conn c= new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance = Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource()!=exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showConfirmDialog(null, " Rs " + amount + "Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
