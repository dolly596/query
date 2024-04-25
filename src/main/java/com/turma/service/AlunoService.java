package com.turma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turma.entities.Aluno;
import com.turma.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private final AlunoRepository AlunoRepository;

	@Autowired
	public AlunoService(AlunoRepository AlunoRepository) {
		this.AlunoRepository = AlunoRepository;
	}

	public List<Aluno> buscaTodosAluno(){
		return AlunoRepository.findAll();
	}
	//@query
	public List<Aluno> findByNome(String nome) {
		return AlunoRepository.findByNome(nome);
	}
	//@query
	public List <Aluno> findByNomeCompletoLike (String nomecompleto) {
		return AlunoRepository.findByNomeCompletoLike(nomecompleto);
	}
	public Aluno buscaAlunoId (Long id) {
		Optional <Aluno> Aluno = AlunoRepository.findById(id);
		return Aluno.orElse(null);			
	}
	
	
		
	public Aluno salvaAluno(Aluno Aluno) {
		return AlunoRepository.save(Aluno);
	}
	
	//Query Method
		public List<Aluno> buscarAlunosPorCidade(String cidade){
			return AlunoRepository.findByCidade(cidade);
		}
		public List<Aluno> buscarAlunosPorNome(String nome){
			return AlunoRepository.findByCidade(nome);
		}
		
		public List<Aluno> buscarAlunosPorRenda(Double renda){
			return AlunoRepository.findByRenda(renda);
		}
		public List<Aluno> buscarAlunosPorRa(String ra){
			return AlunoRepository.findByRa(ra);
		}
		public List<Aluno> buscarAlunosPorCidadeERenda(String cidade, Double renda){
			return AlunoRepository.findByCidadeAndRenda(cidade, renda);
		}
		
	public Aluno alterarAluno(Long id, Aluno alterarAluno) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alterarAluno.setId(id);
			return AlunoRepository.save(alterarAluno);
		}
		return null;
	}

	public boolean apagarAluno(Long id) {
		Optional <Aluno> existeAluno = AlunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			AlunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}