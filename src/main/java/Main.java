import dev.carlos.SESEmailSender;
import dev.carlos.Email;
import com.amazonaws.regions.Regions;
import java.io.IOException;

public class Main{
  public static void main(String[] args) throws IOException {
    Email email = new Email();
    email.setFrom("xyz90xyz@gmail.com");
    email.setTo("cahe1540@gmail.com");
    email.setAwsregion(Regions.US_WEST_1);
    email.setHtmlBody("<h1>Amazon SES test (AWS SDK for Java)</h1>"
        + "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
        + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>"
        + "AWS SDK for Java</a>");
    email.setTextBody("This email was sent through Amazon SES "
        + "using the AWS SDK for Java.");
    email.setHtmlBody("Amazon SES test (AWS SDK for Java)");
    email.setSubject("Test message");

    SESEmailSender.sendEmail(email);
  }
}

