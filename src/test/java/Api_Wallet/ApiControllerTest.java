package Api_Wallet;

import Api_Wallet.models.Wallet;
import Api_Wallet.repositories.WalletRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WalletRepository repository;

    @Test
    public void getTest() throws URISyntaxException {
        repository.deleteAll();

        Wallet wallet = new Wallet(1, null, 5000);
        repository.save(wallet);

        ResponseEntity<List<Wallet>> responseEntity = restTemplate.exchange(
                new RequestEntity<>(HttpMethod.GET, new URI("http://localhost:8080/api/v1/wallets/1")), new ParameterizedTypeReference<>() {
                });

        Assertions.assertEquals(200, responseEntity.getStatusCode());
        List<Wallet> response = responseEntity.getBody();
        Assertions.assertEquals(1, response.get(0).getAmount());
    }
}
