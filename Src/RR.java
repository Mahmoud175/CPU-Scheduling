package OS;

/**
 *
 * @author Mahmoud
 */

public class RR {
    int[] remainingTime , arrivalTime , burstTime , waitingTime , turnaroundTime , queue , completionTime;
    int n , quantum;
    
    public RR(int n ,int quantum,int[] remainingTime , int[] arrivalTime , int[] burstTime){
        this.arrivalTime = arrivalTime;
        this.remainingTime = remainingTime;
        this.burstTime = burstTime;
        this.n = n;
        this.quantum = quantum;
        this.waitingTime = new int[n];
        this.turnaroundTime = new int[n];
        this.queue = arrivalTime.clone();
        this.completionTime = new int[n];
    }
    
    public void processor(){
        int currentTime = 0;
        int completed = 0;
        int latest = -1;

        while(completed!=n){
            int arrivedFirst = Integer.MAX_VALUE;
            int currentProcess = -1;

            for(int i = 0 ; i < n ; i ++){
                if(queue[i]<arrivedFirst && currentTime-queue[i] >=0 && remainingTime[i] > 0){
                    currentProcess = i;
                    arrivedFirst = queue[i];
                }
            }
            if(currentProcess==-1 && remainingTime[latest]>0){
                currentProcess = latest;
            }
             

            if(currentProcess>=0){
                for(int i = 0 ; i < quantum ; i++){
                if(remainingTime[currentProcess]==0)
                    break;
                else
                    remainingTime[currentProcess]--;
                    
                    for(int j = 0 ; j < n ; j++){
                        if(j != currentProcess && currentTime-arrivalTime[j] >=0&& remainingTime[j]!=0){
                            waitingTime[j]++;
                        } 
                    }
                    currentTime++;
                    
                }
                queue[currentProcess] = currentTime+1;
                latest = currentProcess;
                if(remainingTime[currentProcess] == 0){
                completed++;
                turnaroundTime[currentProcess] = burstTime[currentProcess] + waitingTime[currentProcess];
                completionTime[currentProcess] = currentTime;
                }
            }
            else
                currentTime++;
            
            
        }
        System.out.println(currentTime);
        Finish();
    }

    private void Finish(){
        Double TotalWait = 0.0;
        Double TotalTurn = 0.0;
        char a = 'A';
        System.out.println("    Arrival Time         "+"Burst Time         "+"Completion Time         "+"Waiting Time         "+"Turnaround Time");
        for(int i = 0 ; i < n ; i ++){
        System.out.print(a+"     "+arrivalTime[i] + "                     "+burstTime[i] + "                      "+completionTime[i] + "                    "+waitingTime[i] + "                    "+turnaroundTime[i]);
            System.out.println();
            TotalTurn += turnaroundTime[i];
            TotalWait += waitingTime[i];
            a++;
        }
        System.out.println("Average Waiting Time = "+TotalWait/n + "\nAverage Turnaround Time = "+TotalTurn/n);
    }
}