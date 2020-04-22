import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * This class is the Graphical user interface of the program
 */
public class GUI extends JFrame {
    private JFrame f;
    private JPanel panel = new JPanel();
    private JTextField hostInput;
    private JTextField userInput;
    private JTextField passInput;
    private JTextField fromInput;
    private JTextField toInput;
    private JTextField subjectInput;
    private JButton sendButton;
    JTextPane messageText;

    private JTextArea message;

    /**
     * Constructor that builds the Graphical user interface and sets default values to the components in the GUI
     * @throws SQLException
     */
    GUI() {
        //Input
        JLabel hostText = new JLabel("Host:");
        panel.add(hostText);
        hostInput = new JTextField("smtp.gmail.com");
        panel.add(hostInput);
        JLabel usernameText = new JLabel("Username:");
        panel.add(usernameText);
        userInput = new JTextField("");
        panel.add(userInput);
        JLabel passwordText = new JLabel("Password:");
        panel.add(passwordText);
        passInput = new JPasswordField("");
        panel.add(passInput);
        JLabel fromText = new JLabel("From:");
        panel.add(fromText);
        fromInput = new JTextField("");
        panel.add(fromInput);

        JLabel toText = new JLabel("To:");
        panel.add(toText);
        toInput = new JTextField("");
        panel.add(toInput);

        JLabel subjectText = new JLabel("Subject:");
        panel.add(subjectText);
        subjectInput = new JTextField("Hello subject");
        panel.add("North",subjectInput);





        sendButton = new JButton("Send");
        this.getContentPane().add("South", sendButton);
        /**
         * Add actionListener to Button to trigger method "sendButtonClicked()"
         */
        sendButton.addActionListener(e -> {
            sendButtonClicked();
        });

        //Output
        message = new JTextArea();
        message.setSize(600, 300);
        this.getContentPane().add("Center", message);
        panel.setLayout(new GridLayout(6, 2));
        this.getContentPane().add("North", panel);
        setSize(500, 2000);
        setVisible(true);
        message.setText("Hello Friend");

    }



    /**
     * This method is called when clicking the sendButton, it creates a new connection to the gmail server and send a new email.
     */
    private void sendButtonClicked() {
        SendEmail sendEmail = new SendEmail();

        sendEmail.sendEmail(toInput.getText(), fromInput.getText(), hostInput.getText(), subjectInput.getText(),  message.getText(), userInput.getText(), passInput.getText());
    }


}
