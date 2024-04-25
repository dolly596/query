package com.turma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turma.entities.Aluno;
import com.turma.entities.Turma;
import com.turma.repository.TurmaRepository;

@Service
public class TurmaService {
	
	private final TurmaRepository TurmaRepository;

	@Autowired
	public TurmaService(TurmaRepository TurmaRepository) {
		this.TurmaRepository = TurmaRepository;
	}

	public List<Turma> buscaTodosTurma(){
		return TurmaRepository.findAll();
	}
	public List<Turma> buscarTurmaPorDescricao(String descricao){
		return TurmaRepository.findByDescricao(descricao);
	}
	public List<Turma> buscarTurmaPorNome(String nome){
		return TurmaRepository.findByNome(nome);
	}
	public List<Turma> buscarTurmaPorNomeEDesc(String nome, String descricao){
		return TurmaRepository.findByNomeAndDescricao(nome, descricao);
	}
	public Turma buscaTurmaId (Long id) {
		Optional <Turma> Turma = TurmaRepository.findById(id);
		return Turma.orElse(null);			
	}

	public Turma salvaTurma(Turma Turma) {
		return TurmaRepository.save(Turma);
	}

	public Turma alterarTurma(Long id, Turma alterarTurma) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			alterarTurma.setId(id);
			return TurmaRepository.save(alterarTurma);
		}
		return null;
	}

	public boolean apagarTurma(Long id) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			TurmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}