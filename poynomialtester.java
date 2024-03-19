public class poynomialtester {
    public static void main(String[] args) {
       double [] coefficients = {3.0,-5.0,0.0,12.0};
        polynomial k = new polynomial(coefficients);
        System.out.println(k.toString());
        System.out.println(k.eval(5));
        System.out.println(k.eval2(5));
        System.out.println(k.getDegree());
        System.out.println();
        double [] coeffecient_for_p = {3.0,4.0,5.0,2.0};
        double [] coeffecient_for_q = {2.0,4.0,1.0};
        polynomial px = new polynomial(coeffecient_for_p);
        polynomial qx = new polynomial(coeffecient_for_q);
        polynomial added = px.add(qx);
        polynomial multiplied = px.mul(qx);      
        // controling the add, sub, mutliply
        System.out.println(added);
        System.out.println(px.sub(qx));
        System.out.println(multiplied);
        System.out.println();
        // controling the multiply
        double [] coeffecient_for_a = {3.0,4.0,1.0};
        double [] coeffecient_for_b = {2.0,1.0};
        polynomial a = new polynomial(coeffecient_for_a);
        polynomial b = new polynomial(coeffecient_for_b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.compose(b));
        // controling the division
        System.out.println();
        double [] coeffecient_for_c = {3.0,4.0,1.0,3.0,0.0,2.0};
        double [] coeffecient_for_d = {2.0,1.0};
        polynomial c = new polynomial(coeffecient_for_c);
        polynomial d = new polynomial(coeffecient_for_d);
        System.out.println(c.dİV(d));
        System.out.println();
        // starting to test the findequal method
        double [] coeffecient_for_e = {10.0};
        double [] coeffecient_for_f = {2.0,1.0};
        double [] coeffecient_for_g = {2.0};
        double [] coeffecient_for_h = {2.0};
        polynomial e = new polynomial(coeffecient_for_e);
        polynomial f = new polynomial(coeffecient_for_f);
        polynomial g = new polynomial(coeffecient_for_g);
        polynomial h = new polynomial(coeffecient_for_h);
        int [] result = e.findEqual(f);
        int [] result2 = g.findEqual(h);
        for(int i = 0; i < result.length; i++)
        {
            if(result[i] != 0)
            {
            System.out.print(result[i]);
            }
        }
        System.out.println();
        for(int i = 0; i < result2.length; i++)
        {
            if(result2[i] != 0)
            {
            System.out.print(result2[i]);
            }
        }    
    }
}
