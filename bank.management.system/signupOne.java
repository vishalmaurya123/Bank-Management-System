import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class signupOne extends JFrame implements ActionListener {
    long random;
    JTextField namTextField, fnamTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JRadioButton male, female, married, unmarried;
    JButton next;
    JDateChooser dateChooser;

    signupOne() {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel formnoLabel = new JLabel("APPLICATION FORM NO. " + random);
        formnoLabel.setFont(new Font("Raleway", Font.BOLD, 38));
        formnoLabel.setBounds(140, 20, 600, 40);
        add(formnoLabel);

        getContentPane().setBackground(Color.WHITE);

        JLabel personaldetails = new JLabel("PAGE 1: Personal Details ");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290, 60, 400, 30);
        add(personaldetails);

        // Name
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 120, 100, 30);
        add(name);
        namTextField = new JTextField();
        namTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        namTextField.setBounds(300, 120, 400, 30);
        add(namTextField);

        // Father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 170, 200, 30);
        add(fname);
        fnamTextField = new JTextField();
        fnamTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnamTextField.setBounds(300, 170, 400, 30);
        add(fnamTextField);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        // Gender
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 270, 200, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 270, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 270, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Email
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 320, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 320, 400, 30);
        add(emailTextField);

        // Marital Status
        JLabel marital = new JLabel("Marital Status");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 370, 200, 30);
        add(marital);
        married = new JRadioButton("Married");
        married.setBounds(300, 370, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 370, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        // Address
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 420, 200, 30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 420, 400, 30);
        add(addressTextField);

        // City
        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 470, 200, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 470, 400, 30);
        add(cityTextField);

        // State
        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 520, 200, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 520, 400, 30);
        add(stateTextField);

        // Pincode
        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 570, 200, 30);
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 570, 400, 30);
        add(pinTextField);

        // Next Button
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
        String formno = String.valueOf(random);
        String name = namTextField.getText();
        String fname = fnamTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        }else if (female.isSelected()) {
            gender = "Female";
        }
        String email =emailTextField.getText();
        String marital =null;
        if (married.isSelected()) {
            marital = "Married";
        }else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
               // Statement s = c.getStatement();
                String query = "insert into signup values  ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signupOne();
    }
}
