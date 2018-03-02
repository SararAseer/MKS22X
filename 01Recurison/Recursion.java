public class Recursion{
    public void e(double n){
	if (n<0){

	    throw new IllegalArgumentException();
	}


    }
    public int fact(int n){
	e(n);
	if (n<=0){
	    return 1;
	}
	
	return n*fact(n-1);
    }

    public int fib(int n){
	e(n);
	if (n==1||n==0){
	    return n;
	}
	return fibhelp(n,0,1);
	
    }

    public int fibhelp(int n,int n1,int nn){
	e(n);
	if (n==0){
	    return n1;
	}
	return fibhelp(n-1,nn,n1+nn);

    }

    public double sqrt(double n){
	e(n);
	if (n ==0){
	    return n;
	}
	return sqrt2(n,1,n);
	

    }

    public double sqrt2(double n, double x, double g){
	e(n);
	double z= (g+x)/2;
	if (Math.abs((((n-(z*z))/n)*100))<=.000001){
	    return x;
	}
	x=(g+x)/2;
	g=n/x;
	return sqrt2(n,x,g);
	
    }
	
    public double guess(double n){
	e(n);

	return n+1;
    }

    public boolean isPossibleSum(int n, int target){
	e(n);
	if(n<target){
	    return sdh(n,target,0);
	}
	return true;

    }

    public boolean sdh(int n, int t,int s){
	if (t==s){
	    return true;
	}
	if (n<0 && t==s){
	    return true;
	}

	return  sdh(n-1,t,s+n)||sdh(n-1,t,s);
    }
}
