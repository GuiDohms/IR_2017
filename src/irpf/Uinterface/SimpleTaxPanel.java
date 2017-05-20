package irpf.Uinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import irpf.negocio.TaxPaymentComplete;
import irpf.negocio.TaxPaymentC;
import irpf.negocio.TaxPaymentSimple;
import irpf.negocio.TaxPaymentS;
import irpf.negocio.Checker;
import irpf.negocio.TaxPayer;
import irpf.negocio.TaxPayerComplete;

public class SimpleTaxPanel extends JPanel {
	private JLabel lblName;
	private JLabel lblCpf;
	private JLabel lblTotalIncome;
	private JLabel lblSocialSecurityContribution;
	private JLabel lblIncomeTax;

	private JTextField textFieldName;
	private JTextField textFieldCpf;
	private JTextField texFieldTotalIncome;
	private JTextField textFieldSocialSecurityContribution;

	private JButton btnClear;
	private JButton btnCalculate;

	public SimpleTaxPanel() {}

	public void makeForm() {
		this.setBounds(0, 0, 494, 422);
		this.setLayout(null);

		lblName = new JLabel("Name");
		lblName.setBounds(30, 40, 350, 14);
		this.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setBounds(30, 59, 350, 20);
		textFieldName.setColumns(10);
		this.add(textFieldName);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(30, 84, 350, 14);
		this.add(lblCpf);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(30, 103, 195, 20);
		textFieldCpf.setColumns(10);
		this.add(textFieldCpf);

		lblTotalIncome = new JLabel("Total Income");
		lblTotalIncome.setBounds(30, 128, 350, 14);
		this.add(lblTotalIncome);

		texFieldTotalIncome = new JTextField();
		texFieldTotalIncome.setBounds(30, 147, 195, 20);
		texFieldTotalIncome.setColumns(10);
		this.add(texFieldTotalIncome);

		lblSocialSecurityContribution = new JLabel("SS Contribution");
		lblSocialSecurityContribution.setBounds(30, 172, 350, 14);
		this.add(lblSocialSecurityContribution);

		textFieldSocialSecurityContribution = new JTextField();
		textFieldSocialSecurityContribution.setBounds(30, 191, 195, 20);
		textFieldSocialSecurityContribution.setColumns(10);
		this.add(textFieldSocialSecurityContribution);

		lblIncomeTax = new JLabel("Income Tax:");
		lblIncomeTax.setBounds(30, 334, 195, 14);
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
		String totalIncome = texFieldTotalIncome.getText();
		String socialSecurityContribution = textFieldSocialSecurityContribution.getText();

		String incomeTax;

		Checker checker = new Checker();
		if (checker.logicalTaxPaymentS(name, cpf, totalIncome, socialSecurityContribution)) {
			TaxPayer taxpayer = new TaxPayer(checker.getName(), checker.getCpf(), checker.getTotalIncome(), checker.getSocialSecurityContribution());
			TaxPaymentS simpleTax = new TaxPaymentS(taxpayer);
			incomeTax = "R$ " + String.format("%.2f", simpleTax.getTaxToPayS());
		} else {
			incomeTax = "Error!";
		}
		lblIncomeTax.setText("Income Tax: " + incomeTax);
	}

	protected void do_btnClear_actionPerformed(ActionEvent e) {
		textFieldName.setText("");
		textFieldCpf.setText("");
		texFieldTotalIncome.setText("");
		textFieldSocialSecurityContribution.setText("");
		lblIncomeTax.setText("Income Tax:");
	}
}