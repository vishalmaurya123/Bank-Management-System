import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class signupTwo extends JFrame implements ActionListener {
    JTextField pan, aadhar;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox religion, category, occupation, education, income;
    String formno;

    signupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW APPLICATION FORM-PAGE 2");

        JLabel additionaldetails = new JLabel("PAGE 2: Additional Details ");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 60, 400, 30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 120, 100, 30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 120, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 170, 200, 30);
        add(fname);

        String valcategory[] = {"General", "OBC", "SC", "ST", "OTHERS"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 170, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);

        String incomecategory[] = {"Null", "<1,50000", "<2,50000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 220, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Education");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationvalues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        education = new JComboBox(educationvalues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 370, 200, 30);
        add(marital);

        String occupationvalues[] = {"Salaried", "Self Employed", "Business", "Student", "Retired"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300, 370, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 420, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 420, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 470, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 470, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 520, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 520, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 520, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup mariatalGroup = new ButtonGroup();
        mariatalGroup.add(syes);
        mariatalGroup.add(sno);

        JLabel pincode = new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 570, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 570, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 570, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emariatalGroup = new ButtonGroup();
        emariatalGroup.add(eyes);
        emariatalGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 28);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;

        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String exisitingaccount = null;
        if (eyes.isSelected()) {
            exisitingaccount = "Yes";
        } else if (eno.isSelected()) {
            exisitingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo  VALUES ('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorcitizen + "','" + exisitingaccount + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Added Successfully");
           // signup3 object
            setVisible(false);
            new signupThree(formno).setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signupTwo("");
    }
}
