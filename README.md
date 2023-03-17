# CPU-Scheduling
The project containts the implementation of The Shortest-Job-First(SJF) and Round-Robin(RR) CPU scheduling algorithms in java

##RR
In the RR algorithm, each process is given a fixed time slice (also known as a time quantum), and the CPU scheduler rotates between the processes in a circular fashion. When a process is given its time slice, it runs for that specific amount of time before being preempted, and the next process in the queue is given the CPU.The implementation of the RR algorithm can be found in the Fcfs.java file. The program reads in the processes and outputs the waiting time, completion time and turnaround time for each process.
