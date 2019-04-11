package dev.codenation.gestaohospital;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.codenation.gestaohospital.hospital.Hospital;
import dev.codenation.gestaohospital.padrao.Paginacao;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class HospitalTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    private String id = "5cad7eaad942f909fc285675";

    //PARA TESTAR CADASTRO
    private String nomeHospital = "Hospital NotreDame";
    private int quantidadeLeitos = 10;

    private double longitude = 12;
    private double latitude = 12;
    private double distancia = 3;

    public HospitalTest() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Test
    public void cadastra() throws ParseException, IOException {
        Hospital hospital = new Hospital();
        hospital.setNome(nomeHospital);
        hospital.setQuantidadeLeitos(quantidadeLeitos);
        hospital.setLeitosDisponiveis(quantidadeLeitos);

        ResponseEntity<String> response = restTemplate.exchange("/v1/hospitais", HttpMethod.POST, new HttpEntity<>(mapper.writeValueAsString(hospital), httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisa() {
        Paginacao<?> response = restTemplate.getForObject("/v1/hospitais", Paginacao.class);
        assertThat(response).isNotNull();
    }

    @Test
    public void pesquisaPorId() throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/hospitais/"+id, String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void listaEstoque() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/hospitais/"+id+"/estoque",String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void localizaHospitalMaisProximo() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/hospitais/localizar?lon="+longitude+"&lat="+latitude+"&distancia="+distancia, String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
