package br.com.ada.mm;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class MailManage {

  public static void main(String[] args) throws ParseException {

    Message message1 = new Message("daniel@ada.br", "09/12/22", "banana", "exercicio1");
    Message message2 = new Message("joao@ada.pt", "10/12/22", "melancia", "exercicio2");
    Message message3 = new Message("joao@ada.pt", "11/12/22", "morango", "exercicio3");
    Message message4 = new Message("maria@ada.br", "12/12/22", "manga", "exercicio4");
    Message message5 = new Message("java@ada.pt", "13/12/22", "pera", "exercicio5");
    Message today = new Message("today@ada.pt", "17/12/22", "frutas de hoje", "exercicio6");
    Message jilo = new Message("feira@ada.pt", "17/12/22", "jilo barato", "exercicio7");

    MailMap mailMap = new MailMap();
    
    //Guardar um novo mail recebido;

    mailMap.archiveReceived(message1);
    mailMap.archiveReceived(message2);
    mailMap.archiveReceived(message3);
    mailMap.archiveReceived(message4);
    mailMap.archiveReceived(message5);
    mailMap.archiveReceived(today);
    mailMap.archiveReceived(jilo);

    // Determinar o total de enderecos a partir dos quais se recebeu mail;

    mailMap.totalOfReceivedMessages();

    //Determinar quantos mails têm por origem um dado endereço;

    mailMap.totalOfReceivedMessagesBySender("joao@ada.pt");

    //Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro;

    mailMap.listOfMessagesWithSubjectKeywords(Arrays.asList("banana", "melancia"));

    //O mesmo que a questão anterior, mas criando um conjunto contendo os mails;

    mailMap.listOfMessagesWithSpecificSender(Arrays.asList("daniel@ada.br", "joao@ada.pt", "ada@ada.jp"));

    //Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro;

    mailMap.cleanMessagesBeforeDate("12/12/22", mailMap.getArquivo());

    //Criar uma lista dos endereços que hoje enviaram mails;

    List<String> peopleWhoSentToday = mailMap.peopleWhoSentToday();
    System.out.println(peopleWhoSentToday);

    //Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam);

    mailMap.antiSpam(Arrays.asList("jaca", "jilo", "bucho"));
    
    //Eliminar todos os mails de um dado endereço anteriores a uma data dada;

    mailMap.cleanMessagesFromSenderBeforeDate("java@ada.pt", "15/12/22");

    //Criar uma listagem com todos os endereços de mail oriundos de Portugal;

    mailMap.sendersFromSomeCountry("pt");


  }
  
}
