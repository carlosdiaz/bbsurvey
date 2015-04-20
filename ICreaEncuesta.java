package Encuesta;

import net.rim.device.api.collection.util.SparseList;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;


public class ICreaEncuesta extends MainScreen implements FieldChangeListener{

	LabelField lblNumPregunta;			//Enumera la pregunta
	ObjectChoiceField choiceField;		//Da el tipo de pregunta
	LabelField efPregunta;				//Escriba su pregunta
	//RichTextField txtPreguntaField;
	TextField txtPreguntaField;
	ButtonField btnSiguiente;			
	ButtonField btnAnterior;
	ButtonField btnFinalizar;	
	ButtonField btnAgregarRespuestas;	
	//ListField lfRespuestas;
	
	RespuestasListField lfRespuestas;
		
	String choices[] = {"Simple", "Multiple"};
	
	
	SparseList lista;				//El objeto tipo lista donde guardare toda la información de los nodos	
	int indice = 0;
	Nodo nodo = null;
		
	HorizontalFieldManager manager1;
		
	public void inicializaControles() {
		
		setTitle("Sistema de encuestas - Nueva");
		lblNumPregunta = new LabelField("1");
		choiceField = new ObjectChoiceField("Tipo de pregunta", choices);
		efPregunta = new LabelField("Escriba su pregunta: ");	
		txtPreguntaField = new TextField(30);						//Probablemente este widget lo cambie x uno mayor
		//txtPreguntaField = new RichTextField();								
		btnSiguiente = new ButtonField("Siguiente");
		btnAnterior = new ButtonField("Anterior");
		btnFinalizar = new ButtonField("Finalizar");
		btnAgregarRespuestas = new ButtonField("Agregar respuestas");
		//lfRespuestas = new ListField(10);
		lfRespuestas = new RespuestasListField();
		
		
	}
	
	
	public ICreaEncuesta(SparseList lista) {
			
		super();
		this.lista = lista;
		inicializaControles();
								
		btnSiguiente.setChangeListener(this);
		btnAnterior.setChangeListener(this);
		btnAgregarRespuestas.setChangeListener(this);

								
		add(lblNumPregunta);
		add(choiceField);
		add(efPregunta);		
		add(txtPreguntaField);
		//instanciamos al manager1
		manager1 = new HorizontalFieldManager(Field.FIELD_LEFT);
		
		manager1.add(btnSiguiente);
		manager1.add(btnAnterior);			
		add(manager1);			
		add(btnFinalizar);
		add(btnAgregarRespuestas);
		add(lfRespuestas);
															
	}
	
public void fieldChanged(Field field, int context) {		
		
		if (field==btnSiguiente) {
			//if(hayRespuestas() && hayPregunta())
			if(hayPregunta())
			{
				Nodo nuevo = new Nodo(txtPreguntaField.getText());
				//Aqui sigue el proceso de guardar en el XML
				lista.add(nuevo);
				indice++;
				limpiaControles();				
			}
			else {				
				Dialog.alert("Ingrese preguntas y respuestas");
			}
		} 
		else if (field==btnAnterior) {						
			if (indice>=1) {		//Si hay mas de un elemento
				indice--;
				//txtPreguntaField.setText((String)lista.get(indice));
				Dialog.alert("Adentro de btnAnterior");
			}			
		}
		else if (field == btnAgregarRespuestas) {
			Dialog.alert("Adentro de lfRespuestas");
			if(hayPregunta()) {
			  IAgregaRespuestas iRespuestas = new IAgregaRespuestas();
			  UiApplication.getUiApplication().pushScreen(iRespuestas);	
			}
			
		}
											
}
	

public void limpiaControles() {
	
	txtPreguntaField.setText("");
	//Faltaría limpiar el ListField
	
	
}


public boolean hayPregunta() {
		
	if(txtPreguntaField.getText().compareTo("")==0 )
	{
		//Dialog.alert("Vacia");
		return false;
	}
	else{
		//Dialog.alert("Llena");
		return true;
		}	
}


public boolean hayRespuestas() {
	if(lfRespuestas.isEmpty()) 
		return true;		
	else 		
		return false;	
}

	
}
