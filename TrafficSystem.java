package TS;
import java.util.Scanner;
import java.util.Random;
public class TrafficSystem {

    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;
    
    Scanner ob = new Scanner(System.in);
    int chance; 
    Random rand = new Random();
    
    private int left = 0;
    private int forward = 0;
    private int carsin = 0;
    private int carsout = 0;
    private int total = 0;
    private int maxtime = 0;    
    private int time = 0;
    
    /** Prints out the choices for the user and takes in the users input on the right traffic components
     */
    public TrafficSystem(int r0, int r12, int flight, int tlight, int ccar) {
	this.r0 = new Lane(r0);
	this.r1 = new Lane(r12); 
	this.r2 = new Lane(r12);
	this.s1 = new Light(flight, (flight/2));	
	this.s2 = new Light(tlight, (tlight/2));
	this.chance = ccar;
    }

    /** steps the car forward in the array(road) aswell as the lights and the time. It also makes new cars to put in on the array(road) and takes out the old ones at the light. It does everything.
     */
    public void step() {
	int i = rand.nextInt(chance);
	if(s1.isGreen()){
	    if(r1.firstCar() != null){
	    	if((this.time - r1.firstCar().getBornTime()) > this.maxtime){
	    		this.maxtime = (this.time - r1.firstCar().getBornTime());
	    	}
	    this.total = (this.total + (this.time - r1.firstCar().getBornTime())); 
	    r1.getFirst();
	    this.carsout++;
	    }
	}
	r1.step();
	if(s2.isGreen()){
		if(r2.firstCar() != null){
		   if((this.time - r2.firstCar().getBornTime()) > this.maxtime){
		    this.maxtime = (this.time - r2.firstCar().getBornTime());
		  }
		 this.total = (this.total + (this.time - r2.firstCar().getBornTime())); 
		 r2.getFirst();
		 this.carsout++;
	    }
	}
	r2.step();
	if(r0.firstCar() != null){
	    if((r0.firstCar().getDest() == 2) && r2.lastFree()){
		r2.putLast(r0.firstCar());
		r0.getFirst();
		this.left++;
	    }
	    else if((r0.firstCar().getDest() == 1) && r1.lastFree()){
		r1.putLast(r0.firstCar());
		r0.getFirst();
		this.forward++;
	    }
	}
	r0.step();
	if(i == 0){
	    Car c = new Car(this.time, (rand.nextInt(2) + 1));
	    r0.putLast(c);
	    this.carsin++;
	}
	s1.step();
	s2.step();
	this.time ++;
    }

    /**Prints out the simulation of the traffic system which includes lights and road
     */
    public void print() {
	System.out.println("" +s1.toString()+"\t" +r1.toString()+ "" +r0.toString()+ "\n" +s2.toString()+ "\t" +r2.toString()+"/\n\n");
    }
    
/** Counts how many cars that drive into the roads.
 * @return The number of cars that drove into the system.
 */
    public int getcarsin(){
	return this.carsin;
    }

    /** Counts how many cars that drive out from the roads.
     * @return The number of cars that drove out of the system.
     */
    public int getcarsout(){
	return this.carsout;
    }
    
 /** Count how many cars that turn left.
  * @return The number of cars that turned left in the system.
  */
    public int getleft(){
	return this.left;
    }

    /**count how many cars that drive forward.
     * @return The number of cars that drove forward.
     */
    public int getforward(){
	return this.forward;
    }
    
    /** calculates the average time it takes a car to go thru the system.
     * @return The average time i took a car to drive thru the system.
     */
    public int getTotal(){
    	if (this.carsout == 0)
    		return 0;
	    else{
	    	this.total = (this.total / this.carsout);
	    	return this.total;
	    	}
    }
    
    /** calculates the maximum time it takes a car to go thru the system.
     * @return The maximum time it took a car to go thru the system.
     */
    public int getMax(){
    	return this.maxtime;
    }

    /** Prints the statics of the traffic system 
     */

    public void printstat(){
	System.out.println("Number of cars in: " +getcarsin()+ "\nNumber of cars going left: " +getleft()); 
	System.out.println("Number of cars driving forward: " +getforward()+ "\nNumber of cars out: " +getcarsout()+ "\nThe average time it took for a car to go thru the system: " +getTotal()+ " loops \nThe maximum time it took for a car to go thru the system: " +getMax()+ " loops \n");
    }

}
