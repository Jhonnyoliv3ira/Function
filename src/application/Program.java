package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		String path = "c:/in.txt";
		List<Employee> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] file = line.split(",");
				String name = file[0];
				String email = file[1];
				Double salary = Double.parseDouble(file[2]);
				list.add(new Employee(name, email, salary));
				line = br.readLine();
				
			}
			
			System.out.println("Enter Salary: ");
			Double valor = sc.nextDouble();
			
			List<String> em = list.stream().filter(p -> p.getSalary() > valor).map(p -> p.getEmail()).sorted().collect(Collectors.toList());
			em.forEach(System.out::println);
			
			Double sum = list.stream().filter(p -> p.getName().charAt(0) == 'M').map(p -> p.getSalary()).reduce(0.0, (x,y) -> x+y);
			System.out.println("Soma dos salários: " + sum);

		} catch (IOException e) {
			System.out.println("Erro " + e.getMessage());
		}

	}

}
