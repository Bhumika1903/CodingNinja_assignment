/*Implement a polynomial class, that contains following functions -

1. setCoefficient -
This function sets coefficient for a particular degree value. If term with given degree is not there in the polynomial,
then corresponding term (with specified degree and value) is added. If the term is already present in the polynomial,
then previous coefficient value is replaced by given coefficient value.

2. add -
Adds two polynomials and returns a new polynomial which has the result.

3. subtract -
Subtracts two polynomials and returns a new polynomial which has the result.

4. multiply -
Multiplies two polynomials and returns a new polynomial which has the result.

5. print -
Prints all the terms (only terms with non zero coefficients are to be printed) in increasing order of degree.
Print pattern for a single term : "x"
	
And multiple terms should be printed separated by space. For more clarity, refer sample test cases.
Note : Only keep those terms which have non - zero coefficients.

Input Format:
The first line of input contains count of the number of coefficients in polynomial 1(C1)
The next line of input has C1 degrees for polynomial 1.
The next line of input has C1 coefficients for polynomial 1.  
The next line of input contains count of the number of coefficients in polynomial 2(C2)
The next line of input has C2 degrees for polynomial 2.
The next line of input has C2 coefficients for polynomial 2.  
The next line of input has the choice for the function you want to implement.

Output Format:
The output will be printed in case of print function same as that of print function format.

Sample Input 1 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2

Sample Output 1 :
P1 + P2 = 2x2 2x3 3x4 4x6

Sample Input 2 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2

Sample Output 2 :
P1 - P2 = 2x3 -3x4 4x6
*/
package classes_and_object;

public class Polynomial {
	int degCoeff[];
    Polynomial(){
        degCoeff=new int[10];
    }
	
	public void setCoefficient(int degree, int coeff){
	
        if(degree>degCoeff.length-1){
            int temp[]=degCoeff;
            degCoeff=new int[degree+1];
            for(int i=0;i<temp.length;i++)
                degCoeff[i]=temp[i];
        }
        degCoeff[degree]=coeff;
		
	}
    
  
	
	public void print(){
		for(int i=0;i<degCoeff.length;i++){
            if(degCoeff[i]!=0){
                System.out.print(degCoeff[i]+"x"+i+" ");
            }
        }
	}

	
	
	public Polynomial add(Polynomial p){
	
        Polynomial ans=new Polynomial();
        int plen1=this.degCoeff.length;
        int plen2=p.degCoeff.length;
        int len=Math.min(plen1,plen2);
        int i;
        for(i=0;i<len;i++){
            ans.setCoefficient(i,this.degCoeff[i]+p.degCoeff[i]);
        }
        
        while(i<plen1){
            ans.setCoefficient(i,this.degCoeff[i]);
            i++;
        }
          while(i<plen2){
            ans.setCoefficient(i,p.degCoeff[i]);
            i++;
        }
        return ans;
		
	}
	public Polynomial subtract(Polynomial p){
			
         Polynomial ans=new Polynomial();
        int plen1=this.degCoeff.length;
        int plen2=p.degCoeff.length;
        int len=Math.min(plen1,plen2);
        int i;
        for(i=0;i<len;i++){
            ans.setCoefficient(i,this.degCoeff[i]-p.degCoeff[i]);
        }
        
        while(i<plen1){
            ans.setCoefficient(i,this.degCoeff[i]);
            i++;
        }
          while(i<plen2){
            ans.setCoefficient(i,-p.degCoeff[i]);
            i++;
        }
        return ans;
	}
    
    public int getCoeff(int degree){
        if(degree<this.degCoeff.length){
            return degCoeff[degree];
        }
        else
            return 0;
    }
	
	public Polynomial multiply(Polynomial p){
		
        Polynomial ans=new Polynomial();
        for(int i=0;i<this.degCoeff.length;i++){
            for(int j=0;j<p.degCoeff.length;j++){
                int termDeg=i+j;
                int termCoeff=this.degCoeff[i]*p.degCoeff[j];
                int oldCoeff=ans.getCoeff(termDeg);
                ans.setCoefficient(termDeg,termCoeff+oldCoeff);
            }
        }
        return ans;
	}

	

}
