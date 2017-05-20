package irpf.Uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import irpf.negocio.Checker;
import irpf.negocio.TaxPayerComplete;
import irpf.negocio.TaxPaymentC;

public class FullTaxFrame extends JFrame {

	private JPanel contentPane;
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

	private JButton btnBack;
	private JButton btnCalculate;
	private JButton button;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullTaxFrame frame = new FullTaxFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FullTaxFrame() {
		setResizable(false);
		setTitle("Income Tax Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Name");
		lblName.setBounds(30, 40, 350, 20);
		getContentPane().add(lblName);

		textFieldName = new JTextField();
		textFieldName.setBounds(30, 60, 350, 20);
		getContentPane().add(textFieldName);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(30, 85, 350, 20);
		getContentPane().add(lblCpf);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(30, 105, 195, 20);
		getContentPane().add(textFieldCpf);

		lblTotalIncome = new JLabel("Total Income");
		lblTotalIncome.setBounds(30, 130, 350, 20);
		getContentPane().add(lblTotalIncome);

		texFieldTotalIncome = new JTextField();
		texFieldTotalIncome.setBounds(30, 150, 195, 20);
		getContentPane().add(texFieldTotalIncome);

		lblSocialSecurityContribution = new JLabel("SS Contribution");
		lblSocialSecurityContribution.setBounds(30, 175, 350, 20);
		getContentPane().add(lblSocialSecurityContribution);

		textFieldSocialSecurityContribution = new JTextField();
		textFieldSocialSecurityContribution.setBounds(30, 195, 195, 20);
		getContentPane().add(textFieldSocialSecurityContribution);

		lblAge = new JLabel("Age");
		lblAge.setBounds(30, 220, 350, 20);
		getContentPane().add(lblAge);

		textFieldAge = new JTextField();
		textFieldAge.setBounds(30, 240, 195, 20);
		getContentPane().add(textFieldAge);

		lblTotalDependents = new JLabel("Number of Dependents");
		lblTotalDependents.setBounds(30, 265, 350, 20);
		getContentPane().add(lblTotalDependents);

		textFieldNumDependents = new JTextField();
		textFieldNumDependents.setBounds(30, 285, 195, 20);
		getContentPane().add(textFieldNumDependents);

		lblIncomeTax = new JLabel("Income Tax:");
		lblIncomeTax.setBounds(30, 320, 195, 20);
		getContentPane().add(lblIncomeTax);

		btnBack = new JButton("Back");
		btnBack.setBounds(30, 375, 84, 23);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				IR_2017 nwIR = new IR_2017();
				nwIR.setVisible(true);
			}
		});
		getContentPane().add(btnBack);

		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(386, 375, 89, 23);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCalculate_actionPerformed(e);
			}
		});
		getContentPane().add(btnCalculate);
		
		button = new JButton("Clear");
		button.setBounds(296, 375, 84, 23);
		contentPane.add(button);
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


