import java.util.*;

public class mmprac {

    public static void firstFit(int blockSize,int processSize,int[] blocks, int[] processes){
        int[] allocation = new int[processSize];
        for (int i = 0; i < processSize; i++) {
            allocation[i]=-1;
        }
        boolean[] blockAllocated =new boolean[blockSize];
        for(int i = 0; i<processSize;i++) {
            for(int j=0;j<blockSize;j++) {
                if(!blockAllocated[j] && processes[i]<=blocks[j]) {
                    allocation[i]=j;
                    blockAllocated[j]=true;
                    break;
                }
            }
        }
        System.out.println("");
        System.out.println("First Fit");
        for(int i =0;i<processSize;i++){
            if(allocation[i]==-1) {
                System.out.println("Process " + (i + 1) + " not allocated");
            }
            else{
                System.out.println("Process" + (i+1) + "allocated at block" +(allocation[i]+1));
            }
        }
        System.out.println("");

    }
    public static void nextFit(int blockSize,int processSize,int[] blocks, int[] processes){
        int[] allocation = new int[processSize];
        for (int i = 0; i < processSize; i++) {
            allocation[i]=-1;
        }
        int lastIndex=0;
        for(int i = 0; i<processSize;i++) {
            for(int j=lastIndex;j<blockSize;j++) {
                if(blocks[j]>=processes[i]) {
                    allocation[i]=j;
                    lastIndex=j+1;
                    break;
                }
            }
        }

        System.out.println("Next Fit");
        for(int i =0;i<processSize;i++){
            if(allocation[i]==-1) {
                System.out.println("Process " + (i + 1) + " not allocated");
            }
            else{
                System.out.println("Process" + (i+1) + "allocated at block" +(allocation[i]+1));
            }
        }
        System.out.println("");

    }
    public static void bestFit(int blockSize,int processSize,int[] blocks, int[] processes){
        int[] allocation = new int[processSize];
        for (int i = 0; i < processSize; i++) {
            allocation[i]=-1;
        }
        boolean[] blockAllocated =new boolean[blockSize];
        for(int i = 0; i<processSize;i++) {
            int startIndex=-1;
            for(int j=0;j<blockSize;j++) {
                if(!blockAllocated[j] && processes[i]<=blocks[j]){
                    if(startIndex==-1 || blocks[startIndex]>blocks[j]) {
                        startIndex=j;
                    }
                }
            }
            if(startIndex!=-1) {
                allocation[i]=startIndex;
                blockAllocated[startIndex]=true;
            }
        }

        System.out.println("Best Fit");
        for(int i =0;i<processSize;i++){
            if(allocation[i]==-1) {
                System.out.println("Process " + (i + 1) + " not allocated");
            }
            else{
                System.out.println("Process" + (i+1) + "allocated at block" +(allocation[i]+1));
            }
        }
        System.out.println("");


    }
    public static void worstFit(int blockSize,int processSize,int[] blocks, int[] processes){
        int[] allocation = new int[processSize];
        for (int i = 0; i < processSize; i++) {
            allocation[i]=-1;
        }
        boolean[] blockAllocated =new boolean[blockSize];

        for(int i = 0; i<processSize;i++) {
            int startIndex=-1;
            for(int j=0;j<blockSize;j++) {
                if(!blockAllocated[j] && processes[i]<=blocks[j]){
                    if(startIndex==-1 || blocks[startIndex]<blocks[j]) {
                        startIndex=j;
                    }
                }
            }
            if(startIndex!=-1) {
                allocation[i]=startIndex;
                blockAllocated[startIndex]=true;
            }
        }
        System.out.println("Worst Fit");
        for(int i =0;i<processSize;i++){
            if(allocation[i]==-1) {
                System.out.println("Process " + (i + 1) + " not allocated");
            }
            else{
                System.out.println("Process" + (i+1) + "allocated at block" +(allocation[i]+1));
            }
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of blocks");
        int blockSize=sc.nextInt();
        System.out.println("Enter number of processes");
        int processSize=sc.nextInt();
        int[] blocks = new int[blockSize];
        int[] processes = new int[processSize];
        System.out.println("Enter the block sizes");
        for ( int i =0; i < blockSize; i++) {
            blocks[i]=sc.nextInt();
        }
        System.out.println("Enter the process sizes");
        for ( int i =0; i < processSize; i++) {
            processes[i]=sc.nextInt();
        }
        firstFit(blockSize,processSize,blocks,processes);
        nextFit(blockSize,processSize,blocks,processes);
        bestFit(blockSize, processSize, blocks, processes);
        worstFit(blockSize,processSize,blocks,processes);
    }
}
