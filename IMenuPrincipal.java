package Encuesta;
import net.rim.device.api.collection.util.SparseList;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.container.MainScreen;


public class IMenuPrincipal extends MainScreen  {

	BitmapField bitMapField;	
	SparseList lista = new SparseList();
	ButtonField btnNueva = new ButtonField("Nueva encuesta");
	ButtonField btnAbrir = new ButtonField("Abrir encuesta");
	
	public IMenuPrincipal() {
		
		super();
        LabelField title = new LabelField("Sistema de encuestas",LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH);
        setTitle(title);                           
        Bitmap logoBitMap = Bitmap.getBitmapResource("logoSI.png");
        bitMapField = new BitmapField(logoBitMap, Field.FIELD_LEFT);                                       
        add(bitMapField);
		
	}
	
	
	private MenuItem _nuevaMenu = new MenuItem("Nueva encuesta", 110, 10) {
        public void run() {
                   	
        	ICreaEncuesta creaEncuesta = new ICreaEncuesta(lista);
            UiApplication.getUiApplication().pushScreen(creaEncuesta );
        }
    };
    
	/*
    private MenuItem _abrirMenu = new MenuItem("Abrir encuesta", 110, 10) {
        public void run() {
           
        	IAbrirEncuesta abrirEncuesta = new IAbrirEncuesta();
            UiApplication.getUiApplication().pushScreen(abrirEncuesta );
        }
    };
    */
    
    protected void makeMenu( Menu menu, int instance )
    {
            menu.add(_nuevaMenu);
            
            /*
            menu.add(_abrirMenu);                       
            menu.add(_subirMenu);           
            menu.add(_aplicarMenu);
            menu.add(_sincronizarMenu);
            */
    }
			
      public boolean onClose()
      {
              Dialog.alert("Cerrando!");
              System.exit(0);
              return true;
      }

}
