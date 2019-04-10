package dev.codenation.gestaohospital;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.http.HttpHeaders;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class PacienteTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    public PacienteTest() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }

    @Test
    public void save() throws ParseException, JsonProcessingException {
        Paciente paciente = new Paciente("13456787654", "Thiago Campos", new SimpleDateFormat("dd-MM-yyyy").parse("12-01-1993"), Genero.MASCULINO);
        ResponseEntity<Void> response = restTemplate.exchange("/v1/pacientes", HttpMethod.POST, new HttpEntity<>(mapper.writeValueAsString(paciente), httpHeaders), Void.class);

        assertThat(response.hasBody()).isEqualTo(true);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void update() {
        ResponseEntity<Void> response = restTemplate.exchange("/v1/pacientes", HttpMethod.PUT, new HttpEntity<>("{}", httpHeaders), Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void get() {
        ResponseEntity<Void> response = restTemplate.exchange("/v1/pacientes", HttpMethod.GET, null, Void.class);
        assertThat(response.getBody()).isEqualTo("");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void search() {
        ResponseEntity<Void> response = restTemplate.exchange("/v1/pacientes/1", HttpMethod.GET, null, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
