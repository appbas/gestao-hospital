package dev.codenation.gestaohospital.tipoproduto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/tipos-produtos")
public class TipoProdutoController {
	
	@Autowired
	private TipoProdutoServiceImpl service;
	
	@GetMapping("/todos")
	public List<TipoProduto> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Optional<TipoProduto> obterPorId(@RequestParam("id") String id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public TipoProduto cadastrar(@RequestBody TipoProduto tipoProduto) {
		return service.cadastrar(tipoProduto);
	}

}
