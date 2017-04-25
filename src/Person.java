
public class Person {
	
	 /*
	 • Nome*
	 • CPF*
	 • Idade**
	 • Número de dependentes**
	 • Contribuição previdenciária oficial***
	 • Total de rendimentos***
	 *Campos obrigatórios para todos os contribuintes
	 **Campos obrigatórios para os contribuintes que fazem declaração completa
	 ***Campos obriggatórios para permitir o cálculo do imposto (qualquer
        modalidade)
*/
	
	
	private String name, cpf;
	private int age, numDependent;
	private double previdentiaryContribution, revenueTotal;
	
	public Person(String name, String cpf, int age, int numDependent, double previdentiaryContribution, double revenueTotal) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
		this.numDependent = numDependent;
		this.previdentiaryContribution = previdentiaryContribution;
		this.revenueTotal = revenueTotal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumDependent() {
		return numDependent;
	}

	public void setNumDependent(int numDependent) {
		this.numDependent = numDependent;
	}

	public double getPrevidentiaryContribution() {
		return previdentiaryContribution;
	}

	public void setPrevidentiaryContribution(double previdentiaryContribution) {
		this.previdentiaryContribution = previdentiaryContribution;
	}

	public double getRevenueTotal() {
		return revenueTotal;
	}

	public void setRevenueTotal(double revenueTotal) {
		this.revenueTotal = revenueTotal;
	}
	
	
	
	
}
