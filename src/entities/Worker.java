package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel leve;
	private double baseSalary;
	
	/*associacoes abaixo || obs: como no projeto diz ter varios contratos, deve-se armazená-los em uma lista*/
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	/*Obs: Quando se tiver uma lista, não se deve incluir ela no generate constructor using fields
	 * o correto é instanciá-la como um new ArrayList<>() para iniciá-la vazia*/
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel leve, double baseSalary, Department department) {
		super();
		this.name = name;
		this.leve = leve;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLeve() {
		return leve;
	}

	public void setLeve(WorkerLevel leve) {
		this.leve = leve;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	
	/*MÉTODOS: */
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	
	public double income(int year, int month) {
		
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		/*para cada contract c na lista de contracts, teste se o contract c é desse ano/mes e caso ele seja, acrescente o valor na soma:*/
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
