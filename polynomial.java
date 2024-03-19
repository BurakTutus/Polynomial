

public class polynomial {

    private double [] coefficients;

    public polynomial(int d, double c)
    {
        coefficients = new double[d+1];
        coefficients[d] = c;        
    }
    public polynomial()
    {
        //coefficients = new double[1];
        //coefficients [0] = 0;
        this(0,0.0);
    }
    public polynomial(double [] coefficients)
    {
        this.coefficients = coefficients;
    }
    public double getCoefficient(int degree)
    {
        if(degree >= coefficients.length)
        {
            return 0;
        }
        return coefficients[degree];
    }
    public int getDegree()
    {
        for(int i = coefficients.length - 1; i >= 0; i--)
        {
            if(coefficients[i] != 0)
            {
                return i;
            }
        }
        return 0;
    }
    public String toString()
    {
        String expression = "";
        for(int i = 0; i < coefficients.length; i++)
        {
            if(coefficients[i] != 0)
            {
                if(coefficients[i] > 0 && i != 0)
                {
                    expression += "+";
                }
                expression += coefficients[i];                
                if(i != 0 )
                {
                    expression += "x^" + i;
                }
                expression += " ";
            }

        }
        return expression;
    }
    public double eval(double x)
    {
        double sum = 0;
        for(int i = 0; i < coefficients.length; i++)
        {
            sum += Math.pow(x, i) * coefficients[i];
        }
        return sum;
    }
    public double eval2(double x)
    {
        double sum = 1;       
        
            sum = (coefficients[coefficients.length - 1] * x) + coefficients[coefficients.length - 2];
            for(int i = coefficients.length - 2; i > 0; i--)
            {
                sum = (sum * x) + coefficients[i -1];
            }
        return sum;
    }
    public polynomial add(polynomial p2)
    {
        
        if(p2.coefficients.length >= this.coefficients.length)
        {
            double [] next = new double [p2.coefficients.length];
            for(int k = 0; k < next.length; k++)
            {
                next[k] = p2.coefficients[k];
            }
            polynomial result = new polynomial(next);
            for(int i = 0; i < this.coefficients.length; i++)
            {
                double sum = this.coefficients[i] + p2.coefficients[i];
                result.coefficients[i] = sum;
            }
            return result;
        }
        else
        {
            double [] next = new double [this.coefficients.length];
            for(int k = 0; k < next.length; k++)
            {
                next[k] = this.coefficients[k];
            }
            polynomial result = new polynomial(next);
            for(int i = 0; i < p2.coefficients.length; i++)
            {
                double sum = this.coefficients[i] + p2.coefficients[i];
                result.coefficients[i] = sum;
            }
            return result;
        }
        
    }
    public polynomial sub(polynomial p2)
    {
        for(int i = 0; i < p2.coefficients.length; i++)
        {
            p2.coefficients[i] = -1 * p2.coefficients[i];
        }
        return this.add(p2);
    }

    public polynomial mul(polynomial p2)
    {
        double [] coefficients2 = new double[p2.coefficients.length + this.coefficients.length];
        polynomial result = new polynomial(coefficients2);        
        for(int i = 0; i < this.coefficients.length; i++)
        {
            for(int j = 0; j < p2.coefficients.length; j++)
            {
                result.coefficients[i + j] += this.coefficients[i] * p2.coefficients[j];
            }
        }
        return result;
    }
    /*P(x) = 3 + 4x + 1x2
    Q(x) = 2 + 1x 
    
    15 + 8x + 1x2
    in this situation we get the first index from the Q and mutliply it with every p[i] and get a rresult    
    */
    
    
    public polynomial compose(polynomial p2)
    {
        int degree = (this.getDegree() * p2.getDegree()) + 1;
        double [] x = new double[degree];
        polynomial result = new polynomial(x);
        double [] y = new double[p2.coefficients.length];
        for(int i = 0; i < p2.coefficients.length; i++)
        {
            y[i] = p2.coefficients[i];
        }
        polynomial temp = new polynomial(y);
        for(int i = 1; i < this.coefficients.length; i++)
        {
            for(int j = 1; j < i; j++)
            {
                temp = temp.mul(p2);
            }
            for(int k = 0; k < temp.coefficients.length; k++)
            {
                temp.coefficients[k] *= this.coefficients[i];
            }
            result = result.add(temp);
            y = new double[p2.coefficients.length];
            for(int a = 0; a < p2.coefficients.length; a++)
            {
                y[a] = p2.coefficients[a];
            }
            temp = new polynomial(y);            
        }
            result.coefficients[0] = result.coefficients[0] + this.coefficients[0]; 
            return result;
    }    
    public polynomial dİv(polynomial p2)
    {
        double [] y = new double[this.getDegree() - p2.getDegree() + 1];
        polynomial answer = new polynomial(y);        
        polynomial result = this;
        while(result.getDegree() >= p2.getDegree())
        {
            int highest_term_of_P = result.getDegree();
            int highest_term_of_q = p2.getDegree();
            double leading_term_coeffecient_p = result.coefficients[highest_term_of_P]; 
            double leading_term_coeffecient_q = p2.coefficients[highest_term_of_q];
            double [] x = new double[highest_term_of_P - highest_term_of_q + 1];
            x[highest_term_of_P - highest_term_of_q] = leading_term_coeffecient_p / leading_term_coeffecient_q;
            polynomial temp = new polynomial(x);
            polynomial temp2 = temp.mul(p2);
            result = result.sub(temp2);
            answer.coefficients[highest_term_of_P - highest_term_of_q] = leading_term_coeffecient_p / leading_term_coeffecient_q;
        }
        return answer;
    }
    public int [] findEqual(polynomial p2)
    {
        int [] answers = new int[200];
        int count = 0;
        for(int i = 1; i < 201; i++)
        {
            if(this.eval(i) == p2.eval(i))
            {
                answers[count] = i;
                count++;
            }
        }        
        return answers;
    }

}