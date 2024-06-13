package Api_Wallet.repositories;

import Api_Wallet.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Optional<Wallet> findByUuidEquals(Integer uuid);

    @Query("select w.amount from Wallet w where w.uuid = ?1")
    Integer findByUuidIs(Integer uuid);


}
