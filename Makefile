
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $*.java
	
all: $(CLASSES)
	$(JC) $(JFLAGS) $(CLASSES)

CLASSES = \
	Car.java \
	Lane.java \
	Light.java \
	Simulation.java \
	TrafficSystem.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class


test:  AllTests.class
	java junit.textui.TestRunner AllTests 
