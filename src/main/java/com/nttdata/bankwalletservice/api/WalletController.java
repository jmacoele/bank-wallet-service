package com.nttdata.bankwalletservice.api;

import com.nttdata.bankwalletservice.model.document.Wallet;
import com.nttdata.bankwalletservice.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Wallet Service.
 *
 * @author jmacoele
 *
 */

@RestController
@RequestMapping("/wallets")
@Slf4j
public class WalletController {

  @Autowired
  private WalletService walletService;

  @GetMapping
  @Operation(summary = "Get list of Wallets")
  public Flux<Wallet> getAll() {
    log.info("getAll" + "OK");
    return walletService.findAll().log();
  }

  @GetMapping("{id}")
  @Operation(summary = "Get Wallet by Id")
  public Mono<Wallet> getById(@PathVariable("id") final String id) {
    log.info("getById: " + id);
    return walletService.findById(id).log();
  }

  @PutMapping("{id}")
  @Operation(summary = "Update Wallet by Id")
  public Mono<Wallet> updateById(@PathVariable("id") final String id,
      @RequestBody final Wallet wallet) throws Exception {
    log.info("update: " + id);
    return walletService.save(id, wallet).log();
  }

  @PostMapping (
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create Wallet")
  public Mono<Wallet> create(@RequestBody final Wallet wallet) throws Exception {
    log.info("create: " + wallet.getId());
    return walletService.save(wallet).log();
  }

  @DeleteMapping("{id}")
  @Operation(summary = "Delete Wallet")
  public Mono<Wallet> delete(@PathVariable final String id) {
    log.info("delete: " + id);
    return walletService.delete(id).log();
  }

  @GetMapping("/exists/{id}")
  @Operation(summary = "verify existence of Wallet")
  public Mono<Boolean> existsById(@PathVariable("id") final String id) {
    log.info("exists by: " + id);
    return walletService.existsById(id).log();
  }
}