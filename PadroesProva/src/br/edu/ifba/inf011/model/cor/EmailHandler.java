package br.edu.ifba.inf011.model.cor;

import java.time.LocalDate;

import br.edu.ifba.inf011.model.evento.Evento;

//Handler para Email
public class EmailHandler implements Handler {
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
     if (evento.getPrioridade() >= 5 && evento.iniciaEm(LocalDate.now())) {
         String formatada = formatarMensagemParaEmail(evento);
         enviandoMensagemEmail(formatada);
     }
     if (proximo != null) {
         proximo.processar(evento); // Passa para o próximo handler
     }
 }
 private String formatarMensagemParaEmail(Evento evento) {
     // Lógica de formatação para Email
     return "Email: " + evento.getDescricao();
 }

 private void enviandoMensagemEmail(String mensagem) {
     // Lógica de envio para Email
     System.out.println("Enviando mensagem Email: " + mensagem);
 }
}
