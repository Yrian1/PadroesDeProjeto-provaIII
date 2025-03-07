package br.edu.ifba.inf011.model.cor;

import java.time.LocalDate;

import br.edu.ifba.inf011.model.evento.Evento;

//Handler para WhatsApp
public class WhatsAppHandler implements Handler {
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
     if (evento.getPrioridade() == 10 && evento.iniciaEm(LocalDate.now())) {
         String formatada = formatarMensagemParaWhatsApp(evento);
         enviandoMensagemWhatsApp(formatada);
     } 
     if (proximo != null) {
         proximo.processar(evento); // Passa para o próximo handler
     }
 }

 private String formatarMensagemParaWhatsApp(Evento evento) {
     // Lógica de formatação para WhatsApp
     return "WhatsApp: " + evento.getDescricao();
 }

 private void enviandoMensagemWhatsApp(String mensagem) {
     // Lógica de envio para WhatsApp
     System.out.println("Enviando mensagem WhatsApp: " + mensagem);
 }


}