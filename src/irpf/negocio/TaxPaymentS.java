package irpf.negocio;

public abstract class TaxPaymentS {
	protected double taxBasisFormulaS;
	protected TaxPayer taxpayer;

	
	public TaxPaymentS(TaxPayer taxpayer){
		this.taxpayer = taxpayer;
	}
	
	
	public TaxPayer getTaxPayer() {
		return taxpayer;
	}


	public void setTaxPayer(TaxPayer taxpayer) {
		this.taxpayer = taxpayer;
	}


	protected abstract void setTaxBasisFormulaS(); //ver com o professor pq pede para ficar protected
	
		public double getTaxToPayS(){
			double howMuchTax = 0;
			if(this.taxBasisFormulaS <= 12000){
				howMuchTax = 0;
			}else if (this.taxBasisFormulaS > 12000 && this.taxBasisFormulaS <24000){
				howMuchTax = (this.taxBasisFormulaS - 12000)*0.15;
			}else if (this.taxBasisFormulaS >= 24000){
				howMuchTax = (this.taxBasisFormulaS -12000)*0.15 + (this.taxBasisFormulaS - 24000)*0.275;
			}
			return howMuchTax;
		}
		
		
}
