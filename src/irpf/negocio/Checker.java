package irpf.negocio;

public class Checker {
	private String name;
	private String cpf;
	private double totalIncome;
	private double socialSecurityContribution;
	private int age;
	private int numDep;

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public double getSocialSecurityContribution() {
		return socialSecurityContribution;
	}

	public int getAge() {
		return age;
	}

	public int getNumDep() {
		return numDep;
	}

	public boolean logicalName(String name) {
		boolean logical = false;
		if (name.length() > 0) {
			logical = true;
			this.name = name;
		}
		return logical;
	}

	public boolean logicalCpf(String cpf) {
		boolean logical;
		try {
			Double.parseDouble(cpf);
			logical = true;
			this.cpf = cpf;
		} catch(Exception ex) {
			logical = false;
		}
		return logical;
	}

	public boolean logicalIncome(String totalIncome) {
		boolean logical;
		try {
			double ti = Double.parseDouble(totalIncome);
			if (ti < 0) {
				logical = false;
			} else {
				logical = true;
				this.totalIncome = ti;
			}
		} catch(Exception ex) {
			logical = false;
		}
		return logical;
	}

	public boolean logicalSocialSecurityContribution(String socialSecurityContribution) {
		boolean logical;
		try {
			double ss = Double.parseDouble(socialSecurityContribution);
			if (ss < 0) {
				logical = false;
			} else {
				logical = true;
				this.socialSecurityContribution = ss;
			}
		} catch(Exception ex) {
			logical = false;
		}
		return logical;
	}

	public boolean logicalAge(String age) {
		boolean logical;
		try {
			double h = Integer.parseInt(age);
			if (h < 0) {
				logical = false;
			} else {
				logical = true;
				this.socialSecurityContribution = h;
			}
		} catch(Exception ex) {
			logical = false;
		}
		return logical;
	}

	public boolean logicalDependents(String numDep) {
		boolean logical;
		try {
			int nd = Integer.parseInt(numDep);
			if (nd < 0) {
				logical = false;
			} else {
				logical = true;
				this.numDep = nd;
			}
		} catch(Exception ex) {
			logical = false;
		}
		return logical;
	}

	public boolean logicalTaxPaymentS(String name, String cpf, String totalIncome, String socialSecurityContribution) {
		if (
			this.logicalName(name) &&
			this.logicalCpf(cpf) &&
			this.logicalIncome(totalIncome) &&
			this.logicalSocialSecurityContribution(socialSecurityContribution)
		) {
			return true;
		}
		return false;
	}

	public boolean logicalTaxPaymentC(String name, String cpf, String totalIncome, String socialSecurityContribution, String age, String numDep) {
		if (
			this.logicalTaxPaymentS(name, cpf, totalIncome, socialSecurityContribution) &&
			this.logicalAge(age) &&
			this.logicalDependents(numDep)
		) {
			return true;
		}
		return false;
	}
}
