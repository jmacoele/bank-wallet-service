package com.nttdata.bankwalletservice.events;

import com.nttdata.bankwalletservice.entity.WalletDebitCard;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * Waller Card Associated Event Class.
 *
 * @author jmacoele
 *
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class WalletCardAsociatedEvent extends Event<WalletDebitCard> {

}
