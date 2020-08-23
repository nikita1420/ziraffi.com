package Utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;


public class EmailUtil
{       
	
	@Test
	public static void sendemail() throws Exception
	{  
		System.out.println("Email started sending");
	
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("test-output\\emailable-report.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Report");
		  attachment.setName("Test");
		  
		// Create the email message	 
    MultiPartEmail email = new MultiPartEmail();
	email.setHostName("smtp.gmail.com");
	email.setSSLOnConnect(true);
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("ziraffitesting@gmail.com","test@12345"));
	email.setSSLOnConnect(true);
	email.setFrom("kapoor.nikita5455@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("angelkhanna1420@gmail.com");
	
	// add the attachment
	  email.attach(attachment);

	  // send the email
	  email.send();
	
	
	}
}
