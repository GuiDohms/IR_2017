package irpf.negocio;

public class TaxPayerComplete extends TaxPayer {
	private int age, numDep;
	
	public TaxPayerComplete(String name, String cpf, double totalIncome, double socialSecurityContribution, int age, int numDep){
		super(name, cpf, totalIncome, socialSecurityContribution);
		this.age = age;
		this.numDep = numDep;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumDep() {
		return numDep;
	}

	public void setNumDep(int numDep) {
		this.numDep = numDep;
	}

	@Override
	public String toString() {
		return "Name: " + name + '\n' +
				"CPF: " + cpf + '\n' +
				"Age: " + age + '\n' +
				"Number of Dependents: " + numDep + + '\n' +
				"Total Income: " + totalIncome + '\n' +
				"Social Security Contribution: " + socialSecurityContribution + '\n';
	}
	
}
