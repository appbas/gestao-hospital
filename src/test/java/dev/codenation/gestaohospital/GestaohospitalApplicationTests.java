package dev.codenation.gestaohospital;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import dev.codenation.gestaohospital.leito.Leito;
import dev.codenation.gestaohospital.leito.LeitoController;
import dev.codenation.gestaohospital.paciente.PacienteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClientException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(SpringExtension.class)
//@AutoConfigureMockMvc
public class GestaohospitalApplicationTests {
	
//	private static final String BASE_PATH = "/v1/hospitais";
//	@Autowired
//	private MockMvc mockMvc;
	
//	@Autowired
//    private TestRestTemplate restTemplate;
	
//	@LocalServerPort
//    private int port;

//	@Test
//	public void contextLoads() throws RestClientException, URISyntaxException {
//		restTemplate.getForEntity(new URI("http://localhost:"+port+"/v1/hospitais").toString(), String.class);
//	}

    @Autowired
    LeitoController controller;

    @Autowired
    PacienteController pacienteController;


    @Test
    public void obterPorIdTest() {
        ResponseEntity<Leito> response = controller.obterPorId("1");
        assertEquals(response.getStatusCode(), ResponseEntity.status(1));
    }

}
