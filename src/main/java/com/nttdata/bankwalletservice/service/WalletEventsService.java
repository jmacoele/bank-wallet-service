package com.nttdata.bankwalletservice.service;


import com.nttdata.bankwalletservice.entity.WalletDebitCard;
import com.nttdata.bankwalletservice.events.Event;
import com.nttdata.bankwalletservice.events.EventType;
import com.nttdata.bankwalletservice.events.WalletCardAsociatedEvent;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
/**
 * Kafka Wallet Events Service class.
 *
 * @author jmacoele
 *
 */

@Component
public class WalletEventsService {
  
  @Autowired
  private KafkaTemplate<String, Event<?>> producer;
  
  @Value("${topic.customer.name:customers}")
  private String topicCustomer;
  
  /**
   * register a debit card method.
   *
   * @param debitCard debit card.
   */
  
  public void registerDebitCard(WalletDebitCard debitCard) {

    WalletCardAsociatedEvent created = new WalletCardAsociatedEvent();
    created.setData(debitCard);
    created.setId(UUID.randomUUID().toString());
    created.setType(EventType.REGISTER_DEBITCARD);
    created.setDate(new Date());

    this.producer.send(topicCustomer, created);
  }
  
  

}