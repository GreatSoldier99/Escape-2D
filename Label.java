import greenfoot.*;

/**
 * Label. Esta clase sirve para crear "etiquetas" con imágenes, que pueden usarse para crear titulos o textos simples.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class Label extends Actor{
    private GreenfootImage labelImage;
    private String labelText;
    //No me funciona usar \t, lo corregire en cuanto pueda solucionarlo.
    private String splitter = "                        ";
    
    /**
     * Label. Este constructor es utilizado cuando se requiere hacer textos de forma simple. Recibe como parámetros:
     * -Record. Recibe un objeto Record el cual se usa para crear el texto que muestra el record (nombre y puntuación).
     */
    public Label(Record record){
        labelText=record.getNamePlayer()+splitter+Integer.toString(record.getScorePlayer());
        labelImage = new GreenfootImage(labelText,35,Color.WHITE,null,Color.BLACK);
        setImage(labelImage);
    }
    
    /**
     * Label. Este constructor es utilizado cuando se reuqiere hacer textos de forma personalizada, como lo son los titulos. Recibe como parámetros:
     * -text. El texto que estara en la imágen.
     * -foreGround. El color de las letras del texto.
     * -outLine. El color del contorno de las letras del texto.
     */
    public Label(String text, Color foreGround, Color outLine){
        labelImage = new GreenfootImage(text,50,foreGround,null,outLine);
        setImage(labelImage);
    }
}
