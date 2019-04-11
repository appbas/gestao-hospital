package dev.codenation.gestaohospital;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.codenation.gestaohospital.produto.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class ProdutoTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    //PARA TESTAR CADASTRO
    private String nome = "Bolsão de sangue o+";
    private String descricao = "Doação";
    private String descricaoTipo = "Banco de Sangue";

    public ProdutoTest() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Test
    public void cadastra() throws ParseException, IOException {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);

        ResponseEntity<String> response = restTemplate.exchange("/v1/produtos", HttpMethod.POST, new HttpEntity<>(mapper.writeValueAsString(produto), httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisa() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/produtos", String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
