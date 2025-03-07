package br.edu.ifba.inf011.model.cor;

import br.edu.ifba.inf011.model.evento.Evento;

public interface Handler {
    void setProximo(Handler proximo);
    void processar(Evento evento);
}
