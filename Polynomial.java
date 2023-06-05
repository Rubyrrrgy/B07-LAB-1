public class Polynomial {
	double[]coefficients; 

public Polynomial () {
	coefficients = new double[]{0};
}
public Polynomial (double[]a) {
    coefficients = a;
}
public Polynomial add (Polynomial other) {
    int a = coefficients.length;
    int b = other.coefficients.length;
    double[] c = new double[Math.max(a, b)];
    if(a>b) {c = this.coefficients;}
    else {c = other.coefficients;}
    for (int i = 0; i < Math.min(a, b); i++) {  
    		c[i] = coefficients[i] + other.coefficients[i];
    	}
    return new Polynomial(c);
}
public double evaluate (double x) {
	double eval = 0;
	for (int i = 0; i < coefficients.length;i++) {
		eval += coefficients[i] * Math.pow(x, i) ;
	
	}
	return eval;
}
public boolean hasRoot(double r) {
	return evaluate(r)== 0;
}
}
