package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import modelo.exceções.DominioExceções;

public class Reserva {
	private Integer numeroQuarto;
	private Date entradaD;
	private Date saidaD;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date entradaD, Date saidaD) throws DominioExceções {
		if(!saidaD.after(entradaD)) {
			throw new DominioExceções("Error -data de saida anterior a data de entrada");
			}
		this.numeroQuarto = numeroQuarto;
		this.entradaD = entradaD;
		this.saidaD = saidaD;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entradaD;
	}

	public Date getSaida() {
		return saidaD;
	}

	public long Duração() {
	
		long diferença = saidaD.getTime() - entradaD.getTime();
		return TimeUnit.DAYS.convert(diferença, TimeUnit.MILLISECONDS);
	}
	
	public void AtualizaçãoDuração(Date entradaD, Date saidaD) throws DominioExceções {
		Date agora = new Date();
		if (entradaD.before(agora) || saidaD.before(agora) ) {
			throw new DominioExceções("Error as datas devem ser futuras: ");
		}
		if(!saidaD.after(entradaD)) {
			throw new DominioExceções("Error -data de saida anterior a data de entrada");
			}
		else {
				this.entradaD = entradaD;
				this.saidaD = saidaD;
			}
	}

	@Override
	public String toString() {
		return "Quarto: "
				+numeroQuarto
				+", Entrada: "
				+ sdf.format(entradaD)
				+", Saida: "
				+sdf.format(saidaD)
				+", Duração: "
				+Duração()
				+", Noites";
	}
}
