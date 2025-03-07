package br.edu.ifba.inf011.model.cor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.edu.ifba.inf011.model.evento.Evento;

//Handler para Google Calendar
public class GoogleCalendarHandler implements Handler {
 private Handler proximo;

 @Override
 public void setProximo(Handler proximo) {
     this.proximo = proximo;
 }

 @Override
 public void processar(Evento evento){
	 if (evento.getPrioridade() == null) {
		 System.out.println("prioridade == null");
		 return;
	 }
     if (evento.getPrioridade() >= 1 && evento.getPrioridade() < 5 &&
         evento.iniciaEntre(LocalDateTime.now().minus(2, ChronoUnit.DAYS), LocalDateTime.now())) {
         String formatada = formatarMensagemParaEmail(evento);
         adicionandoEventoAoGoogleCalendar(formatada);
     } 
     if (proximo != null) {
         proximo.processar(evento); // Passa para o próximo handler
     }
 }

 private String formatarMensagemParaEmail(Evento evento) {
     // Lógica de formatação para Email
     return "Google Calendar: " + evento.getDescricao();
 }

 private void adicionandoEventoAoGoogleCalendar(String mensagem) {
     // Lógica de adição ao Google Calendar
     System.out.println("Adicionando evento ao Google Calendar: " + mensagem);
 }
}