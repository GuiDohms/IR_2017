
public class CompleteDeclaration extends Declaration {
	
	private int age, numDependents;
	
	public CompleteDeclaration(String name, String cpf, int age, int numDependents, double previdentiaryContribution, double revenueTotal){
		super(name, cpf, previdentiaryContribution, revenueTotal);
		this.age = age;
		this.numDependents = numDependents;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumDependents() {
		return numDependents;
	}

	public void setNumDependents(int numDependents) {
		this.numDependents = numDependents;
	}
	
	public double baseMath(){
		double base = 0;
		base = getRevenueTotal() - getPrevidentiaryContribution();
		return base;
	}
	
	public double baseDiscount(){
		double discount = 0;
		discount = baseMath() - (baseMath()*0.05);
		return discount;
	}
	
	public double contribution(){
		double contribution = 0;
		if(baseMath()<= 12.000){
			contribution = 0;
		}if(baseMath()>12.000 && baseMath()<24.000){
			contribution = (baseMath()-12.000)*0.15;
		}if(baseMath()>=24.000){
			
		}
		return contribution;
	} 
	
}
