package irpf.Uinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import irpf.Uinterface.*;
import irpf.negocio.TaxPaymentComplete;
import irpf.negocio.TaxPaymentC;
import irpf.negocio.TaxPaymentSimple;
import irpf.negocio.TaxPaymentS;
import irpf.negocio.Checker;
import irpf.negocio.TaxPayer;
import irpf.negocio.TaxPayerComplete;

public class FullTaxPanel extends JPanel {
	
	private JLabel lblName;
	private JLabel lblCpf;
	private JLabel lblTotalIncome;
	private JLabel lblSocialSecurityContribution;
	private JLabel lblAge;
	private JLabel lblTotalDependents;
	private JLabel lblIncomeTax;

	private JTextField textFieldName;
	private JTextField textFieldCpf;
	private JTextField texFieldTotalIncome;
	private JTextField textFieldSocialSecurityContribution;
	private JTextField textFieldAge;
	private JTextField textFieldNumDependents;

	private JButton btnClear;
	private JButton btnCalculate;

	public FullTaxPanel() {}

	public void makeForm() {
		this.setBounds(0, 0, 500, 450);
		this.setLayout(null);

		lblName = new JLabel("Name");
		lblName.setBounds(30, 40, 350, 20);
		this.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setBounds(30, 60, 350, 20);
		this.add(textFieldName);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(30, 85, 350, 20);
		this.add(lblCpf);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(30, 105, 195, 20);
		this.add(textFieldCpf);

		lblTotalIncome = new JLabel("Total Income");
		lblTotalIncome.setBounds(30, 130, 350, 20);
		this.add(lblTotalIncome);

		texFieldTotalIncome = new JTextField();
		texFieldTotalIncome.setBounds(30, 150, 195, 20);
		this.add(texFieldTotalIncome);

		lblSocialSecurityContribution = new JLabel("SS Contribution");
		lblSocialSecurityContribution.setBounds(30, 175, 350, 20);
		this.add(lblSocialSecurityContribution);

		textFieldSocialSecurityContribution = new JTextField();
		textFieldSocialSecurityContribution.setBounds(30, 195, 195, 20);
		this.add(textFieldSocialSecurityContribution);

		lblAge = new JLabel("Age");
		lblAge.setBounds(30, 220, 350, 20);
		this.add(lblAge);

		textFieldAge = new JTextField();
		textFieldAge.setBounds(30, 240, 195, 20);
		this.add(textFieldAge);

		lblTotalDependents = new JLabel("Number of Dependents");
		lblTotalDependents.setBounds(30, 265, 350, 20);
		this.add(lblTotalDependents);

		textFieldNumDependents = new JTextField();
		textFieldNumDependents.setBounds(30, 285, 195, 20);
		this.add(textFieldNumDependents);

		lblIncomeTax = new JLabel("Income Tax:");
		lblIncomeTax.setBounds(30, 320, 195, 20);
		this.add(lblIncomeTax);

		btnClear = new JButton("Clear");
		btnClear.setBounds(296, 378, 84, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClear_actionPerformed(e);
			}
		});
		this.add(btnClear);

		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(385, 378, 89, 23);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCalculate_actionPerformed(e);
			}
		});
		this.add(btnCalculate);
	}

	protected void do_btnCalculate_actionPerformed(ActionEvent e) {
		String name = textFieldName.getText();
		String cpf = textFieldCpf.getText();
		String total_income = texFieldTotalIncome.getText();
		String social_security_contribution = textFieldSocialSecurityContribution.getText();
		String age = textFieldAge.getText();
		String total_dependents = textFieldNumDependents.getText();

		String incomeTax;

		Checker checker = new Checker();
		if (checker.logicalTaxPaymentC(name, cpf, total_income, social_security_contribution, age, total_dependents)) {
			TaxPayerComplete taxpayer = new TaxPayerComplete(checker.getName(), checker.getCpf(), checker.getTotalIncome(), checker.getSocialSecurityContribution(), checker.getAge(), checker.getNumDep());
			TaxPaymentC completeTax = new TaxPaymentC(taxpayer);
			incomeTax = "R$ " + String.format("%.2f", completeTax.getTaxToPayC());
		} else {
			incomeTax = "Error!";
		}
		lblIncomeTax.setText("Income Tax " + incomeTax);
	}

	protected void do_btnClear_actionPerformed(ActionEvent e) {
		textFieldName.setText("");
		textFieldCpf.setText("");
		texFieldTotalIncome.setText("");
		textFieldSocialSecurityContribution.setText("");
		textFieldAge.setText("");
		textFieldNumDependents.setText("");
		lblIncomeTax.setText("Income Tax:");
	}
	
}