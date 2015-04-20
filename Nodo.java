package Encuesta;


public class Nodo {

	public String strPregunta;
	public String strRespuestas[] = new String[10];
	int ultimo = 0;
	
			
	//Primer constructor
	public Nodo(String strPregunta) {		
		
		this.strPregunta = strPregunta;		
	
	}
	
	public void setRespuesta(String strRespuesta) {
		
		strRespuestas[ultimo] = strRespuesta;
		ultimo++;
		
	}
	
	public int getUltimo() {
		
		return ultimo;
	}
	
	

	public String getStrPregunta() {
		return strPregunta;
	}



	public void setStrPregunta(String strPregunta) {
		this.strPregunta = strPregunta;
	}



	public String[] getStrRespuestas() {
		return strRespuestas;
	}


	
	public void setStrRespuestas(String[] strRespuestas) {
		this.strRespuestas = strRespuestas;
	}
}

