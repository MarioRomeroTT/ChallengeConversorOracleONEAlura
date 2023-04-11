package gui;

import java.awt.EventQueue;
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

import conversorTemperatura.OperacionesTemp;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Window.Type;

public class VentanaConversorTemperatura extends JFrame implements ActionListener {

	private JPanel panelConverTemeperatura;
	private JTextField txtCantGrados;
	private JLabel lblResultTemConv;
	private JComboBox comboBoxTempOrigen;
	private JComboBox comboBoxTempDestino;
	private JButton btnConvertTemp;

	public VentanaConversorTemperatura() {
		setType(Type.POPUP);
		setBackground(new Color(153, 204, 255));
		setForeground(SystemColor.activeCaption);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConversorTemperatura.class.getResource("/imagenes/iconLogo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	

		setBounds(100, 100, 477, 322);
		panelConverTemeperatura = new JPanel();
		panelConverTemeperatura.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelConverTemeperatura);
		
		setTitle("CHALLENGER ALURA - CONVERSOR TEMPERATURA");
		setResizable(false);
		setLocationRelativeTo(null);
		panelConverTemeperatura.setLayout(null);
		
		JLabel lblIndicacionTemp1 = new JLabel("Seleccione los grados y tipo de medición a convertir");
		lblIndicacionTemp1.setBounds(10, 11, 443, 20);
		lblIndicacionTemp1.setFont(new Font("Calibri", Font.BOLD, 16));
		lblIndicacionTemp1.setHorizontalAlignment(SwingConstants.LEFT);
		panelConverTemeperatura.add(lblIndicacionTemp1);
		
		txtCantGrados = new JTextField();
		txtCantGrados.setBounds(66, 55, 96, 20);
		panelConverTemeperatura.add(txtCantGrados);
		txtCantGrados.addActionListener(this);
		txtCantGrados.setColumns(10);
		
		comboBoxTempOrigen = new JComboBox();
		comboBoxTempOrigen.setBounds(197, 55, 96, 20);
		comboBoxTempOrigen.setModel(new DefaultComboBoxModel(new String[] {"CELSIUS", "FAHRENHEIT", "KELVIN"}));
		comboBoxTempOrigen.addActionListener(this);
		panelConverTemeperatura.add(comboBoxTempOrigen);
		
		JLabel lblIndicacionTemp2 = new JLabel("Seleccione tipo medida a la que desea realizar la conversión");
		lblIndicacionTemp2.setBounds(10, 106, 426, 20);
		lblIndicacionTemp2.setFont(new Font("Calibri", Font.BOLD, 16));
		panelConverTemeperatura.add(lblIndicacionTemp2);
		
		comboBoxTempDestino = new JComboBox();
		comboBoxTempDestino.setBounds(66, 145, 96, 20);
		comboBoxTempDestino.setModel(new DefaultComboBoxModel(new String[] {"CELSIUS", "FAHRENHEIT", "KELVIN"}));
		comboBoxTempDestino.addActionListener(this);
		panelConverTemeperatura.add(comboBoxTempDestino);
		
		lblResultTemConv = new JLabel("");
		lblResultTemConv.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 19));
		lblResultTemConv.setBounds(26, 176, 341, 67);
		panelConverTemeperatura.add(lblResultTemConv);
		
		JButton btnSalirT = new JButton("Salir");
		btnSalirT.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 19));
		btnSalirT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		 dispose();
		 }});
		btnSalirT.setBounds(189, 251, 89, 23);
		panelConverTemeperatura.add(btnSalirT);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		OperacionesTemp converTemp = new OperacionesTemp();
		
		if(converTemp.ValidarNumero(txtCantGrados.getText())== true) {
			converTemp.setCantgrados(Double.parseDouble(txtCantGrados.getText()));
			converTemp.setMedidaOrigen(comboBoxTempOrigen.getSelectedItem().toString());
			converTemp.setMedidaDestino(comboBoxTempDestino.getSelectedItem().toString());
			converTemp.opConverTemp();
			
			lblResultTemConv.setText(converTemp.getCantgradostResultado() + " "+ converTemp.getSimbolo() +" " + converTemp.getMedidaDestino());
			
		} else {
			txtCantGrados.setText("");
			lblResultTemConv.setText("");
			JOptionPane.showMessageDialog(null, "Valor inválido");
		}		
	}
}
