import java.util.*;
class RSA
{
    double d,p,q,n,e,f,M,g,V,Qn,N;
    Scanner sc=new Scanner(System.in);
    RSA()
    {
        p=0.0;
        q=0.0;
        n=p*q;
        e= 2.0;
        Qn=0.0;
        M=0.0;
    }
    void check()
    {
         System.out.println("Enter two prime numbers");
         p=sc.nextDouble();
         q=sc.nextDouble();
         n=p*q;
         Qn=(p-1)*(q-1);
         System.out.println("Enter a message");
         M=sc.nextDouble();
         int v=(int)M%26;
         char l=(char)(65+v-1);
         System.out.println("Message is "+l);
         if(gcd(M,n)==1.0)
         {
            while(e<Qn)
            {
              if(gcd(Qn,e)==1.0)
                {
                   g=e;
                   break;
                }
              else
                   e++;
            }
            for(d=2;d<Qn;d++)
            { 
              if(d*g % Qn ==1)
              {
                System.out.println("d="+d);
                f=d;
                break;
              }
            }
             System.out.println("Public key="+n+","+g);
             System.out.println("Private key="+n+","+f);
             V=(Math.pow(M,e)% n);
             V=(Math.pow(M,e)% n);
             System.out.println(Math.pow(V,f));
             N=(Math.pow(V,f)%n);
             int o= (int)V%26;
             char s=(char)(65+o-1);
             System.out.println("Encrypted message is " +V+" which is "+s);
             int x= (int)N%26;
             char q=(char)(65+x-1);
             System.out.println("Decrypted message is "+N+" which is "+q);
         }
         else
         {
             System.out.println("Invalid message: not co-prime to n");
             System.exit(0);
         }
    }
    double gcd(double a,double b)
    {
        double r= a%b;
        if(r!=0)
        return gcd(b,r);
        else
        return b;
    }
    void main()
    {
        RSA obj=new RSA();
        obj.check();
    }
}