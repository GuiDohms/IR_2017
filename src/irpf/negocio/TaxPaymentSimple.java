package irpf.negocio;

public abstract class TaxPaymentSimple extends TaxPaymentS{
	

	public TaxPaymentSimple(TaxPayer taxpayer){
		super(taxpayer);
		this.setTaxBasisFormulaS();
	}
	
	protected void setTaxBasisFormulaS(){
		double taxBasis = 0;
		taxBasis = this.getTaxPayer().getTotalIncome() - this.getTaxPayer().getSocialSecurityContribution();
		taxBasis = 0.95*taxBasis;
		this.taxBasisFormulaS = taxBasis; 
		
	}
}
