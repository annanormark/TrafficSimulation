public class Car {

    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng

    public Car(int bornTime, int dest){
	this.borntime = bornTime;
	this.dest = dest;
    }

    public getDest(){
	return this.dest;
    }

    public getBornTime(){
	return this.borntime;
    }
    // konstruktor och get-metoder
    ...

    public String toString() {
	return "Car (Borntime: bornTime="+getBornTime()+", Destination: dest="+getDest()+")";
    }
	
}

