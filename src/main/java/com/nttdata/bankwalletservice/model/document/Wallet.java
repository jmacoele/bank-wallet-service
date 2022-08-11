package com.nttdata.bankwalletservice.model.document;

import com.nttdata.bankwalletservice.model.document.type.WalletIdentityNumberTypeEnum;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Credit Class.
 *
 * @author jmacoele
 *
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "wallets")
public class Wallet {

  @Id
  private String id;

  private String name;
  
  private String cellPhoneNumber;
  
  private String email;
  
  private String imei;

  private WalletIdentityNumberTypeEnum identityNumberType;

  private String identityNumber;

  private Double balance;

  private String debitCard;

  private List<WalletMovement> movements;

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;

  @CreatedBy
  private String createdBy;

  @LastModifiedBy
  private String updatedBy;

}