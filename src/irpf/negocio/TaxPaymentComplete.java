package irpf.negocio;

public abstract class TaxPaymentComplete extends TaxPaymentC{
	
	public TaxPaymentComplete(TaxPayerComplete taxpayer){
		super(taxpayer);
		this.setTaxBasisFormulaC();
	}
	
	protected void setTaxBasisFormulaC(){
		double taxBasis = 0;
		taxBasis = this.getTaxpayerComplete().getTotalIncome() - this.getTaxpayerComplete().getSocialSecurityContribution();
		
		if (this.taxpayer.getAge() < 65) {
			if (this.taxpayer.getNumDep() <= 2) {
				// 2%
				taxBasis = 0.98 * taxBasis;
			} else if (this.taxpayer.getNumDep() >= 3 && this.taxpayer.getNumDep() <= 5) {
				// 3.5%
				taxBasis = 0.965 * taxBasis;
			} else if (this.taxpayer.getNumDep() > 5) {
				// 5%
				taxBasis = 0.95 * taxBasis;
			}
		} else {
			if (this.taxpayer.getNumDep() <= 2) {
				// 3%
				taxBasis = 0.97 * taxBasis;
			} else if (this.taxpayer.getNumDep() >= 3 && this.taxpayer.getNumDep() <= 5) {
				// 4.5%
				taxBasis = 0.955 * taxBasis;
			} else if (this.taxpayer.getNumDep() > 5) {
				// 6%
				taxBasis = 0.94 * taxBasis;
			}
		}

		this.taxBasisFormulaC = taxBasis;
	}
			
}