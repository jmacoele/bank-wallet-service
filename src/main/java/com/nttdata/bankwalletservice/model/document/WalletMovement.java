package com.nttdata.bankwalletservice.model.document;

import com.nttdata.bankwalletservice.model.document.type.WalletStateTypeEnum;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Credit Payment Class.
 *
 * @author jmacoele
 *
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "walletmovements")
public class WalletMovement {

  @Id
  private Long id;

  @CreatedDate
  private LocalDateTime date;

  private String shortDescription;

  private Double amount;
  
  private WalletStateTypeEnum state;

  private String clientAnnotation;

}
