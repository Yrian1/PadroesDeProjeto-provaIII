package br.edu.ifba.inf011.model.cor;

import br.edu.ifba.inf011.model.evento.Evento;

public class Notificador {
    private Handler cadeia;

    public Notificador(Handler cadeia) {
        this.cadeia = cadeia;
    }

    public void notificar(Evento evento){
        cadeia.processar(evento);
    }
}