//file window
/**
 * Project_CSE215Lab
 * Date: 04.06.20 
 * @Name: Md Rashad Tanjim ID: 1620952042
 * @Name: Abdullah Bin Khurshid ID: 1813050642
 * @Name: Sumaya Siddique ID: 1912180642
 */
package Project_HMRS;
import java.io.File;
import java.util.Scanner;
/**
 * Project_CSE215Lab
 * Date: 10.03.20 
 * @Name: Md Rashad Tanjim ID: 1620952042
 */
public class Update {
    private Guest[] ob;
	
	public Update() {}
	
	public Guest[] GuestInitialization()
	{
		ob = new Guest[20];
		
		int index=0;
		
		try
		{
			File f = new File("clientInfo.txt");
			Scanner input = new Scanner(f);
					
			while(input.hasNextLine())
			{
				ob[index] = new Guest(
                                        input.nextLine(),
                                        input.nextLine(),
					input.nextLine(),
                                        input.nextLine(),
                                        input.nextLine(),
                                        input.nextLine(),
                                        input.nextLine(),
                                        input.nextLine(),
                                        input.nextLine()
                                        );
				index++;
			}	
		
		}
		
		catch(Exception e){}
				
		return ob;
		
	}
	
	
}
