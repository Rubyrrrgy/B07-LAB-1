public class Driver {
public static void main(String [] args) {
Polynomial p = new Polynomial();
System.out.println(p.evaluate(3));
double [] c1 = {6,0,0,5};
int []c12 = {1,0,0,4};
Polynomial p1 = new Polynomial(c1,c12);
double [] c2 = {0,-2,0,0,-9};
int [] c22 = {0,5,0,0,10};
Polynomial p2 = new Polynomial(c2,c22);
Polynomial s = p1.add(p2);
System.out.println("s(1) = " + s.evaluate(1));
Polynomial z = p1.multiply(p2);
System.out.println(z.evaluate(1));
if(s.hasRoot(1))
System.out.println("1 is a root of s");
else
System.out.println("1 is not a root of s");
}
}