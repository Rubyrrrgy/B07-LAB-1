
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Polynomial {
	double[]coefficients; 
	int[]exponents;
public Polynomial () {
	this.coefficients = null;
	this.exponents = null;
}
public Polynomial (double[] coefficients, int[] exponents) {
    this.coefficients = coefficients;
    this.exponents = exponents;
}
public Polynomial add (Polynomial other) {
	if(this.coefficients == null && other.coefficients != null) {
		return other;
	}
	if(this.coefficients != null && other.coefficients == null) {
		return this;
	}
	if(this.coefficients == null && other.coefficients == null) {
		return this;
	}
    int a = coefficients.length;
    int b = other.coefficients.length;
    double[]c = new double[a+b];
    int[]d = new int[a+b];
    for(int i = 0; i<a; i++) {
    	c[i] = coefficients[i];
    	d[i] = exponents[i];
    }
    int lenf = a;
    for(int i = 0; i<b; i++) {
    	for(int j = 0; j<= lenf; j++) {
    		if(j<lenf && d[j] == other.exponents[i]) {
    			c[j] = c[j] + other.coefficients[i];
    			j = j + lenf + b + a;
    		}
    		else if(j == lenf) {
    			d[j] = other.exponents[i];
    			c[j] = other.coefficients[i];
    			lenf++;
    			j = j + lenf + b + a;
    		}
    	}
    }
    double[]fnal = new double[lenf];
    int[]fnal2 = new int[lenf];
    for(int i = 0; i<lenf; i++) {
    	fnal[i] = c[i];
    	fnal2[i] = d[i];
    }
    return new Polynomial(fnal, fnal2);
}

public Polynomial multiply(Polynomial other) {
	if(coefficients == null || other.coefficients == null) {
		return new Polynomial();
	}
	Polynomial init_poly = new Polynomial();
	for(int i = 0; i < coefficients.length; i++) {
		double[]c = new double [other.coefficients.length];
	    int[]d = new int [other.coefficients.length];
	    for (int j = 0; j < other.coefficients.length; j++ ) {
	    	c[j]= other.coefficients[j]* this.coefficients[i];
	        d[j]= other.exponents[j]+ this.exponents[i];
	    }
		init_poly = init_poly.add(new Polynomial(c,d));
		
		
	}
	return init_poly;
			
	
	
	
	
	
}
public double evaluate (double x) {
	if(coefficients == null) {
		return 0;
	}
	double eval = 0;
	for (int i = 0; i < coefficients.length;i++) {
		eval += coefficients[i]* Math.pow(x,exponents[i]) ;
	
	}
	return eval;
}
public boolean hasRoot(double r) {
	return evaluate(r)== 0;
}

public Polynomial(File file) throws Exception
{
	Scanner myScanner = new Scanner (file);
	
	if(!myScanner.hasNextLine()) {
		this.coefficients = null;
		this.exponents = null;
	}
	else {
		String line = myScanner.nextLine();
		line = line.replace("-","+-");
		
		String[] poly_arr = line.split("\\+");
		
		this.exponents = new int [poly_arr.length];
		this.coefficients = new double [poly_arr.length];
		
		for(int i = 0; i < poly_arr.length;i++) {
			String[] subArray = poly_arr[i].split("x");
			coefficients[i] = Double.parseDouble(subArray[0]);
			
			if(subArray.length > 1) {
				exponents[i] = Integer.parseInt(subArray[1]);
				
			}
			else {
				exponents[i] = 0;
			}
		}
	
}
myScanner.close();
}

public void saveToFile(String myFile)throws Exception{
	String writesString = "";
	
	for(int i = 0; i < this.coefficients.length; i++) {
		writesString += coefficients[i];
		if(exponents[i]!= 0) {
			writesString+="x" + exponents[i];
			
		}
		writesString += "+";
				
	}
	
	if(writesString.endsWith("+")) {
		writesString = writesString.substring(0,writesString.length()-1);
		
	}
	FileWriter myWriter = new FileWriter(new File(myFile));
	myWriter.write(writesString);
	myWriter.close();
	
	
}
}
