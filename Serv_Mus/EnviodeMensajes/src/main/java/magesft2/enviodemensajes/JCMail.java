package magesft2.enviodemensajes;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeJava.to;

/**
 * @web http://blog.jheysonmatta.com.pe
 * @author Jheyson Matta
 */
public class JCMail {

    private String from = "";//tu_correo@gmail.com
    private String password = "";//tu password: 123456 :)
    private String to = "";
    // destinatario1@hotmail.com,destinatario2@hotmail.com, destinatario_n@hotmail.com
    private InternetAddress[] addressTo;
    private String Subject = "";//titulo del mensaje
    private String MessageMail = "";//contenido del mensaje
    private String host = "localhost";

    public JCMail(){}

    public void SEND() throws MessagingException, IOException{
    	Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		String resourceName = "config.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties config = new Properties();
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		    config.load(resourceStream);
		}

		final String gmailAccount = config.getProperty("gmail.account");
		final String gmailPassword = config.getProperty("gmail.password");
		final String[] emailDestinations = config.getProperty("emaildestinations").split(";");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(gmailAccount,gmailPassword);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(gmailAccount));
			
			for (String emailDestination : emailDestinations) {
				message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestination));
			}

			message.setSubject("Email Subject - Asunto del correo electronico");

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Email text Body - Texto o cuerpo del correo electronico");
			
			Multipart multipart = new MimeMultipart();
			
			//Setting email text message
			multipart.addBodyPart(messageBodyPart);

			//set the attachments to the email
	        message.setContent(multipart);

			Transport.send(message);

			System.out.println("Correo enviado");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
    //remitente
    public void setFrom(String mail){ this.from = mail; }
    public String getFrom(){ return this.from; }
    //Contraseña
    public void setPassword(char[] value){
        this.password = new String(value);
    }
    public String getPassword(){ return this.password; }
    //destinatarios
    public void setTo(String mail){
       /* String[] tmp =mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i]);
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }*/
       this.to=mail;
    }
    public InternetAddress[] getTo(){ return this.addressTo; }
    //titulo correo
    public void setSubject(String value){ this.Subject = value; }
    public String getSubject(){ return this.Subject; }
    //contenido del mensaje
    public void setMessage(String value){ this.MessageMail = value; }
    public String getMessage(){ return this.MessageMail; }

}
