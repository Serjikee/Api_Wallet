package Api_Wallet.controllers;


import Api_Wallet.models.Wallet;
import Api_Wallet.repositories.WalletRepository;
import Api_Wallet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    WalletRepository repository;

    @Autowired
    WalletService service;

    @GetMapping("/all")
    public List<Wallet> getWallets() {
        return service.getAll();
    }

    @GetMapping("/wallets/{WALLET_UUID}")
    public String getWalletById(@PathVariable("WALLET_UUID") int WALLET_UUID){
        return service.getById(WALLET_UUID);
    }

    @PostMapping("/wallet")
    public void walletOperation(@RequestBody Wallet wallet){
        service.operation(wallet);
    }

    @PostMapping("/create")
    public void walletCreate(@RequestBody Wallet wallet){
        service.create(wallet);
    }
}
