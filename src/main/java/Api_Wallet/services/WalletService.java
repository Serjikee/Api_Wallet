package Api_Wallet.services;

import Api_Wallet.exception.WalletNotFoundException;
import Api_Wallet.models.Wallet;
import Api_Wallet.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WalletService {
    @Autowired
    WalletRepository repository;

    public List<Wallet> getAll() {
        return repository.findAll();
    }

    public String getById(int uuid) {
        String res = "Баланс = " + repository.findByUuidIs(uuid);
        return res;
    }

    public void operation(Wallet wallet) {
        var res = repository.findByUuidEquals(wallet.getUuid()).orElseThrow(WalletNotFoundException::new);
        String op = wallet.getOperationType().toUpperCase();
        Wallet newWallet = repository.findByUuidEquals(wallet.getUuid()).get();
        int newAmount;

        if (op.equals("DEPOSIT")) {

            newAmount = newWallet.getAmount() + wallet.getAmount();
            newWallet.setAmount(newAmount);
            newWallet.setOperationType(op);
            repository.save(newWallet);

        } else if (op.equals("WITHDRAW")) {

            newAmount = newWallet.getAmount() - wallet.getAmount();

            if (newAmount >= 0) {
                newWallet.setAmount(newAmount);
                newWallet.setOperationType(op);
                repository.save(newWallet);
            }
        }
    }

    public void create(Wallet wallet) {
        if (wallet.getAmount() == null) {
            wallet.setAmount(0);
        }
        repository.save(wallet);
    }
}
