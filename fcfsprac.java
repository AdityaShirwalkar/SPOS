
import java.util.Scanner;


class fcfsprac{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process");
        int n = sc.nextInt();//5
        System.out.println("Enter Arrival time");
        int[] arrival = new int[n];//3 5 1 2 4 -> 1 2 3 4 5
        for(int i=0;i<n;i++){
            arrival[i]=sc.nextInt();
        }
        System.out.println("Enter CPU time");
        int[] cpu = new int[n];//2 7 4 3 9 -> 4 3 2 9 7
        for(int i=0;i<n;i++){
            cpu[i]=sc.nextInt();
        }
        String[] process = new String[n];
        for(int i =0; i<n ;i++) {
            process[i]="p"+(i+1);//p1 p2 p3 p4 p5 -> p3 p4 p1 p5 p2
        }
        int[] startTime = new int[n];
        int[] finishTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        for(int i=0;i<n;i++) {
            for(int j =i+1;j<n;j++){
                int temp1,temp2;
                String temp;
                if(arrival[j]<arrival[i]) {
                    temp1=arrival[i];
                    arrival[i]=arrival[j];
                    arrival[j]=temp1;

                    temp2=cpu[i];
                    cpu[i]=cpu[j];
                    cpu[j]=temp2;

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
        System.out.println("PROCESSESS  ARRIVALTIME   CPUTIME   STARTTIME    FINISHTIME    TURNTIME    WAITINGTIME");
        for (int i = 0; i < n; i++) {
            System.out.println("\t");
            System.out.print(process[i] + "\t\t");
            System.out.print(arrival[i] + "\t\t");
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