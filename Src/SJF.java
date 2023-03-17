/**
 *
 * @author Mahmoud
 */
public class SJF {
    int[] remainingTime , arrivalTime , burstTime , waitingTime , turnaroundTime , completionTime;
    int n ;
    
    public SJF(int n ,int[] remainingTime , int[] arrivalTime , int[] burstTime){
        this.arrivalTime = arrivalTime;
        this.remainingTime = remainingTime;
        this.burstTime = burstTime;
        this.n = n;
        this.waitingTime = new int[n];
        this.turnaroundTime = new int[n];
        this.completionTime = new int[n];
    }
    
    public void processor(){
        int currentTime = 0;
        int completed = 0;
        while(completed!=n){
            int shortestProcess = -1;
            int shortestTime = Integer.MAX_VALUE;
            
            //find the shortest process
            for(int i = 0 ; i < n ; i ++){
                if(burstTime[i]<shortestTime && currentTime-arrivalTime[i] >=0 && remainingTime[i] > 0){
                    shortestProcess = i;
                    shortestTime = burstTime[i];
                }
            }
            //if found process it increase the current time  and compute the waiting and completion and turnaround times 
            if(shortestProcess >= 0){
                remainingTime[shortestProcess] = 0;
                completed++;
                waitingTime[shortestProcess] = currentTime-arrivalTime[shortestProcess];
                currentTime += burstTime[shortestProcess];
                turnaroundTime[shortestProcess] = burstTime[shortestProcess] + waitingTime[shortestProcess];
                completionTime[shortestProcess] = currentTime;
            }
            else{
                currentTime++;
            }
            
        }
        Finish();
    }
    private void Finish(){
        Double TotalWait = 0.0;
        Double TotalTurn = 0.0;
        char a = 'A';
        System.out.println("    Arrival Time         "+"Burst Time         "+"Completion Time         "+"Waiting Time         "+"Turnaround Time");
        for(int i = 0 ; i < n ; i ++){
        System.out.print(a+"     "+arrivalTime[i] + "                     "+burstTime[i] + "                     "+completionTime[i] + "                     "+waitingTime[i] + "                    "+turnaroundTime[i]);
            System.out.println();
            TotalTurn += turnaroundTime[i];
            TotalWait += waitingTime[i];
            a++;
        }
        System.out.println("Average Waiting Time = "+TotalWait/n + "\nAverage Turnaround Time = "+TotalTurn/n);
    }
}
