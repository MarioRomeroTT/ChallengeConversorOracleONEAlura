package conversorTemperatura;

import java.text.DecimalFormat;

public class OperacionesTemp {

	private String medidaOrigen;
	private String medidaDestino;
	private String simbolo;
	private double cantgrados;
	private double cantgradostResultado;
	

	public String getMedidaOrigen() {
		return medidaOrigen;
	}

	public void setMedidaOrigen(String medidaOrigen) {
		this.medidaOrigen = medidaOrigen;
	}

	public String getMedidaDestino() {
		return medidaDestino;
	}

	public void setMedidaDestino(String medidaDestino) {
		this.medidaDestino = medidaDestino;
	}

	public double getCantgrados() {
		return cantgrados;
	}

	public void setCantgrados(double cantgrados) {
		this.cantgrados = cantgrados;
	}

	public String getCantgradostResultado() {
		return formato.format(cantgradostResultado);
	}

	public void setCantgradostResultado(double cantgradostResultado) {
		this.cantgradostResultado = cantgradostResultado;
	}

	DecimalFormat formato = new DecimalFormat("##.##");

	public boolean ValidarNumero(String input) {
		try {
			double x = Double.parseDouble(input);

			if (x >= 0 || x < 0)
				;
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void opConverTemp() {
		
		switch (medidaOrigen) {
	
		case "CELSIUS": {
			switch (medidaDestino) {
			case "FAHRENHEIT":
				
				cantgradostResultado = cantgrados * 1.8 + 32;
				simbolo = "°F"; 

				break;

			case "KELVIN":
				
				cantgradostResultado = cantgrados + 273.15;
				simbolo = "K";

				break;

			default:
				cantgradostResultado = cantgrados;
				simbolo = "°C";

			}
		}
			break;
		case "FAHRENHEIT": {
			switch (medidaDestino) {
			case "CELSIUS":
				
				cantgradostResultado = (cantgrados - 32) / 1.8;
				simbolo = "°C";

				break;

			case "KELVIN":
				cantgradostResultado = ((cantgrados - 32) / 1.8 )+ 273.15;
				simbolo = "K";

				break;

			default:
				cantgradostResultado = cantgrados;
				simbolo = "°F";

			}
		}

			break;
		// por defecto es el kelvin
		default: 
			switch (medidaDestino) {
			case "CELSIUS":
				cantgradostResultado = cantgrados -273.15;
				simbolo = "°C";

				break;

			case "FAHRENHEIT":
				cantgradostResultado = -(cantgrados -273.15)*1.8 + 32;
				simbolo = "°F";

				break;

			default:
				cantgradostResultado = cantgrados;
				simbolo = "K";

			}
		}
	}

	public String getSimbolo() {
		return simbolo;
	}
}