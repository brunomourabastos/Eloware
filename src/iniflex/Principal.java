package iniflex;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Set;

public class Principal {	
	public static void main( String args[]) {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(new Funcionario("Maria","18/10/2000", "2009.44", "Operador"));
		funcionarios.add(new Funcionario("João","12/05/1990", "2284.38", "Operador"));
		funcionarios.add(new Funcionario("Caio","02/05/1961", "9836.14", "Coordenador"));
		funcionarios.add(new Funcionario("Miguel","14/10/1988", "19119.88", "Diretor"));
		funcionarios.add(new Funcionario("Alice","05/01/1995", "2234.38", "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor","19/11/1999", "1582.72", "Operador"));
		funcionarios.add(new Funcionario("Arthur","31/03/1993", "4071.84", "Contador"));
		funcionarios.add(new Funcionario("Laura","08/07/1994", "3017.45", "Gerente"));
		funcionarios.add(new Funcionario("Heloísa","24/05/2003", "1606.85", "Eletricista"));
		funcionarios.add(new Funcionario("Helena","02/09/1996", "2799.93", "Gerente"));
		
		System.out.println("3.1 - Após inserir todos os funcionários");		
		System.out.println("--------------------------------------------------------");
		System.out.printf("%10s %15s %10s %15s", "Nome", "Data Nascimento", "Salário", "Função");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		for(Funcionario funcionario: funcionarios) {
			System.out.format("%10s %15s %10s %15s", funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), 
					funcionario.getFuncao());
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
		
		//Remover funcionário Joao
		
		funcionarios.remove(1);
		System.out.println();
		System.out.println("3.2 - Sem o funcionário João");
		System.out.println("--------------------------------------------------------");
		System.out.printf("%10s %15s %10s %15s", "Nome", "Data Nascimento", "Salário", "Função");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		for(Funcionario funcionario: funcionarios) {
			System.out.format("%10s %15s %10s %15s", funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), 
					funcionario.getFuncao());
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
		
			
		//10% de aumento para todos os funcionários:
		
		funcionarios.stream().forEach(
				(Funcionario funcionario) ->
				{
					funcionario.setSalario(
							String.valueOf( funcionario.getSalarioDouble()*1.1F )
							);
				}
				);
		System.out.println();
		System.out.println("3.4 - Após receber 10% de aumento para todos os funcionários");
		System.out.println("--------------------------------------------------------");
		System.out.printf("%10s %15s %10s %15s", "Nome", "Data Nascimento", "Salário", "Função");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		for(Funcionario funcionario: funcionarios) {
			System.out.format("%10s %15s %10s %15s", funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), 
					funcionario.getFuncao());
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
		System.out.println();
		
		//Agrupar os funcionarios por função:
		
		Map<String, Set<String>> funcionariosAgrupados = funcionarios.stream().collect(
				Collectors.groupingBy( Funcionario::getFuncao,
						Collectors.mapping(Funcionario::getNome, Collectors.toSet())));
		System.out.println("3.5 & 3.6 - Lista agrupada por função");
		System.out.println("--------------------------------------------------------");
		System.out.println("Lista agrupada:" + funcionariosAgrupados);
		//Imprimir a lista de funcionários em ordem alfabética:
		
		funcionarios.sort(Comparator.comparing(Funcionario::getNome));
		System.out.println();
		System.out.println("3.10 - Após ordenar por ordem alfabética");
		System.out.println("--------------------------------------------------------");
		System.out.printf("%10s %15s %10s %15s", "Nome", "Data Nascimento", "Salário", "Função");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		for(Funcionario funcionario: funcionarios) {
			System.out.format("%10s %15s %10s %15s", funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), 
					funcionario.getFuncao());
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
		
		//Imprimir total dos salários:
				System.out.println();
				System.out.printf("3.11 - Total Salarios: R$ "
						+ "%.2f%n", 
						funcionarios.stream()
						.mapToDouble(Funcionario::getSalarioDouble).reduce(0, (value1, value2) -> value1 + value2));
		
		//Imprimir quantos salários mínimos, cada funcionário ganha:
		System.out.println();
		System.out.println("3.12 - Quantidade de salários mínimos");
		System.out.println("--------------------------------------------------------");
		System.out.printf("%10s %15s ", "Nome", "Salários Mínimos");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		for(Funcionario funcionario: funcionarios) {
			System.out.format("%10s %.2f%n", funcionario.getNome(), funcionario.getSalarioDouble()/1212); 
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
		
		
		
	}
	
	
	
}
