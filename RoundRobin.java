import java.util.Scanner;

public class RoundRobin 
{
    public void calculate(int process[], int n, int bt[], int quantum)
    {
        int rem_bt[]=new int[n];
        int wt[]=new int[n];
        int tat[]=new int[n];
        for(int i=0;i<n;i++) rem_bt[i]=bt[i];
        int t=0;
        float avg=0;
        while(true)
        {
            boolean done=true;
            for(int i=0;i<n;i++)
            {
                if(rem_bt[i]>0)
                {
                    done=false;
                    if(rem_bt[i]>quantum)
                    {
                        t+=quantum;
                        rem_bt[i]-=quantum;
                    }
                    else
                    {
                        t+=rem_bt[i];
                        rem_bt[i]=0;
                        wt[i]=t-bt[i];
                    }
                }
            }
            if(done==true) break;
        }
        System.out.println("Waiting times are:");
     
            for(int i=0;i<n;i++)
            {
                System.out.println(wt[i]);
                avg+=wt[i];
            }
            avg=avg/n;
            System.out.println("Average waiting time is: "+avg);
            avg=0;
        System.out.println("Turn around times are:");
        for(int i=0;i<n;i++) 
        {
            tat[i]=wt[i]+bt[i];
            System.out.println(tat[i]);
            avg+=tat[i];
        }
        avg=avg/n;
        System.out.println("Average turn around time is: "+avg);
    }
     public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no.of processes");
        int n=sc.nextInt();
        System.out.println("Enter quantum time:");
        int quantum=sc.nextInt();
        int process[]=new int[n];
        int bt[]=new int[n];
        for(int i=0;i<n;i++)
        {
            process[i]=i+1;
            System.out.println("enter execution time of "+process[i]+" proccess");
            bt[i]=sc.nextInt();
        }
        RoundRobin r=new RoundRobin();
        r.calculate(process, n, bt, quantum);
    }
}
