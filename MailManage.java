package br.com.ada.email;

import java.util.Arrays;
import java.util.List;

public class MailManage {

  public static void main(String[] args) {

    Message message1 = new Message("daniel@ada.br", "09/12/22", "09/12/22", "exercicio1", "banana");
    Message message2 = new Message("joao@ada.pt", "10/12/22", "10/12/22", "exercicio2", "melancia");
    Message message3 = new Message("joao@ada.pt", "11/12/22", "11/12/22", "exercicio3", "dificil3");
    Message message4 = new Message("maria@ada.br", "12/12/22", "12/12/22", "exercicio4", "dificil4");
    Message message5 = new Message("java@ada.pt", "13/12/22", "13/12/22", "exercicio5", "dificil5");

    MailMap mailMap = new MailMap();
    
    //Guardar um novo mail recebido;

    mailMap.archiveReceived(message1);
    mailMap.archiveReceived(message2);
    mailMap.archiveReceived(message3);
    mailMap.archiveReceived(message4);
    mailMap.archiveReceived(message5);

    //Determinar o total de enderecos a partir dos quais se recebeu mail;

    mailMap.totalOfReceivedMessages();

    //Determinar quantos mails têm por origem um dado endereço;

    mailMap.totalOfReceivedMessagesBySender("joao@ada.pt");

    //Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro;

    List<String> listOfMessagesWithSubjectKeywords = mailMap.listOfMessagesWithSubjectKeywords(Arrays.asList("banana", "melancia"));

    //O mesmo que a questão anterior, mas criando um conjunto contendo os mails;

    List<String> listOfMessagesWithSpecificSender = mailMap.listOfMessagesWithSpecificSender("daniel@ada", "joao@ada");

    //Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro;

    mailMap.cleanMessagesBeforeDate("12/12/22");

    //Criar uma lista dos endereços que hoje enviaram mails;

    List<String> messagesSentToday = mailMap.messagesSentToday();
    
    //Eliminar todos os mails de um dado endereço anteriores a uma data dada;

    mailMap.cleanMessagesFromSenderBeforeDate("daniel@ada", "12/12/22");

    //Criar uma listagem com todos os endereços de mail oriundos de Portugal;

    List<String> sendersFromSomeCountry("pt");


  }
  
}
