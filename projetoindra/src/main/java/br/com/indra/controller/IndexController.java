package br.com.indra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indra.model.Pessoa;
import br.com.indra.repository.PessoaRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class IndexController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoa")
	@ApiOperation(value = "Mostrar todos os cadastros", notes = "Essa operação retorna todos os cadastros")
	public List<Pessoa> listaPessoa() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/pessoa/{id}")
	@ApiOperation(value = "Mostrar cadastro por ID", notes = "Operação que retorna o cadastro do ID passado")
	public Pessoa listaPessoaId(@PathVariable(value = "id") long id) {
		return pessoaRepository.findById(id);
	}

	@PostMapping("/pessoa")
	@ApiOperation(value = "Cadastrar uma nova pessoa", notes = "Essa operação salva um novo registro com as informações de pessoa.")
	public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@DeleteMapping("/pessoa")
	@ApiOperation(value = "Deletar cadastro por ID", notes = "Operação que exclui o cadastro de acordo com o ID passado")
	public String deletarCadastro(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
		return "Cadastro id " + pessoa.getId() + " deletado";
	}

	@PutMapping("/pessoa")
	@ApiOperation(value = "Alterar Cadastro por ID", notes = "Operação que alterar o cadastro do ID passado")
	public Pessoa atualizarCadastro(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}