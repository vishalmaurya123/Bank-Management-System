import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdraw,ministatement,pinchange,fastcash,balenceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){

        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(170,240,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(110,370,135,27);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(325,370,135,27);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(110,405,135,27);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(325,405,135,27);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(110,440,135,27);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balenceenquiry = new JButton("Balence Enquiry");
        balenceenquiry.setBounds(325,440,135,27);
        balenceenquiry.addActionListener(this);
        image.add(balenceenquiry);

        exit = new JButton("Exit");
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
            System.exit(0);
        }else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit (pinnumber).setVisible(true);
        }else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withrawl(pinnumber).setVisible(true);            
        }else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balenceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);   
        }else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
