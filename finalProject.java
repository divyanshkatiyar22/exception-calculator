import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Custom Exceptions
class InvalidInputException extends Exception {
    public String toString() {
        return "You have given the wrong input!! This is not the valid input for calculation";
    }
}
class CannotDivideBy0Exception extends Exception {
    public String toString() {
        return "Divide any value by 0 is not possible in mathematics";
    }
}
class MaxInputException extends Exception {
    public String toString() {
        return "The input value cannot exceed 100000";
    }
}
class MaxMultiplierReachedException extends Exception {
    public String toString() {
        return "The input for multiplication cannot exceed 7000";
    }
}

// Main class with GUI
public class finalProject extends JFrame implements ActionListener {

    JTextField t1, t2;
    JLabel resultLabel;
    JButton addBtn, subBtn, mulBtn, divBtn;

    public finalProject() {
        setTitle("Custom Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Enter first number:"));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Enter second number:"));
        t2 = new JTextField();
        add(t2);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");

        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        resultLabel = new JLabel("Result will be shown here.");
        add(resultLabel);

        // Registering action listeners
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());

            if (a > 100000 || b > 100000) {
                throw new MaxInputException();
            }

            if (e.getSource() == addBtn) {
                resultLabel.setText("Answer is: " + (a + b));
            } else if (e.getSource() == subBtn) {
                resultLabel.setText("Answer is: " + (a - b));
            } else if (e.getSource() == mulBtn) {
                if (a > 7000 || b > 7000) {
                    throw new MaxMultiplierReachedException();
                }
                resultLabel.setText("Answer is: " + (a * b));
            } else if (e.getSource() == divBtn) {
                if (b == 0) {
                    throw new CannotDivideBy0Exception();
                }
                resultLabel.setText("Answer is: " + (a / b));
            }

        } catch (NumberFormatException ex) {
            showMessage("Please enter valid numeric inputs.");
        } catch (Exception ex) {
            showMessage(ex.toString());
        }
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        finalProject calc = new finalProject();
        calc.setVisible(true);
    }
}
