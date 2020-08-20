package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import modelo.exce��es.DominioExce��es;

public class Reserva {
	private Integer numeroQuarto;
	private Date entradaD;
	private Date saidaD;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date entradaD, Date saidaD) throws DominioExce��es {
		if(!saidaD.after(entradaD)) {
			throw new DominioExce��es("Error -data de saida anterior a data de entrada");
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

	public long Dura��o() {
	
		long diferen�a = saidaD.getTime() - entradaD.getTime();
		return TimeUnit.DAYS.convert(diferen�a, TimeUnit.MILLISECONDS);
	}
	
	public void Atualiza��oDura��o(Date entradaD, Date saidaD) throws DominioExce��es {
		Date agora = new Date();
		if (entradaD.before(agora) || saidaD.before(agora) ) {
			throw new DominioExce��es("Error as datas devem ser futuras: ");
		}
		if(!saidaD.after(entradaD)) {
			throw new DominioExce��es("Error -data de saida anterior a data de entrada");
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
				+", Dura��o: "
				+Dura��o()
				+", Noites";
	}
}
