import java.util.Scanner;
public class Test 
{
    public static void main(String[] args) 
    {
        int n;
        System.out.println("enter no.of processes");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int P[]=new int[n];
        int A[]=new int[n];
        int E[]=new int[n];
        int C[]=new int[n];
        int T[]=new int[n];
        int W[]=new int[n];
       float aw=0,at=0;
        for(int i=0;i<n;i++)
        {
            P[i]=i+1;
            System.out.println("enter arrival time of "+P[i]+" proccess");
            A[i]=sc.nextInt();
            System.out.println("enter execution time of "+P[i]+" proccess");
            E[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            if(i==0)  C[i]=E[i];
            else 
            {
                if(C[i-1]>A[i])
                C[i]=E[i]+C[i-1];
                else
                C[i]=A[i]+E[i];
            }
            T[i]=C[i]-A[i];
            W[i]=T[i]-E[i];
        }
        for(int i=0;i<n;i++)
        {
            aw+=W[i];
            at+=T[i];
        }
        aw=aw/n;
        at=at/n;
        System.out.println("completion times are:");
        for(int i=0;i<n;i++)  System.out.println(C[i]);

        System.out.println("turn around times are:");
        for(int i=0;i<n;i++)  System.out.println(T[i]);
       
        System.out.println("waiting times are:");
        for(int i=0;i<n;i++) System.out.println(W[i]);
        
        System.out.println("average waiting time is "+aw);
        System.out.println("average turn around time is "+at);
    }
    
}