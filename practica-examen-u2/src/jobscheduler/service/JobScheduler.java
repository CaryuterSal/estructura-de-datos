package jobscheduler.service;

import jobscheduler.infrastructure.UniqueIdGenerator;
import jobscheduler.infrastructure.datastructures.ArrayQueue;
import jobscheduler.infrastructure.datastructures.ArrayStack;
import jobscheduler.infrastructure.datastructures.SinglyLinkedList;
import jobscheduler.infrastructure.datastructures.api.List;
import jobscheduler.infrastructure.datastructures.api.Queue;
import jobscheduler.infrastructure.datastructures.api.Stack;
import jobscheduler.model.Job;

import java.util.UUID;

public class JobScheduler {

    private final UniqueIdGenerator uniqueIdGenerator;

    private final Queue<Job> pendingQueue =  new ArrayQueue<>();
    private final Stack<Job> processingStack = new ArrayStack<>();
    private final List<Job> commitLog = new SinglyLinkedList<>();


    public JobScheduler(UniqueIdGenerator uniqueIdGenerator) {
        this.uniqueIdGenerator = uniqueIdGenerator;
    }

    public UUID submit(final String jobDescription){
        Job.Id id =  new Job.Id(uniqueIdGenerator.generate());
        Job job = new Job(
                id,
                jobDescription
        );
        pendingQueue.offer(job);
        return id.value();
    }

    public int process(final int quantity){
        int current = quantity;
        while(!pendingQueue.isEmpty() && current > 0){
            Job job = pendingQueue.poll();
            processingStack.push(job);

            current--;
        }
        return quantity - current;
    }

    public int commit(){
        int commited = 0;
        while(!processingStack.isEmpty()){
            Job job = processingStack.pop();
            commitLog.addLast(job);

            commited++;
        }
        return commited;
    }

    public int rollback(final int quantity){

        int current = quantity;
        while(!commitLog.isEmpty() && current > 0){
            Job lastJob = commitLog.get(commitLog.size() - 1);
            commitLog.remove(lastJob);
            pendingQueue.offer(lastJob);

            current--;
        }
        return quantity - current;
    }

    public List<Job> commitLog() {
        return commitLog;
    }

    public Stack<Job> processingStack() {
        return processingStack;
    }

    public Queue<Job> pendingQueue() {
        return pendingQueue;
    }
}
