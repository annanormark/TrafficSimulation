public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    public Light(int period, int green) {
	this.period = period;
	this.green = green;
    }

    public void    step() { 
	while(this.time < this.period)
	    this.time++;
       // Stegar fram klocka ett steg
    }

    public boolean isGreen()   {
	if(this.time<this.green)
	    return true;
	return false;
	// Returnerar true om time<green, annars false
    }

    public String  toString()  {
	return "Light (Period: period="+this.period+", Time; time="+this.time+", Green: green="+this.green+")";
    }
	
}

