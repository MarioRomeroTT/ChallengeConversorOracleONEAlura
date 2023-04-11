package conversorDivisa;

import java.text.DecimalFormat;

public class OperacionesDivisa {
	
	
	private String divisaOrigen;
	private String divisaDestino;
	private double cant;
	private double cantResultado;
	

  
	public String getDivisaOrigen() {
		return divisaOrigen;
	}
	public void setDivisaOrigen(String divisaOrigen) {
		this.divisaOrigen = divisaOrigen;
	}
	public String getDivisaDestino() {
		return divisaDestino;
	}
	public void setDivisaDestino(String divisaDestino) {
		this.divisaDestino = divisaDestino;
	}
	public double getCant() {
		return cant;
	}
	public void setCant(double cant) {
		this.cant = cant;
	}
	public String getCantResultado() {
		return formato.format(cantResultado);
	}
	public void setCantResultado(double cantResultado) {
		this.cantResultado = cantResultado;
	}
	
	public OperacionesDivisa() {
	
	}
	
	DecimalFormat formato = new DecimalFormat("##.####");
	
	   public boolean ValidarNumero(String input) {
	        try {
	        	double x = Double.parseDouble(input);
	            
	            if(x >= 0 || x < 0);
	                return true;
	            } catch (NumberFormatException e) {
	                return false;
	            }
	    }

	public void conversionDivisa() {
		
		switch (divisaOrigen) {
		case "ARG": {
			switch (divisaDestino) {
			case "EUR":
				cantResultado = cant * 0.0043;

				break;
			case "GBP":
				cantResultado = cant * 0.0038;

				break;
			case "JPY":
				cantResultado = cant * 0.63;

				break;
			case "KRW":
				cantResultado = cant * 6.21;

				break;
			case "USD":
				cantResultado = cant * 0.0047;

				break;

			default:
				cantResultado = cant;
			}
			;
			break;
		}
		case "EUR": {

			switch (divisaDestino) {

			case "ARG":
				cantResultado = cant * 230.73;

				break;

			case "GBP":
				cantResultado = cant * 0.88;

				break;
			case "JPY":
				cantResultado = cant * 145.07;

				break;
			case "KRW":
				cantResultado = cant * 1435.16;

				break;
			case "USD":
				cantResultado = cant * 1.09;

				break;

			default:
				cantResultado = cant;
			}

			break;
		}
		case "GBP": {
			switch (divisaDestino) {

			case "ARG":
				cantResultado = cant * 263.04;

				break;
			case "EUR":
				cantResultado = cant * 1.14;

				break;

			case "JPY":
				cantResultado = cant * 165.42;

				break;
			case "KRW":
				cantResultado = cant * 1633.30;

				break;
			case "USD":
				cantResultado = cant * 1.24;

				break;
			default:
				cantResultado = cant;
			}

			break;
		}
		case "JPY": {
			switch (divisaDestino) {

			case "ARG":
				cantResultado = cant * 1.59;

				break;
			case "EUR":
				cantResultado = cant * 0.0069;

				break;
			case "GBP":
				cantResultado = cant * 0.0060;

				break;

			case "KRW":
				cantResultado = cant * 9.87;

				break;
			case "USD":
				cantResultado = cant * 0.0075;

				break;
			default:
				cantResultado = cant;
			}

			break;
		}
		case "KRW": {
			switch (divisaDestino) {

			case "ARG":
				cantResultado = cant * 0.16;

				break;
			case "EUR":
				cantResultado = cant * 0.00070;

				break;
			case "GBP":
				cantResultado = cant * 0.00061;

				break;
			case "JPY":
				cantResultado = cant * 0.10;

				break;

			case "USD":
				cantResultado = cant * 0.00076;

				break;
			default:
				cantResultado = cant;
			}

			break;
		}
		// por defecto es USD
		default: {
			switch (divisaDestino) {

			case "ARG":
				cantResultado = cant * 212.41;

				break;
			case "EUR":
				cantResultado = cant * 0.92;

				break;
			case "GBP":
				cantResultado = cant * 0.81;

				break;
			case "JPY":
				cantResultado = cant * 133.56;

				break;
			case "KRW":
				cantResultado = cant * 1319.00;

				break;

			default:
				cantResultado = cant;
			}
		}
		}
	}

}



	 