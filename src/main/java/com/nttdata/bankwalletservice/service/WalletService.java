package com.nttdata.bankwalletservice.service;

import com.nttdata.bankwalletservice.model.document.Wallet;
import com.nttdata.bankwalletservice.model.repository.IWalletRepository;
import com.nttdata.bankwalletservice.model.service.IWalletService;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Credit Service.
 *
 * @author jmacoele
 *
 */

@Service
public class WalletService implements IWalletService {

  @Autowired
  private IWalletRepository walletRepository;

  @Override
  public Mono<Wallet> findById(String id) {
    return this.walletRepository.findById(id)
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Flux<Wallet> findAll() {
    return this.walletRepository.findAll()
        .switchIfEmpty(Flux.empty());
  }

  @Override
  public Mono<Wallet> save(Wallet wallet) throws Exception {
    wallet.setId(UUID.randomUUID().toString());
    return this.walletRepository.save(wallet);
  }

  @Override
  public Mono<Wallet> save(String id, Wallet wallet)
      throws Exception {
    return this.walletRepository.save(wallet);
  }

  @Override
  public Mono<Wallet> delete(String id) {
    final Mono<Wallet> wallet = findById(id);
    if (Objects.isNull(wallet)) {
      return Mono.empty();
    }
    return findById(id).switchIfEmpty(Mono.empty())
        .filter(Objects::nonNull)
        .flatMap(walletToBeDeleted -> this.walletRepository
            .delete(walletToBeDeleted)
            .then(Mono.just(walletToBeDeleted)));
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return this.walletRepository.existsById(id);
  }
}
