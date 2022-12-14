package br.com.ada.email;

public class Message {

  public String sender;
  public String sentDate;
  public String receivedDate;
  public String subject;
  public String body;
  
  public Message(String sender, String sentDate, String receivedDate, String subject, String body) {
    this.sender = sender;
    this.sentDate = sentDate;
    this.receivedDate = receivedDate;
    this.subject = subject;
    this.body = body;
  }
  public String getSender() {
    return sender;
  }
  public void setSender(String sender) {
    this.sender = sender;
  }
  public String getSentDate() {
    return sentDate;
  }
  public void setSentDate(String sentDate) {
    this.sentDate = sentDate;
  }
  public String getReceivedDate() {
    return receivedDate;
  }
  public void setReceivedDate(String receivedDate) {
    this.receivedDate = receivedDate;
  }
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }
  
}
