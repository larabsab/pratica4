package br.com.valueprojects.teste_unidade_2.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.valueprojects.teste_unidade_2.builder.CriadorDeJogo;
import br.com.valueprojects.teste_unidade_2.dominio.Jogo;
import br.com.valueprojects.teste_unidade_2.dominio.Participante;
import br.com.valueprojects.teste_unidade_2.dominio.Resultado;

public class JogoTest {
	@Test
	public void deveTerJogoComUnicoParticipante() {
		Jogo jogo = new Jogo("Jogo de corrida");
		assertEquals(0, jogo.getResultados().size());

		jogo.anota(new Resultado(new Participante("Leonardo"), 150));

		assertEquals(1, jogo.getResultados().size());

		assertEquals(150.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}
	
	

	@Test
	public void deveTerVariosResultados() {
		Jogo jogo = new CriadorDeJogo()
        .para("Cata moedas")
        .resultado(new Participante("Nelson"), 150.0)
        .resultado(new Participante("Pedro"), 200.0)
        .constroi();

		assertEquals(2, jogo.getResultados().size());
		assertEquals(150.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
		assertEquals(200.0, jogo.getResultados().get(1).getMetrica(), 0.00001);
		
	}
	
	//RED - TDD
	
	/* @Test
	    public void verificaMediaTest() {
	      //Arrange  
		 Jogo jogo = new Jogo("Jogo 01");

	        Participante membroUm   = new Participante("Membro Um");
	        Participante membroDois = new Participante("Membro Dois");

	        jogo.anota(new Resultado(membroUm, 500));
	        jogo.anota(new Resultado(membroDois, 500));
//Action + Assert
	        assertEquals(500, jogo.calculaMedia(), 1e-3);
	    }*/
	
	@Test
	public void naoDeveAceitarDoisResultadosDoMesmoParticipante(){

		Jogo jogo = new Jogo("Ca a pe as");
		Participante leonardo = new Participante("Leonardo");

		jogo.anota(new Resultado(leonardo, 500.0));
		//deve ser ignorado
		jogo.anota(new Resultado(leonardo, 600.0));

		assertEquals(1, jogo.getResultados().size());
        assertEquals(500, jogo.getResultados().get(0).getMetrica(), 0.00001);
		}
	
	


}
