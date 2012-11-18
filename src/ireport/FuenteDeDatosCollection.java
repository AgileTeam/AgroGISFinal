package ireport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;


public class FuenteDeDatosCollection {
    private static java.util.Collection coleccionDeDatos;
     public  JRDataSource createBeanCollectionDatasource()
    {
        
        
        return new JRBeanCollectionDataSource(createBeanCollection());
    }    
     
     public static  java.util.Collection  createBeanCollection()
     {   
            
        return getColeccionDeDatos();
     }

    public static java.util.Collection getColeccionDeDatos() {
        return coleccionDeDatos;
    }

    public static void setColeccionDeDatos(java.util.Collection aColeccionDeDatos) {
        coleccionDeDatos = aColeccionDeDatos;
    }
}
