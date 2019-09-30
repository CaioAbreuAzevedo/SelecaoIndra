package br.com.indra;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.indra.model.Pessoa;
import br.com.indra.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaRepositoryTest {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testeUnitarioCadastrar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setPrimeiroNome("Caio");
		pessoa.setSobrenome("Abreu de Azevedo");
		pessoa.setCpf("00400400401");
		pessoa.setRg("100300500455");
		pessoa.setSexo('M');
		
		this.pessoaRepository.save(pessoa);
		Assertions.assertThat(pessoa.getId()).isNotNull();
		Assertions.assertThat(pessoa.getPrimeiroNome()).isEqualTo("Caio");
	}
	
	@Test
	public void testeUnitarioDeletar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setPrimeiroNome("Caio");
		pessoa.setSobrenome("Abreu de Azevedo");
		pessoa.setCpf("00400400401");
		pessoa.setRg("100300500455");
		pessoa.setSexo('M');

		this.pessoaRepository.save(pessoa);
		pessoaRepository.delete(pessoa);
		
		assertThat(pessoaRepository.findById(pessoa.getId()));
	}
	
}
