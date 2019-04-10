package dev.codenation.gestaohospital;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.repackaged.org.joda.time.Instant;
import dev.codenation.gestaohospital.leito.Leito;
import dev.codenation.gestaohospital.leito.TipoAcomodacaoEnum;
import dev.codenation.gestaohospital.paciente.Genero;
import dev.codenation.gestaohospital.paciente.Paciente;
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
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class LeitoTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    private String id = "5cad7eaad942f909fc285675";
    private String idPaciente = "5cad7eaad942f909fc285675";

    //PARA TESTAR CADASTRO
    private TipoAcomodacaoEnum tipoAcomodacaoEnum = TipoAcomodacaoEnum.APARTAMENTO;
    private String CPF = "41356787658";
    private String nomeCompleto = "Marcos Santos";
    private Genero genero = Genero.MASCULINO;
    private String dataNascimento = "12-01-1993";

    public LeitoTest() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Test
    public void cadastra() throws ParseException, IOException {
        Leito leito = new Leito();
        leito.setTipoAcomodacao(tipoAcomodacaoEnum);
        ResponseEntity<String> response = restTemplate.exchange("/v1/leitos", HttpMethod.POST, new HttpEntity<>(mapper.writeValueAsString(leito), httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void atualiza() throws ParseException {
        Leito leito = new Leito();
        leito.setTipoAcomodacao(tipoAcomodacaoEnum);
        leito.setPaciente(new Paciente(CPF, nomeCompleto, new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimento), genero));

        ResponseEntity<String> response = restTemplate.exchange("/v1/leitos", HttpMethod.PUT, new HttpEntity<>(leito, httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisa() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/leitos", String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisaPorId() throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/leitos/"+id, String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void realizaCheckIn() throws ParseException {
        Leito leito = new Leito();
        leito.getPaciente().setId(idPaciente);
        ResponseEntity<String> response = restTemplate.exchange("/v1/leitos/"+idPaciente+"/check-in", HttpMethod.PUT, new HttpEntity<>(leito, httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void realizaCheckOut() throws ParseException {
        Leito leito = new Leito();
        leito.setId(id);
        leito.getPaciente().setId(idPaciente);
        ResponseEntity<String> response = restTemplate.exchange("/v1/leitos/"+idPaciente+"/check-out", HttpMethod.PUT, new HttpEntity<>(leito, httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
