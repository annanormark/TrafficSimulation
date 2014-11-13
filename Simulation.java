package TS;
import java.util.*;
public class Simulation {

    /**
       Makes the trafficsystem and simulation, and lets the user write the input to the system.
     */
    public static void main(String [] args) {
	Scanner ob = new Scanner(System.in);
	System.out.println("All input values must be in numbers (integers)");
	System.out.println("Length of simulation");
	int n = ob.nextInt();
	
	System.out.println("The length of in-lane:");
	int r0 = ob.nextInt();
	System.out.println("The length of the turn-lane and the forward-lane:");
	int r12 = ob.nextInt();
	System.out.println("The period of the forward light:");
	int flight = ob.nextInt();
	System.out.println("The period of the turning light:");
	int tlight = ob.nextInt();	
	System.out.println("The chance of a car arriving:");
	int car = ob.nextInt();
	
	TrafficSystem T = new TrafficSystem(r0, r12, flight, tlight, car);
	for(int i = 0; i < n; i++){
	    try {
		Thread.sleep(500);                 
	    } 
	    catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    T.step();
	    T.print();
	}
	T.printstat();
    }
}
