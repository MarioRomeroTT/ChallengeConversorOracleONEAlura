package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import conversorDivisa.OperacionesDivisa;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class VentanaConversorDivisas extends JFrame implements ActionListener {

	private JPanel panelConvertorDivisa;
	private JTextField txtCantDivisa;
	private JComboBox comboBoxDivisaOrigen;
	private JComboBox comboBoxDivisaDestino;
	private JLabel lblResultadoDivisa;
	private JButton btnSalirD;
	


	public VentanaConversorDivisas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConversorDivisas.class.getResource("/imagenes/iconLogo.png")));
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		panelConvertorDivisa = new JPanel();
		panelConvertorDivisa.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelConvertorDivisa);
		panelConvertorDivisa.setLayout(null);
		
		setTitle("CHALLENGER ALURA - CONVERSOR DIVISAS");
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		JLabel lblIndicacionDivisa1 = new JLabel("Seleccione la moneda y cantidad a convertir");
		lblIndicacionDivisa1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblIndicacionDivisa1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIndicacionDivisa1.setBounds(25, 11, 375, 41);
		panelConvertorDivisa.add(lblIndicacionDivisa1);
				
		txtCantDivisa = new JTextField();
		txtCantDivisa.setBounds(66, 55, 96, 20);
		panelConvertorDivisa.add(txtCantDivisa);
		txtCantDivisa.addActionListener(this);
		txtCantDivisa.setColumns(10);
		
		comboBoxDivisaOrigen = new JComboBox();
		comboBoxDivisaOrigen.setModel(new DefaultComboBoxModel(new String[] {"ARG","EUR", "GBP", "JPY", "KRW", "USD"}));
		comboBoxDivisaOrigen.setBounds(197, 54, 96, 21);
		comboBoxDivisaOrigen.addActionListener(this);
		panelConvertorDivisa.add(comboBoxDivisaOrigen);
		
		JLabel lblIndicacionDivisa2 = new JLabel("Seleccione la moneda a la que desea realizar la conversión");
		lblIndicacionDivisa2.setFont(new Font("Calibri", Font.BOLD, 16));
		lblIndicacionDivisa2.setBounds(25, 86, 401, 41);
		panelConvertorDivisa.add(lblIndicacionDivisa2);
		
		
		comboBoxDivisaDestino = new JComboBox();
		comboBoxDivisaDestino.setModel(new DefaultComboBoxModel(new String[] {"ARG","EUR", "GBP", "JPY", "KRW", "USD"}));
		comboBoxDivisaDestino.setBounds(66, 126, 96, 21);
		comboBoxDivisaDestino.addActionListener(this);
		panelConvertorDivisa.add(comboBoxDivisaDestino);
		
		lblResultadoDivisa = new JLabel("");
		lblResultadoDivisa.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 19));
		lblResultadoDivisa.setBounds(66, 170, 303, 54);
		panelConvertorDivisa.add(lblResultadoDivisa);
		
		btnSalirD = new JButton("Salir");
		btnSalirD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalirD.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 19));
		btnSalirD.setBounds(173, 229, 89, 23);
		panelConvertorDivisa.add(btnSalirD);
		

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		OperacionesDivisa convertir = new OperacionesDivisa();
		if (convertir.ValidarNumero(txtCantDivisa.getText()) == true) {
			
			convertir.setCant(Double.parseDouble(txtCantDivisa.getText()));
			convertir.setDivisaOrigen(comboBoxDivisaOrigen.getSelectedItem().toString());
			convertir.setDivisaDestino(comboBoxDivisaDestino.getSelectedItem().toString());
			convertir.conversionDivisa();
			lblResultadoDivisa.setText(	"SON " + convertir.getCantResultado()+ " " + convertir.getDivisaDestino());
			
		} else {
			txtCantDivisa.setText("");
			lblResultadoDivisa.setText("");
            JOptionPane.showMessageDialog(null, "Valor inválido");
            }

		
		}
	
	
	}

