package driver;


import view.MainViewWindow;
import view.View;

public class MVCDriver {

	public static void main(String[] args) 
	{
		
		View view = new MainViewWindow();  //View is interface
		
		view.start();  // start the program from here
	}

}
