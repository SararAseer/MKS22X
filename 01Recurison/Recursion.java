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
	return sqrt2(n,0);
	

    }

    public double sqrt2(double n, double x){
	e(n);
	double z= ( n / x + x) / 2;
	if ((((n-(z*z))/n)*100)<=.00001&&(((n-(z*z))/n)*100)>=0){
	    return x;
	}
	x=x+1;
	return sqrt2(n,x);
	
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
