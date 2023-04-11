package aplicacionConversor;

import gui.VentanaPrincipal;


public class Aplicacion {
	public Aplicacion() {
		presentarMenuPrincipal();
	}

	private void presentarMenuPrincipal() {
		VentanaPrincipal ventanaMenuPrincipal = new VentanaPrincipal();
		ventanaMenuPrincipal.setVisible(true);
	}
}