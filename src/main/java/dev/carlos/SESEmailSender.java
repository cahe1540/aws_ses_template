package dev.carlos;

import java.io.IOException;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import java.util.Objects;

public class SESEmailSender {

  public static void sendEmail(Email email) throws IOException {
    if (Objects.isNull(email.getConfigSet())) {
      sendEmailWithoutConfig(email);
    }
    sendEmailWithConfig(email);
  }

  private static void sendEmailWithConfig(Email email) throws IOException {
    try {
      AmazonSimpleEmailService client =
          AmazonSimpleEmailServiceClientBuilder.standard()
              .withRegion(email.getAwsregion()).build();
      SendEmailRequest request = new SendEmailRequest()
          .withDestination(
              new Destination().withToAddresses(email.getTo()))
          .withMessage(new Message()
              .withBody(new Body()
                  .withHtml(new Content()
                      .withCharset("UTF-8").withData(email.getHtmlBody()))
                  .withText(new Content()
                      .withCharset("UTF-8").withData(email.getTextBody())))
              .withSubject(new Content()
                  .withCharset("UTF-8").withData(email.getSubject())))
          .withSource(email.getFrom())
          .withConfigurationSetName(email.getConfigSet());
      client.sendEmail(request);
      System.out.println("Email sent!");
    } catch (Exception ex) {
      System.out.println("The email was not sent. Error message: "
          + ex.getMessage());
    }
  }

  private static void sendEmailWithoutConfig(Email email) throws IOException {
    try {
      AmazonSimpleEmailService client =
          AmazonSimpleEmailServiceClientBuilder.standard()
              .withRegion(email.getAwsregion()).build();
      SendEmailRequest request = new SendEmailRequest()
          .withDestination(
              new Destination().withToAddresses(email.getTo()))
          .withMessage(new Message()
              .withBody(new Body()
                  .withHtml(new Content()
                      .withCharset("UTF-8").withData(email.getHtmlBody()))
                  .withText(new Content()
                      .withCharset("UTF-8").withData(email.getTextBody())))
              .withSubject(new Content()
                  .withCharset("UTF-8").withData(email.getSubject())))
          .withSource(email.getFrom());
      client.sendEmail(request);
      System.out.println("Email sent!");
    } catch (Exception ex) {
      System.out.println("The email was not sent. Error message: "
          + ex.getMessage());
    }
  }

  public static String prepareBody(String arg1, String arg2, String html) {
    html = html.replace("<NAME>", arg1);
    html = html.replace("<MESSAGE>", arg2);
    return html;
  }
}
