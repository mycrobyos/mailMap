package br.com.ada.mm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MailMap {

  Map<String, Set<Message>> arquivo = new HashMap<>();
  private int length;

  public Map<String, Set<Message>> getArquivo() {
    return arquivo;
  }

  public Map<String, Set<Message>> archiveReceived(Message message) {

    if (!arquivo.containsKey(message.sender)) {
      Set<Message> messages = new HashSet<>();
      messages.add(message);
      this.arquivo.put(message.getSender(), messages);
    } else {
      var existingSenderMessages = this.arquivo.get(message.sender);
      existingSenderMessages.add(message);
      arquivo.put(message.getSender(), existingSenderMessages);
    }

    return this.arquivo;
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

  public void listOfMessagesWithSubjectKeywords(List<String> keywords) {
    List<String> matches = new ArrayList<>();

    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      for (Message message : entry.getValue()) {
        for (int i = 0; i < keywords.size(); i++) {
          if (message.getSubject().contains(keywords.get(i))) {
            matches.add(entry.getKey());
          }
        }
      }
    }
    System.out.println("Remetente(s) encontrado(s) com o(s) critério(s) especificado(s): " + matches);
  }

  public void listOfMessagesWithSpecificSender(List<String> senders) {
    List<String> matches = new ArrayList<>();

    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      for (int i = 0; i < senders.size(); i++) {
        if (entry.getKey().contains(senders.get(i))) {
          matches.add(entry.getKey());
        }
      }
    }
    System.out.println("Remetente(s) encontrado(s): " + matches);
  }

  public void cleanMessagesBeforeDate(String date, Map<String, Set<Message>> arquivo) throws ParseException {
    var parameter = dateParser(date);
    var messagesToBeDeleted = new HashMap<String, Set<Message>>();

    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      for (Message message : entry.getValue()) {
        if (message.getSentDate().before(parameter)) {
          messagesToBeDeleted.put(entry.getKey(), entry.getValue());
        }
      }
    }
    for (Map.Entry<String, Set<Message>> entry : messagesToBeDeleted.entrySet()) {
      arquivo.remove(entry.getKey());
    }
    System.out.println("As seguintes mensagens que antecedem " + date + " foram removidas:\n" + messagesToBeDeleted);
  }

  public List<String> peopleWhoSentToday() throws ParseException {
    List<String> peopleWhoSentToday = new ArrayList<>();
    Calendar today = Calendar.getInstance();
    today.set(Calendar.HOUR_OF_DAY, 0);

    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      for (Message message : entry.getValue()) {
        if (message.getSentDate().equals(today.getTime())) {
          peopleWhoSentToday.add(entry.getKey());
        }
      }
    }
    return peopleWhoSentToday;
  }

  public void cleanMessagesFromSenderBeforeDate(String sender, String date) throws ParseException {
    var messagesFromSenderToBeChecked = new HashMap<String, Set<Message>>();

    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      if (sender.equals(entry.getKey())) {
        messagesFromSenderToBeChecked.put(entry.getKey(), entry.getValue());
      }
    }
    cleanMessagesBeforeDate(date, messagesFromSenderToBeChecked);
  }

  public void sendersFromSomeCountry(String country) {
    List<String> sendersFromCountry = new ArrayList<>();

    for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
      length = entry.getKey().length();

      if (country.equals(entry.getKey().substring(length - 2, length))) {
        sendersFromCountry.add(entry.getKey());
      }
    }
    System.out.println(sendersFromCountry);
  }

  private Date dateParser(String date) throws ParseException {
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yy");
    var parameter = sdf1.parse(date);
    return parameter;
  }

  public void antiSpam(List<String> keywords) {
    var messagesToBeDeleted = new HashMap<String, Set<Message>>();

    for (String keyword : keywords) {
      for (Map.Entry<String, Set<Message>> entry : arquivo.entrySet()) {
        for (Message message : entry.getValue()) {
          if (message.getSubject().contains(keyword)) {
            messagesToBeDeleted.put(entry.getKey(), entry.getValue());
          }
        }
      }
    }

    for (Map.Entry<String, Set<Message>> entry : messagesToBeDeleted.entrySet()) {
      arquivo.remove(entry.getKey());
    }
    System.out.println("As seguintes mensagens com palavras proibidas foram removidas:\n" + messagesToBeDeleted);


  }

}
