package br.com.ada.mm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

  public String sender;
  public Date sentDate;
  public String subject;
  public String body;
  
  public Message(String sender, String sentDate, String subject, String body) throws ParseException {
    SimpleDateFormat sdf1= new SimpleDateFormat("dd/mm/yy");
    this.sender = sender;
    this.sentDate = sdf1.parse(sentDate);
    this.subject = subject;
    this.body = body;
  }

  public String getSender() {
    return sender;
  }

  public Date getSentDate() {
    return sentDate;
  }

  public String getSubject() {
    return subject;
  }
  
  
}
