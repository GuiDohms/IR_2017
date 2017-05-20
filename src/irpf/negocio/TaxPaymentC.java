package irpf.negocio;

public abstract class TaxPaymentC {
	protected double taxBasisFormulaC;
	protected TaxPayerComplete taxpayer;

	
	public TaxPaymentC(TaxPayerComplete taxpayer){
		this.taxpayer = taxpayer;
	}
	
	
	public TaxPayerComplete getTaxpayerComplete() {
		return taxpayer;
	}


	public void setTaxpayerComplete(TaxPayerComplete taxpayer) {
		this.taxpayer = taxpayer;
	}


	protected abstract void setTaxBasisFormulaC(); //ver com o professor pq pede para ficar protected
	
		public double getTaxToPayC(){
			double howMuchTax = 0;
			if(this.taxBasisFormulaC <= 12000){
				howMuchTax = 0;
			}else if (this.taxBasisFormulaC > 12000 && this.taxBasisFormulaC <24000){
				howMuchTax = (this.taxBasisFormulaC - 12000)*0.15;
			}else if (this.taxBasisFormulaC >= 24000){
				howMuchTax = (this.taxBasisFormulaC -12000)*0.15 + (this.taxBasisFormulaC - 24000)*0.275;
			}
			return howMuchTax;
		}
}
