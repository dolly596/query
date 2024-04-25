package com.turma.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turma.entities.Aluno;
import com.turma.service.AlunoService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/aluno")
public class AlunoController {
		
		private final AlunoService AlunoService;

		@Autowired
		public AlunoController(AlunoService AlunoService) {
			this.AlunoService = AlunoService;
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Aluno> buscaAlunoIdControlId (@ PathVariable Long id) {
			Aluno Aluno = AlunoService.buscaAlunoId(id);
			if (Aluno != null) {
				return ResponseEntity.ok(Aluno);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		
		//@query
		@GetMapping("/nome/{nome}")
		public List<Aluno> findAlunosPorNome(@PathVariable String nome){
			return AlunoService.findByNome(nome);
		}
		//@query
		@GetMapping("/nome-completo/{nomecompleto}")
		public List<Aluno> findAlunosPorNomeCompleto(@PathVariable String nomecompleto){
		return AlunoService.findByNomeCompletoLike(nomecompleto);
		}
		@GetMapping("/cidade/{cidade}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade){
			List<Aluno> Aluno = AlunoService.buscarAlunosPorCidade(cidade);
			return ResponseEntity.ok(Aluno);
		}
		/*@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorNomeControl(@PathVariable String nome){
			List<Aluno> Aluno = AlunoService.buscarAlunosPorNome(nome);
			return ResponseEntity.ok(Aluno);
		}*/
		
		@GetMapping("/renda/{renda}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorRendaControl(@PathVariable Double renda){
			List<Aluno> Aluno = AlunoService.buscarAlunosPorRenda(renda);
			return ResponseEntity.ok(Aluno);
		}
		@GetMapping("/ra/{ra}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorRaControl(@PathVariable String ra){
			List<Aluno> Aluno = AlunoService.buscarAlunosPorRa(ra);
			return ResponseEntity.ok(Aluno);
		}
		@GetMapping("/cidade/{cidade}/renda/{renda}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorCidadeRendaControl(@PathVariable String cidade, @PathVariable Double renda){
			List<Aluno> Aluno = AlunoService.buscarAlunosPorCidadeERenda(cidade, renda);
			return ResponseEntity.ok(Aluno);
		}
		
		
		@GetMapping("/")
		public ResponseEntity<List<Aluno>> buscaTodosAlunoControl(){
			List<Aluno> Aluno = AlunoService.buscaTodosAluno();
			return ResponseEntity.ok(Aluno);
		}
		
		@PostMapping("/")
		public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody  Aluno Aluno){
			Aluno salvaAluno= AlunoService.salvaAluno(Aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Aluno> alterarAlunoControl(@PathVariable Long id, @RequestBody Aluno Aluno){
			Aluno alterarAluno = AlunoService.alterarAluno(id, Aluno);
			if(alterarAluno != null) {
				return ResponseEntity.ok(alterarAluno);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){
			boolean Aluno = AlunoService.apagarAluno(id);
			if (Aluno) {
				return ResponseEntity.ok().body("O Aluno foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}