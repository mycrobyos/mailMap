package br.com.ada.mm;

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
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((sender == null) ? 0 : sender.hashCode());
    result = prime * result + ((sentDate == null) ? 0 : sentDate.hashCode());
    result = prime * result + ((receivedDate == null) ? 0 : receivedDate.hashCode());
    result = prime * result + ((subject == null) ? 0 : subject.hashCode());
    result = prime * result + ((body == null) ? 0 : body.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Message other = (Message) obj;
    if (sender == null) {
      if (other.sender != null)
        return false;
    } else if (!sender.equals(other.sender))
      return false;
    if (sentDate == null) {
      if (other.sentDate != null)
        return false;
    } else if (!sentDate.equals(other.sentDate))
      return false;
    if (receivedDate == null) {
      if (other.receivedDate != null)
        return false;
    } else if (!receivedDate.equals(other.receivedDate))
      return false;
    if (subject == null) {
      if (other.subject != null)
        return false;
    } else if (!subject.equals(other.subject))
      return false;
    if (body == null) {
      if (other.body != null)
        return false;
    } else if (!body.equals(other.body))
      return false;
    return true;
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
