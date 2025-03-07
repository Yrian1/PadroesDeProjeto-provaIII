package br.edu.ifba.inf011.model.fm;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import br.edu.ifba.inf011.academico.DatabaseAcademico;
import br.edu.ifba.inf011.model.Calendario;
import br.edu.ifba.inf011.model.Equipe;
import br.edu.ifba.inf011.model.Geolocalizacao;
import br.edu.ifba.inf011.model.adapter.AulaObjectAdapter;
import br.edu.ifba.inf011.model.decorator.OnlineCalendarioDecorator;
import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.evento.Lembrete;
import br.edu.ifba.inf011.model.evento.Partida;
import br.edu.ifba.inf011.model.evento.TipoEvento;
import br.edu.ifba.inf011.model.evento.builder.BuilderPartida;
import br.edu.ifba.inf011.model.cor.EmailHandler;
import br.edu.ifba.inf011.model.cor.GoogleCalendarHandler;
import br.edu.ifba.inf011.model.cor.Handler;
import br.edu.ifba.inf011.model.cor.Notificador;
import br.edu.ifba.inf011.model.cor.WhatsAppHandler;

public class Aplicacao extends AplicacaoCalendario{

	
	@Override
	protected Calendario createCalendario(){
		try {
			return 
					new OnlineCalendarioDecorator(
							new OnlineCalendarioDecorator(
									new CalendarioPessoal("inf011@ads.ifba.edu.br", 12, 2024), 
							"http://feriados.com"),
					"http://detroitlions.com");
		}catch(Exception ex) {
			return new CalendarioPessoal("inf011@ads.ifba.edu.br", 12, 2024);
		}	
	}

	public void run2() throws Exception {
		// Cria os handlers
        Handler whatsAppHandler = new WhatsAppHandler();
        Handler emailHandler = new EmailHandler();
        Handler googleCalendarHandler = new GoogleCalendarHandler();

        // Monta a cadeia
      
        googleCalendarHandler.setProximo(whatsAppHandler);
        whatsAppHandler.setProximo(emailHandler);

        // Cria o notificador com a cadeia
        Notificador notificador = new Notificador(googleCalendarHandler);

        // Cria um evento
        Evento evento = new Partida(null, null, null, null, null/* parâmetros do evento */, null, null, null, null);
        evento.setPrioridade(4);
		evento.setDescricao("Fred torce pro bahia");
        evento.setDataInicio(LocalDateTime.now());

        // Notifica o evento
        notificador.notificar(evento);
    }
		
	
	
	
	
public void run() throws Exception {
		
		DatabaseAcademico database = new DatabaseAcademico();
		
		this.adicionarEvento(((BuilderPartida) 
				  			   Partida.builder()
				  					  .setInicio(LocalDateTime.of(1970, 6, 21, 12, 0))
				  					  .setLocalizacao(new Geolocalizacao("Estádio Azteca - Cidade do México")))
					  				  .setPlacar(4, 1)
					  				  .build("Final da Copa do Mundo de 1970", new Equipe("Brasil"), new Equipe("Italia")));
		
		this.adicionarEvento(Lembrete.builder()
							.setInicio(LocalDateTime.of(2025, 02, 03, 19, 30))
							.build(TipoEvento.LEMBRETE, "Avaliação II de Padrões de Projeto"));
		
		this.adicionarEvento(Lembrete.builder()
				.setInicio(LocalDateTime.now())
				.build(TipoEvento.LEMBRETE, "Reunião Semanal"));
		
		this.adicionarEvento(Lembrete.builder()
				.setInicio(LocalDateTime.of(2025, 02, 28, 19, 30))
				.build(TipoEvento.LEMBRETE, "Avaliação III de Padrões de Projeto"));
		
		this.adicionarEvento(new AulaObjectAdapter(database.getAula("INF011")));
		
		
		Collection<Evento> hoje = this.today();
		
		for(Evento e : hoje)
			System.out.println(e.getDescricao());
		
	}
	



	public static void main(String[] args) throws Exception {
		(new Aplicacao()).run();
	}

}
