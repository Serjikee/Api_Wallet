package Api_Wallet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"wallet\"")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid", nullable = false)
    private Integer uuid;

    @Column(name = "\"operationType\"", length = 10)
    private String operationType;

    @Column(name = "amount")
    private Integer amount;

    public Wallet(Integer uuid, String operationType, Integer amount) {
        this.uuid = uuid;
        this.operationType = operationType;
        this.amount = amount;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
