package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long Duração() {
	
		long diferença = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferença, TimeUnit.MILLISECONDS);
	}
	
	public String AtualizaçãoDuração(Date entradaD, Date saidaD) {
		Date agora = new Date();
		
		if (entradaD.before(agora) || saidaD.before(agora) ) {
			return "Error as datas devem ser futuras: ";
		}
		if(!saidaD.after(entradaD)) {
			return "Error -data de saida anterior a data de entrada";
			}
		else {
				this.entrada = entradaD;
				this.saida = saidaD;
				return null;
			}
	}

	@Override
	public String toString() {
		return "Quarto: "
				+numeroQuarto
				+", Entrada: "
				+ sdf.format(entrada)
				+", Saida: "
				+sdf.format(saida)
				+", Duração: "
				+Duração()
				+", Noites";
	}
}
