package br.edu.ifba.inf011.model.adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.edu.ifba.inf011.model.Aula;
import br.edu.ifba.inf011.model.Geolocalizacao;
import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.evento.RelacionadorEventos;

public class AulaObjectAdapter implements Evento{
	
	private Aula aula;
	private Integer prioridade;

	public AulaObjectAdapter(Aula aula) {
		this.aula = aula;
		this.prioridade = 5;
	}

	@Override
	public boolean sobreposto(Evento evento) {
		return (new RelacionadorEventos()).sobreposto(this, evento);
	}

	@Override
	public String getDescricao() {
		return aula.getCodDisciplina() + "-" + aula.getDescricaoDisciplina();
	}

	@Override
	public LocalDateTime getInicio() {
		return aula.getHorario();
	}

	@Override
	public LocalDateTime getTermino() {
		return this.aula.getHorario().plus(100, ChronoUnit.MINUTES);
	}

	@Override
	public Integer getPrioridade() {
		return this.prioridade;
	}

	@Override
	public Geolocalizacao getLocalizacao() {
		return this.aula.getSala();
	}

	@Override
	public boolean iniciaEm(LocalDate timestamp) {
		return (new RelacionadorEventos()).iniciaEm(this, timestamp);
	}

	@Override
	public boolean iniciaEntre(LocalDateTime inicio, LocalDateTime fim) {
		return (new RelacionadorEventos()).iniciaEntre(this, inicio, fim);
	}

	@Override
	public void setDescricao(String desc) {
		// TODO Auto-generated method stub
		this.aula.setDescricaoDisciplina(desc);
		
	}

	@Override
	public void setPrioridade(Integer prioridade) {
		// TODO Auto-generated method stub
		this.prioridade = prioridade;
	}

	@Override
	public void setDataInicio(LocalDateTime now) {
		// TODO Auto-generated method stub
		this.aula.setHorario(now);
		
	}

}
