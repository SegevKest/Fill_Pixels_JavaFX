import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import java.util.Random;


// The Class responsible for creating the Controller of the Matrix
// With Btn + Canvas
public class MyMatrixController {

    @FXML
    private Canvas canvasObj;

    @FXML
    private Button generateBtn;
   
    private GraphicsContext gc; 
    
    
	Random rnd = new Random(); // Random Object

	private final int TEN = 10;	// Ten Constant

	
	// Init Method - create canvas  + draw the not filled matrix
    public void initialize() {	
    	gc = canvasObj.getGraphicsContext2D();
    	
    	// Initialize the matrix
    	for (int i =0; i<=canvasObj.getHeight();i+=TEN)	 		
    		for (int j =0; j<=canvasObj.getWidth();j+=TEN) 
    			gc.strokeRect(i, j, TEN, TEN);
    }
    
    @FXML
    void btnPressed(ActionEvent event) {
    	
    	int rndNumber, serial, countFilled = 0;
    	
    	// Calculate the limit rectangle to fill
    	double totalRects = ( (canvasObj.getWidth() * canvasObj.getHeight( )) / (TEN*TEN) );
    	double totalRectsToFill = totalRects * 0.1;	// 10% Limit
    	
    	// Clear current state of canvas
    	gc.clearRect(0, 0,canvasObj.getWidth() , canvasObj.getHeight());
    	
    	for (int i =0; i<=canvasObj.getHeight();i+=TEN)	{
    		for (int j =0; j<=canvasObj.getWidth();j+=TEN) {
    			
    			//Get random numbers
	    		serial = rnd.nextInt(TEN);
	    		rndNumber = rnd.nextInt(TEN);
	    			   
	    		// Logic to fill the cell
	    		if(serial == rndNumber && countFilled < totalRectsToFill)	{
	    			gc.fillRect(i, j, TEN, TEN);
	    			countFilled++;
	    		}
	    		else
	    			gc.strokeRect(i, j, TEN, TEN);
    		}
    	}
    }
    
    

}
