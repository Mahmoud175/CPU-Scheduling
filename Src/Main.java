package OS;

import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();

        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] remainingTime = new int[n];

        System.out.println("Enter Arrival times: ");
        for(int i = 0 ; i < n ; i++){
            arrivalTime[i] = sc.nextInt();
        }
        System.out.println("Enter Burst times: ");
        for(int i = 0 ; i < n ; i++){
            burstTime[i] = sc.nextInt();
            remainingTime[i] = burstTime[i];
        }
        while(true){
            System.out.println("Choose Algorithm: \n" + "1. SJF \n"+"2. RR \n"+"0. Exit");
            int choise = sc.nextInt();
            if(choise==1){
                SJF sjf = new SJF(n, remainingTime, arrivalTime, burstTime);
                sjf.processor();
                break;
            }
            else if(choise==2){
                System.out.println("Enter quantum time: ");
                int quantum = sc.nextInt();
                RR rr = new RR(n,quantum,remainingTime, arrivalTime, burstTime);
                rr.processor();
                break;
            }
            else if(choise==0){
                break;
            }
            else{
                System.out.println("Choose 1 or 2 please");
            }  
        }
        
        
    }
}
