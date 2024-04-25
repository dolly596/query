package com.turma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turma.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByRenda(Double renda);
	List<Aluno> findByRa(String ra);
	List<Aluno> findByCidadeAndRenda(String cidade, Double renda);
	@Query("SELECT a FROM Aluno a WHERE a.nome = :nome")
	List<Aluno> findByNome (@Param("nome") String nome);
	@Query("SELECT a FROM Aluno a WHERE a.nomecompleto = :nomecompleto")
	List<Aluno> findByNomeCompletoLike (@Param("nomecompleto") String nomecompleto);
	@Query("SELECT a FROM Aluno a Join a.turma t WHERE t.id = :turmaId")
	List<Aluno> findByTurmaId (@Param("turmaId") Long turmaId);

}