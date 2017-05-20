package irpf.Uinterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import irpf.negocio.Checker;
import irpf.negocio.TaxPayerComplete;
import irpf.negocio.TaxPaymentC;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class IR_2017 extends JFrame {

	private JPanel contentPane;
	private SimpleTaxPanel simpleTaxPanel;
	private FullTaxPanel fullTaxPanel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IR_2017 frame = new IR_2017();
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
	public IR_2017() {
		setResizable(false);
		setTitle("Income Tax Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Main Menu
		JMenuBar menuBar = new JMenuBar();//BARRABARBARABA
		menuBar.setBounds(0, 0, 494, 21);
		contentPane.add(menuBar);

		JMenu mnFile = new JMenu("Exit");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Bye");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

	
		JButton simpleTax = new JButton("Simple Tax");
		simpleTax.setBackground(Color.DARK_GRAY);
		simpleTax.setForeground(Color.LIGHT_GRAY);
		simpleTax.setFont(new Font("Courier", Font.BOLD, 57));
		simpleTax.setBounds(19, 53, 454, 113);
		contentPane.add(simpleTax);
		simpleTax.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		JButton fullTax = new JButton("Full Tax");
		fullTax.setForeground(Color.GRAY);
		fullTax.setFont(new Font("Courier", Font.BOLD, 57));
		fullTax.setBackground(Color.LIGHT_GRAY);
		fullTax.setBounds(19, 225, 454, 113);
		contentPane.add(fullTax);

		// Simple tax calculator
		simpleTaxPanel = new SimpleTaxPanel();
		simpleTaxPanel.makeForm();

		// full tax calculator
		fullTaxPanel = new FullTaxPanel();
		fullTaxPanel.makeForm();
	}

	protected void do_mntmSimplifiedTaxReturn_actionPerformed(ActionEvent e) {
		changePanel(simpleTaxPanel);
	}

	protected void do_mntmCompleteTaxReturn_actionPerformed(ActionEvent e) {
		changePanel(fullTaxPanel);
	}

	private void changePanel(JPanel panel) {
		if (contentPane.getComponents().length > 1) {
			contentPane.remove(contentPane.getComponent(1));
		}
		contentPane.add(panel);
		contentPane.revalidate();
		contentPane.repaint();
	}
}
