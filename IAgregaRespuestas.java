package Encuesta;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class IAgregaRespuestas extends MainScreen implements FieldChangeListener{
	
	LabelField lfResp1 = new LabelField("Respuesta: ");	
	TextField tfResp1 = new TextField(10);	
	HorizontalFieldManager hf1;
	ButtonField btnGuardar = new ButtonField("Guardar");
	ButtonField btnCancelar = new ButtonField("Cancelar");
	
	
	public IAgregaRespuestas() {
		// TODO Auto-generated constructor stub
		setTitle("Encuestas - Agregar respuestas" );
		
		btnGuardar.setChangeListener(this);
		hf1 = new HorizontalFieldManager(Field.FIELD_LEFT);
		
		add(lfResp1);
    	add(tfResp1);
    	add(hf1);
    	hf1.add(btnGuardar);
    	hf1.add(btnCancelar);    	    	    
		
	}
	
	
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if (field==btnGuardar) {
			
			
		}
		
	}
	

}
