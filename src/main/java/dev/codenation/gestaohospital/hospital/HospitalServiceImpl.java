package dev.codenation.gestaohospital.hospital;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import dev.codenation.gestaohospital.estoque.Estoque;
import dev.codenation.gestaohospital.exceptions.NenhumResultadoException;
import dev.codenation.gestaohospital.leito.Leito;
import dev.codenation.gestaohospital.leito.TipoAcomodacaoEnum;
import dev.codenation.gestaohospital.paciente.Paciente;
import dev.codenation.gestaohospital.paciente.PacienteRepository;
import dev.codenation.gestaohospital.paciente.PacienteResource;
import dev.codenation.gestaohospital.paciente.PacienteServiceImpl;
import dev.codenation.gestaohospital.padrao.Paginacao;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	@Autowired
	private PacienteRepository pacienteRepository;

	private final Function<? super Hospital, ? extends HospitalResource> MAPPER = objeto -> HospitalResource.builder()
			.comId(objeto.getId()).comQuantidadeLeitos(objeto.getQuantidadeLeitos()).comLeitosDisponiveis(objeto.getLeitosDisponiveis())
			.comLocation(objeto.getLocation()).comNome(objeto.getNome()).comEstoque(objeto.getEstoque()).comLeitos(objeto.getLeitos()).build();

	@Override
	public GeoResults<Hospital> localizar(double longitude, double latitude, double distancia) {
		
		Optional.of(distancia).filter(d -> d > 0)
				.orElseThrow(() -> new IllegalArgumentException("Distancia do raio de pesquisa nao pode ser negativa"));
		
		return repository.findByLocationNear(new Point(longitude, latitude),
				new Distance(distancia, Metrics.KILOMETERS));
	}

	@Override
	public List<Estoque> listarEstoque(String id) {
		Optional<Hospital> findById = repository.findById(id);
		if (!findById.isPresent()) {
			throw new NenhumResultadoException("Nenhum hospital encontrado");
		}
		return findById.map(Hospital::getEstoque).orElse(Collections.emptyList());
	}

	protected HospitalRepository getRepository() {
		return repository;
	}

	@Override
	public List<HospitalResource> listar() {

		return getRepository().findAll().stream().map(MAPPER).collect(Collectors.toList());
	}

	@Override
	public Paginacao<HospitalResource> pesquisar(Paginacao<HospitalResource> paginacao) {
		Pageable pageable = PageRequest.of(paginacao.getPagina(), paginacao.getTamanhoPagina());
		Page<Hospital> find = getRepository().findAll(pageable);
		paginacao.setTotalRegistros(find.getTotalElements());
		paginacao.setResultado(find.getContent().stream().map(MAPPER).collect(Collectors.toList()));

		return paginacao;
	}

	@Override
	public HospitalResource cadastrar(Hospital objeto) {
		return MAPPER.apply(getRepository().insert(objeto));
	}

	@Override
	public HospitalResource alterar(Hospital objeto) {
		return MAPPER.apply(getRepository().save(objeto));
	}

	@Override
	public Optional<HospitalResource> obterPorId(String id) {
		return getRepository().findById(id).map(MAPPER);
	}

	@Override
	public void excluir(String id) {
		getRepository().deleteById(id);
	}

	@Override
	public void checkin(String idHospital, String idPaciente) {
		Optional<Hospital> op = getRepository().findById(idHospital);
		Optional<Paciente> opPaciente = pacienteRepository.findById(idPaciente);
		
		if (op.isPresent() && opPaciente.isPresent()) {
			Hospital hospital = op.get();
			Paciente paciente = opPaciente.get();
			Leito leito = new Leito();
			leito.setDataEntrada(new Date());
			leito.setTipoAcomodacao(TipoAcomodacaoEnum.APARTAMENTO);
			leito.setPaciente(paciente);
			hospital.setLeitosDisponiveis(Integer.sum(hospital.getLeitosDisponiveis(), -1));
			hospital.getLeitos().add(leito);
			
			getRepository().save(hospital);
		}
	}
	
	@Override
	public void checkout(String idHospital, String idPaciente) {
		Optional<Hospital> op = getRepository().findById(idHospital);
		Optional<Paciente> opPaciente = pacienteRepository.findById(idPaciente);
		
		if (op.isPresent() && opPaciente.isPresent()) {
			Hospital hospital = op.get();
			Optional<Leito> findFirst = hospital.getLeitos().stream().filter(leito -> leito.getPaciente().getId().equals(idPaciente)).findFirst();
			if (findFirst.isPresent()) {
				findFirst.get().setDataSaida(new Date());
			}
			hospital.setLeitosDisponiveis(Integer.sum(hospital.getLeitosDisponiveis(), 1));
			getRepository().save(hospital);
		}
	}

	@Override
	public List<PacienteResource> pacientes(String id) {
		Optional<Hospital> findById = repository.findById(id);
		List<PacienteResource> pacientes = Collections.emptyList(); 
		if (findById.isPresent()) {
			Hospital hospital = findById.get();
			pacientes = hospital.getLeitos().stream().map(Leito::getPaciente).map(PacienteServiceImpl.MAPPER).collect(Collectors.toList());
		}
		return pacientes;
	}

}
