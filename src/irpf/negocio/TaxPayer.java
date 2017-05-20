package irpf.negocio;

public class TaxPayer {
	String name, cpf; 
	double totalIncome, socialSecurityContribution;
	
	public TaxPayer(String name, String cpf, double totalIncome, double socialSecurityContribution){
		this.name = name;
		this.cpf = cpf;
		this.totalIncome = totalIncome;
		this.socialSecurityContribution = socialSecurityContribution;
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

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public double getSocialSecurityContribution() {
		return socialSecurityContribution;
	}

	public void setSocialSecurityContribution(double socialSecurityContribution) {
		this.socialSecurityContribution = socialSecurityContribution;
	}

	@Override
	public String toString() {
		return "Name: " + name + '\n'
				+ "CPF: " + cpf + '\n'
				+ "Total Income: " + totalIncome + '\n'
				+ "Social Security Contribution: " + socialSecurityContribution + '\n';
	}
	
}
