package com.nttdata.bankwalletservice.model.repository;

import com.nttdata.bankwalletservice.model.document.Wallet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * ICreditRepository interface.
 *
 * @author jmacoele
 *
 */

@Repository
public interface IWalletRepository
    extends ReactiveMongoRepository<Wallet, String> {

}
