import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    /**
     * @param to mail to send to
     * @param from mail to send from
     * @param host host to use (gmail)
     * @param subject subject to send
     * @param userMessage message to send
     * @param username username to log into gmail
     * @param password password to login to gmail
     * Initiates all the necessary properties to send mail to gmail server, with said parameters
     */
    public void sendEmail(String to, String from, String host, String subject, String userMessage, String username, String password) {

        /**
         * Add all necessary properties to connect to email server
         */
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); //TLS

        /**
         * Add authentication object to authenticate connection with username and password
         *
         */
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        /**
         * Create message to send and define recipients to receive
         */
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);
            message.setText(userMessage);
            System.out.println(session.getTransport());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

