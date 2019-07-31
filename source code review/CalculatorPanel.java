package tangentfunction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * User interface of the tangent calculator.
 * 
 * @author Qing Li SID:40082701
 */
public class CalculatorPanel extends JFrame {

  static JFrame frame = new JFrame("TangentCalculator");
  JTextField display = new JTextField("");
  Font font = new Font("Consolas", Font.BOLD, 40);
  Font font1 = new Font("Consolas", Font.BOLD, 20);
  Actionlistener al = new Actionlistener(); // create an object of action listener

  // calculator buttons
  JButton buttonClear = new JButton("C"); // button "clear"
  JButton buttonTan = new JButton("tan"); // button "tan"

  /**
   * Constructor.
   */
  public CalculatorPanel() {
    super();

    // set button's color
    buttonClear.setBackground(Color.white);
    buttonTan.setBackground(Color.pink);

    // set button's font
    buttonClear.setFont(font1);
    buttonTan.setFont(font1);

    // set background
    display.setHorizontalAlignment(JTextField.RIGHT);
    display.setFont(font);
    display.setBackground(Color.white);
    display.setEditable(true);

    // set input textbox
    JPanel pan1 = new JPanel();
    pan1.setLayout(new GridLayout(1, 1, 5, 5));
    pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
    pan1.add(display);

    // add buttons into the whole panel
    JPanel panBody = new JPanel();
    panBody.setLayout(new GridLayout(1, 2));
    panBody.add(buttonTan);
    panBody.add(buttonClear);
    panBody.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

    // set layout
    frame.setLayout(new BorderLayout());
    frame.add(pan1, BorderLayout.NORTH);
    frame.add(panBody, BorderLayout.CENTER);
    frame.setSize(780, 180);
    frame.setLocation(260, 150);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // give each button an action listener
    buttonClear.addActionListener(al);
    buttonTan.addActionListener(al);
  }

  /**
   * Action Listener.
   */
  public class Actionlistener implements ActionListener {

    TangentFunction tan = new TangentFunction();
    public String preDisplay = "";

    /**
     * Action controller.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      Object click1 = e.getSource(); // get the button's name
      if (click1 == buttonClear) {
        preDisplay = "";
        display.setText(""); // clear everything
      } else if (click1 == buttonTan) {

        String result = tan.tangent(display.getText()); // get the calculated result

        if (result.equals("Error: Empty input!")) {
          display.setText("Error: Empty input!"); // error report
        } else if (result.equals("Error: This is not a real number!")) {
          display.setText("Error: This is not a real number!"); // error report
        } else if (result.equals("Error: The value is not existing!")) {
          display.setText("Error: The value is not existing!"); // error report
        } else {
          display.setText(String.valueOf(result));
        }
        preDisplay = "";
      }
    }
  }
}
