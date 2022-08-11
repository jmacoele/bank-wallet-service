package com.nttdata.bankwalletservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * Bank Credit Service Application.
 *
 * @author jmacoele
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class BankWalletServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BankWalletServiceApplication.class, args);
  }

}
