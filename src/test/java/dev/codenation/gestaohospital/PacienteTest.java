package dev.codenation.gestaohospital;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class PacienteTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    private String id = "5cad7eaad942f909fc285675";

    //PARA TESTAR CADASTRO
    private String CPF = "43356787658";
    private String nomeCompleto = "Carlos Santos";
    private Genero genero = Genero.MASCULINO;
    private String dataNascimento = "12-01-1993";

    //PARA TESTAR UPDATE
    private String cpfAtualizado = "43356787658";
    private String nomeAtualizado = "Carlos dos Santos";
    private Genero generoAtualizado = Genero.MASCULINO;
    private String dataNascimentoAtualizada = "12-01-1993";

    public PacienteTest() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Test
    public void cadastra() throws ParseException, IOException {
        Paciente paciente = new Paciente(CPF, nomeCompleto, new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimento), genero);
        ResponseEntity<String> response = restTemplate.exchange("/v1/pacientes", HttpMethod.POST, new HttpEntity<>(mapper.writeValueAsString(paciente), httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void atualiza() throws ParseException {
        Paciente paciente = new Paciente(cpfAtualizado, nomeAtualizado, new SimpleDateFormat("dd-MM-yyyy").parse(dataNascimentoAtualizada), generoAtualizado);
        paciente.setId(id);
        ResponseEntity<String> response = restTemplate.exchange("/v1/pacientes", HttpMethod.PUT, new HttpEntity<>(paciente, httpHeaders), String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisa() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/pacientes", String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisaPorId() throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/pacientes/"+id, String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisaPorNome() {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/pacientes/porNome/"+nomeAtualizado,String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void pesquisaPorCpf() throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/pacientes/porCPF/"+cpfAtualizado, String.class);
        System.out.println("Retorno: "+response.getBody());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
