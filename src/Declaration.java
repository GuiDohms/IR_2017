
public class Declaration {
	
	 /*
	 � Nome*
	 � CPF*
	 � Idade**
	 � N�mero de dependentes**
	 � Contribui��o previdenci�ria oficial***
	 � Total de rendimentos***
	 *Campos obrigat�rios para todos os contribuintes
	 **Campos obrigat�rios para os contribuintes que fazem declara��o completa
	 ***Campos obriggat�rios para permitir o c�lculo do imposto (qualquer
        modalidade)
*/
	
	
	private String name, cpf;
	//private int age, numDependent;
	private double previdentiaryContribution, revenueTotal;
	
	public Declaration(String name, String cpf, double previdentiaryContribution, double revenueTotal) {
		this.name = name;
		this.cpf = cpf;
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
