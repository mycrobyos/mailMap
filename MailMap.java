package br.com.ada.email;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MailMap {

  public String sender;
  public List<Message> inbox;
  Map<String, Set<Message>> arquivo = new HashMap<>();

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public List<Message> getInbox() {
    return inbox;
  }

  public void setInbox(List<Message> inbox) {
    this.inbox = inbox;
  }

  public void archiveReceived(Message message) {

    if (!arquivo.containsKey(message.sender)) {
      Set<Message> messages = new HashSet<>();
      messages.add(message);
      this.arquivo.put(message.getSender(), messages);
    } else {
      var existingSenderMessages = this.arquivo.get(message.sender);
      existingSenderMessages.add(message);
      arquivo.put(message.sender, existingSenderMessages);
    }
  }

  public void totalOfReceivedMessages() {
    var count = 0;
    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      var size = entry.getValue().size();
      while (size > 0) {
        count++;
        size--;
      }
    }
    System.out.println("Foram recebidas " + count + " mensagens");
  }

  public void totalOfReceivedMessagesBySender(String sender) {
    var count = 0;
    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      if (sender.equals(entry.getKey())) {
        var size = entry.getValue().size();
        while (size > 0) {
          count++;
          size--;
        }
      }
    }
    System.out.println("Total de mensagens enviadas por " + sender + " = " + count);
  }

  public List<String> listOfMessagesWithSubjectKeywords(List<String> keywords) {
    
    return null;
  }



}