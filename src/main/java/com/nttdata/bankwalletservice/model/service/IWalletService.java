package com.nttdata.bankwalletservice.model.service;

import com.nttdata.bankwalletservice.model.document.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ICreditService Interface.
 *
 * @author jmacoele
 *
 */

public interface IWalletService {

  Mono<Wallet> findById(String id);

  Flux<Wallet> findAll();

  Mono<Boolean> existsById(String id);

  Mono<Wallet> save(Wallet wallet) throws Exception;

  Mono<Wallet> save(String id, Wallet wallet) throws Exception;

  Mono<Wallet> delete(String id);

}
