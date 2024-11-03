
import java.util.Scanner;


class sjfprac{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process");
        int n = sc.nextInt();
        int[] arrival = new int[n];
        for(int i=0;i<n;i++){
            arrival[i]=0;
        }
        System.out.println("Enter CPU time");
        int[] cpu = new int[n];
        for(int i=0;i<n;i++){
            cpu[i]=sc.nextInt();
        }
        String[] process = new String[n];
        for(int i =0; i<n ;i++) {
            process[i]="p"+(i+1);
        }
        int[] startTime = new int[n];
        int[] finishTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        for(int i=0;i<n;i++) {
            for(int j =i+1;j<n;j++){
                int temp1;
                String temp;
                if(cpu[j]<cpu[i]) {
                    temp1=cpu[i];
                    cpu[i]=cpu[j];
                    cpu[j]=temp1;

                    temp=process[i];
                    process[i]=process[j];
                    process[j]=temp;
                }
            }
        }
        startTime[0]=arrival[0];
        for(int i =1;i<n;i++){
            startTime[i]=startTime[i-1]+cpu[i-1];
        }
        finishTime[0]=startTime[0]+cpu[0];
        for(int i=1;i<n;i++){
            finishTime[i]=startTime[i]+cpu[i];
        }
        for (int i = 0; i < n; i++){
            turnaroundTime[i]=finishTime[i]-arrival[i];
        }
        for (int i = 0; i < n; i++) {
            waitingTime[i]=startTime[i]-arrival[i];
        }
        float avg_turnaround_time = 0;
        float avg_waiting_time = 0;
        float sum1 = 0;
        float sum = 0;
        for (int i = 0; i < n; i++) {
            sum = turnaroundTime[i] + sum;
            sum1 = waitingTime[i] + sum1;
        }
        avg_turnaround_time = sum / 5;
        avg_waiting_time = sum1 / 5;
        System.out.println("PROCESSESS  CPUTIME   STARTTIME    FINISHTIME    TURNTIME    WAITINGTIME");
        for (int i = 0; i < n; i++) {
            System.out.println("\t");
            System.out.print(process[i] + "\t\t");
            System.out.print(cpu[i] + "\t\t");
            System.out.print(startTime[i] + "\t\t");
            System.out.print(finishTime[i] + "\t\t");
            System.out.print(turnaroundTime[i] + "\t\t");
            System.out.print(waitingTime[i] + "\t\t");
            System.out.println("\n");
        }
        System.out.println("\n");
        System.out.println("average turnaround time is " + avg_turnaround_time);
        System.out.println("average waiting time is " + avg_waiting_time);
    }
}