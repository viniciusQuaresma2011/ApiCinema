package com.cinema.tests;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;


import com.cinema.model.Endereco;
import com.cinema.model.Filme;
import com.cinema.model.Ingresso;
import com.cinema.model.Sessao;
import com.cinema.model.Usuario;

import com.cinema.repository.FilmeRepository;



@SpringBootTest
@Configuration
class CinemaSistemaApplicationTests {

	
	
	
	private static FilmeRepository filmeRepository;
	
	
	@Test
	public void testeUsuario() {
		Endereco endereco = new Endereco();
		endereco.setRua("bom jesus");
		endereco.setCep("123456");
		endereco.setEstado("PE");
		endereco.setLogradouro("Uf");
		endereco.setPonto_referencia("perto do cais");
		
		Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setEmail("teste@gmail.com");
		usuario.setTelefone("882254886");
		usuario.setEndereco(endereco);
		
		Assertions.assertEquals("bom jesus", usuario.getEndereco().getRua());
		Assertions.assertEquals("123456", usuario.getEndereco().getCep());
		Assertions.assertEquals("PE", usuario.getEndereco().getEstado());
		Assertions.assertEquals("Uf", usuario.getEndereco().getLogradouro());
		Assertions.assertEquals("perto do cais", usuario.getEndereco().getPonto_referencia());
		
		Assertions.assertEquals("teste", usuario.getNome());
		Assertions.assertEquals("teste@gmail.com", usuario.getEmail());
		Assertions.assertEquals("882254886", usuario.getTelefone());
		Assertions.assertEquals(endereco, usuario.getEndereco());
	}


	@Test
	public void testeFilme() {
	
		Filme filme = new Filme();
		filme.setId_filme(12L);
		filme.setNome("teste1");
		filme.setAno_lancamento("2018");
		filme.setDuracao("2 horas");
		filme.setDirecao("havoc");
		filme.setOrigem("nordico");
		filme.setDublagem("portugues/ingles");
		filme.setTipo("Acao");
		
		Filme filme2 = new Filme();
		filme2.setId_filme(12L);
		filme2.setNome("teste2");
		filme2.setAno_lancamento("2017");
		filme2.setDuracao("02:30");
		filme2.setDirecao("havoc2");
		filme2.setOrigem("nordico2");
		filme2.setDublagem("portugues/ingles2");
		filme2.setTipo("Acao2");
		
		List<Filme> filmes = new ArrayList();
		filmes.add(filme);
		filmes.add(filme2);
		
		
	
	
		
		Assertions.assertEquals("teste1", filme.getNome());
		Assertions.assertEquals("2018", filme.getAno_lancamento());
		Assertions.assertEquals("2 horas", filme.getDuracao());
		Assertions.assertEquals("havoc", filme.getDirecao());
		Assertions.assertEquals("nordico" , filme.getOrigem());
		Assertions.assertEquals("portugues/ingles", filme.getDublagem());
		Assertions.assertEquals("Acao" , filme.getTipo());
		
		Assertions.assertEquals("teste2", filme.getNome());
		Assertions.assertEquals("2017", filme.getAno_lancamento());
		Assertions.assertEquals("02:30", filme.getDuracao());
		Assertions.assertEquals("havoc2", filme.getDirecao());
		Assertions.assertEquals("nordico2" , filme.getOrigem());
		Assertions.assertEquals("portugues/ingles2", filme.getDublagem());
		Assertions.assertEquals("Acao2" , filme.getTipo());
		
		
		for (int i = 0; i < filmes.size(); i++) {
			Filme film = filmes.get(i);
			String nomeFilme = film.getNome();
			String anoLancamento = film.getAno_lancamento();
			String duracaoFilme = film.getDuracao();
			
			
			if(i == 0) {
				Assertions.assertEquals("teste1", nomeFilme);
				Assertions.assertEquals("2018", anoLancamento);
				Assertions.assertEquals("2 horas", duracaoFilme);
			}
			
			if(i == 1) {
				Assertions.assertEquals("teste2", nomeFilme);
				Assertions.assertEquals("2017", anoLancamento);
				Assertions.assertEquals("02:30", duracaoFilme);
			}
			
			
		}
		
		
		
	}
	
	@Test
	public void testeSessao() {
		Sessao sessao = new Sessao();
		sessao.setNome("sessao 1");
		sessao.setHorario("13:00");
		sessao.setDisponibilidade("Sim");
		
		
		
		
		Assertions.assertEquals("sessao 1" , sessao.getNome());
		Assertions.assertEquals("13:00", sessao.getHorario());
		Assertions.assertEquals("Sim", sessao.getDisponibilidade());
	}
	
	@Test
	public void testeIngresso() {
		Ingresso ingresso = new Ingresso();
		//Usuario usuario = usuarioRepository.findAll();
		//ingresso.setUsuario();
	}
	

}
