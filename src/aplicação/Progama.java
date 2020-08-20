package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.exceções.DominioExceções;

public class Progama {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner entrada = new Scanner(System.in);
		try {
			System.out.println("Entre com o numero do quarto:");
			Integer numero = entrada.nextInt();
			System.out.println("Data da entrada (dd/mm/yyyy): ");
			Date entradaD = sdf.parse(entrada.next());
			System.out.println("Data de saida (dd/mm/yyyy): ");
			Date saidaD = sdf.parse(entrada.next());
			
			Reserva reserva = new Reserva(numero, entradaD, saidaD);
			System.out.println(reserva);
			
			System.out.println("Atualização de duração");
			
			System.out.println("Data da entrada (dd/mm/yyyy): ");
			entradaD = sdf.parse(entrada.next());
			System.out.println("Data de saida(dd/mm/yyyy): ");
			saidaD = sdf.parse(entrada.next());
			
			reserva.AtualizaçãoDuração(entradaD, saidaD);
			System.out.println(reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato da data invalida: ");
		}
		catch (DominioExceções e) {
			System.out.println("Error na reserva: " +e.getMessage() );
		}
		catch (RuntimeException e) {
			System.out.println("Error não indetificado");
		}

		entrada.close();
	}

}
