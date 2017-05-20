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
import irpf.negocio.TaxPayer;
import irpf.negocio.TaxPaymentS;

public class SimpleTaxFrame extends JFrame {

	private JPanel contentPane;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleTaxFrame frame = new SimpleTaxFrame();
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
	public SimpleTaxFrame() {
		setResizable(false);
		setTitle("Income Tax Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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


