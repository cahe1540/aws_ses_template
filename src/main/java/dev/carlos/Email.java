package dev.carlos;

import com.amazonaws.regions.Regions;

public class Email {
  private String from;
  private Regions awsregion;
  private String to;
  private String subject;
  private String htmlBody;
  private String textBody;
  private String configSet;

  public Email() {
  }

  public Email(String from, Regions awsregion, String to, String subject, String htmlBody,
      String textBody, String configSet) {
    this.from = from;
    this.awsregion = awsregion;
    this.to = to;
    this.subject = subject;
    this.htmlBody = htmlBody;
    this.textBody = textBody;
    this.configSet = configSet;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public Regions getAwsregion() {
    return awsregion;
  }

  public void setAwsregion(Regions awsregion) {
    this.awsregion = awsregion;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getHtmlBody() {
    return htmlBody;
  }

  public void setHtmlBody(String htmlBody) {
    this.htmlBody = htmlBody;
  }

  public String getTextBody() {
    return textBody;
  }

  public void setTextBody(String textBody) {
    this.textBody = textBody;
  }

  public String getConfigSet() {
    return configSet;
  }

  public void setConfigSet(String configSet) {
    this.configSet = configSet;
  }
}
