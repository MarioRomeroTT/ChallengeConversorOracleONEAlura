package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversorDivisa.OperacionesDivisa;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel panelPrincial;
	private JButton btnDivisa, btnTemperatura;
	OperacionesDivisa operaConversionDivisa;


	public VentanaPrincipal() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/iconLogo.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		panelPrincial = new JPanel();
		panelPrincial.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincial);
		panelPrincial.setLayout(null);
		
		setTitle("CHALLENGER ALURA - CONVERSOR");
		setResizable(false);
		
		JLabel lblPresentacion = new JLabel("Proyect JAVA - Challenger Conversor ");
		lblPresentacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresentacion.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		lblPresentacion.setBounds(0, 11, 426, 44);
		panelPrincial.add(lblPresentacion);
		
		JLabel lblEnunciado = new JLabel("Elija el tipo de Conversor que desea utilizar");
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEnunciado.setBounds(0, 77, 416, 44);
		panelPrincial.add(lblEnunciado);
		
		btnDivisa = new JButton("DIVISAS");
		btnDivisa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconCambio.png")));
		btnDivisa.setBounds(76, 143, 131, 30);
		btnDivisa.addActionListener(this);
		panelPrincial.add(btnDivisa);
		
		btnTemperatura = new JButton("TEMPERATURA");
		btnTemperatura.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconTemp.png")));
		btnTemperatura.setBounds(223, 143, 131, 30);
		btnTemperatura.addActionListener(this);
		panelPrincial.add(btnTemperatura);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnDivisa == e.getSource()) {
			VentanaConversorDivisas ventaConversorMoneda =new VentanaConversorDivisas();
			ventaConversorMoneda.setVisible(true);
						
			
			
		} else if(btnTemperatura == e.getSource()) {
			
			VentanaConversorTemperatura ventanaConversorTemp= new VentanaConversorTemperatura();
			ventanaConversorTemp.setVisible(true);
					
		}
		
	}
}
