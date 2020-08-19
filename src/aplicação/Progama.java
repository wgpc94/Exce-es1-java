package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Progama {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com o numero do quarto:");
		Integer numero = entrada.nextInt();
		System.out.println("Data da entrada: ");
		Date entradaD = sdf.parse(entrada.next());
		System.out.println("Data de saida: ");
		Date saidaD = sdf.parse(entrada.next());
		
		if(!saidaD.after(entradaD)) {
			System.out.println("Error -data de saida anterior a data de entrada ");
		}
		else {
			Reserva reserva = new Reserva(numero, entradaD, saidaD);
			System.out.println(reserva);
			
			System.out.println("Atualização de duração");
			
			System.out.println("Data da entrada: ");
			entradaD = sdf.parse(entrada.next());
			System.out.println("Data de saida: ");
			saidaD = sdf.parse(entrada.next());
			
			String error = reserva.AtualizaçãoDuração(entradaD, saidaD);
			if (error != null) {
				System.out.println(error);
			}
			else {
				System.out.println(reserva);
			}
		}

		entrada.close();
	}

}
